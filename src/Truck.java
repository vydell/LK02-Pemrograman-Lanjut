import java.util.*;

public class Truck extends Kendaraan {
    Scanner in = new Scanner(System.in);
    private float maxLoadKg;
    private float capacity;
    private float beratSekarang;
    private float volumeSekarang;
    private String namaPerusahaan;
    private Penumpang[] daftarPekerja;

    public Truck(String platnomor, int maxPenumpang, String namaPerusahaan, int pekerjaTerdaftar, float maxLoadKg, float capacity) {
        super(platnomor, maxPenumpang, "Truck", pekerjaTerdaftar);
        this.maxLoadKg = maxLoadKg;
        this.capacity = capacity;
        this.namaPerusahaan = namaPerusahaan;
        this.daftarPekerja = daftarPenumpang;
    }

    public void daftarPekerja(String nama, int kode) {
        if (currentPIndex<=(penumpangTerdaftar-1)) {
            daftarPekerja[currentPIndex] = new Penumpang(nama, kode);
            currentPIndex++;
            System.out.println("Pekerja truck terdaftar "+currentPIndex+"/"+penumpangTerdaftar);
        } else {
            System.out.println("Tidak dapat mendaftarkan pekerja lagi. Pekerja terdaftar "+currentPIndex+"/"+penumpangTerdaftar);
        }
    }

    public void masukBarang(float berat, float volume) {
        if (cekAdaPekerja()) {
            if (!cekKeberatan(berat, beratSekarang) && !cekKepenuhan(volume, volumeSekarang)) {
                beratSekarang += berat;
                volumeSekarang += volume;
                System.out.println("Barang berhasil dimasukkan ke truck");
                System.out.println("Load saat ini "+beratSekarang+" kg per "+maxLoadKg+" kg");
                System.out.println("Kapasitas saat ini "+volumeSekarang+" m2 per "+capacity+" m2");
            } else {
                System.out.println("Berat atau ruangan sisa di truck tidak cukup untuk memasukkan barang.");
            }
        } else {
            System.out.println("Tidak ada pekerja di truck untuk mengangkat barang.");
        }
    }

    public void penumpangNaik(int jumlah){
        if ((cekPenuh(penumpang, jumlah))) {
            System.out.println(pembukaan()+" tidak ada cukup ruang");
        } else {
            for (int i=0; i<jumlah; i++) {
                System.out.println("Mohon verifikasi identitas pekerja anda");
                System.out.print("ID pekerja: ");
                int id = in.nextInt();
                in.nextLine();
                System.out.print("Nama perusahaan anda: ");
                String perusahaan = in.nextLine();

                boolean isPekerja = false;
                for (int j=0; j<currentPIndex; j++) {
                    if (daftarPekerja[j].getId()==id && perusahaan.equals(namaPerusahaan)) {
                        isPekerja = true;
                        break;
                    }
                }

                cekPekerja(isPekerja, id);

                System.out.println("");
            }

            getJumlahPenumpang();
        }
    }

    public void getInfo() {
        System.out.println("Berikut informasi tentang truck tersebut: ");
        System.out.println("Nama perusahan: "+namaPerusahaan);
        System.out.println("Jumlah pekerja: "+currentPIndex);
        System.out.println("Maksimal pekerja pada bidang logistik: "+penumpangTerdaftar);
        System.out.println("Load yang diangkut saat ini "+beratSekarang+" kg per "+maxLoadKg+" kg");
        System.out.println("Kapasitas yang digunakan saat ini "+volumeSekarang+" m2 per "+capacity+" m2");
        System.out.println("Pengemudi truck terdaftar: "+driver.getNama());
    }

    private boolean cekKeberatan(float berat, float beratSekarang) {
        return ((beratSekarang+berat)>maxLoadKg);
    }

    private boolean cekKepenuhan(float volume, float volumeSekarang) {
        return ((volumeSekarang+volume)>capacity);
    }

    private boolean cekAdaPekerja() {
        return (penumpang>0);
    }

    private void cekPekerja(boolean isPekerja, int penumpang) {
        if (isPekerja) {
            System.out.println("Silakan masuk.");
            penumpang++;
        } else {
            System.out.println("Anda tidak terdaftar di truck perusahaan tersebut");
        }
    }
}
