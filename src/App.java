import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n=========================\n");
            System.out.println("Pilih opsi kendaraan: \n1. Bus\n2. Truck");
            int opsiKendaraan = in.nextInt();
            in.nextLine();

            switch (opsiKendaraan) {
                case 1:
                    System.out.println("\n=========================\n");
                    
                    Bus bus1 = new Bus("B 1234 VGL", 10, "Rosalia Indah", "Jakarta-Salatiga", 50000, 10);

                    bus1.setDestinasi("Jakarta Semarang Banyumanik Salatiga");
                    bus1.daftarDriver("Bagas", 1234, "Bus");
                    bus1.getInfo();

                    System.out.println("\n=========================\n");
                    bus1.daftarPenumpang("Fayza", 549);
                    bus1.daftarPenumpang("Rangga", 213);
                    bus1.daftarPenumpang("Lutfiah", 921);
                    
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
                    Truck truck1 = new Truck("B 9876 OLK", 2, "Ban Empat", 3, 400, 30);
                    truck1.daftarPekerja("Bagas", 1234);
                    truck1.daftarPekerja("Rangga", 5432);
                    truck1.daftarPekerja("Ali", 1642);
                    truck1.daftarPekerja("Budi", 1241); //melebihi maksimal pekerja
                    truck1.daftarDriver("Bima", 1245123, "Truck");
                    
                    System.out.println("\n=========================\n");
                    truck1.getInfo();

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
