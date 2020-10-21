import org.json.simple.JSONObject;
import java.util.Random;

public class AnswerGenerator {

   private static final JSONObject que = (JSONObject) DocBot.allPhrases.get("?");
   private static final JSONObject like = (JSONObject) DocBot.allPhrases.get("like");
   private static final JSONObject want = (JSONObject) DocBot.allPhrases.get("want");
   private static final JSONObject feel = (JSONObject) DocBot.allPhrases.get("feel");
   private static final JSONObject other = (JSONObject) DocBot.allPhrases.get("other");
   private static final JSONObject nice = (JSONObject) DocBot.allPhrases.get("nice");

   public static String getResponse(String userInput) {

      Random rand = new Random();
      String input = userInput.toLowerCase();

      switch (input) {
         case "/start":
            return "Hi! I`m your bot for communication:)";
         case "yes":
         case "no":
            return "Could you please tell me more about this.";
      }

      if (input.endsWith("?")) {

         if (input.contains("why")) {
            return WordPref.changePref(userInput) + "I would like to know that too.";

         } else if (input.contains("how")) {
            return "Do you really want to know " + WordPref.changePref(input);

         } else if (input.contains("can") || input.contains("could")) {
            return (rand.nextInt(2) == 1 ? "Sorry, I cannot." : "I wish I could.");

         } else if (input.contains("when")) {
            return "Time goes by fast, so I can't say " +
                    (WordPref.changePref(userInput)).replace('?','.');

         } else if (input.contains("where")) {
            return "Unfortunately, I don't know " +
                    WordPref.changePref(userInput).replace("?", "") + ".";

         } else if (input.contains(" or ")) {
            return "I think, I would prefer the " + (rand.nextInt(2) == 1 ? "first" : "second") + " option.";

         } else if (input.contains("what") || input.contains("do you like") || input.contains("do you love")) {
            return "I don't know. What about you?";

         } else {
            int randInt = rand.nextInt(8);
            return (String) que.get(String.valueOf(randInt));
         }

      } else if (input.contains("like") || input.contains("love")) {
         int randInt = rand.nextInt(6);
         return (String) like.get(String.valueOf(randInt));

      } else if (input.contains("want")) {
         int randInt = rand.nextInt(4);
         return (String) want.get(String.valueOf(randInt));

      } else if (input.contains("feel")) {
         int randInt = rand.nextInt(5);
         return (String) feel.get(String.valueOf(randInt));

      } else if(input.contains("i am")) {
         return "Why " + WordPref.changePref(input) + "?";
      }
      else {
         for (String innerKey : (Iterable<String>) nice.keySet()) {
            if (input.contains(innerKey)) {
               return (String) nice.get(innerKey);
            }
         }

         int randInt = rand.nextInt(9);
         return (String) other.get(String.valueOf(randInt));
      }
   }
}
