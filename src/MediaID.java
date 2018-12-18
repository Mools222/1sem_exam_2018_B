// Specific import statements
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *  Hver mediefil hos TV2 skal have et unikt ID, og denne klasse hjælper med at genrere unikke ID'er
 */
// Class
public class MediaID {

    // Data field
    private static int latestId = 100;

    // Since it has no explicit constructor, this class contains a default constructor

    // Method
    // Public visibility modifier means the method can be accessed from any other classes.
    // Static methods can be called without creating an instance of the class.
    // The return value type is int, meaning the method returns an int
    public static int generate() {

        // Creates an instance of the File class with the parameter "media_id.txt"
        File file = new File("media_id.txt");

        // Låser filen op før adgang
        // file.setWritable(true);

        // Try-catch block to handle exceptions
        try {

            // One-way if statement
            if (file.exists()) { // Boolean expression. Checks whether the file exists.
                FileReader fileReader = new FileReader(file); // Creates an instance of the FileReader class with the instance "file" of the File class as the parameter
                Scanner scanner = new Scanner(file); // Creates an instance of the Scanner class with the instance "file" of the File class as the parameter. The Scanner class is used to read files
                latestId = (int) scanner.nextInt(); // Sets the latestId as the next int found in the media_id.txt file
            }

            latestId++; // Adds 1 to latestId by using the post-increment operator

            FileWriter fileWriter = new FileWriter(file); // Creates an instance of the FileWriter class with the instance "file" of the File class as the parameter. The class is used for writing streams of characters
            fileWriter.write(Integer.toString(latestId)); // Converts the integer in latestId to String and writes it to media_id.txt
            fileWriter.close(); // Closes the file

        } catch (IOException e) { // Catches IOException
            e.printStackTrace(); // The printStackTrace() method prints stack trace information on the console.
        }

        // Låser filen ned for at den ikke redigeres ved en fejl
        // file.setReadOnly();

        return latestId; // Returns the int, latestId
    }

}