package fr.nohas.go4food.resto;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import fr.nohas.go4food.R;
// activité qui s'occupe de gestion de planning d'un restorateur
public class RestoWeelyPlanningActivity extends AppCompatActivity {

    CheckBox cbAll,cbMonday,cbTuesday,cbWendnesday,cbThursday,cbFriday,cbSaturday,cbSunday;
    EditText debJ1,finJ1,debJ2,finJ2,debJ3,finJ3,debJ4,finJ4,debJ5,finJ5,debJ6,finJ6,debJ7,finJ7;
    Button bttSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_weely_planning);

        cbAll = findViewById(R.id.cb_allDays);
        cbMonday = findViewById(R.id.cb_Monday);
        cbTuesday = findViewById(R.id.cb_tues);
        cbWendnesday = findViewById(R.id.cb_wendnesday);
        cbThursday = findViewById(R.id.cb_thursday);
        cbFriday = findViewById(R.id.cb_Friday);
        cbSaturday = findViewById(R.id.cb_saturday);
        cbSunday = findViewById(R.id.cb_sunday);

        //Edite Text input time
        debJ1=findViewById(R.id.et_deb1); finJ1=findViewById(R.id.et_fin1);

        debJ2=findViewById(R.id.et_deb2); finJ2=findViewById(R.id.et_fin2);

        debJ3=findViewById(R.id.et_deb3); finJ3=findViewById(R.id.et_fin3);

        debJ4=findViewById(R.id.et_deb4); finJ4=findViewById(R.id.et_fin4);

        debJ5=findViewById(R.id.et_deb5); finJ5=findViewById(R.id.et_fin5);

        debJ6=findViewById(R.id.et_deb6); finJ6=findViewById(R.id.et_fin6);

        debJ7=findViewById(R.id.et_deb7); finJ7=findViewById(R.id.et_fin7);

        bttSave = findViewById(R.id.btt_save);

        //when "check all" change state
        cbAll.setOnCheckedChangeListener((compoundButton, isChecke) -> cjeckAllCheckedChange(isChecke));

        //Save button
        bttSave.setOnClickListener(View->{
            registerPlanning();
        });
    }
    public void registerPlanning(){
        String debJ1Str,finJ1Str,debJ2Str,finJ2Str,debJ3Str,finJ3Str,debJ4Str,finJ4Str,debJ5Str,finJ5Str,debJ6Str,finJ6Str,debJ7Str,finJ7Str;
            debJ1Str=debJ1.getText().toString();
            finJ1Str=finJ1.getText().toString();
            debJ2Str=debJ2.getText().toString();
            finJ2Str=finJ2.getText().toString();
            debJ3Str=debJ3.getText().toString();
            finJ3Str=finJ3.getText().toString();
            debJ4Str=debJ4.getText().toString();
            finJ4Str=finJ4.getText().toString();
            debJ5Str=debJ5.getText().toString();
            finJ5Str=finJ5.getText().toString();
            debJ6Str=debJ6.getText().toString();
            finJ6Str=finJ6.getText().toString();
            debJ7Str=debJ7.getText().toString();
            finJ7Str=finJ7.getText().toString();

            if(cbMonday.isChecked() && (debJ1Str.isEmpty() || finJ1Str.isEmpty()) ){
                debJ1.setError(getString(R.string.field_required));
                return;
            }
            if(cbTuesday.isChecked() && (debJ2Str.isEmpty() || finJ2Str.isEmpty()) ){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
            if(cbWendnesday.isChecked() && (debJ3Str.isEmpty() || finJ3Str.isEmpty()) ){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
            if(cbThursday.isChecked() && (debJ4Str.isEmpty() || finJ4Str.isEmpty()) ){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
            if(cbFriday.isChecked() && (debJ5Str.isEmpty() || finJ5Str.isEmpty()) ){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
            if(cbSaturday.isChecked() && (debJ6Str.isEmpty() || finJ6Str.isEmpty()) ){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
            if(cbSunday.isChecked() && (debJ7Str.isEmpty() || finJ7Str.isEmpty()) ){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
            if(cbAll.isChecked()){
                 // if()
             }




    }

    //when "check all" change state
    private void cjeckAllCheckedChange(boolean isChecked){
        cbMonday.setChecked(isChecked);
        cbTuesday.setChecked(isChecked);
        cbWendnesday.setChecked(isChecked);
        cbThursday.setChecked(isChecked);
        cbFriday.setChecked(isChecked);
        cbSaturday.setChecked(isChecked);
        cbSunday.setChecked(isChecked);
    }
}