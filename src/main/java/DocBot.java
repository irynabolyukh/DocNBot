import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DocBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

        SendMessage message = new SendMessage();

        String userInput = update.getMessage().getText();

        message.setText(getResponsesArray(userInput));
        message.setChatId(update.getMessage().getChatId());


        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

   public String getResponsesArray(String messageFromTheCustomer){

        if(messageFromTheCustomer.equals("/start")){
            return "Твій Бот-Лікар на місці!";
        }
        else if(messageFromTheCustomer.contains("Привіт")){
            return "Привіт, що тебе хвилює?";
        }
        else if(messageFromTheCustomer.contains("болить")){
            return "Опиши свій біль?";
        }
        else if(messageFromTheCustomer.contains("дякую")){
            return "Звертайтесь! Щось ще?";
        }
        return "Гарного здоров‘ячка ;)";
   }

    public String getBotUsername() {
        return "docHelpNaUKMA_bot";
    }

    public String getBotToken() {
        return "1221107279:AAELDUoVdMPkzcNM8Z4QdwqjGuesP9UiQ-4";
    }



}
