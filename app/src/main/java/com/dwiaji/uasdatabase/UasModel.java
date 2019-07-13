package com.dwiaji.uasdatabase;

public class UasModel {
    private String nik;
    private String nama;
    private String alamat;
    private String kelamin;

    public UasModel(String nik, String nama, String alamat, String kelamin) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.kelamin = kelamin;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }
}
