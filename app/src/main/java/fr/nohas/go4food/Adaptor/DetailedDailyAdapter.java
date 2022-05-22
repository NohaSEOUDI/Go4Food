package fr.nohas.go4food.Adaptor;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.nohas.go4food.R;
import fr.nohas.go4food.client.models.DetailedDailyModel;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {
    List<DetailedDailyModel> list;

    public DetailedDailyAdapter(List<DetailedDailyModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage()); // listMeal[position].getChose()
        holder.name.setText(list.get(position).getName());
        holder.rating.setText(list.get(position).getRating());
        holder.description.setText(list.get(position).getDescription());
        holder.price.setText(list.get(position).getPrice());
        holder.timing.setText(list.get(position).getTiming());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,rating,description,price,timing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            rating = itemView.findViewById(R.id.detailed_rating);
            description = itemView.findViewById(R.id.detailed_description);
            price = itemView.findViewById(R.id.detailed_price);
            timing = itemView.findViewById(R.id.timming);
        }
    }
}
