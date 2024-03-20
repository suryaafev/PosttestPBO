import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Pasien {

    private String namaPasien;
    private String penyakit;
    private String alamat;
    private int noHP;

    public Pasien(String namaPasien, String penyakit, String alamat, int noHP) {
        this.namaPasien = namaPasien;
        this.penyakit = penyakit;
        this.alamat = alamat;
        this.noHP = noHP;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNoHP() {
        return noHP;
    }

    public void setNoHP(int noHP) {
        this.noHP = noHP;
    }
}

public class App {
    static ArrayList<Pasien> data = new ArrayList<>();

    static void tambah(String nama, String penyakit, String alamat, int noHP) {
        Pasien pasien = new Pasien(nama, penyakit, alamat, noHP);
        data.add(pasien);
    }

    static void lihat() {
        for (int i = 0; i < data.size(); i++) {
            Pasien pasien = data.get(i);
            System.out.println("\ndata ke - " + (i + 1));
            System.out.println("Nama Pasien         : " + pasien.getNamaPasien());
            System.out.println("Penyakit Pasien     : " + pasien.getPenyakit());
            System.out.println("Alamat Pasien       : " + pasien.getAlamat());
            System.out.println("No Handphone Pasien : " + pasien.getNoHP() + "\n");
        }
    }

    static void ubah(int index, String nama, String penyakit, String alamat, int noHP) {
        for (int i = 0; i < data.size(); i++) {
            Pasien pasien = data.get(i);
            if (index - 1 == i) {
                pasien.setNamaPasien(nama);
                pasien.setPenyakit(penyakit);
                pasien.setAlamat(alamat);
                pasien.setNoHP(noHP);
            }
        }
    }

    static void hapus(int index) {
        data.remove(index - 1);
    }

    public static void main(String[] args) throws IOException {
        String nama, penyakit, alamat;
        int pilih, index, noHP;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("\nPROGRAM PENDATAAN PASIEN");
            System.out.println("1. Lihat Data Pasien");
            System.out.println("2. Tambah Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Silahkan Pilih Menu : ");
            pilih = Integer.parseInt(br.readLine());

            if (pilih == 1) {
                lihat();
            } else if (pilih == 2) {
                System.out.print("\nMasukkan Nama Pasien        : ");
                nama = br.readLine();

                System.out.print("Masukkan Penyakit Pasien    : ");
                penyakit = br.readLine();

                System.out.print("Masukkan Alamat Pasien      : ");
                alamat = br.readLine();

                System.out.print("Masukkan No Handphone Pasien: ");
                noHP = Integer.parseInt(br.readLine());

                tambah(nama, penyakit, alamat, noHP);
            } else if (pilih == 3) {
                lihat();
                System.out.print("\nPilih Data yang Ingin Diubah : ");
                index = Integer.parseInt(br.readLine());

                System.out.print("Masukkan Nama Pasien Baru       : ");
                nama = br.readLine();

                System.out.print("Masukkan Penyakit Pasien Baru   : ");
                penyakit = br.readLine();

                System.out.print("Masukkan Alamat Pasien Baru     : ");
                alamat = br.readLine();

                System.out.print("Masukkan No Handphone Pasien Baru: ");
                noHP = Integer.parseInt(br.readLine());

                ubah(index, nama, penyakit, alamat, noHP);
            } else if (pilih == 4) {
                lihat();
                System.out.print("\nPilih Data yang Ingin Dihapus : ");
                index = Integer.parseInt(br.readLine());
                hapus(index);
            } else if (pilih == 5) {
                System.exit(0);
            } else {
                System.out.println("\nMenu yang Anda Pilih Salah!!\n");
            }
        }
    }
}
