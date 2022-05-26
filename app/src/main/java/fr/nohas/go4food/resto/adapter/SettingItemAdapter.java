package fr.nohas.go4food.resto.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import fr.nohas.go4food.R;
import fr.nohas.go4food.resto.fragments.NextResourcesFragment;

public class SettingItemAdapter extends RecyclerView.Adapter<SettingItemAdapter.MyViewHolder> {
    Context context;
    String listSittings[],listDesc[];
    int listIcons[];
    Fragment fragment;

    public SettingItemAdapter(Context cntx, String list1[], String list2[], int iconsList[]){
        this.context=cntx;
        this.listSittings = list1;
        this.listDesc = list2;
        this.listIcons = iconsList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // le nom de layout où on a crée le item row
        View view = inflater.inflate(R.layout.resto_row_item_setting, parent, false);
        return new MyViewHolder(view); // on passe le view à notre MyViewHolder constructeur
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {  //see le param
        //to dynamically set data
        holder.textView1.setText(listSittings[position]);
        holder.textView2.setText(listDesc[position]);
        holder.iconImage.setImageResource(listIcons[position]);
        
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we launch new Fragment here 
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                fragment = new NextResourcesFragment(listIcons[position],listSittings[position],listDesc[position]);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_holder,fragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return listSittings.length;
    }
    //MyViewHolder is communicated with onBindViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder { // on reçois le view ici, ainsi on doit récupérer les id de notre UI
        TextView textView1,textView2;
        ImageView iconImage;
        LinearLayout linearLayout;//mainLinearLayoutItemRow;
        
        public MyViewHolder(@NonNull View itemView) { // boite pour ranger tous les composants à controler
            super(itemView);

            textView1 = itemView.findViewById(R.id.tv_item_name);
            textView2 = itemView.findViewById(R.id.tv_item_desc);
            iconImage = itemView.findViewById(R.id.imageView_item);
            linearLayout = itemView.findViewById(R.id.mainLinearLayoutItemRow);

        }

    }
    
}
