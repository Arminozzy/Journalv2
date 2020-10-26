import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Journalv2 {

    Scanner in = new Scanner(System.in);
    BufferedReader br;
    BufferedWriter bwr;

    File file = new File("C:\\Users\\14442\\Desktop\\journal.txt");


    public void read() throws IOException {
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
        } catch (Exception e) {
            //
        }
        finally {
            br.close();
        }

    }
    public void write() throws IOException {
        System.out.println("Let's write to the journal! Enter the line you would like to add.");
        FileWriter writer = new FileWriter(file);
        bwr = new BufferedWriter(writer);

        try {
            String firstline = in.nextLine();
            bwr.write(firstline + "\n");
            System.out.println("You entered: " + firstline);
            boolean anotherLineFlag = true;
            while (anotherLineFlag) {
                System.out.println("Would you like to add another line?");
                String anotherline = in.nextLine();
                switch (anotherline) {
                    case "yes" -> {
                        System.out.println("Enter another line.");
                        String secondline = in.nextLine();
                        bwr.write(secondline + "\n");
                        System.out.println("You entered: " + secondline);
                    }
                    case "no" -> {
                        System.out.println("Your line has been entered to the journal.");
                        anotherLineFlag = false;
                    }
                    default -> System.out.println("Please enter a valid command");
                }
            }
        } catch (IOException e) {
            System.out.println("Error, your file could not be found: " + file.toString());
        } finally {
            bwr.close();
        }

    }

    public static void main(String[] args) throws IOException {
        Journalv2 Journal = new Journalv2();

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to your journal.");
        System.out.println("Would you like to read or write?");



        String answer = in.nextLine();
        switch (answer) {
            case "read" -> {
                Journal.read();
            }
            case "write" -> {
                Journal.write();
            }
            default -> System.out.println("Enter a valid command");

        }
    }
}
