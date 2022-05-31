package com.example.bankingapp.UI;

import android.provider.BaseColumns;

public class UserLib {

private UserLib() {}

public  static final class UserEntry implements BaseColumns{



    public static final String DATABASE_NAME="User";
    public static final int DATABASE_VERSION=1;
    public  static final String TABLE_USER="users";
    public static final String COLUMN_USER_NAME="name";
    public static final String COLUMN_ACCOUNT_NUMBER="acc_no";
    public static final String COLUMN_IFSC_CODE="ifsc_code";
    public static final String COLUMN_PHONE_NO="phone_no";
    public static final String COLUMN_ACCOUNT_BALANCE="acc_bal";
    public static final String COLUMN_USER_EMAIL="email";










            ;
}




}
