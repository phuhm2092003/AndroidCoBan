package fpt.edu.appasm.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpt.edu.appasm.model.Classes;

public class ClassesDao {
    private SQLiteDatabase db;

    public ClassesDao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public void insert(Classes cl){
        ContentValues values = new ContentValues();
        values.put("id", cl.getId());
        values.put("name", cl.getName());

        db.insert("classes", null, values);
    }

    @SuppressLint("Range")
    public List<Classes> get(String sql, String...select){
        List<Classes> list = new ArrayList<>();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(sql, select);
        while (cursor.moveToNext()) {
            Classes classes = new Classes();
            classes.setId(cursor.getString(cursor.getColumnIndex("id")));
            classes.setName(cursor.getString(cursor.getColumnIndex("name")));
            list.add(classes);
        }

        return list;
    }

    public List<Classes> getAll(){
        String sql = "SELECT * FROM classes";
        return get(sql);
    }

    public int delete(String id){
        return db.delete("classes", "id=?", new String[]{id});
    }
}
