package com.simulasi.percetakan.model;

import java.util.ArrayList;
import java.util.List;

public class PesananCetak {
    private String idPesanan;
    private String namaPelanggan;
    private List<String> detailLayanan = new ArrayList<>();
    private String status = "ANTREAN"; 

    public PesananCetak(String idPesanan, String namaPelanggan) {
        this.idPesanan = idPesanan;
        this.namaPelanggan = namaPelanggan;
    }

    public void tambahLayanan(String layanan) {
        if (!status.equals("ANTREAN")) {
            throw new IllegalStateException("Gagal: Pesanan sedang diproses.");
        }
        detailLayanan.add(layanan);
    }

    public void prosesPesanan() {
        if (detailLayanan.isEmpty()) {
            throw new IllegalStateException("Gagal: Pesanan kosong.");
        }
        this.status = "DIPROSES";
    }

    // Getter untuk konversi otomatis ke JSON oleh Spring Boot
    public String getIdPesanan() { return idPesanan; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public String getStatus() { return status; }
    public List<String> getDetailLayanan() { return detailLayanan; }
}