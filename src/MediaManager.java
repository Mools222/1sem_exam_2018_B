import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MediaManager {

    // Her kommer din kode

    public void logMediaFolder(String folderNavn) {
        File file = new File(folderNavn);
        File[] list = file.listFiles();

        for (File e: list) {
            System.out.println(e.getName());
        }
    }

    public ArrayList readMediaFolder(String folderNavn) {
        File file = new File(folderNavn);
        File[] list = file.listFiles();
        ArrayList<String> stringList = new ArrayList<>();

        for (File e: list) {
            stringList.add(e.getName());

            String filtype = e.getName().substring(e.getName().lastIndexOf('.') + 1);

            if (filtype.equals("mp4") || filtype.equals("m4v") || filtype.equals("mov")) {
                Video video = new Video();
            } else if (filtype.equals("jpg") || filtype.equals("png") || filtype.equals("gif")) {
                Billede billede = new Billede();
            } else if (filtype.equals("txt")) {
                Artikel artikel = new Artikel();
            }
        }

        return stringList;
    }

}
