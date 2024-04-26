import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

abstract class Pasien {

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

    public final String getNamaPasien() {
        return namaPasien;
    }

    public final void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public final String getPenyakit() {
        return penyakit;
    }

    public final void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public final String getAlamat() {
        return alamat;
    }

    public final void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public final int getNoHP() {
        return noHP;
    }

    public final void setNoHP(int noHP) {
        this.noHP = noHP;
    }

    public abstract void displayInfo();
}

class PasienBiasa extends Pasien {
    private double biaya;

    public PasienBiasa(String namaPasien, String penyakit, String alamat, int noHP, double biaya) {
        super(namaPasien, penyakit, alamat, noHP);
        this.biaya = biaya;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    @Override
    public void displayInfo() {
        System.out.println("\nNama Pasien         : " + getNamaPasien());
        System.out.println("Penyakit Pasien     : " + getPenyakit());
        System.out.println("Alamat Pasien       : " + getAlamat());
        System.out.println("No Handphone Pasien : " + getNoHP());
        System.out.println("Biaya              : " + getBiaya());
    }
}

class PasienBPJS extends Pasien {
    private String noBPJS;

    public PasienBPJS(String namaPasien, String penyakit, String alamat, int noHP, String noBPJS) {
        super(namaPasien, penyakit, alamat, noHP);
        this.noBPJS = noBPJS;
    }

    public String getNoBPJS() {
        return noBPJS;
    }

    public void setNoBPJS(String noBPJS) {
        this.noBPJS = noBPJS;
    }

    @Override
    public void displayInfo() {
        System.out.println("\nNama Pasien         : " + getNamaPasien());
        System.out.println("Penyakit Pasien     : " + getPenyakit());
        System.out.println("Alamat Pasien       : " + getAlamat());
        System.out.println("No Handphone Pasien : " + getNoHP());
        System.out.println("Nomor BPJS         : " + getNoBPJS());
    }
}

public class App {
    static ArrayList<Pasien> data = new ArrayList<>();

    static void tambahPasienBiasa(String nama, String penyakit, String alamat, int noHP, double biaya) {
        PasienBiasa pasien = new PasienBiasa(nama, penyakit, alamat, noHP, biaya);
        data.add(pasien);
    }

    static void tambahPasienBPJS(String nama, String penyakit, String alamat, int noHP, String noBPJS) {
        PasienBPJS pasien = new PasienBPJS(nama, penyakit, alamat, noHP, noBPJS);
        data.add(pasien);
    }

    static void lihat() {
        for (int i = 0; i < data.size(); i++) {
            Pasien pasien = data.get(i);
            System.out.println("\ndata ke - " + (i + 1));
            pasien.displayInfo();
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
        String nama, penyakit, alamat, noBPJS;
        int pilih, index, noHP;
        double biaya;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("\nPROGRAM PENDATAAN PASIEN");
            System.out.println("1. Lihat Data Pasien");
            System.out.println("2. Tambah Data Pasien Biasa");
            System.out.println("3. Tambah Data Pasien BPJS");
            System.out.println("4. Ubah Data");
            System.out.println("5. Hapus Data");
            System.out.println("6. Keluar");
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

                System.out.print("Masukkan Biaya Pasien       : ");
                biaya = Double.parseDouble(br.readLine());

                tambahPasienBiasa(nama, penyakit, alamat, noHP, biaya);
            } else if (pilih == 3) {
                System.out.print("\nMasukkan Nama Pasien        : ");
                nama = br.readLine();

                System.out.print("Masukkan Penyakit Pasien    : ");
                penyakit = br.readLine();

                System.out.print("Masukkan Alamat Pasien      : ");
                alamat = br.readLine();

                System.out.print("Masukkan No Handphone Pasien: ");
                noHP = Integer.parseInt(br.readLine());

                System.out.print("Masukkan Nomor BPJS Pasien  : ");
                noBPJS = br.readLine();

                tambahPasienBPJS(nama, penyakit, alamat, noHP, noBPJS);
            } else if (pilih == 4) {
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

                Pasien pasien = data.get(index - 1);
                if (pasien instanceof PasienBiasa) {
                    System.out.print("Masukkan Biaya Pasien Baru      : ");
                    biaya = Double.parseDouble(br.readLine());
                    ((PasienBiasa) pasien).setBiaya(biaya);
                } else if (pasien instanceof PasienBPJS) {
                    System.out.print("Masukkan Nomor BPJS Pasien Baru : ");
                    noBPJS = br.readLine();
                    ((PasienBPJS) pasien).setNoBPJS(noBPJS);
                }

                ubah(index, nama, penyakit, alamat, noHP);
            } else if (pilih == 5) {
                lihat();
                System.out.print("\nPilih Data yang Ingin Dihapus : ");
                index = Integer.parseInt(br.readLine());
                hapus(index);
            } else if (pilih == 6) {
                System.exit(0);
            } else {
                System.out.println("\nMenu yang Anda Pilih Salah!!\n");
            }
        }
    }
}
