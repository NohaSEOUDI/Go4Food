package fr.nohas.go4food.driver;

public class Driver {
    public String d_nom, d_prenom,d_city, d_adress, d_adressmail, d_numTel,d_password ;
    public int d_age;
    public String d_typeVehicule;
    public Boolean d_receve_delivery_commandes;
    // public D_Planning d_dispo;

    public Driver(){  }

    public Driver(String d_nom, String d_prenom,String d_city, String d_adress, String d_adressmail, String d_numTel, String d_password, int d_age,String d_typeVehicule, Boolean d_receve_delivery_commandes){//D_Planning d_dispo,
        this.d_nom=d_nom;
        this.d_prenom=d_prenom;
        this.d_city=d_city;
        this.d_adress=d_adress;
        this.d_adressmail=d_adressmail;
        this.d_numTel=d_numTel;
        this.d_password=d_password;
        this.d_age=d_age;
        this.d_typeVehicule=d_typeVehicule;
        this.d_receve_delivery_commandes=d_receve_delivery_commandes;
        //this.d_dispo=d_dispo;
    }

}
