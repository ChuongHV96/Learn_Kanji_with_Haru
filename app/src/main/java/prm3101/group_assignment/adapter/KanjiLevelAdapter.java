package prm3101.group_assignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import prm3101.group_assignment.R;
import prm3101.group_assignment.activity.KanjiDetailActivity;
import prm3101.group_assignment.data.Kanji;
import prm3101.group_assignment.data.KanjiLevel;

/**
 * Created by chuonghv on 12/26/17.
 */

public class KanjiLevelAdapter extends RecyclerView.Adapter<KanjiLevelAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<KanjiLevel> mData;
    private LayoutInflater mLayoutInflater;

    public KanjiLevelAdapter(Context mContext, ArrayList<KanjiLevel> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.items_kanji_level, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final KanjiLevel data = mData.get(position);
        holder.character.setText(data.getCharacter());
        holder.mean.setText(data.getMean());
        holder.onyomi.setText(data.getOnyomi());
        holder.kunyomi.setText(data.getKunyomi());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(mContext, KanjiDetailActivity.class);
//                intent.putExtra("kanjiData", course.getKanjiData());
//                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView character, mean, onyomi, kunyomi;
        ImageView audio;
        View item;

        public ViewHolder(View itemView) {
            super(itemView);
            character = (TextView) itemView.findViewById(R.id.character);
            audio = (ImageView) itemView.findViewById(R.id.volume);
            mean = (TextView) itemView.findViewById(R.id.meanValue);
            onyomi = (TextView) itemView.findViewById(R.id.onValue);
            kunyomi = (TextView) itemView.findViewById(R.id.kunValue);
            item = itemView;
        }

        @Override
        public void onClick(View view) {
            //to do
        }
    }
}
