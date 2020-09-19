import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


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


   public String getResponsesArray(String messageFromTheCustomer) {


        try{

            Reader reader = Files.newBufferedReader(Paths.get("customer.json"));
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode parser = objectMapper.readTree(reader);

            System.out.println(parser.path("id").asLong());
            System.out.println(parser.path("name").asText());
            System.out.println(parser.path("email").asText());
            System.out.println(parser.path("age").asLong());


        }catch (Exception ex) {
            ex.printStackTrace();
        }


//       if(messageFromTheCustomer.equals("/start")){
//            return "Твій Бот-Лікар на місці!";
//        }
//        else if(messageFromTheCustomer.contains("Привіт")){
//            return "Привіт, що тебе хвилює?";
//        }
//        else if(messageFromTheCustomer.contains("болить")){
//            return "Опиши свій біль?";
//        }

         return "Гарного здоров‘ячка ;)";
   }



    public String getBotUsername() {
        return "docHelpNaUKMA_bot";
    }

    public String getBotToken() {
        return "1221107279:AAELDUoVdMPkzcNM8Z4QdwqjGuesP9UiQ-4";
    }

}
