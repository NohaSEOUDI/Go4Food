package fr.nohas.go4food.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import fr.nohas.go4food.R;
public class ClientRegisterActivity extends AppCompatActivity {
    private FirebaseAuth clientAuth;
    private Button bttRegister;
    private ProgressBar progressBar;
    private EditText edt_firstName,edt_lastName,edt_email,edt_phone,edt_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        edt_firstName=findViewById(R.id.edt_fName);
        edt_lastName=findViewById(R.id.edt_lName);
        edt_email=findViewById(R.id.email_adress);
        edt_phone=findViewById(R.id.edt_numTel);
        edt_password=findViewById(R.id.edt_pass);

        //initialize Firebase auth
        clientAuth=FirebaseAuth.getInstance();
       /* if(clientAuth.getCurrentUser() != null){ // do an alert not simply a toast
            Toast.makeText(this, "You have already an account !", Toast.LENGTH_SHORT).show();
            return;
        }*/

        bttRegister= findViewById(R.id.next);
        bttRegister.setOnClickListener(View->{
            registerUser();
            startActivity(new Intent(ClientRegisterActivity.this, ClientMenuActivity.class));
        });

        progressBar=findViewById(R.id.progressBar_register);

    }
    private void registerUser(){


        String fName,lName,emailAdress,phoneNumber,passwordString;

        fName=edt_firstName.getText().toString();
        lName=edt_lastName.getText().toString();
        emailAdress=edt_email.getText().toString();
        phoneNumber=edt_phone.getText().toString();
        passwordString=edt_password.getText().toString();

        //for validation
        if(fName.isEmpty()){
            edt_firstName.setError(getString(R.string.fName_required));
            edt_firstName.requestFocus();
            return;
        }
        if(lName.isEmpty()){
            edt_lastName.setError(getString(R.string.lName_required));
            edt_lastName.requestFocus();
            return;
        }
        if(emailAdress.isEmpty()){
            edt_email.setError(getString(R.string.email_adress_required));
            edt_email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAdress).matches()){
            edt_email.setError(getString(R.string.email_not_valid));
            edt_email.requestFocus();
            return;
        }
        if(phoneNumber.isEmpty()){
            edt_phone.setError(getString(R.string.phone_required));
            edt_phone.requestFocus();
            return;
        }
        if(passwordString.isEmpty()){
            edt_password.setError(getString(R.string.paswd_required));
            edt_password.requestFocus();
            return;
        }
        if(passwordString.length() < 6){
            edt_password.setError(getString(R.string.paswd_lenght));
            edt_password.requestFocus();
            return;
        }

        ///------------

        progressBar.setVisibility(View.VISIBLE);

        clientAuth.createUserWithEmailAndPassword(emailAdress,passwordString)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //so we create a client object
                            Client client= new Client(fName,lName,phoneNumber,emailAdress,passwordString);
                            FirebaseDatabase.getInstance().getReference("Client")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(client).addOnCompleteListener(new OnCompleteListener<Void>(){

                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(ClientRegisterActivity.this,getString(R.string.cl_registered), Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        //redirect to login layout
                                    }else {
                                        Toast.makeText(ClientRegisterActivity.this, getString(R.string.cl_not_registered), Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(ClientRegisterActivity.this, getString(R.string.cl_not_registered), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


    }
}