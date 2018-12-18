public class Video extends Media {
    private String filtype;
    private String laenge;
    private String oploesning;
    private String fotograf;

    public Video() {
    }

    public Video(String filtype, String laenge, String oploesning, String fotograf) {
        this.filtype = filtype;
        this.laenge = laenge;
        this.oploesning = oploesning;
        this.fotograf = fotograf;
    }

    public String getFiltype() {
        return filtype;
    }

    public String getLaenge() {
        return laenge;
    }

    public String getOploesning() {
        return oploesning;
    }

    public String getFotograf() {
        return fotograf;
    }

    @Override
    public void logToConsol() {
        System.out.println("Navn: " + getName() + " Medietype: Video");
    }
}
