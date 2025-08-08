import java.io.*;
import java.util.Scanner;

public class NoteBuf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n===== NOTES APP =====");
            System.out.println("1. Write notes");
            System.out.println("2. View notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    writeNotes(fileName, sc);
                    break;
                case 2:
                    viewNotes(fileName);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void writeNotes(String fileName, Scanner sc) {
        try {
            FileWriter fw = new FileWriter(fileName, true); 
            System.out.println("Enter your notes (type 'exit' to stop writing):");
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("exit")) break;
                fw.write(line + "\n");
            }
            fw.close();
            System.out.println("Notes saved!");
        } catch (IOException e) {
            System.out.println(" Error saving notes: " + e.getMessage());
        }
    }

   
    public static void viewNotes(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String noteLine;
            System.out.println("\n Your saved notes:\n");
            while ((noteLine = br.readLine()) != null) {
                System.out.println(noteLine);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(" No notes found! (File does not exist yet)");
        } catch (IOException e) {
            System.out.println(" Error reading notes: " + e.getMessage());
        }
    }
}
