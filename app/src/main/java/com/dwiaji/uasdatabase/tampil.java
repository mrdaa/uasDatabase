package com.dwiaji.uasdatabase;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dwiaji.uasdatabase.model.DataItem;
import com.dwiaji.uasdatabase.model.ResponseBio;
import com.dwiaji.uasdatabase.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tampil extends AppCompatActivity {

    List<DataItem> data = new ArrayList<>();
    RecyclerView rc_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        rc_View =findViewById(R.id.rcView);

        getDataBio();

        rc_View.setAdapter(new tampilAdapter(tampil.this,data));
        rc_View.setLayoutManager(new LinearLayoutManager(tampil.this));
    }

    private void getDataBio() {
        final ProgressDialog progress = new ProgressDialog(tampil.this);
        progress.setMessage("waiting ...");
        progress.show();

        Call<ResponseBio> request = RetrofitConfig.getApiService().ambilData();
        request.enqueue(new Callback<ResponseBio>() {
            @Override
            public void onResponse(Call<ResponseBio> call, Response<ResponseBio> response) {
                progress.dismiss();
                if (response.isSuccessful()){
                    data =response.body().getData();
                    rc_View.setAdapter(new tampilAdapter(tampil.this,data));
                }else{
                    Toast.makeText(tampil.this, "Request not success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBio> call, Throwable t) {

            }
        });
    }
}
