package fr.nohas.go4food.driver.driverModels;

public class UsersHistModel {
    int image;
    String name,ville,address,hour,date;

    public UsersHistModel(int image, String name, String ville, String address, String hour, String date) {
        this.image = image;
        this.name = name;
        this.ville = ville;
        this.address = address;
        this.hour = hour;
        this.date = date;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
