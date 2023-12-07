package app.telegramgptbot.telegrambot.command;

import app.telegramgptbot.telegrambot.TelegramBot;

public class MessageAdmin implements Command {
    private final Long chatId;
    private final TelegramBot telegramBot;

    public MessageAdmin(Long chatId, TelegramBot telegramBot) {
        this.chatId = chatId;
        this.telegramBot = telegramBot;
    }

    @Override
    public void execute() {
        String message = "Your message is sent to admin. We will reply shortly.";
        telegramBot.sendMessage(chatId, message);
    }
}
