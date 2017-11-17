package com.glutenfreesoftware.shareable_shopping;

/**
 * Created by Kristian on 15.11.2017.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oebar on 08.11.2017.
 */

public class ListItems extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String username = "";
    private String list = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_list_items, container, false);

        username = getArguments().getString("username");
        list = getArguments().getString("list");
        getActivity().setTitle(list);

        Button deleteListBtn = (Button) view.findViewById(R.id.delete_list);
        deleteListBtn.setOnClickListener(new View.OnClickListener() {
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
        Button addItemBtn = (Button) view.findViewById(R.id.add_item);
        addItemBtn.setOnClickListener(new View.OnClickListener() {

            String ItemItemToAdd = "";

            @Override
            public void onClick(final View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Add item");

                // Set up the input
                final EditText input = new EditText(getActivity());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ItemItemToAdd = input.getText().toString();

                        addListItem(v, list, ItemItemToAdd, username);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 3s = 3000ms
                                getListItemsMethod();
                            }
                        }, 3000);
                        System.out.println("user:" + ItemItemToAdd);
                        //addedRoom = input.getText().toString();

                        System.out.println(ItemItemToAdd);
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
        Button shareListBtn = (Button) view.findViewById(R.id.share_list);
        shareListBtn.setOnClickListener(new View.OnClickListener() {

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


        System.out.println("ListItem: " + username + " " + list);

        recyclerView = (RecyclerView) view.findViewById(R.id.rooms_recyclerview);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        getListItemsMethod();

        /*
        final List<ListItemObj> input = new ArrayList<>();
        try {
            new getListItems(new getListItems.OnPostExecute() {
                @Override
                public void onPostExecute(List<ListItemObj> listItems) {
                    if (listItems.isEmpty()) {
                        System.out.println("listItems is empty");
                    }
                    for (ListItemObj l : listItems) {
                        System.out.println(l.getListItemList() + " " + l.getListItemName() + " " + l.getListItemOwner());
                        input.add(l);
                    }
                    mAdapter = new ListItemAdapter("Kristian", input);
                    recyclerView.setAdapter(mAdapter);
                }
            }).execute(new URL("http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/getListItems?listItemList=Taco&listItemOwner=Kristian"));
        } catch (Exception e) {
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

        //getActivity().setTitle("List Items");
    }

    public void getListItemsMethod(){
        final List<ListItemObj> input = new ArrayList<>();
        try {
            new getListItems(new getListItems.OnPostExecute() {
                @Override
                public void onPostExecute(List<ListItemObj> listItems) {
                    if (listItems.isEmpty()) {
                        System.out.println("listItems is empty");
                    }
                    for (ListItemObj l : listItems) {
                        System.out.println(l.getListItemList() + " " + l.getListItemName() + " " + l.getListItemOwner());
                        input.add(l);
                    }
                    mAdapter = new ListItemAdapter(username, input);
                    recyclerView.setAdapter(mAdapter);
                }
            }).execute(new URL("http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/getListItems?listItemList="+list+"&listItemOwner="+username));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addListItem(View v, String listItemList, String listItemName, String listItemOwner) {
        RequestQueue queue = Volley.newRequestQueue(v.getContext());
        String url = "http://158.38.193.60:8080/Shareable-Shopping-List-REST/api/lists/addListItem?listItemList=" + listItemList + "&listItemName=" + listItemName + "&listItemOwner=" + listItemOwner;
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //System.out.println("Response is: "+ response /*response.substring(0,500)*/);
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }

        }) {
            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", " application/json");
                return params;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
