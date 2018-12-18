import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MediaIDTest {

    // This tests two things:
    // 1. Is the returned value numeric. This is done by using the isDigit() method from the Character class
    // 2. Is the returned value unique. This is done by creating an ArrayList, checking whether the number is on that list and then adding it to the list to check it against the following numbers
    @Test
    public void generate() {
        ArrayList<Integer> list = new ArrayList<>(); // Create an ArrayList
        for (int i = 0; i < 1000; i++) {
            int value = MediaID.generate(); // Generate an ID
            String numeric = Integer.toString(value); // Parse the int to String

            for (int j = 0; j < numeric.length(); j++) {
                assertTrue(Character.isDigit(numeric.charAt(j))); // Check for numbers
            }

            assertTrue(!list.contains(value)); // Check whether the number is on the list
            list.add(value);
        }
    }
}