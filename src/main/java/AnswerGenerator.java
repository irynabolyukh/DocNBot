import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Random;

public class AnswerGenerator {

    public static String getResponse(String userInput){

        Random rand = new Random();
        String input = userInput.toLowerCase();

        switch (input){
            case "так":
            case "ні":
                return "Будь ласка, не будьте так небагатослівні.";
        }

        if(input.endsWith("?")) {
            if (input.contains("чому")) {
                return WordPref.changePref(userInput) + " - це дуже складне запитання і поки я не маю відповіді на таке важке запитання, " +
                        "чекайде апдейтів :) ";
            }
            else if(input.contains("як")){
                return "Вас цікавить " + WordPref.changePref(input);
            }
            else if(input.contains("коли")){
                return "Час плинний, то мені важко відповісти, але ваше питання \" " +
                        WordPref.changePref(userInput) + "\" дуже цікаве.";
            }
            else if(input.contains("куди")){
                return "Я не знаю " +
                        WordPref.changePref(userInput).replace("?","") + ", на жаль.";
            }
            else {
                int randInt = rand.nextInt(5);
                JSONObject que = (JSONObject) DocBot.allPhrases.get("?");
                return (String) que.get(String.valueOf(randInt));
            }
        }

        if (input.contains("бол") || input.contains("біл")) {
            JSONObject pain = (JSONObject) DocBot.allPhrases.get("біль");

            for (String innerKey : (Iterable<String>) pain.keySet()) {
                if (input.contains(innerKey)) {
                    return (String) pain.get(innerKey);
                }
            }
            int randInt = rand.nextInt(2);
            JSONObject other = (JSONObject) pain.get("інше");
            return (String) other.get(String.valueOf(randInt));
        }
        else if(input.contains("погано")) {
            int randInt = rand.nextInt(4);
            JSONObject pain = (JSONObject) DocBot.allPhrases.get("погано");
            return (String) pain.get(String.valueOf(randInt));
        }
        else{
            JSONObject other = (JSONObject) DocBot.allPhrases.get("other");
            for (String innerKey : (Iterable<String>) other.keySet()) {
                if (input.contains(innerKey)) {
                    return (String) other.get(innerKey);
                }
            }
            JSONObject nice = (JSONObject) DocBot.allPhrases.get("nice");
            for (String innerKey : (Iterable<String>) nice.keySet()) {
                if (input.contains(innerKey)) {
                    return (String) nice.get(innerKey);
                }
            }
            JSONObject otherOther = (JSONObject) other.get("інше");
            int randInt = rand.nextInt(12);
            return (String) otherOther.get(String.valueOf(randInt));
        }
    }
}
