package app.telegramgptbot.telegrambot.command;

import app.telegramgptbot.telegrambot.TelegramBot;

public class StartCommand implements Command {
    private final Long chatId;
    private final String name;
    private final TelegramBot telegramBot;

    public StartCommand(Long chatId, String name, TelegramBot telegramBot) {
        this.chatId = chatId;
        this.name = name;
        this.telegramBot = telegramBot;
    }

    @Override
    public void execute() {
        String answer = "Hi, " + name + ", nice to meet you! "
                + "Write any questions to the chat and get AI generated "
                + "response or use command /admin to write to administration";
        telegramBot.sendMessage(chatId, answer);
    }
}
