package com.glutenfreesoftware.shareable_shopping;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oebar on 08.11.2017.
 */

public class ShoppingLists extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String username = "";
    private String room = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_shopping_lists, container, false);

        Button deleteRoomBtn = (Button) view.findViewById(R.id.delete_room);
        deleteRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Are you sure you wish to delete room?");
                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        /*
                        Insert code for deletion of room here
                         */

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

                //Insert code for adding to server from server

            }

        });
        Button addListBtn = (Button) view.findViewById(R.id.add_list);
        addListBtn.setOnClickListener(new View.OnClickListener() {

            String addedList = "";

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Add list");

                // Set up the input
                final EditText input = new EditText(getActivity());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addedList = input.getText().toString();

                        System.out.println("user:" + addedList);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

                //Insert code for adding to server from server

            }

        });

        Button shareRoomBtn = (Button) view.findViewById(R.id.share_room);
        shareRoomBtn.setOnClickListener(new View.OnClickListener() {

            String addedUser = "";

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Share");

                // Set up the input
                final EditText input = new EditText(getActivity());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addedUser = input.getText().toString();

                        System.out.println("user:" + addedUser);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

                //Insert code for adding to server from server

            }

        });

        username = getArguments().getString("username");
        room = getArguments().getString("room");
        getActivity().setTitle(room);
        System.out.println("Shopping list: " + username + " " + room);

        recyclerView = (RecyclerView) view.findViewById(R.id.rooms_recyclerview);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        getListsMethod();
        /*
        final List<ListObj> input = new ArrayList<>();
        try{
            new getLists(new getLists.OnPostExecute() {
                @Override
                public void onPostExecute(List<ListObj> lists) {
                    if(lists.isEmpty()){
                        System.out.println("list is empty...hello?");
                    }
                    for(ListObj l: lists){
                        System.out.println(l.getListRoom() + " " + l.getListName() + " " + l.getListOwner());
                        input.add(l);
                    }
                    mAdapter = new ListAdapter("Kristian", input);
                    recyclerView.setAdapter(mAdapter);
                }
            }).execute(new URL("http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/getLists?listRoom="+room+"&listOwner="+username));
        } catch (Exception e){
            e.printStackTrace();
        }
        */
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

        //getActivity().setTitle("Shopping Lists");
    }

    public void getListsMethod(){

        final List<ListObj> input = new ArrayList<>();
        try{
            new getLists(new getLists.OnPostExecute() {
                @Override
                public void onPostExecute(List<ListObj> lists) {
                    if(lists.isEmpty()){
                        System.out.println("list is empty...hello?");
                    }
                    for(ListObj l: lists){
                        System.out.println(l.getListRoom() + " " + l.getListName() + " " + l.getListOwner());
                        input.add(l);
                    }
                    mAdapter = new ListAdapter("Kristian", input);
                    recyclerView.setAdapter(mAdapter);
                }
            }).execute(new URL("http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/getLists?listRoom="+room+"&listOwner="+username));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
