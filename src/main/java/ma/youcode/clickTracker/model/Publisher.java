package ma.youcode.clickTracker.model;

public class Publisher {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Category category;

    public Publisher(){

    }

    public Publisher(String nom, String prenom, String email, Category category){

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.category = category;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public Category getCategory(){
        return category;
    }
    public void setCategory(Category cat){
        category = cat;
    }
}
