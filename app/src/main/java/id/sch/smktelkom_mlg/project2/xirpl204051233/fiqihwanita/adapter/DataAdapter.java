package id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.R;
import id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.model.Data;


/**
 * Created by user on 21/3/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    ArrayList<Data> datas;
    IDataAdapter mIDataAdapter;

    public DataAdapter(Context context, ArrayList<Data> datas) {
        this.datas = datas;
        mIDataAdapter = (IDataAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data data = datas.get(position);
        holder.tvJudul.setText(data.title);
        holder.tvDeskripsi.setText(data.descripsion);
        holder.ivFoto.setImageResource(data.picture);

    }

    @Override
    public int getItemCount() {
        if (datas != null)
            return datas.size();
        return 0;

    }

    public interface IDataAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageview);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIDataAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }

}
