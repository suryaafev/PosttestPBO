import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class pasien {

    String namaPasien;
    String penyakit;
    String alamat;
    int noHP;

    pasien(String namaPasien, String penyakit, String alamat, int noHP) {
        this.namaPasien = namaPasien;
        this.penyakit = penyakit;
        this.alamat = alamat;
        this.noHP = noHP;
    }

    public String getnamaPasien() {
        return namaPasien;
    }

    public String getpenyakit() {
        return penyakit;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getnoHP() {
        return noHP;
    }

    public void setnamaPasien(String namapasien) {
        namaPasien = namapasien;
    }

    public void setpenyakit(String Penyakit) {
        penyakit = Penyakit;
    }

    public void setAlamat(String Alamat) {
        alamat = Alamat;
    }

    public void setnoHP(int nohp) {
        noHP = nohp;
    }
}

public class App {
    static ArrayList<pasien> data = new ArrayList<>();

    static void tambah(String nama, String ketua, String alamat, int noHP) {
        pasien dt = new pasien(nama, ketua, alamat, noHP);
        data.add(dt);
    }

    static void lihat() {
        for (int i = 0; i < data.size(); i++) {
            pasien dt = data.get(i);
            System.out.println("\ndata ke - " + (i + 1));
            System.out.println("nama pasien         : " + dt.getnamaPasien());
            System.out.println("penyakit pasien     : " + dt.getpenyakit());
            System.out.println("alamat pasien       : " + dt.getAlamat());
            System.out.println("No handphone pasien : " + dt.getnoHP() + "\n");
        }
    }

    static void ubah(int index, String nama, String ketua, String alamat, int noHP) {
        for (int i = 0; i < data.size(); i++) {
            pasien dt = data.get(i);
            if (index - 1 == i) {
                dt.setnamaPasien(nama);
                dt.setpenyakit(ketua);
                dt.setAlamat(alamat);
                dt.setnoHP(noHP);
            }
        }
    }

    static void hapus(int index) {
        data.remove(index - 1);
    }

    public static void main(String[] args) throws IOException {
        String nama, ketua, alamat;
        int pilih, index, noHP;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("\nPROGRAM PENDATAAN PASIEN");
            System.out.println("1. lihat data pasien");
            System.out.println("2. tambah data");
            System.out.println("3. ubah data");
            System.out.println("4. hapus data");
            System.out.println("5. keluar");
            System.out.print("silahkan pilih menu : ");
            pilih = Integer.parseInt(br.readLine());

            if (pilih == 1) {
                lihat();
            } else if (pilih == 2) {
                System.out.print("\nmasukkan nama pasien        : ");
                nama = br.readLine();

                System.out.print("masukkan penyakit pasien      : ");
                ketua = br.readLine();

                System.out.print("masukkan alamat pasien        : ");
                alamat = br.readLine();

                System.out.print("masukkan No handphone pasien  : ");
                noHP = Integer.parseInt(br.readLine());

                tambah(nama, ketua, alamat, noHP);
            } else if (pilih == 3) {
                lihat();
                System.out.print("\npilih data yang ingin diubah :");
                index = Integer.parseInt(br.readLine());

                System.out.print("masukkan nama pasien          : ");
                nama = br.readLine();

                System.out.print("masukkan penyakit pasien      : ");
                ketua = br.readLine();

                System.out.print("masukkan alamat pasien        : ");
                alamat = br.readLine();

                System.out.print("masukkan No handphone pasien  : ");
                noHP = Integer.parseInt(br.readLine());

                ubah(index, nama, ketua, alamat, noHP);
            } else if (pilih == 4) {
                lihat();
                System.out.print("\npilih data yang ingin dihapus : ");
                index = Integer.parseInt(br.readLine());
                hapus(index);
            } else if (pilih == 5) {
                System.exit(0);
            } else {
                System.out.println("\n menu yang anda pilih salah!!\n");
            }
        }
    }
}