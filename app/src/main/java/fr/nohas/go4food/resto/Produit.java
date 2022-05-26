package fr.nohas.go4food.resto;

//classe produit pour enregister un produit dans la bdd
public class Produit {
    private String photo, name,description,variation, price;
    public Produit(){ }
    public Produit(String photo, String name, String description, String variation, String prix){
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.variation = variation;
        this.price = prix;
    }
    //--------------------getters---------------------
    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVariation() {
        return variation;
    }

    public String getPrice() {
        return price;
    }

    //--------------------setters---------------------

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
