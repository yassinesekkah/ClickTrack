package ma.youcode.clickTracker.dto;

public class OffreStatsResponse {

    private final String offre;
    private final int nombreLiens;
    private final int Clicks;

    public OffreStatsResponse(int nombreLiens, String offre, int clicks) {
        this.nombreLiens = nombreLiens;
        this.offre = offre;
        Clicks = clicks;
    }

    public String getOffre() {
        return offre;
    }

    public int getNombreLiens() {
        return nombreLiens;
    }

    public int getClicks() {
        return Clicks;
    }
}
