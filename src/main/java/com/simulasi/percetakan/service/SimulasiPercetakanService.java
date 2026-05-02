package com.simulasi.percetakan.service;

import com.simulasi.percetakan.model.PesananCetak;
import com.simulasi.percetakan.repository.PesananRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;

@Service
public class SimulasiPercetakanService {
    private final PesananRepository repository;

    public SimulasiPercetakanService(PesananRepository repository) {
        this.repository = repository;
    }

    public PesananCetak buatPesanan(String nama) {
        // Generate ID acak sederhana
        String id = "ORD-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        PesananCetak pesanan = new PesananCetak(id, nama);
        repository.simpan(pesanan);
        return pesanan;
    }

    public PesananCetak tambahLayanan(String id, String layanan) {
        PesananCetak pesanan = repository.cari(id);
        if (pesanan == null) throw new IllegalArgumentException("ID tidak ditemukan");
        pesanan.tambahLayanan(layanan);
        return pesanan;
    }

    public PesananCetak eksekusiProses(String id) {
        PesananCetak pesanan = repository.cari(id);
        if (pesanan == null) throw new IllegalArgumentException("ID tidak ditemukan");
        pesanan.prosesPesanan();
        return pesanan;
    }

    public Collection<PesananCetak> lihatSemuaAntrean() {
        return repository.ambilSemua();
    }
}