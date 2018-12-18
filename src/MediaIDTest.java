import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MediaIDTest {

    @Test
    public void generate() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int value = MediaID.generate();
            String numeric = Integer.toString(value);

            for (int j = 0; j < numeric.length(); j++) {
                assertTrue(Character.isDigit(numeric.charAt(j)));
            }

            assertTrue(!list.contains(value));
            list.add(value);
        }
    }
}