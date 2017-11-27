package com.glutenfreesoftware.shareable_shopping;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {
    private String username;
    private String roomName;
    private String roomOwner;
    private List<RoomObj> values;

    public Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            context = v.getContext();
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, RoomObj item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RoomAdapter(String username, List<RoomObj> myDataset) {
        this.username = username;
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.model, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final RoomObj room = values.get(position);
        //System.out.println("This is the roomID in roomAdapter: " + room.getRoomID() + " ************************************************************");
        holder.txtHeader.setText(room.getRoomName());
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(position);
                System.out.println(holder.txtHeader.getText());
                //System.out.println("This is the roomID in roomAdapter onClick: " + room.getRoomID() + " ************************************************************");
                Intent intent;
                intent = new Intent(context, ListActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("room", holder.txtHeader.getText().toString());
                intent.putExtra("roomID", room.getRoomID());
                context.startActivity(intent);

            }
        });

        holder.txtFooter.setText("Owner: " + room.getRoomOwner());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}