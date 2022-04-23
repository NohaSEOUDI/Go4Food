package fr.nohas.go4food.Domaine;

public class CategorieDomaine {
    private  String title, pic;

    public CategorieDomaine(String title, String pic){
        this.pic = pic;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
