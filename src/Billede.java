public class Billede extends Media {
    private String filtype;
    private int breddeIPixels;
    private int hoejdeIPixels;
    private String fotograf;

    @Override
    public void logToConsol() {
        System.out.println("Navn: " + getName() + " Medietype: Billede");
    }
}
