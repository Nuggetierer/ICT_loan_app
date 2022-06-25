package Nugget.ict_loan_app;

import java.io.Serializable;

public class Item implements Serializable {
    public static Integer ID;
    public static String Item_Type;
    public static String Item_Desc;

    public Item(){}

    public Item(Integer id, String type, String desc){
        ID = id;
        Item_Type = type;
        Item_Desc = desc;
    }

    public static Integer getID() {
        return ID;
    }

    public static void setID(Integer ID) {
        Item.ID = ID;
    }

    public static String getItem_Type() {
        return Item_Type;
    }

    public static void setItem_Type(String item_Type) {
        Item_Type = item_Type;
    }

    public static String getItem_Desc() {
        return Item_Desc;
    }

    public static void setItem_Desc(String item_Desc) {
        Item_Desc = item_Desc;
    }
}
