package com.glutenfreesoftware.shareable_shopping;

/**
 * Created by Kristian on 15.11.2017.
 */

public class RoomObj {

    private String RoomName;
    private String RoomOwner;

    public RoomObj(String roomName, String roomOwner) {
        RoomName = roomName;
        RoomOwner = roomOwner;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public String getRoomOwner() {
        return RoomOwner;
    }

    public void setRoomOwner(String roomOwner) {
        RoomOwner = roomOwner;
    }
}
