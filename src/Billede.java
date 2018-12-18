public class Billede extends Media {
    private String filtype;
    private int breddeIPixels;
    private int hoejdeIPixels;
    private String fotograf;

    public Billede() {
    }

    public Billede(String filtype, int breddeIPixels, int hoejdeIPixels, String fotograf) {
        this.filtype = filtype;
        this.breddeIPixels = breddeIPixels;
        this.hoejdeIPixels = hoejdeIPixels;
        this.fotograf = fotograf;
    }

    public String getFiltype() {
        return filtype;
    }

    public int getBreddeIPixels() {
        return breddeIPixels;
    }

    public int getHoejdeIPixels() {
        return hoejdeIPixels;
    }

    public String getFotograf() {
        return fotograf;
    }

    @Override
    public void logToConsol() {
        System.out.println("Navn: " + getName() + " Medietype: Billede");
    }
}
