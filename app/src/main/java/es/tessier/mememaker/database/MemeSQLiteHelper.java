package es.tessier.mememaker.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;




public class MemeSQLiteHelper extends SQLiteOpenHelper {

    //Meme Table
    public final static String DB_NAME = "memes.db";
    public final static int DB_VERSION = 2;
    public final static String TAG = MemeSQLiteHelper.class.getName();


    public static final String CREATE_TABLE_MEMES = "CREATE TABLE " + MemeContract.MemesEntry.TABLE_NAME + " ( " +
            MemeContract.MemesEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MemeContract.MemesEntry.COLUMN_ASSET + " TEXT NOT NULL," +
            MemeContract.MemesEntry.COLUMN_NAME + " TEXT NOT NULL," +
            MemeContract.MemesEntry.COLUMN_CREATE_DATE + " INTEGER );";


    static final String CREATE_TABLE_ANNOTATIONS = "CREATE TABLE " + MemeContract.AnnotationsEntry.TABLE_NAME + " ( " +
            MemeContract.AnnotationsEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MemeContract.AnnotationsEntry.COLUMN_TITLE + " TEXT NOT NULL," +
            MemeContract.AnnotationsEntry.COLUMN_X + " INTEGER NOT NULL," +
            MemeContract.AnnotationsEntry.COLUMN_Y + " INTEGER NOT NULL," +
            MemeContract.AnnotationsEntry.COLUMN_COLOR + " INTEGER NOT NULL, " +
            "FOREIGN KEY (" + MemeContract.AnnotationsEntry.COLUMN_ID + ") " +    //  Foreign Key de esta  tabla
            " REFERENCES MEME(" + MemeContract.MemesEntry.COLUMN_ID + ") );"; //  hace referencia a la otra tabla.


///crearemos una constante llamada ALTER_ADD_CREATE_DATE
    public static final String ALTER_ADD_CREATE_DATE ="ALTER TABLE "+MemeContract.MemesEntry.TABLE_NAME +
            " ADD COLUMN "+ MemeContract.MemesEntry.COLUMN_CREATE_DATE+ "INTEGER ;";

    public MemeSQLiteHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE_MEMES);
            db.execSQL(CREATE_TABLE_ANNOTATIONS);
        } catch (SQLException e) {
            Log.e(TAG, "Android SQLEXCEPTION caught" + e);
        }
    }


    @Override

public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){

    switch (oldVersion){
        case 1:
            db.execSQL(ALTER_ADD_CREATE_DATE);
    }
}
}



