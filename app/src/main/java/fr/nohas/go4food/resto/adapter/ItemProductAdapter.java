package fr.nohas.go4food.resto.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.nohas.go4food.R;
import fr.nohas.go4food.resto.Produit;
import fr.nohas.go4food.resto.fragments.DescProductFragment;

//to adapt our recycler view of product
public class ItemProductAdapter extends RecyclerView.Adapter<ItemProductAdapter.MyViewHolder> {
   // Context context;
    ArrayList<Produit> arrayListProd;
    Uri uri;

    public ItemProductAdapter(ArrayList<Produit> arrayListProd) {
      //  this.context = context;
        this.arrayListProd = arrayListProd;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.resto_row_item_product,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produit p = arrayListProd.get(position);
        holder.nameProd.setText(p.getName());
        holder.image.setImageURI(null);//uri); // il faut mettre l'uri de l'image here

        holder.image.setOnClickListener(View ->{
            AppCompatActivity activity = (AppCompatActivity) View.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new DescProductFragment()).addToBackStack(null).commit();

        });
    }

    @Override
    public int getItemCount() {
        return arrayListProd.size();
    }

    //inner class
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameProd;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView); // les composant qui sont dans le itemRow product
            nameProd = itemView.findViewById(R.id.tv_prodName);
            image = itemView.findViewById(R.id.iv_image);
        }
    }
}
