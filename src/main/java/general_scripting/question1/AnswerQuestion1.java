package general_scripting.question1;

import java.util.Arrays;
import java.util.List;

public class AnswerQuestion1 {

    public static void main(String[] args) {

        reverseEverything("Happy New Year! I hope you are doing well too. And I hope I do well in this test!");
    }

    /**
     * Given a string, reverse each word in it and reverse the entire string.
     * For example, if the given string is “hope you are doing well”, then the output should be “llew gniod era uoy epoh”.
     * Assume that all characters in the string are lower case.
     * Create a method called reverseEverything(String s) where ‘s’ is the input from the user in order to solve this question.
     */

    private static void reverseEverything(String s){

        if (s.length() > 1){

            List<String> words = Arrays.asList(s.split("\\s"));

            StringBuilder sBuilder = new StringBuilder(s.length());

            for (int i = 0; i <= words.size() - 1; i++) {
                sBuilder.append(words.get(i)).append(' ');
            }

            String reverseAll = sBuilder.reverse().toString().trim();

            System.out.println(reverseAll);

        } else {

            System.out.println("\"" + s + "\"" + " is not long enough to see a difference! Please try again.");

        }
    }
}
