package general_scripting.question3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class AnswerQuestion3 {

    /**
     * There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:

     Apple – a fruit, a tech firm
     Table – an object, contains rows and columns when used in context of computers
     Orange – a fruit

     Given a path to the file do the following:

     a)	Create a method called doesFileExist(String path) which takes the path of the file and
     tells the user if the file exists at that path or not. Assume all paths are relative to your project structure.
     If the file does not exist, catch the requisite exception.

     b)	Read each word and its possible meanings and print them out. Your output should look like this:

     Word1
     Meaning 1
     Meaning 2
     Word2
     Meaning1
     Meaning2

     Use appropriate data structures wherever necessary.

     */

    public static void main(String[] args) throws IOException {
//        new AnswerQuestion3().doesFileExist("/src/main/resources/dictionary.txt");
//        new AnswerQuestion3().readProjectFile("/src/main/resources/dictionary.txt");
    }

    /**
     * The methods asked are below. I have created a file "dictionary.txt" under resources.
     */

    /**
     * For a)
     * @param path - the path inside project directory
     * @return boolean
     */

    public boolean doesFileExist(String path) {
        File file = new File(System.getProperty("user.dir") + path);

        if (file.isFile()) {

            System.out.println("The file exists.");
            return true;
        }

        try {
            throw new FileNotFoundException("This path is not leading to a file. Check the path again.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(false);
        return false;
    }

    /**
     * For b)
     * @param path - the path under project directory
     */

    public void readProjectFile(String path) throws IOException {

        if (doesFileExist(path)){

            File file = new File(System.getProperty("user.dir") + path);

            String inStr = new String(Files.readAllBytes(file.toPath()));

            String[] fileStringAfterSplit = inStr.split("[-,\n]");

            System.out.println("Here are the file contents: ");
            for (String s : fileStringAfterSplit){
                System.out.println(s);
            }


        } else {
            throw new FileNotFoundException("No file here. Please check the file path.");
        }

    }
}

