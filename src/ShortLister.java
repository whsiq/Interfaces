import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";

        ArrayList<String> records = new ArrayList<>();
        String[] splitWords;
        ArrayList<Object> validWords = new ArrayList<>();

        ShortWordFilter shortWordFilter = new ShortWordFilter();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));


                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    records.add(rec);
                    line++;
                }
                reader.close();
                System.out.println("\n\nFile read successfully.");

                System.out.println("======================");
                System.out.println("Words under 5 letters:");
                System.out.println("======================");

                /*
                    For loop which iterates through each line, splitting individual words into splitWords,
                    a String[] array. Collections.addAll() takes all items from this array and puts them
                    in validWords, which is an ArrayList<Object>. The list needs to be an Object type in
                    order to use the Collect.collectAll(...) method.
                 */
                for (String l : records) {
                    splitWords = l.split(" ");
                    Collections.addAll(validWords, splitWords);
                }

                // Collect.collectAll will eliminate all words with a length > 5 with shortWordFilter
                validWords = Collect.collectAll(shortWordFilter, validWords);

                // For loop to print the valid words
                for (Object o : validWords) {
                    System.out.println(o);
                }
            }
            else {
                System.out.println("No file chosen.");
                System.out.println("Please run the program again.");
                System.exit(0);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
