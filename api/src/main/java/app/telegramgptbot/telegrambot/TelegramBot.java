package app.telegramgptbot.telegrambot;

import app.telegramgptbot.adminpanel.dto.chatlog.ChatLogRequestDto;
import app.telegramgptbot.adminpanel.service.ChatLogService;
import app.telegramgptbot.telegrambot.command.Command;
import app.telegramgptbot.telegrambot.command.MessageAdmin;
import app.telegramgptbot.telegrambot.command.SendMessageCommand;
import app.telegramgptbot.telegrambot.command.StartCommand;
import app.telegramgptbot.telegrambot.config.TelegramBotConfig;
import app.telegramgptbot.telegrambot.exception.ChatActionProcessingException;
import app.telegramgptbot.telegrambot.exception.UpdateProcessingException;
import app.telegramgptbot.telegrambot.service.ChatGptService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@RequiredArgsConstructor
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private static final String COMMAND_START = "/start";
    private static final String COMMAND_MESSAGE_ADMIN = "/admin";
    private static final String TO_ADMIN = "toAdmin: ";
    private static final String MESSAGE_FOR_USER = "Your message was sent to admin."
            + " We will reply shortly.";
    private final TelegramBotConfig telegramBotConfig;
    private final ChatGptService chatGptService;
    private final ChatLogService chatLogService;
    private final Map<Long, Boolean> adminMessagePending = new HashMap<>();

    @Override
    public String getBotUsername() {
        return telegramBotConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleMessage(update.getMessage());
        }
    }

    private void handleMessage(Message message) {
        String chatGptResponse;
        long chatGptResponseTime = 0;

        String userMessage = message.getText();
        long userMessageReceivedTime = System.currentTimeMillis();

        Long chatId = message.getChatId();
        User user = message.getFrom();
        String userName = user.getUserName();
        String fullName = getFullName(user);

        try {
            sendTypingAction(chatId);
            Command command;

            if (adminMessagePending.containsKey(chatId) && adminMessagePending.get(chatId)) {
                command = new SendMessageCommand(chatId, MESSAGE_FOR_USER, this);
                adminMessagePending.put(chatId, false);
                saveChatLog(chatId, userName, fullName, TO_ADMIN + userMessage, null,
                        userMessageReceivedTime, chatGptResponseTime);

            } else {
                switch (userMessage) {
                    case COMMAND_START:
                        command = new StartCommand(chatId, fullName, this);
                        break;
                    case COMMAND_MESSAGE_ADMIN:
                        command = new MessageAdmin(chatId, this);
                        adminMessagePending.put(chatId, true);
                        break;
                    default:
                        chatGptResponse = chatGptService.getChatGptResponse(userMessage);
                        chatGptResponseTime = System.currentTimeMillis();
                        command = new SendMessageCommand(chatId, chatGptResponse, this);
                        saveChatLog(chatId, userName, fullName, userMessage, chatGptResponse,
                                userMessageReceivedTime, chatGptResponseTime);
                        break;
                }
            }
            command.execute();
        } catch (Exception e) {
            throw new UpdateProcessingException("Error processing the received update. "
                    + "Reason: " + e.getMessage());
        }
    }

    private String getFullName(User user) {
        String firstName = user.getFirstName();
        String lastName = (user.getLastName() != null && !user.getLastName().isEmpty())
                ? user.getLastName() : " ";
        return String.format("%s %s", firstName, lastName);
    }

    private void saveChatLog(Long chatId, String userName, String fullName, String userMessage,
                             String chatGptResponse, long userMessageReceivedTime,
                             long chatGptResponseTime) {
        LocalDateTime checkedChatGptResponseTime = (chatGptResponseTime != 0)
                ? new Timestamp(chatGptResponseTime).toLocalDateTime() : null;
        chatLogService.save(new ChatLogRequestDto(chatId, userName, fullName, userMessage,
                chatGptResponse, new Timestamp(userMessageReceivedTime).toLocalDateTime(),
                checkedChatGptResponseTime));
    }

    private void sendTypingAction(long chatId) {
        SendChatAction sendChatAction = new SendChatAction();
        sendChatAction.setChatId(String.valueOf(chatId));
        sendChatAction.setAction(ActionType.TYPING);

        try {
            execute(sendChatAction);
        } catch (TelegramApiException e) {
            throw new ChatActionProcessingException("Error sending typing action: "
                    + " Reason: " + e.getMessage());
        }
    }

    public void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new UpdateProcessingException("Failed to send the message."
                    + " Reason: " + e.getMessage());
        }
    }
}
