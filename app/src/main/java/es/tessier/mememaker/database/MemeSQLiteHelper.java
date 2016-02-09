package es.tessier.mememaker.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/**
 * Created by Evan Anger on 8/17/14.
 */
public class MemeSQLiteHelper extends SQLiteOpenHelper{

    //Meme Table
    public final static String DB_NAME="memes.db";
    public final static int DB_VERSION=1;
    public final static String TAG="Error";
    public MemeSQLiteHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE_MEMES);
            db.execSQL(CREATE_TABLE_ANNOTATIONS);
        }catch (SQLException e){
            Log.e(TAG,"Android SQLEXCEPTION caught"+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //Meme Table Annotations functionality
    static final String MEMES_TABLE="MEMES";
    static final String COLUMN_MEMES_ASSET="asset";
    static final String COLUMN_MEMES_NAME="name";
    static final String COLUMN_MEMES_ID="_id";


    static final String ANNOTATION_TABLE="ANNOTATIONS";
    static final String COLUMN__ID="_id";
    static final String COLUMN_TITLE="title";
    static final int COLUMN_X=0;
    static final int COLUMN_Y=0;
    static final int COLUMN_COLOR=0;
    static final String CREATE_TABLE_MEMES="CREATE TABLE"+MEMES_TABLE+"("+
            COLUMN_MEMES_ID+"INTEGER PRIMARY KEY AUTOINCREMENT"+
            COLUMN_MEMES_ASSET+"TEXT NOT NULL"+
            COLUMN_MEMES_NAME+"TEXT NOT NULL)";



    static final String CREATE_TABLE_ANNOTATIONS="CREATE TABLE"+ANNOTATION_TABLE+"("+
            COLUMN__ID+"INTEGER PRIMARY KEY AUTOINCREMENT"+
            COLUMN_TITLE+"TEXT NOT NULL"+
            COLUMN_X+"INTEGER NOT NULL" +
            COLUMN_Y+"INTEGER NOT NULL"+
            COLUMN_COLOR+"INTEGER NOT NULL FOREIGN KEY"+")";
}