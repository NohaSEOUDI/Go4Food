package fr.nohas.go4food.client.Adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.nohas.go4food.R;
import fr.nohas.go4food.client.activities.DetailedDailyMealActivity;
import fr.nohas.go4food.client.models.DailyMealModel;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder> {
    Context context;
    List<DailyMealModel> listMeal;

    public DailyMealAdapter(Context context, List<DailyMealModel> listMeal) {
        this.context = context;
        this.listMeal = listMeal;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // layout d'item tjrs ici
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(listMeal.get(position).getImage()); // listMeal[position].getChose()
        holder.name.setText(listMeal.get(position).getName());
        holder.discount.setText(listMeal.get(position).getDiscount());
        holder.description.setText(listMeal.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedDailyMealActivity.class);
                intent.putExtra("type",listMeal.get(position).getType());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMeal.size();
    }

    //ici on init les composant trouvant dans notre layout_item
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,discount,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewDailyMeal);
            name = itemView.findViewById(R.id.textViewNameDailyMenu);
            discount = itemView.findViewById(R.id.discountTv);
            description = itemView.findViewById(R.id.descriptionTV);
        }
    }
}
