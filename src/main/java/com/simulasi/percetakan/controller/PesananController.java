package com.simulasi.percetakan.controller;

import com.simulasi.percetakan.model.PesananCetak;
import com.simulasi.percetakan.service.SimulasiPercetakanService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/pesanan")
public class PesananController {
    private final SimulasiPercetakanService service;

    public PesananController(SimulasiPercetakanService service) {
        this.service = service;
    }

    // Endpoint 1: Melihat semua pesanan
    @GetMapping
    public Collection<PesananCetak> getAll() {
        return service.lihatSemuaAntrean();
    }

    // Endpoint 2: Membuat pesanan baru
    @PostMapping("/buat")
    public PesananCetak buat(@RequestParam String nama) {
        return service.buatPesanan(nama);
    }

    // Endpoint 3: Menambahkan layanan (misal: fotokopi, jilid)
    @PutMapping("/{id}/tambah-layanan")
    public PesananCetak tambah(@PathVariable String id, @RequestParam String layanan) {
        return service.tambahLayanan(id, layanan);
    }

    // Endpoint 4: Memproses pesanan
    @PutMapping("/{id}/proses")
    public PesananCetak proses(@PathVariable String id) {
        return service.eksekusiProses(id);
    }
}