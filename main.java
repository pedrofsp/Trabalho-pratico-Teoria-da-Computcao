import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class main {
  public static void main(String[] args) {
    try {
      File getFile = new File("MT.txt");
      Scanner readFile = new Scanner(getFile);
      while (readFile.hasNextLine()) {
        String data = readFile.nextLine();
        System.out.println(data);
      }
      readFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}