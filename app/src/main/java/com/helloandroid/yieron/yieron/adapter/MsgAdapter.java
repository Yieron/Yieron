package com.helloandroid.yieron.yieron.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.helloandroid.yieron.yieron.R;
import com.helloandroid.yieron.yieron.model.Msg;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLL;
        LinearLayout rightLL;
        TextView txtLeft;
        TextView txtRight;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLL = (LinearLayout) itemView.findViewById(R.id.ll_left_msg);
            rightLL = (LinearLayout) itemView.findViewById(R.id.ll_right_msg);
            txtLeft = (TextView) itemView.findViewById(R.id.txt_left_msg);
            txtRight = (TextView) itemView.findViewById(R.id.txt_right_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.leftLL.setVisibility(View.VISIBLE);
            holder.rightLL.setVisibility(View.GONE);
            holder.txtLeft.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SEND) {
            holder.rightLL.setVisibility(View.VISIBLE);
            holder.leftLL.setVisibility(View.GONE);
            holder.txtRight.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
