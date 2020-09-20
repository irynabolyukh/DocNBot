import org.json.simple.JSONObject;

public class AnswerGenerator {

    public static String getResponse(String userInput){

        switch (userInput.toLowerCase()){
            case "так":
            case "ні":
                return "Будь ласка, не будьте так небагатослівні.";
        }

        if(userInput.endsWith("?")) {
            if (userInput.toLowerCase().contains("чому")) {
                return WordPref.changePref(userInput) + "Чому то дуже важко і поки я не маю відповіді на таке важке запитання, " +
                        "чекайде апдейтів :) ";
            }
            if(userInput.toLowerCase().contains("як")){
                return "Вас цікавить  " + WordPref.changePref(userInput);
            }
            if(userInput.toLowerCase().contains("коли")){
                return "Час плинний, то мені важко відповісти, але ваше питання \" " +
                        WordPref.changePref(userInput) + "\" дуже цікаве ";
            }
            else {
                return "Дивне питаннячко, сформулюйте будь ласка по іншому";
            }
        }

        if (userInput.contains("голов")) {
            JSONObject head = (JSONObject) DocBot.allPhrases.get("рука");

            if(userInput.contains("бол")){

            }
            String firstName = (String) head.get("лікар");
            System.out.println(firstName);

        }else{
            return "розкажіть будь ласка більше про це";
        }
        return "Гарного здоров‘ячка";
    }
}
