package com.sheygam.masa_2018_g1_19_12_18_hw;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WelcomeFragment.Callback, EmailFragment.Callback, PasswordFragment.Callback {
    private WelcomeFragment wf;
    private String email;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wf = new WelcomeFragment();
        wf.setCallback(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_container,wf)
                .commit();
    }

    @Override
    public void onLoginClicked() {
        EmailFragment ef = new EmailFragment();
        ef.setCallback(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_container,ef)
                .addToBackStack("ROOT")
                .commit();
    }

    @Override
    public void onEmailBackClick() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onEmailNextClick(String email) {
        this.email = email;
        PasswordFragment pf = new PasswordFragment();
        pf.setCallback(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_container,pf)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onPasswordBackClick() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onPasswordOkCLick(String password) {
        this.password = password;
        Bundle args = new Bundle();
        args.putString("EMAIL",email);
        args.putString("PASSWORD",password);
        wf.setArguments(args);
        getSupportFragmentManager().popBackStack("ROOT",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
