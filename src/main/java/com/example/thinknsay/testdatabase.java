package com.example.thinknsay;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class testdatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testdatabase);

        VocabDatabaseHelper dbHelper = new VocabDatabaseHelper (this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String insertQuery = "INSERT INTO Vocabtable (word, category) values('green','color'),('red','color')," +
                "('blue','color'),('pink','color')";
        String insertQuery1 = "INSERT INTO Vocabtable (word, category) values('orange', 'fruit') ";
        String insertQuery2 = "INSERT INTO Vocabtable (word, category) values('apple', 'fruit') ";

        db.execSQL(insertQuery);
        db.execSQL(insertQuery1);
        db.execSQL(insertQuery2);

        String query = "SELECT * From Vocabtable";
        Cursor cursor = db.rawQuery(query, null);
        StringBuilder sb = new StringBuilder();
        while (cursor.moveToNext()) {
            String word = cursor.getString(cursor.getColumnIndex("word"));
            String name = cursor.getString(cursor.getColumnIndex("category"));
            sb.append(word + " : " + name);
            sb.append("\n");
        }
        cursor.close();
        db.close();

        TextView tvName = (TextView)findViewById(R.id.textView1);
        tvName.setText(sb.toString());

    }
}
