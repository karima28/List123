package com.testphase.list;

import android.provider.BaseColumns;

public class ItemContract {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "itemlist.db";




    public ItemContract() {}

    //Inner class that defines the table contents

    //TABLE 1 for itemlist (Groups) - ITEM ID AND ITEM NAME

    public static abstract class Table1 implements BaseColumns {
        public static final String ITEM_TABLE_NAME = "itemlist";
        public static final String ITEM_COLUMN_ID = "_id";
        public static final String ITEM_COLUMN_NAME = "name";
        public static final String ITEM_COLUMN_DESC = "description";

    }

    /* ADD THIS TABLE LATER !!
    TABLE 2 for iteminfo (Children) - ITEM ID AND ITEM DESCRIPTION
    public static abstract class Table2 implements BaseColumns {
        public static final String TABLE_NAME = "iteminfo";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_ITEM_DESC = "desc" ;


        //Creating/adding entries
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_ITEM_DESC + " TEXT" +
                        "ID_ITEM references " + Table1.TABLE_NAME
                        + ");";

        //Deleting entries
        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }*/
}
