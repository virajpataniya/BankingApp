package com.example.bankingapp.UI;

import static com.example.bankingapp.UI.UserLib.UserEntry.COLUMN_ACCOUNT_BALANCE;
import static com.example.bankingapp.UI.UserLib.UserEntry.COLUMN_ACCOUNT_NUMBER;
import static com.example.bankingapp.UI.UserLib.UserEntry.COLUMN_IFSC_CODE;
import static com.example.bankingapp.UI.UserLib.UserEntry.COLUMN_PHONE_NO;
import static com.example.bankingapp.UI.UserLib.UserEntry.COLUMN_USER_EMAIL;
import static com.example.bankingapp.UI.UserLib.UserEntry.COLUMN_USER_NAME;
import static com.example.bankingapp.UI.UserLib.UserEntry.DATABASE_NAME;
import static com.example.bankingapp.UI.UserLib.UserEntry.DATABASE_VERSION;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankingapp.UI.UserLib.UserEntry;

public class UserHelper extends SQLiteOpenHelper {



    String TABLE_USER = UserLib.UserEntry.TABLE_USER;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + UserLib.UserEntry.TABLE_USER + "("
                + COLUMN_ACCOUNT_NUMBER + "INTEGER NOT NULL, " + COLUMN_USER_NAME + "VARCHAR NOT NULL, "
                + COLUMN_USER_EMAIL + " VARCHAR NOT NULL," + COLUMN_IFSC_CODE + " VARCHAR NOT NULL," + COLUMN_PHONE_NO + "INTEGER NOT NULL, "
                + COLUMN_ACCOUNT_BALANCE + "INTEGER NOT NULL);"  );

        //Insert the SQl statement
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(5643,'Bhavesh','bhavesh@gmail.com','6754','98675483',10000)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(4633,'Viraj','viraj@gmail.com','1354','765846333',9000)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(7624,'Dhairya','dhairya@gmail.com','6754','98675483',8700)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(5643,'Nitin ','nitin@gmail.com','3452','876954673',7400)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(8965,'Jayam','jayam@gmail.com','1258','765839024',5400)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(2167,'Sanjeev','sanjeev@gmail.com','1264','768594375',5200)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(2674,'Tushar','tushar@gmail.com','54632','756749375',3300)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(3456,'Jerry','jerry@gmail.com','1544','6758456327',4300)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(8752,'Ayush','ayush@gmail.com','7621','675905463',5900)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(5632,'Krunal','krunal@gmail.com','7869','8769679435',4600)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(7890,'Jayant','jayant@gmail.com','9765','786653455',6340)");
        sqLiteDatabase.execSQL("insert into " + TABLE_USER+" values(5641,'Yagnik','yagnik@gmail.com','1453','768930546',1500)");


        SQLiteDatabase database= this.getWritableDatabase();
        database.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        onCreate(sqLiteDatabase);
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_USER, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_USER + " set " + UserEntry.COLUMN_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_ACCOUNT_NUMBER + " = " + accountNo);
    }

}


