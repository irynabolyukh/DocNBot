import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DocBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {


        String userInput = update.getMessage().getText();
        SendMessage message = new SendMessage();

        String hello = "Твій Бот-Лікар на місці, чим я можу допомогти?";
        String hello2 = "Привіт, що тебе хвилює?";

        message.setText(hello);
        message.setChatId(update.getMessage().getChatId());

        if (userInput.equals("Привіт")) {

            message.setText(hello2);
            message.setChatId(update.getMessage().getChatId());
        }

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "docHelpNaUKMA_bot";
    }

    public String getBotToken() {
        return "1221107279:AAELDUoVdMPkzcNM8Z4QdwqjGuesP9UiQ-4";
    }



}
