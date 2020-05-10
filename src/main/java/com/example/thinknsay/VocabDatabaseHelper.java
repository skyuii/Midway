package com.example.thinknsay;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VocabDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "vocab.db";
    private static final int DATABASE_VERSION = 1;
    public VocabDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Vocabtable "
                + " ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " word TEXT, "
                + " category TEXT "
                + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Vocabtable");
        onCreate(db);
    }
}
