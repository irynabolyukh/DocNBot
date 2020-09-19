import com.google.inject.internal.cglib.proxy.$UndeclaredThrowableException;
import org.json.simple.JSONObject;

public class AnswerGenerator {

    public static String getResponse(String userInput){


        if (userInput.contains("голов")) {
            JSONObject head = (JSONObject) DocBot.allPhrases.get("рука");

            if(userInput.contains("бол")){
                
            }
            String firstName = (String) head.get("лікар");
            System.out.println(firstName);
        }

        if(userInput.toLowerCase().equals("так") || userInput.toLowerCase().equals("ні")){
            return "Будь ласка, не будьте так небагатослівні";
        }else if(userInput.endsWith("?")){
            if(userInput.toLowerCase().contains("чому") || userInput.toLowerCase().contains("як") ||
                    userInput.toLowerCase().contains("що робити") || userInput.toLowerCase().contains("коли")){
                return "Раджу вам звернутися до свого сімейного лікаря";
            }else{
                return "А чому ви питаєте?";
            }
        }else{
            return "розкажіть будь ласка більше про це";
        }



//        return "Гарного здоров‘ячка";
    }
}
