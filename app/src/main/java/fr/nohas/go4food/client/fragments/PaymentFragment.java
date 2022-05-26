package fr.nohas.go4food.client.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import fr.nohas.go4food.R;
import fr.nohas.go4food.ClientOrderInProgressActivity;

public class PaymentFragment extends Fragment {
    EditText number,day,year,validationNumber;
    Button buttonSubmit;
    Fragment fragmentPaymentOK;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_payment, container, false);
        number = rootView.findViewById(R.id.edt_num_carte);
        day = rootView.findViewById(R.id.edt_jour_carte);
        year = rootView.findViewById(R.id.edt_annee_carte);
        validationNumber = rootView.findViewById(R.id.edt_numV_carte);
        buttonSubmit = rootView.findViewById(R.id.bt_ok_carte);

        buttonSubmit.setOnClickListener(View ->  {
            if(checkEditTExt()){
                startActivity(new Intent(getActivity(), ClientOrderInProgressActivity.class));
                //fragmentPaymentOK = new RestoAddedDoneFragment();
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.client_main_fragment_holder,fragmentPaymentOK).addToBackStack(null).commit();
            }
        });
        return rootView;
    }

    private boolean checkEditTExt(){
        String strNumber,strDay,strYear,strValidationNumber;
        strNumber = number.getText().toString();
        strDay  = day.getText().toString();
        strYear = year.getText().toString();
        strValidationNumber = validationNumber.getText().toString();

        if(strNumber.isEmpty()){
            number.setError(getString(R.string.number_required));
            number.requestFocus();
            return false;
        }else if(strDay.isEmpty()){
            number.setError(getString(R.string.day_required));
            number.requestFocus();
            return false;
        }
        else if(strYear.isEmpty()){
            number.setError(getString(R.string.year_required));
            number.requestFocus();
            return false;
        }
        else  if(strValidationNumber.isEmpty()){
            number.setError(getString(R.string.validation_number_required));
            number.requestFocus();
            return false;
        }
        return true;
    }
}