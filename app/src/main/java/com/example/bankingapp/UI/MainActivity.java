package com.example.bankingapp.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bankingapp.R;

public class MainActivity extends AppCompatActivity {

    Animation anim;
    LottieAnimationView lottieAnimationView;

    TextView bankName;
    Button allUsers, allTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        anim= AnimationUtils.loadAnimation(this, R.anim.animation);

        allUsers=findViewById(R.id.allUsers);
        allTransactions=findViewById(R.id.allTransactions);
        bankName=findViewById(R.id.bankName);
        lottieAnimationView=findViewById(R.id.lottie);

        bankName.setAnimation(anim);
        allUsers.setAnimation(anim);
        allTransactions.setAnimation(anim);
        lottieAnimationView.setAnimation(anim);
    }

    public void showAllUsers(View view){
        Intent intent= new Intent(this, UsersList.class);
        startActivity(intent);
    }

    public void showAllTransactions(View view){
        Intent intent= new Intent(this, TransferHistory.class);
        startActivity(intent);

    }

}