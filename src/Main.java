import java.io.File;
import java.util.ArrayList;

public class Main {

    // Public static named constants
    // Public visibility modifier means they can be accessed from any other classes.
    // The static modifier means they're shared by all objects of the class
    public static final String SOFTWARE_VERSION = "0.1.0";
    public static final String MEDIA_MAPPE = "media/";

    // Main methods. Runs the program
    public static void main(String[] args) {

        // Creates an instance of the Test class
        Test.test();

        MediaManager mediaManager = new MediaManager();

        mediaManager.logMediaFolder("media");

        ArrayList<String> list = mediaManager.readMediaFolder("media");
        for (String e : list) {
            System.out.println(e);
        }

        Video video = new Video("mov", "2:25", "720p", "Kurt Petersen");
        Billede billede = new Billede("gif", 595, 842, "Peter Kurtsen");
        Artikel artikel = new Artikel("Some Guy", "Bla bla bla.", "media\\guy.tiff");

//        mediaManager.database(video);
//        mediaManager.database(billede);
//        mediaManager.database(artikel);

        String numeric = "124";
        for (int j = 0; j < numeric.length(); j++) {
            System.out.println(Character.isDigit(numeric.charAt(j)));
        }

    }
}



