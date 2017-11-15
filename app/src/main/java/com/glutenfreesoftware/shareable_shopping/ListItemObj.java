package com.glutenfreesoftware.shareable_shopping;

/**
 * Created by Kristian on 15.11.2017.
 */

public class ListItemObj {

    private String listItemList;
    private String listItemName;
    private String listItemOwner;

    public ListItemObj(String listItemList, String listItemName, String listItemOwner) {
        this.listItemList = listItemList;
        this.listItemName = listItemName;
        this.listItemOwner = listItemOwner;
    }

    public String getListItemList() {
        return listItemList;
    }

    public void setListItemList(String listItemList) {
        this.listItemList = listItemList;
    }

    public String getListItemName() {
        return listItemName;
    }

    public void setListItemName(String listItemName) {
        this.listItemName = listItemName;
    }

    public String getListItemOwner() {
        return listItemOwner;
    }

    public void setListItemOwner(String listItemOwner) {
        this.listItemOwner = listItemOwner;
    }
}
