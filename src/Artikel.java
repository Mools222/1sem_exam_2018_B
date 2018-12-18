public class Artikel extends Media {
    private String forfatter;
    private String artikeltekst;
    private String tilhoerendeBillede;

    @Override
    public void logToConsol() {
        System.out.println("Navn: " + getName() + " Medietype: Artikel");
    }
}
