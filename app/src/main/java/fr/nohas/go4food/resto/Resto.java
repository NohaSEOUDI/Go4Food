package fr.nohas.go4food.resto;

public class Resto {
    public String r_nom, r_adresse, r_mail, r_city, r_password, r_phone;
    //public R_Planning horaireDeTravail;


    public Resto(){  }
    public Resto(String r_nom,String r_adresse,String r_mail,String r_city,String r_password,String r_phone){//,R_Planning horaireDeTravail){
         this.r_nom=r_nom;
         this.r_adresse=r_adresse;
         this.r_mail=r_mail;
         this.r_city=r_city;
         this.r_password=r_password;
         this.r_phone=r_phone;
      //   this.horaireDeTravail=horaireDeTravail;
    }

}
