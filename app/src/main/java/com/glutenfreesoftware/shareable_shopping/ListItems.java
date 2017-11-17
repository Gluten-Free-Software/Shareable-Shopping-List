package com.glutenfreesoftware.shareable_shopping;

/**
 * Created by Kristian on 15.11.2017.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oebar on 08.11.2017.
 */

public class ListItems extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String username = "";
    private String room = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_list_items, container, false);

        Button deleteRoomBtn = (Button) view.findViewById(R.id.delete_list);
        deleteRoomBtn.setOnClickListener( new View.OnClickListener(){
                                              @Override
                                              public void onClick(View v){
                                                  //Insert code for adding to server from server
                                                  System.out.println("List deleted");
                                              }
                                          }
        );
        Button shareListBtn = (Button) view.findViewById(R.id.share_list);
        shareListBtn.setOnClickListener( new View.OnClickListener(){
                                              @Override
                                              public void onClick(View v){
                                                  //Insert code for adding to server from server
                                                  System.out.println("Shared list");
                                              }
                                          }
        );
        Button addItemBtn = (Button) view.findViewById(R.id.add_item);
        addItemBtn.setOnClickListener( new View.OnClickListener(){
                                             @Override
                                             public void onClick(View v){
                                                 //Insert code for adding to server from server
                                                 System.out.println("Item added");
                                             }
                                         }
        );

        username = getArguments().getString("username");
        room = getArguments().getString("list");
        getActivity().setTitle(room);
        System.out.println("ListItem: " + username + " " + room);

        recyclerView = (RecyclerView) view.findViewById(R.id.rooms_recyclerview);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        final List<ListItemObj> input = new ArrayList<>();
        try{
            new getListItems(new getListItems.OnPostExecute() {
                @Override
                public void onPostExecute(List<ListItemObj> listItems) {
                    if(listItems.isEmpty()){
                        System.out.println("listItems is empty");
                    }
                    for(ListItemObj l: listItems){
                        System.out.println(l.getListItemList() + " " + l.getListItemName() + " " + l.getListItemOwner());
                        input.add(l);
                    }
                    mAdapter = new ListItemAdapter("Kristian", input);
                    recyclerView.setAdapter(mAdapter);
                }
            }).execute(new URL("http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/getListItems?listItemList=Taco&listItemOwner=Kristian"));
        } catch (Exception e){
            e.printStackTrace();
        }
        //"http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/getLists?listRoom=Oppskrifter&listOwner=Kristian"
        //
        //http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/getLists?listRoom=Oppskrifter&listOwner=Kristian

        //List<String> input = new ArrayList<>();
        //for (int i = 0; i < 100; i++) {
        //    input.add("Test" + i);
        //}// define an adapter
        //mAdapter = new MyAdapter(input);
        //recyclerView.setAdapter(mAdapter);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //getActivity().setTitle("List Items");
    }
}
