package ma.youcode.clickTracker.model;

public class Link {

    private Long id;
    private String urlDestination;
    private String offre;
    private Long publisherId;
    private int clicks;

    public Link(){

    }

    public Link(String urlDestination, String offre, Long publisherId){
        this.urlDestination = urlDestination;
        this.offre = offre;
        this.publisherId = publisherId;
        this.clicks = 0;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUrlDestination(){
        return urlDestination;
    }
    public void setUrlDestination(String urlDestination){
        this.urlDestination = urlDestination;
    }

    public String getOffre(){
        return offre;
    }
    public void setOffre(String offre){
        this.offre = offre;
    }

    public Long getPublisherId(){
        return publisherId;
    }


    public int getClicks(){
        return clicks;
    }

    public void incrementClicks(){
        this.clicks++;
    }

}
