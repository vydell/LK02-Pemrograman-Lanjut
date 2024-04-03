public class Kendaraan {
    protected String platNomor;
    protected int penumpang;
    protected int maxPenumpang;
    protected String jenis = "Kendaraan";

    protected Penumpang[] daftarPenumpang;

    protected int penumpangTerdaftar;
    protected int currentPIndex;
    
    protected Driver driver;
    
    public Kendaraan (String platnomor, int maxPenumpang, String jenis, int penumpangTerdaftar) {
        this.platNomor = platnomor;
        this.maxPenumpang = maxPenumpang;
        this.jenis = jenis;
        this.penumpangTerdaftar = penumpangTerdaftar;
        this.daftarPenumpang = new Penumpang[penumpangTerdaftar];
        this.currentPIndex = 0;
    }

    public void daftarDriver(String nama, int sim, String jenis) {
        driver = new Driver(nama, sim, jenis);
    }

    public void daftarPenumpang(String nama, int kode) {
        daftarPenumpang[currentPIndex] = new Penumpang(nama, kode);
        System.out.println("Penumpang terdaftar "+currentPIndex+"/"+penumpangTerdaftar);
    }

    public void penumpangNaik(int jumlah){
        if ((cekPenuh(penumpang, jumlah))) {
            System.out.println(pembukaan()+" tidak ada cukup ruang");
        } else {
            penumpang += jumlah;
            System.out.println(pembukaan()+" naik "+jumlah+" penumpang");
        }
    }

    public void penumpangTurun(int jumlah){
        if ((cekKosong(penumpang, jumlah))) {
            System.out.println("Di kendaraan hanya ada "+penumpang+" penumpang");
        } else {
            penumpang -= jumlah;
            System.out.println(pembukaan()+" turun "+jumlah+" penumpang");
        }
    }

    public void getJumlahPenumpang() {
        System.out.println(pembukaan()+" ada "+penumpang+" penumpang");
    }

    public void getInfo() {
        System.out.println("Berikut informasi tentang kendaraan tersebut:");
        System.out.println("Plat nomor: "+platNomor);
        System.out.println("Kapasitas penumpang: "+maxPenumpang);
        System.out.println("Pemilik/Pengemudi: "+driver.getNama());
    }

    protected String pembukaan() {
        return jenis+" dengan plat nomor "+platNomor;
    }

    protected boolean cekPenuh(int penumpangSekarang, int jumlahNaik) {
        return ((penumpangSekarang + jumlahNaik)>maxPenumpang);
    }

    protected boolean cekKosong(int penumpangSekarang, int jumlahTurun) {
        return ((penumpangSekarang - jumlahTurun)<0);
    }
}