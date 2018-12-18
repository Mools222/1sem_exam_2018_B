import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MediaManager {

    // Her kommer din kode

    public void logMediaFolder(String folderNavn) {
        File file = new File(folderNavn);
        File[] list = file.listFiles(); // Initialize an array of File objects

        // Display the file name of each file
        for (File e : list) {
            System.out.println(e.getName());
        }
    }

    public ArrayList readMediaFolder(String folderNavn) {
        File file = new File(folderNavn);
        File[] list = file.listFiles(); // Initialize an array of File objects
        ArrayList<String> stringList = new ArrayList<>(); // Create an ArrayList to store Strings

        for (File e : list) {
            // Add the file name to the ArrayList of Strings
            stringList.add(e.getName());

            // Get the file type using the substring method
            String filtype = e.getName().substring(e.getName().lastIndexOf('.') + 1);

            // Instantiates a new media object based on the file name
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

    // This method inserts data into the database using SQL statements. The method's formal parameter is an instance of Media. Since Video, Billede and Artikel extend the Media class, instances of these classes can be passed to the method
    public void database(Media media) {
        PreparedStatement preparedStatement;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33067/semesterproeve", "root", "")) {
            if (media instanceof Video) {
                String query = "INSERT INTO Video (Filtype, Laengde, Oploesning, Fotograf) VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, ((Video) media).getFiltype()); // Since the declared type is Media, casting must be used to call methods from the actual type
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
            ex.printStackTrace();
        }
    }

    // This method updates data in the database using SQL statements
    public void rettelse(int id, String tabel, String kolonne, String rettelse) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33067/semesterproeve", "root", "")) {

            String query = "UPDATE " + tabel + " SET " + kolonne + " = ? WHERE VideoID = ?";

            if (tabel.equalsIgnoreCase("Video"))
                query = "UPDATE " + tabel + " SET " + kolonne + " = ? WHERE VideoID = ?";

            if (tabel.equalsIgnoreCase("Billede"))
                query = "UPDATE " + tabel + " SET " + kolonne + " = ? WHERE BilledeID = ?";

            if (tabel.equalsIgnoreCase("Artikel"))
                query = "UPDATE " + tabel + " SET " + kolonne + " = ? WHERE ArtikelID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rettelse);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // This method deletes data in the database using SQL statements
    public void slet(int id, String tabel) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:33067/semesterproeve", "root", "")) {

            String query = "";
            if (tabel.equalsIgnoreCase("Video"))
                query = "DELETE FROM " + tabel + " WHERE VideoID = ?";

            if (tabel.equalsIgnoreCase("Billede"))
                query = "DELETE FROM " + tabel + " WHERE BilledeID = ?";

            if (tabel.equalsIgnoreCase("Artikel"))
                query = "DELETE FROM " + tabel + " WHERE ArtikelID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
