package fpt.edu.appasm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "appASM";
    private static final int DB_VESION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VESION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String classesSQL = "CREATE TABLE classes(id text PRIMARY KEY NOT NULL," +
                "name text NOT NULL)";
        String studentSQL = "CREATE TABLE student(id text PRIMARY KEY NOT NULL," +
                "name text NOT NULL," +
                "dayBirthday text NOT NULL," +
                "idclass text NOT NUll," +
                "FOREIGN KEY (idclass) REFERENCES classes(id))";
        sqLiteDatabase.execSQL(classesSQL);
        sqLiteDatabase.execSQL(studentSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String calssesSql = "DROP TABLE IF EXISTS classes";
        String studentSql = "DROP TABLE IF EXISTS student";

        sqLiteDatabase.execSQL(calssesSql);
        sqLiteDatabase.execSQL(studentSql);

        onCreate(sqLiteDatabase);
    }
}
