public class Driver {
    private String nama;
    private int simID;
    private String jenisKendaraan;

    public Driver(String nama, int simID, String jenisKendaraan) {
        this.nama = nama;
        this.simID = simID;
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getNama() {
        return nama;
    }

    public int getSim() {
        return simID;
    }

    public String getJenis() {
        return jenisKendaraan;
    }
}
