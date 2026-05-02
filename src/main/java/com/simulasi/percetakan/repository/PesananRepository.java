package com.simulasi.percetakan.repository;

import com.simulasi.percetakan.model.PesananCetak;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PesananRepository {
    private Map<String, PesananCetak> databaseMemori = new HashMap<>();

    public void simpan(PesananCetak pesanan) {
        databaseMemori.put(pesanan.getIdPesanan(), pesanan);
    }

    public PesananCetak cari(String idPesanan) {
        return databaseMemori.get(idPesanan);
    }

    public Collection<PesananCetak> ambilSemua() {
        return databaseMemori.values();
    }
}