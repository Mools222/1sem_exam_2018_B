import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void database(Media media) {
        PreparedStatement preparedStatement;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33067/semesterproeve", "root", "")) {
            if (media instanceof Video) {
                String query = "INSERT INTO Video (Filtype, Laengde, Oploesning, Fotograf) VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, ((Video) media).getFiltype());
                preparedStatement.setString(2, ((Video) media).getLaenge());
                preparedStatement.setString(3, ((Video) media).getOploesning());
                preparedStatement.setString(4, ((Video) media).getFotograf());
                preparedStatement.executeUpdate();
            }

            if (media instanceof Billede) {
                String query = "INSERT INTO Billede (Filtype, Bredde_i_pixels, Hoejde_i_pixels, Fotograf) VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, ((Billede) media).getFiltype());
                preparedStatement.setInt(2, ((Billede) media).getBreddeIPixels());
                preparedStatement.setInt(3, ((Billede) media).getHoejdeIPixels());
                preparedStatement.setString(4, ((Billede) media).getFotograf());
                preparedStatement.executeUpdate();
            }

            if (media instanceof Artikel) {
                String query = "INSERT INTO Artikel (Forfatter, Artikeltekst, Tilhoerende_billede) VALUES (?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, ((Artikel) media).getForfatter());
                preparedStatement.setString(2, ((Artikel) media).getArtikeltekst());
                preparedStatement.setString(3, ((Artikel) media).getTilhoerendeBillede());
                preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
