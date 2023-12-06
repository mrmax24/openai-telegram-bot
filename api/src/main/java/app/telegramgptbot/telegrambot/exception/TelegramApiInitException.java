package app.telegramgptbot.telegrambot.exception;

public class TelegramApiInitException extends RuntimeException {
    public TelegramApiInitException(String message) {
        super(message);
    }
}
