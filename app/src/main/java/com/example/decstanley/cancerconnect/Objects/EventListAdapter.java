package com.example.decstanley.cancerconnect.Objects;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.decstanley.cancerconnect.R;

import java.util.Date;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.MyViewHolder>{

    private Event[] dataSet = new Event[1];




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView eventView;

        public MyViewHolder(TextView v) {
            super(v);
            eventView = v;
        }
    }

    //constructor
    public EventListAdapter(Event[] myDataSet)
    {
        dataSet = myDataSet;


    }

    @Override
    public EventListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_screen, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - sets text of view
        holder.eventView.setText(dataSet[position].getEventTitle());
    }

    //return size of dataset
    @Override
    public int getItemCount() {
        return dataSet.length;
    }
}
