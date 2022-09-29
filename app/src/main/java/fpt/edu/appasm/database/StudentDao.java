package fpt.edu.appasm.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import fpt.edu.appasm.XDate.DayBirthday;
import fpt.edu.appasm.model.Classes;
import fpt.edu.appasm.model.Student;

public class StudentDao {
    private SQLiteDatabase db;

    public StudentDao(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public void insert(Student st){
        ContentValues values = new ContentValues();

        values.put("id", st.getId());
        values.put("name", st.getName());
        values.put("dayBirthdaty", DayBirthday.toDateString(st.getDayBirthday()));
        values.put("idclass", st.getIdClass());

        db.insert("student", null, values);
    }

    @SuppressLint("Range")
    public List<Student> get(String sql, String... select) throws ParseException {
        List<Student> list = new ArrayList<>();

        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(sql, select);

        while (cursor.moveToNext()) {
            Student student = new Student();
            student.setId(cursor.getString(cursor.getColumnIndex("id")));
            student.setName(cursor.getString(cursor.getColumnIndex("name")));
            student.setDayBirthday(DayBirthday.toDate(cursor.getString(cursor.getColumnIndex("dayBirthday"))));
            student.setIdClass(cursor.getString(cursor.getColumnIndex("idclass")));
            list.add(student);
        }
        return list;
    }

    public List<Student> getAll() throws ParseException {
        String sql = "SELECT * FROM student";
        return get(sql);
    }

    public List<Student> getAllByClass(String idclass) throws ParseException {
        String sql = "SELECT * FROM student WHERE idclass=?";
        return get(sql, idclass);
    }

    public void update(Student st){
        ContentValues values = new ContentValues();
        values.put("name", st.getName());
        values.put("dayBirthday", DayBirthday.toDateString(st.getDayBirthday()));
        values.put("idclass", st.getIdClass());
        db.update("student", values, "id=?", new String[]{st.getId()});
    }

    public void delete (String id){
        db.delete("student", "id=?", new String[]{id});
    }

}
