import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocBot extends TelegramLongPollingBot {
    JSONObject allPhrases;

    {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/phrases.json")) {
            Object obj = jsonParser.parse(reader);
            allPhrases = (JSONObject) obj;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

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


    public String JSONanswer(String s) {

        if (s.contains("голов")) {
            JSONObject head = (JSONObject) allPhrases.get("рука");
            String firstName = (String) head.get("лікар");
            System.out.println(firstName);
        }
        return "Гарного здоров‘ячка";
    }


    public String getResponsesArray(String messageFromTheCustomer) {

        return JSONanswer(messageFromTheCustomer);
//        if(messageFromTheCustomer.equals("/start")){
//            return "Твій Бот-Лікар на місці!";
//        }
//        else if(messageFromTheCustomer.contains("Привіт")){
//            return "Привіт, що тебе хвилює?";
//        }
//        else if(messageFromTheCustomer.contains("Привіт")){
//            return "Привіт, що тебе хвилює?";
//        }
//        else if(messageFromTheCustomer.contains("болить")){
//            return "Опиши свій біль?";
//        }

//        return "Гарного здоров‘ячка ;)";
    }

    public String getBotUsername() {
        return "docHelpNaUKMA_bot";
    }

    public String getBotToken() {
        return "1221107279:AAELDUoVdMPkzcNM8Z4QdwqjGuesP9UiQ-4";
    }

}