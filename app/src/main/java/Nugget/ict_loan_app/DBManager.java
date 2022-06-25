package Nugget.ict_loan_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {
    public static String DB_name = "ICT_Storage_info";

    //information regarding SQL Tables
    public static String tableName = "IT_Items";
    public static String id_COLUMN = "ID";
    public static String type_COLUMN = "Item_Type";
    public static String desc_COLUMN = "Item_Desc";

    public static int DATABASE_VERSION = 1;

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_name, factory, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + tableName + "(" + id_COLUMN + " INTEGER," + type_COLUMN + " TEXT,"
                + desc_COLUMN + " TEXT" + ")";

        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
    }

    public void inputItems(ArrayList<Item> itemList){
        SQLiteDatabase db = this.getReadableDatabase();

        for (Item item : itemList){
            ContentValues values = new ContentValues();

            int ID = item.getID();
            String type = item.getItem_Type();
            String des = item.getItem_Desc();

            values.put(id_COLUMN, ID);
            values.put(type_COLUMN, type);
            values.put(desc_COLUMN, des);

            db.insert(tableName, null, values);
        }

        db.close();
    }
}
