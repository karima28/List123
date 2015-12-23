package com.testphase.list;

/**
 * Created by deea on 23/12/15.
 */
public class Item {
    int _id;
    String _name;
    String _description;
    byte[] _image;

    // Empty constructor
    public Item() {

    }

    // constructor
    public Item(int id, String name, String description, byte[] image) {
        this._id = id;
        this._name = name;
        this._description = description;
    }

    // constructor
    public Item(String name, String description, byte[] image) {
        this._name = name;
        this._description = description;
    }

    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }

}
