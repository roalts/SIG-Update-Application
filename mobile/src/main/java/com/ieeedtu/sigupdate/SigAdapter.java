package com.ieeedtu.sigupdate;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by raghav on 07/07/15.
 */
public class SigAdapter extends RecyclerView.Adapter<SigAdapter.ViewHolder> {

    private List<Sig> sigList;

    SigAdapter(List<Sig> sigs){
        this.sigList = sigs;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sig_list_item, viewGroup, false);
        ViewHolder pvh = new ViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.sigName.setText(sigList.get(i).getName());
        viewHolder.sigRoom.setText(sigList.get(i).getRoom());
        viewHolder.sigTime.setText(sigList.get(i).getTime());
        viewHolder.sigTopic.setText(sigList.get(i).getTopic());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO on card click
            }
        });
    }

    @Override
    public int getItemCount() {
        return sigList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView sigName;
        TextView sigRoom;
        TextView sigTime;
        TextView sigTopic;
        View view;

        public ViewHolder(View v) {
            super(v);
            view = v;
            cv = (CardView)itemView.findViewById(R.id.cv);
            sigName = (TextView) v.findViewById(R.id.sig_name);
            sigRoom = (TextView) v.findViewById(R.id.sig_room);
            sigTime = (TextView) v.findViewById(R.id.sig_time);
            sigTopic = (TextView) v.findViewById(R.id.sig_topic);
        }
    }
}
