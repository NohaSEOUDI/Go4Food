package fr.nohas.go4food.driver.driverAdapter;

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
import fr.nohas.go4food.driver.driverModels.UsersHistModel;


public class HistAdapter extends RecyclerView.Adapter<HistAdapter.ViewHolder> {
    Context context;
    List<UsersHistModel> listUserHistModels;

    public HistAdapter(Context context, List<UsersHistModel> listUserHistModels) {
        this.context = context;
        this.listUserHistModels = listUserHistModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.historic_user_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(listUserHistModels.get(position).getImage());
        holder.name.setText(listUserHistModels.get(position).getName());
        holder.ville.setText(listUserHistModels.get(position).getVille());
        holder.address.setText(listUserHistModels.get(position).getAddress());
        holder.hour.setText(listUserHistModels.get(position).getHour());
        holder.date.setText(listUserHistModels.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return listUserHistModels.size();
    }

    //les composants trouvant dans l'historic_user_item
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,ville,address,hour,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hist_image_user);
            name = itemView.findViewById(R.id.hist_name);
            ville =  itemView.findViewById(R.id.hist_city);
            address =  itemView.findViewById(R.id.hist_address);
            hour = itemView.findViewById(R.id.hist_timming);
            date= itemView.findViewById(R.id.hist_date);
        }
    }
}
