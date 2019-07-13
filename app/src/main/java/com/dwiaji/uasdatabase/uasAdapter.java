package com.dwiaji.uasdatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dwiaji.uasdatabase.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class uasAdapter extends RecyclerView.Adapter <uasAdapter.MyHolder> {
    private Context context;
    private List<DataItem> data  = new ArrayList<>();

    public uasAdapter(Context context, List<DataItem>data){
        this.context=context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void  onBindViewHolder(@NonNull MyHolder myHolder, int i){
        myHolder.tvNik.setText(data.get(i).getNik());
        myHolder.tvNama.setText(data.get(i).getNama());
        myHolder.tvAlamat.setText(data.get(i).getAlamat());
        myHolder.tvJenisKelamin.setText(data.get(i).getJenisKelamin());
    }

    @Override
    public int getItemCount() {return data.size();}

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvNik;
        TextView tvNama;
        TextView tvAlamat;
        TextView tvJenisKelamin;

        public MyHolder(@NonNull View itemView){
            super(itemView);
            tvNik = itemView.findViewById(R.id.tv_nik);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvJenisKelamin = itemView.findViewById(R.id.tv_gender);
        }
    }
}
