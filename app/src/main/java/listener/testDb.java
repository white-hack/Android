package listener;

import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import activity.MainActivity;

/**
 * Created by on 2016/03/01.
 */
public class testDb implements DialogInterface.OnClickListener {
    static final String DB = "sqlite_sample.db";
    static final int DB_VERSION = 1;
    static final String CREATE_TABLE = "create table mytable ( _id integer primary key autoincrement, data text not null );";
    static final String DROP_TABLE = "drop table mytable;";

    static SQLiteDatabase mydb;

    private SimpleCursorAdapter myadapter;

    private MainActivity context;

    private ListView listview;
    private Button addbtn, delbtn;

    public testDb(MainActivity c){
        context = c;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        insertTest(context, "test");
    }

    public void insertTest (MainActivity ac ,String data) {
        MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(context);
        mydb = hlpr.getWritableDatabase();

//        ContentValues values = new ContentValues();
//        values.put("data", "data1");
//        mydb.insert("mytable", null, values);

        SQLiteCursor c = (SQLiteCursor) mydb.query("mytable", new String[] {"_id", "data"}, null, null, null, null, "_id DESC");

        int rowcount = c.getCount();
        StringBuffer sb = new StringBuffer();
        c.moveToFirst();

        for (int i = 0; i < rowcount ; i++) {
            int id = c.getInt(0);
            String name = c.getString(1);

            sb.append("[" + id + "," + name + "]¥n");

            c.moveToNext();
        }

        Log.d("debug", sb.toString());
    }

    private static class MySQLiteOpenHelper extends SQLiteOpenHelper {
        public MySQLiteOpenHelper(Context c) {
            super(c, DB, null, DB_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
}

