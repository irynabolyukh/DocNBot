public class WordPref {

    public static String changePref(String userInput){

        String check = userInput.toLowerCase();

        if(userInput.contains("me")) {
            String replaceWord = "you";
            String targetWord = "me";
            return check.replace(targetWord, replaceWord);
        }

        if(userInput.contains("are you")){
            String replaceWord = "I am";
            String targetWord = "are you";
            return check.replace(targetWord, replaceWord);
        }

        if(userInput.contains("i am")){
            String replaceWord = "are you";
            String targetWord = "i am";
            return check.replace(targetWord, replaceWord);
        }

        if(userInput.contains("you")) {
            String replaceWord = "I";
            String targetWord = "you";
            return check.replace(targetWord, replaceWord);
        }


        if(userInput.contains("i")) {
            String replaceWord = "you";
            String targetWord = "i";
            return check.replace(targetWord, replaceWord);
        }

        if(userInput.contains("my")) {
            String replaceWord = "your";
            String targetWord = "my";
            return check.replace(targetWord, replaceWord);
        }

        return userInput;
    }
}
