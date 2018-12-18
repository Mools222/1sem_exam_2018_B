import java.io.File;
import java.time.Instant;
import java.util.Date;

public class Media {

    // Data fields
    private int assetId;
    private String name;
    private Date created = new Date();
    private String fileName;
    private boolean brugergenereret;

    // No args constructor
    public Media() {
        assetId = MediaID.generate();
        created = Date.from(Instant.now());
    }

    // Methods

    // Getters & setters for all the data fields
    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isBrugergenereret() {
        return brugergenereret;
    }

    public void setBrugergenereret(boolean brugergenereret) {
        this.brugergenereret = brugergenereret;
    }

    // Overrides the toString method from the superclass Object
    @Override
    public String toString() {
        return "Media{" +
                "assetId=" + assetId +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    public void logToConsol() {
        System.out.println("Navn: " + name + " Medietype: Media");
    }
}