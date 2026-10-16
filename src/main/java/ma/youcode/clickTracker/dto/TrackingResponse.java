package ma.youcode.clickTracker.dto;

public class TrackingResponse {

    private final String urlRedirection;
    private final String publisher;
    private final String offre;
    private final int clicks;

    public TrackingResponse(String urlRedirection, String publisher, String offre, int clicks){
        this.urlRedirection = urlRedirection;
        this.publisher = publisher;
        this.offre = offre;
        this.clicks = clicks;
    }

    public String getUrlRedirection() {
        return urlRedirection;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getOffre() {
        return offre;
    }

    public int getClicks() {
        return clicks;
    }
}
