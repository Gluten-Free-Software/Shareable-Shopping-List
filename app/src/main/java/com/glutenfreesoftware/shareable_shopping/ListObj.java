package com.glutenfreesoftware.shareable_shopping;

/**
 * Created by Kristian on 15.11.2017.
 */

public class ListObj {

    private String listRoom;
    private String listName;
    private String listOwner;

    public ListObj(String listRoom, String listName, String listOwner) {
        this.listRoom = listRoom;
        this.listName = listName;
        this.listOwner = listOwner;
    }

    public String getListRoom() {
        return listRoom;
    }

    public void setListRoom(String listRoom) {
        this.listRoom = listRoom;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListOwner() {
        return listOwner;
    }

    public void setListOwner(String listOwner) {
        this.listOwner = listOwner;
    }
}

