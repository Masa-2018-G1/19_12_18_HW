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
public class PasswordFragment extends Fragment implements View.OnClickListener {

    private EditText inputPassword;
    private Button backBtn, okBtn;
    private Callback callback;

    public PasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        inputPassword = view.findViewById(R.id.inputPassword);
        backBtn = view.findViewById(R.id.backBtn);
        okBtn = view.findViewById(R.id.okBtn);
        backBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.backBtn && callback != null){
            callback.onPasswordBackClick();
        }else if(v.getId() == R.id.okBtn && callback != null){
            callback.onPasswordOkCLick(inputPassword.getText().toString());
        }
    }

    public void setCallback(Callback callback){
        this.callback = callback;
    }

    public interface Callback{
        void onPasswordBackClick();
        void onPasswordOkCLick(String password);
    }
}
