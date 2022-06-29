package com.example.hurl_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    //creating 2 different tables to store different datatype
    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(user_id INTEGER PRIMARY KEY AUTOINCREMENT,username Text,fullname Text, email_address Text,password Text,date_created Text)");
        myDatabase.execSQL("create Table posts(post_id INTEGER PRIMARY KEY AUTOINCREMENT,fullname Text,content Text,date_post Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //function to store entered data into the database when registering new user
    public void insertData(String username,String fullName,String email,String password,String date){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("fullname",fullName);
        values.put("email",email);
        values.put("password",password);
        values.put("day",date);

        myDatabase.insert("users",null,values);
    }

    //table will update when user edits and updates their profile information
    public void updateIndividual(String username,String fullName,String email,String password, String individual_id){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("fullname",fullName);
        values.put("email",email);
        values.put("password", password);
        myDatabase.update("users",values,"individual_id =?", new String[] {String.valueOf(individual_id)});
    }

    //cursor will check for username and password validation
    public Cursor loginCheck(String userName, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username = ? and password =?", new String[]{userName, pass});
    }

    public void contentAdd(String fullName,String desc,String date){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //will set name, current date and post content when posting
        values.put("fullname", fullName);
        values.put("content", desc);
        values.put("date_post", date);

        database.insert("timeline", null, values); //data insert into timeline
    }

    public Cursor allPosts(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from timeline order by timeline_id desc";
        return db.rawQuery(sql,null);
    }

    public Cursor myposts(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM timeline WHERE fullname = ?", new String[]{name});
    }
}
