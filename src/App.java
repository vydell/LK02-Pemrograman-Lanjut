import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int kodePBus = 10000;
        int kodePTruck = 10000;

        Bus bus1 = new Bus("B 1234 VGL", 10, "Rosalia Indah", "Jakarta-Salatiga", 50000, 10);
        bus1.setDestinasi("Jakarta Semarang Banyumanik Salatiga");
        bus1.daftarDriver("Bagas", 1234, "Bus");

        System.out.println("\n=========================\n");
        bus1.getInfo();

        Truck truck1 = new Truck("B 9876 OLK", 2, "Ban Empat", 3, 400, 30);
        truck1.daftarDriver("Kuswandi", 1240123, "Truck");

        System.out.println("\n=========================\n");
        truck1.getInfo();

        while (true) {

            System.out.println("\n=========================\n");
            System.out.println("Pilih opsi kendaraan: \n1. Bus\n2. Truck");
            int opsiKendaraan = in.nextInt();

            switch (opsiKendaraan) {
                
                case 1: //BUS

                    while (true) {
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
                                    bus1.daftarPenumpang(namaP, kodePBus);
                                    kodePBus++;
                                }
                                break;

                            case 2: //JALANKAN BUS
                                System.out.println("\n=========================\n");
                                bus1.lanjutPerjalanan();
                                break;

                            case 3: //NAIKKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("\nMasukkan jumlah penumpang yang naik: ");
                                int jumlahNaik = in.nextInt();
                                in.nextLine();
                                bus1.penumpangNaik(jumlahNaik);
                                break;

                            case 4: //TURUNKAN PENUMPANG
                                System.out.println("\n=========================\n");
                                System.out.print("\nMasukkan jumlah penumpang yang naik: ");
                                int jumlahTurun = in.nextInt();
                                in.nextLine();
                                bus1.penumpangTurun(jumlahTurun);
                                break;

                            case 5:
                                continue;
                            
                            default:
                                System.out.println("Opsi tidak ada di pilihan, mohon ulangi pilihan anda lagi");
                                continue;
                        }

                        System.out.println("\n=========================\n");
                        System.out.println("Apakah anda ingin lanjut?\n1. Iya\n2. Tidak");
                        int lanjutBus = in.nextInt();
                        in.nextLine();

                        if (lanjutBus==2) break;
                        else if (!(lanjutBus==1)) System.out.println("Opsi tidak ada di pilihan, mohon ulangi pilihan anda lagi");
                    }
                    

                    System.out.println("\n=========================\n");
                    bus1.penumpangNaik(2);
            
                    System.out.println("\n=========================\n");
                    bus1.lanjutPerjalanan();
            
                    System.out.println("\n=========================\n");
                    bus1.getInfo();
                    
                    System.out.println("\n=========================\n");
                    bus1.penumpangTurun(3);
                    bus1.penumpangTurun(1);                    
                    break;

                case 2:
                    System.out.println("\n=========================\n");
                    truck1.penumpangNaik(2);
                    
                    System.out.println("\n=========================\n");
                    truck1.penumpangTurun(2);
            
                    System.out.println("\n=========================\n");
                    truck1.masukBarang(200,10);
            
                    System.out.println("\n=========================\n");
                    truck1.penumpangNaik(2);
                    
                    System.out.println("\n=========================\n");
                    truck1.masukBarang(200,10);
            }
        }
        
        
        
        


        


        





    }
}
