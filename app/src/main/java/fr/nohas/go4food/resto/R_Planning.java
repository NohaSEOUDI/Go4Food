package fr.nohas.go4food.resto;

//planning d'un Resto --> les horaires d'ouvertures et de fermeture
public class R_Planning {
    public String lundi,mardi,mercredi,jeudi,vendredi,samedi,dimanche;
    public Resto id_resto;

    public R_Planning(){ }
    public R_Planning(String lundi,String mardi,String mercredi,String jeudi,String vendredi,String samedi,String dimanche,Resto id_resto){
        this.lundi=lundi;
        this.mardi=mardi;
        this.mercredi=mercredi;
        this.jeudi=jeudi;
        this.vendredi=vendredi;
        this.samedi=samedi;
        this.dimanche=dimanche;
        this.id_resto=id_resto;
    }
}
