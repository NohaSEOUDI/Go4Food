package fr.nohas.go4food.client;

public class Client {
    public String cl_first_name, cl_last_name,cl_phone_number,cl_email_adress,cl_password;

    public Client(){

    }
    public Client(String cl_first_name,String cl_last_name,String cl_phone_number,String cl_email_adress,String cl_password){
        this.cl_first_name=cl_first_name;
        this.cl_last_name=cl_last_name;
        this.cl_phone_number=cl_phone_number;
        this.cl_email_adress=cl_email_adress;
        this.cl_password=cl_password;
    }


}
