package com.dwiaji.uasdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText mNik, mNama, mAlamat;
    Spinner sJk;
    String[] jenisKelamin = {"Laki-laki", "Perempuan"};
    Button btnSimpan, btnTampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNik = findViewById(R.id.txt_nik);
        mNama = findViewById(R.id.txt_nama);
        mAlamat = findViewById(R.id.txt_alamat);
        sJk = findViewById(R.id.sp_jk);
        btnSimpan = findViewById(R.id.btn_daftar);
        btnTampil = findViewById(R.id.btn_lihat);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, jenisKelamin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
            }
        });

    }

    private void simpanData() {
        String nik = mNik.getText().toString().trim();
        String nama = mNama.getText().toString().trim();
        String alamat = mAlamat.getText().toString().trim();
        String kelamin = sJk.getSelectedItem().toString().trim();

        if(nik.isEmpty()){
            mNik.setError("NIK masih Kosong !!");
        }else if (nama.isEmpty()){
            mNama.setError("Nama Masih kosong !");
        }else if (kelamin.isEmpty()){
            Toast.makeText(this, "Jenis Kelamin Belum diisi !", Toast.LENGTH_SHORT).show();
        } else if (alamat.isEmpty()){
            mAlamat.setError("Alamat Belum diisi!");
        }
    }
}
