import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        System.out.println("Welcome to your journal.");
        System.out.println("Would you like to read or write?");

        Scanner in = new Scanner(System.in);

        BufferedReader br;
        File file = new File("C:\\Users\\14442\\Desktop\\journal.txt");

        String answer = in.nextLine();
        switch (answer) {
            case "read" -> {
                System.out.println("Let's read from the journal!");
                try {
                    FileReader fr = new FileReader(file);
                    br = new BufferedReader(fr);

                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Error, your file was not found: " + file.toString());
                } catch (IOException e) {
                    System.out.println("Unable to read file: " + file.toString());
                }
            }
            case "write" -> {
                System.out.println("Let's write to the journal! Enter the line you would like to add.");
                try {
                    String firstline = in.nextLine();
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(firstline + "\n");
                    System.out.println("You entered: " + firstline);
                    System.out.println("Would you like to add another line?");
                    String anotherline = in.nextLine();
                    switch (anotherline) {
                        case "yes" -> {
                            System.out.println("Enter your second line.");
                            String secondline = in.nextLine();
                            bufferedWriter.write(secondline + "\n");
                            System.out.println("You entered: " + secondline);
                        }
                        case "no" -> System.out.println("Your line has been entered to the journal.");
                        default -> System.out.println("Please enter a valid command");
                    }
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Error, your file could not be found: " + file.toString());
                }
            }
            default -> System.out.println("Enter a valid command");

        }
    }
}
