import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileInspector {
    public static void main(String[] args) {
        {
            JFileChooser chooser = new JFileChooser();
            File selectedFile;
            String rec = "";

            try {

                File workingDirectory = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDirectory);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();

                    try(BufferedReader reader = Files.newBufferedReader(file)) {

                    System.out.println("The name of your selected file is: " + selectedFile.getAbsolutePath());

                    int lines = 0;
                    int words = 0;
                    int characters = 0;

                    String linesread;
                    while ((linesread = reader.readLine()) != null)
                    {
                        lines++;
                        characters += linesread.length();
                        words += linesread.split(" ").length;
                    }

                    System.out.println("\nSummary Report:");
                    System.out.println("File Name: " + selectedFile.getName());
                    System.out.println("Number of Lines: " + lines);
                    System.out.println("Number of Words: " + words);
                    System.out.println("Number of Characters: " + characters);

                    reader.close();

                    System.out.println("\n\nData file read!");
                    }

                }
                else
                {
                    System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found!!!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}