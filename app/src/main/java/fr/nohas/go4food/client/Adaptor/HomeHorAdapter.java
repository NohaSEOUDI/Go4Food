package fr.nohas.go4food.client.Adaptor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.nohas.go4food.R;
import fr.nohas.go4food.client.interfaces.UpdateVerticalRec;
import fr.nohas.go4food.client.models.HomeHorModel;
import fr.nohas.go4food.client.models.HomeVerModel;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza_1, "Pizza Big Boss", "10:00 -23:00", "4.9", "Min - $34"));
            homeVerModels.add(new HomeVerModel(R.drawable.burger6, "Burger St Roch", "10:00 -23:00", "4.9", "Min - $34"));
            homeVerModels.add(new HomeVerModel(R.drawable.frites7, "Frittes Frottes", "10:00 -23:00", "4.9", "Min - $34"));
            homeVerModels.add(new HomeVerModel(R.drawable.fish7, "Possoin St Roch", "10:00 -23:00", "4.9", "Min - $34"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            //choose categories
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    notifyDataSetChanged();
                    if(position == 0) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.frites1,"Frites King","9:00 - 23:00","3.9","Min - $14"));
                        homeVerModels.add( new HomeVerModel(R.drawable.frites4,"French frites ","8:00 - 23:00","5.0","Min - $11"));
                        homeVerModels.add( new HomeVerModel(R.drawable.frites3,"Frites frotte","7:00 - 23:00","2.9","Min - $30"));
                        homeVerModels.add( new HomeVerModel(R.drawable.frites5,"Frites rock","11:00 - 23:00","1.9","Min - $40"));
                        homeVerModels.add( new HomeVerModel(R.drawable.frites6,"Frites st roch","11:00 - 23:00","1.9","Min - $6"));
                        homeVerModels.add( new HomeVerModel(R.drawable.frites7,"Frites Comédie","11:00 - 23:00","1.9","Min - $6"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    }else if(position == 1) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    } else if(position == 2) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza1,"Pizza King","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza2,"Pizza Pizza","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza3,"Pizza 2","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza5,"Pizza Boss","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza6,"Pizza Boss","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza8,"Pizza Boss","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.pizza9,"Pizza Boss","10:00 -23:00","4.9","Min - $34"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    }else if(position == 3) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.taco3,"Tacos Tacos","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.taco6,"Tacos st roch","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.taco7,"Tacos Orientale","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.tacos1,"Tacos Frenchi","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.tacos2,"Tacos Frenchi","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.tacos5,"Tacos Frenchi","10:00 -23:00","4.9","Min - $34"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    }else if(position == 4) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.burger1,"Big Burger","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger2,"Burger Odysseum","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger3,"Burger Mosson","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger6,"Burger Occitanie","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger7,"Burger U","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.burger,"Burger Université","10:00 -23:00","4.9","Min - $34"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    }else if(position == 5) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add( new HomeVerModel(R.drawable.fish1,"Fish Occitanie","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fish2,"Fish Fish","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fish4,"Fish Université","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fish6,"Fish Mosson","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fish7,"Fish Odysseum","10:00 -23:00","4.9","Min - $34"));
                        homeVerModels.add( new HomeVerModel(R.drawable.fish8,"Fish Frenchi","10:00 -23:00","4.9","Min - $34"));
                        updateVerticalRec.callBack(position, homeVerModels);
                    }
                }
            });

            if(select){
                if(position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }else {
                if(row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else{
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    //c'est l'initalisation des composants de la classe home_horizontal_item.xml
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }
}
