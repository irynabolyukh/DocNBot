import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Random;

public class AnswerGenerator {


    private static final JSONObject que = (JSONObject) DocBot.allPhrases.get("?");
    private static final JSONObject pain = (JSONObject) DocBot.allPhrases.get("біль");
    private static final JSONObject sick = (JSONObject) DocBot.allPhrases.get("погано");
    private static final JSONObject painOther = (JSONObject) pain.get("інше");
    private static final JSONObject other = (JSONObject) DocBot.allPhrases.get("other");
    private static final JSONObject nice = (JSONObject) DocBot.allPhrases.get("nice");
    private static final JSONObject otherOther = (JSONObject) other.get("інше");

    public static String getResponse(String userInput) {

        Random rand = new Random();
        String input = userInput.toLowerCase();

        switch (input) {
            case "/start": return "Гарного здоров'яка! Я Ваш персональний консультант з питань здоров'я :)" +
                    "Можете звертатись до мене, коли у Вас щось болить чи Вам погано :(";
            case "так":
            case "ні":
                return "Будь ласка, не будьте так небагатослівні.";
        }

        if (input.endsWith("?")) {

            if (input.contains("чому")) {
                return WordPref.changePref(userInput) + " - це дуже складне запитання і поки я не маю відповіді на таке важке запитання, " +
                        "чекайде апдейтів :) ";
            } else if (input.contains("як")) {
                return "Вас цікавить " + WordPref.changePref(input);
            } else if (input.contains("коли")) {
                return "Час плинний, то мені важко відповісти, але ваше питання \" " +
                        WordPref.changePref(userInput) + "\" дуже цікаве.";
            } else if (input.contains("куди")) {
                return "Я не знаю " +
                        WordPref.changePref(userInput).replace("?", "") + ", на жаль.";
            } else {
                int randInt = rand.nextInt(7);
                return (String) que.get(String.valueOf(randInt));
            }
        } else if (input.contains("бол") || input.contains("біл")) {

            for (String innerKey : (Iterable<String>) pain.keySet()) {
                if (input.contains(innerKey)) {
                    return (String) pain.get(innerKey);
                }
            }
            int randInt = rand.nextInt(2);
            return (String) painOther.get(String.valueOf(randInt));
        } else if (input.contains("погано")) {
            int randInt = rand.nextInt(4);
            return (String) sick.get(String.valueOf(randInt));
        } else {
            for (String innerKey : (Iterable<String>) other.keySet()) {
                if (input.contains(innerKey)) {
                    return (String) other.get(innerKey);
                }
            }

            for (String innerKey : (Iterable<String>) nice.keySet()) {
                if (input.contains(innerKey)) {
                    return (String) nice.get(innerKey);
                }
            }

            int randInt = rand.nextInt(12);
            return (String) otherOther.get(String.valueOf(randInt));
        }
    }
}
