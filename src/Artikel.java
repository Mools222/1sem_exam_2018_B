public class Artikel extends Media {
    private String forfatter;
    private String artikeltekst;
    private String tilhoerendeBillede;

    public Artikel() {
    }

    public Artikel(String forfatter, String artikeltekst, String tilhoerendeBillede) {
        this.forfatter = forfatter;
        this.artikeltekst = artikeltekst;
        this.tilhoerendeBillede = tilhoerendeBillede;
    }

    public String getForfatter() {
        return forfatter;
    }

    public String getArtikeltekst() {
        return artikeltekst;
    }

    public String getTilhoerendeBillede() {
        return tilhoerendeBillede;
    }

    @Override
    public void logToConsol() {
        System.out.println("Navn: " + getName() + " Medietype: Artikel");
    }
}
