import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int kodePBus = 10000;
        int kodePTruck = 10000;

        //BUS 1
        Bus bus1 = new Bus("B 1234 VGL", 10, "Rosalia Indah", "Jakarta-Salatiga", 50000, 10);
        bus1.setDestinasi("Jakarta Semarang Banyumanik Salatiga");
        bus1.daftarDriver("Bagas", 192084910, "Bus");

        //BUS 2
        Bus bus2 = new Bus("B 9213 VOW", 30, "Suroboyo Bus", "Purabaya-Rajawali", 130000, 30);
        bus2.setDestinasi("Rajawali Jembatan-Merah Veteran Tugu-Pahlawan Alun-Alun-Contong Siola Tunjungan Simpang-Dukuh");
        bus2.daftarDriver("Trianti", 891241298, "Bus");

        System.out.println("\n=========================\n");
        System.out.println("Bus 1");
        bus1.getInfo();

        System.out.println("");
        System.out.println("Bus 2");
        bus2.getInfo();

        //TRUCK 1
        Truck truck1 = new Truck("B 9876 OLK", 2, "Ban Empat", 3, 400, 30);
        truck1.daftarDriver("Kuswandi", 1240123, "Truck");

        //TRUCK 2
        Truck truck2 = new Truck("B 0812 TRE", 4, "Wheel Three", 6, 800, 50);
        truck2.daftarDriver("Budiyanto", 1240123, "Truck");

        System.out.println("\n=========================\n");
        System.out.println("Truck 1");
        truck1.getInfo();

        System.out.println("");
        System.out.println("Truck 2");
        truck2.getInfo();

        while (true) {

            System.out.println("\n=========================\n");
            System.out.println("Pilih opsi kendaraan: \n1. Bus 1\n2. Bus 2\n3. Truck 1\n4. Truck 2");
            int opsiKendaraan = in.nextInt();
            Bus currentBus = bus1;
            Truck currentTruck = truck1;

            if(opsiKendaraan==1) currentBus = bus1;
            else if (opsiKendaraan==2) currentBus = bus2;
            else if (opsiKendaraan==3) currentTruck = truck1;
            else if (opsiKendaraan==4) currentTruck = truck2;

            switch (opsiKendaraan) {
                case 1: //BUS 1
                case 2: //BUS 2
                    while (true) {
                        int lanjutBus;
                        System.out.println("\n=========================\n");
                        System.out.println("Pilih aktifitas yang ingin dilakukan: \n1. Daftarkan penumpang\n2. Jalankan bus\n3. Naikkan penumpang\n4. Turunkan penumpang\n5. Kembali ke menu utama");
                        int opsiBus = in.nextInt();
                        in.nextLine();              
                        
                        switch (opsiBus) {

                            case 1: //DAFTARKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("Masukkan jumlah penumpang yang ingin didaftar: ");
                                int jumlahDaftar = in.nextInt();
                                in.nextLine();

                                for (int i=0; i<jumlahDaftar; i++) {
                                    System.out.print("\nNama penumpang: ");
                                    String namaP = in.nextLine();
                                    currentBus.daftarPenumpang(namaP, kodePBus);
                                    kodePBus++;
                                }
                                break;

                            case 2: //JALANKAN BUS
                                System.out.println("\n=========================\n");
                                currentBus.lanjutPerjalanan();
                                break;

                            case 3: //NAIKKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("\nMasukkan jumlah penumpang yang naik: ");
                                int jumlahNaik = in.nextInt();
                                in.nextLine();
                                currentBus.penumpangNaik(jumlahNaik);
                                break;

                            case 4: //TURUNKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("\nMasukkan jumlah penumpang yang turun: ");
                                int jumlahTurun = in.nextInt();
                                in.nextLine();
                                currentBus.penumpangTurun(jumlahTurun);
                                break;

                            case 5:
                                break;
                            
                            default:
                                System.out.println("Opsi tidak ada di pilihan, mohon ulangi pilihan anda lagi");
                                continue;
                        }

                        System.out.println("\n=========================\n");
                        System.out.println("Apakah anda ingin lanjut dengan bus?\n1. Iya\n2. Tidak");
                        lanjutBus = in.nextInt();
                        in.nextLine();

                        if (lanjutBus==2) break;
                        else if (!(lanjutBus==1)) System.out.println("Opsi tidak ada di pilihan, mohon ulangi pilihan anda lagi");
                    }
                    break;

                case 3: //TRUCK 1
                case 4: //TRUCK 2
                    while (true) {
                        System.out.println("\n=========================\n");
                        System.out.println("Pilih aktifitas yang ingin dilakukan: \n1. Daftarkan pekerja\n2. Angkat barang ke truck\n3. Naikkan pekerja\n4. Turunkan perkeja\n5. Kembali ke menu utama");
                        int opsiTruck = in.nextInt();
                        in.nextLine();              
                        
                        switch (opsiTruck) {

                            case 1: //DAFTARKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("Masukkan jumlah penumpang yang ingin didaftar: ");
                                int jumlahDaftar = in.nextInt();
                                in.nextLine();

                                for (int i=0; i<jumlahDaftar; i++) {
                                    System.out.print("\nNama penumpang: ");
                                    String namaP = in.nextLine();
                                    currentTruck.daftarPekerja(namaP, kodePTruck);
                                    kodePTruck++;
                                }
                                break;

                            case 2: //MASUKKAN BARANG
                                System.out.println("\n=========================\n");
                                System.out.print("Masukkan berat barang dalam kg: ");
                                float berat = in.nextFloat();
                                System.out.print("\nMasukkan volume barang dalam m2: ");
                                float volume = in.nextFloat();
                                currentTruck.masukBarang(berat, volume);
                                break;

                            case 3: //NAIKKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("Masukkan jumlah penumpang yang naik: ");
                                int jumlahNaik = in.nextInt();
                                in.nextLine();
                                currentTruck.penumpangNaik(jumlahNaik);
                                break;

                            case 4: //TURUNKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("\nMasukkan jumlah penumpang yang turun: ");
                                int jumlahTurun = in.nextInt();
                                in.nextLine();
                                currentTruck.penumpangTurun(jumlahTurun);
                                break;

                            case 5:
                                continue;
                            
                            default:
                                System.out.println("Opsi tidak ada di pilihan, mohon ulangi pilihan anda lagi");
                                continue;
                        }

                        System.out.println("\n=========================\n");
                        System.out.println("Apakah anda ingin lanjut dengan truck?\n1. Iya\n2. Tidak");
                        int lanjutTruck = in.nextInt();
                        in.nextLine();

                        if (lanjutTruck==2) break;
                        else if (!(lanjutTruck==1)) {
                            System.out.println("Opsi tidak ada di pilihan, mohon ulangi pilihan anda lagi");
                            continue;
                        }
                    }
                    break;
            }

            System.out.println("\n=========================\n");
            System.out.println("Apakah anda ingin lanjut?\n1. Iya\n2. Tidak");
            int berhenti = in.nextInt();
            in.nextLine();

            if (berhenti==2)break;
        }
    }
}
