import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocBot extends TelegramLongPollingBot {
//    private String answer;

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

    private static void parseEmployeeObject(JSONObject head)
    {
        JSONObject employeeObject = (JSONObject) head.get("голова");
        String firstName = (String) employeeObject.get("лікар");
        System.out.println(firstName);
        String lastName = (String) employeeObject.get("болить");
        System.out.println(lastName);
    }


    public String JSONanswer(String s) throws IOException {
        JSONParser jsonParser = new JSONParser();

        if (s.contains("голов")){
            try (FileReader reader = new FileReader("src/main/java/head.json"))
            {
                Object obj = jsonParser.parse(reader);
                JSONObject jsonObj = (JSONObject) obj;
                JSONObject head = (JSONObject) jsonObj.get("голова");
                String firstName = (String) head.get("лікар");
                System.out.println(firstName);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else if (s.contains("рук")) {

        }
        return "Гарного здоров‘ячка";
    }


    public String getResponsesArray(String messageFromTheCustomer){

        try {
            return JSONanswer(messageFromTheCustomer);
        } catch (IOException e) {
            e.printStackTrace();
            return "Гарного здоров‘ячка";
        }
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