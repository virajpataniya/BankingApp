package com.example.bankingapp.UI;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;


import java.util.ArrayList;

public class UsersList extends AppCompatActivity {

// RecyclerView

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<User> userArrayList;

    //Database
    private UserHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_users);

        // create array list of users
        userArrayList =new ArrayList<User>();

        //create table in database
        dbHelper =new UserHelper(this);

        // Read data from database
        displayDatabaseInfo();

        //show list of items
        recyclerView =findViewById(R.id.usersList);
        recyclerView.setHasFixedSize(true);

        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new UserListAdapter(this, userArrayList);
        recyclerView.setAdapter(myAdapter);
    }

    private void displayDatabaseInfo() {
        userArrayList.clear();

        Cursor cursor = new UserHelper(this).readAllData();

        int phoneNoColumnIndex = cursor.getColumnIndex(UserLib.UserEntry.COLUMN_PHONE_NO);
        int emailColumnIndex = cursor.getColumnIndex(UserLib.UserEntry.COLUMN_USER_EMAIL);
        int ifscCodeColumnIndex = cursor.getColumnIndex(UserLib.UserEntry.COLUMN_IFSC_CODE);
        int accountNumberColumnIndex = cursor.getColumnIndex(UserLib.UserEntry.COLUMN_ACCOUNT_NUMBER);
        int nameColumnIndex = cursor.getColumnIndex(UserLib.UserEntry.COLUMN_USER_NAME);
        int accountBalanceColumnIndex = cursor.getColumnIndex(UserLib.UserEntry.COLUMN_ACCOUNT_BALANCE);

        while (cursor.moveToNext()){
            String currentName = cursor.getString(nameColumnIndex);
            int accountNumber = cursor.getInt(accountNumberColumnIndex);
            String email = cursor.getString(emailColumnIndex);
            String phoneNumber = cursor.getString(phoneNoColumnIndex);
            String ifscCode = cursor.getString(ifscCodeColumnIndex);
            int accountBalance = cursor.getInt(accountBalanceColumnIndex);

            // Display the values from each column of the current row in the cursor in the TextView
            userArrayList.add(new User(currentName, accountNumber, phoneNumber, ifscCode, accountBalance, email));
        }

    }

}
