package e1;

public class StringGames {

    private static int CountLowerCase(String str) {
        int count = 0;
        for(char ch : str.toCharArray()) {
            if(Character.isLowerCase(ch)) {
                count++;
            }
        }
        return count;
    }

    private static int CountUpperCase(String str) {
        int count = 0;
        for(char ch : str.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }

    private static int CountDigit(String str) {
        int count = 0;
        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                count++;
            }
        }
        return count;
    }

    public static String bestCharacters(String s1, String s2){
        if(s1.length() != s2.length()){
            throw new IllegalArgumentException();
        }

        int s1Points = 0, s2Points = 0;

        if(CountLowerCase(s1) > CountLowerCase(s2)){
            s1Points++;
        }else if(CountLowerCase(s1) < CountLowerCase(s2)){
            s2Points++;
        }

        if(CountUpperCase(s1) > CountUpperCase(s2)){
            s1Points++;
        }else if(CountUpperCase(s1) < CountUpperCase(s2)){
            s2Points++;
        }

        if(CountDigit(s1) > CountDigit(s2)){
            s1Points++;
        }else if(CountDigit(s1) < CountDigit(s2)){
            s2Points++;
        }

        if(s1Points > s2Points){
            return s1;
        } else if(s2Points > s1Points){
            return s2;
        } else {
            return s1;
        }
    }

    public static int crossingWords(String s1, String s2) {
        int CountCrossingWords = 0;

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    CountCrossingWords++;
                }
            }
        }
        return CountCrossingWords;
    }

    private static boolean correctAlphabet(String str) {
        char[] alphabet = new char[26];

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }

        if (str.length() != 26) {
            return false;
        }

        int countLetters = 0;
        boolean[] found = new boolean[26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (alphabet[i] == str.charAt(j) && !found[i]) {
                    countLetters++;
                    found[i] = true;
                    break;
                }
            }
        }

        return countLetters == 26;
    }


    public static String wackyAlphabet(String s1, String s2){

        if(!correctAlphabet(s2)){
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s2.length(); i++) {
            char aux = s2.charAt(i);
            for(int j = 0; j < s1.length(); j++) {
                if(s1.charAt(j) == aux) {
                    result.append(aux);
                }
            }
        }
        return result.toString();
    }
}
