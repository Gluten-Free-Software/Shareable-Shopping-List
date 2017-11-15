package com.glutenfreesoftware.shareable_shopping;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oebar on 08.11.2017.
 */

public class Rooms extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String username = "Kristian";


    private String password = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_rooms, container, false);

        username = getArguments().getString("username");
        password = getArguments().getString("password");
        System.out.println(username);

        recyclerView = (RecyclerView) view.findViewById(R.id.rooms_recyclerview);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        try{
            new getRooms(new getRooms.OnPostExecute() {
                @Override
                public void onPostExecute(List<RoomObj> rooms) {
                    if(rooms.isEmpty()){
                        System.out.println("rooms is empty");
                    }
                    for(RoomObj r: rooms){
                        System.out.println(r.getRoomName() + " " + r.getRoomOwner());
                    }


                }
            }).execute(new URL("http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/rooms/getRooms"));



        } catch (Exception e){
            e.printStackTrace();
        }


        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Rooms");
    }
}
