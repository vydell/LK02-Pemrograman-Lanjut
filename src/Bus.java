import java.util.*;

public class Bus extends Kendaraan {
    Scanner in = new Scanner(System.in);
    //variable bus
    private String nama;
    private String jurusanBus;
    private int hargaTiket;

    //variable destinasi perjalanan bus
    private String[] destinasi;
    private int currentDIndex;

    public Bus(String platnomor, int maxPenumpang, String nama, String jurusanBus, int hargaTiket, int penumpangTerdaftar) {
        super(platnomor, maxPenumpang, "Bus", penumpangTerdaftar);
        this.nama = nama;
        this.jurusanBus = jurusanBus;
        this.hargaTiket = hargaTiket;
        this.currentDIndex = 0;
    }

    public void daftarPenumpang(String nama, int kode) {
        if (currentPIndex<=(penumpangTerdaftar-1)) {
            daftarPenumpang[currentPIndex] = new Penumpang(nama, kode);
            currentPIndex++;
            System.out.println("Penumpang bus terdaftar "+currentPIndex+"/"+penumpangTerdaftar);
        } else {
            System.out.println("Tidak dapat mendaftarkan penumpang lagi. Penumpang terdaftar "+currentPIndex+"/"+penumpangTerdaftar);
        }
    }

    public void setDestinasi(String destinasi) {
        this.destinasi = destinasi.split("[ ]");
    }

    public void lanjutPerjalanan() {
        if (currentDIndex<(destinasi.length-1)) {
            System.out.println("Bus telah tiba di terminal "+destinasi[currentDIndex]+". Mohon perhatikan barang bawaan anda.");
            currentDIndex++;
        } else if (currentDIndex<(destinasi.length)) {
            System.out.println("Bus telah tiba di halte terakhir "+destinasi[currentDIndex]+". Mohon perhatikan barang bawaan anda.");
        }   
    }

    public void penumpangNaik(int jumlah){
        if ((cekPenuh(penumpang, jumlah))) {
            System.out.println(pembukaan()+" tidak ada cukup ruang");
        } else {
            for (int i=0; i<jumlah; i++) {
                System.out.println("Mohon verifikasi tiket anda");
                System.out.print("Kode tiket: ");
                int kode = in.nextInt();

                boolean isPassenger = false;
                for (int j=0; j<currentPIndex; j++) {
                    if (daftarPenumpang[j].getId()==kode) {
                        isPassenger = true;
                        break;
                    }
                }

                cekPenumpang(isPassenger, penumpang);

                System.out.println("");
            }

            getJumlahPenumpang();
        }
    }

    public void getInfo() {
        System.out.println("Berikut informasi tentang bus "+nama+" dengan jurusan "+jurusanBus);
        System.out.println("Plat nomor bus: "+platNomor);
        System.out.println("Kapasitas bus: "+maxPenumpang+" penumpang");
        System.out.println("Harga tiket bus: Rp. "+hargaTiket);
        System.out.println("Sopir bus: "+driver.getNama());
        System.out.println("Terminal saat ini: "+destinasi[currentDIndex]);
        if (currentDIndex!=destinasi.length) {
            System.out.println("Destinasi berikutnya: "+destinasi[currentDIndex+1]);
        }
        System.out.println("Jumlah penumpang yang dapat didaftar: "+penumpangTerdaftar);
    }

    private void cekPenumpang(boolean isPassenger, int penumpang) {
        if (isPassenger) {
            System.out.println("Verifikasi berhasil silakan masuk.");
            this.penumpang++;
        } else {
            System.out.println("Anda tidak terdaftar di perjalanan Bus tersebut");
        }
    }

}
