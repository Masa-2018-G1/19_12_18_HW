package com.sheygam.masa_2018_g1_19_12_18_hw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment implements View.OnClickListener {

    private EditText inputEmail;
    private Button backBtn, nextBtn;
    private Callback callback;

    public EmailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        inputEmail = view.findViewById(R.id.inputEmail);
        backBtn = view.findViewById(R.id.backBtn);
        nextBtn = view.findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backBtn && callback != null){
            callback.onEmailBackClick();
        }else if( v.getId() == R.id.nextBtn && callback != null){
            callback.onEmailNextClick(inputEmail.getText().toString());
        }
    }

    public void setCallback(Callback callback){
        this.callback = callback;
    }

    public interface Callback{
        void onEmailBackClick();
        void onEmailNextClick(String email);
    }

}
