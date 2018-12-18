public class Video extends Media {
    private String filtype;
    private String laenge;
    private String oploesning;
    private String fotograf;

    @Override
    public void logToConsol() {
        System.out.println("Navn: " + getName() + " Medietype: Video");
    }
}
