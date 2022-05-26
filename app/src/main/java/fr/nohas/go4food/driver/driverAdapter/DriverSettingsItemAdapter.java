package fr.nohas.go4food.driver.driverAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
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
import fr.nohas.go4food.driver.driverfragments.DriverAccountFragment;
import fr.nohas.go4food.driver.driverfragments.DriverAlertesFragment;
import fr.nohas.go4food.driver.driverfragments.DriverEvaluationFragment;
import fr.nohas.go4food.driver.driverfragments.DriverNotificationsFragment;
import fr.nohas.go4food.driver.driverfragments.DriverPositionFragment;
import fr.nohas.go4food.driver.driverfragments.DriverSchedualFragment;
import fr.nohas.go4food.resto.fragments.NextResourcesFragment;

public class DriverSettingsItemAdapter extends RecyclerView.Adapter<DriverSettingsItemAdapter.MyViewHolder> {
    Context context;
    String driverListSittings[],driverListDesc[];
    int driverListIcons[];
    Fragment fragment;

    public DriverSettingsItemAdapter(Context context, String[] driverListSittings, String[] driverListDesc, int[] driverListIcons,Fragment fragment) {
        this.context = context;
        this.driverListSittings = driverListSittings;
        this.driverListDesc = driverListDesc;
        this.driverListIcons = driverListIcons;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_row_item_setting,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //to dynamically set data
        holder.textView1.setText(driverListSittings[position]);
        holder.textView2.setText(driverListDesc[position]);
        holder.iconImage.setImageResource(driverListIcons[position]);

        holder.linearLayoutOnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //we launch new Fragment here

                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                fragment = new DriverAccountFragment();//driverListIcons[position],driverListSittings[position],driverListDesc[position]);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return driverListSittings.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2;
        ImageView iconImage;
        LinearLayout linearLayoutOnclick;//mainLinearLayoutItemRow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.dr_tv_item_name);
            textView2 = itemView.findViewById(R.id.dr_tv_item_desc);
            iconImage = itemView.findViewById(R.id.dr_imageView_item);
            linearLayoutOnclick = itemView.findViewById(R.id.mainLinearLayoutItemRowDriver);


        }
    }
}
