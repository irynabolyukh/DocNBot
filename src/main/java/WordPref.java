public class WordPref {

    public static String changePref(String userInput){

        String check = userInput.toLowerCase();

        if(userInput.contains(" мене ")) {
            String replaceWord = " вас ";
            String targetWord = " мене ";
            return check.replace(targetWord, replaceWord);
        }

        if(userInput.contains(" я ")) {
            String replaceWord = " ви ";
            String targetWord = " я ";
            return check.replace(targetWord, replaceWord);
        }

        if(userInput.contains(" мені ")) {
            String replaceWord = " вам ";
            String targetWord = " мені ";
            return check.replace(targetWord, replaceWord);
        }

        return userInput;
    }
}
