# Simulasi Proses Bisnis Percetakan (In-Memory Database)

Proyek ini adalah simulasi manajemen antrean percetakan menggunakan arsitektur MVC.

## Teknologi
* Backend: Java 17 / Spring Boot
* Frontend: HTML, CSS, Vanilla JavaScript (Fetch API)
* Database: In-Memory (HashMap)

## Cara Menjalankan Aplikasi
1. Buka proyek ini di IDE (VS Code / IntelliJ).
2. Tunggu hingga Maven selesai mengunduh dependensi.
3. Jalankan file `src/main/java/com/simulasi/percetakan/PercetakanApplication.java`.
4. Buka browser dan akses URL: `http://localhost:8080`

## Fungsionalitas
* Membuat pesanan baru (Status: ANTREAN).
* Menambahkan layanan (contoh: Jilid, Fotokopi).
* Mengeksekusi pesanan (Status berubah menjadi DIPROSES). Business rule akan mencegah pesanan dieksekusi jika belum ada layanan yang ditambahkan.