package bab5;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<data> listTamu = new ArrayList<>();
    static ArrayList<data2> pesanTamu = new ArrayList<>();
    static Scanner scn;
    static int loggedID = 0;
    private static data2 data2;

    public static void main(String[] args) {
        scn = new Scanner(System.in);
        while (true) {
            if (loggedID > 0) {
                System.out.print("Selamat datang di buku tamu!\nAnda login sebagai : " + listTamu.get(loggedID - 1).getNama() + "\n1. Lihat daftar Tamu\n2. Isi Buku Tamu\n3. Lihat Buku Tamu\n4. Logout\n5. Kelua\nMasukkan pilihan : ");
                int pil = scn.nextInt();
                scn.nextLine(); 
                
                if(pil == 1){
                    Main.showTamu();
                } else if (pil == 2){
                    Main.isiPesan();
                } else if (pil == 3){
                    Main.showPesan();
                } else if (pil == 4){
                    Main.logoutTamu();
                } else if (pil == 5){
                    Main.exit();
                } else {
                    System.out.println("Maaf menu tidak ditemukan.");
                }
            } else {
                System.out.print("Selamat datang di buku tamu!\n1. Daftar\n2. Login\n3. Lihat Daftar Tamu\n4. Lihat Buku Tamu\n5. Logout\n6. Exit\nMasukkan pilihan : ");
                int pil = scn.nextInt();
                scn.nextLine(); 
                
                if(pil == 1){
                    Main.addTamu();
                } else if(pil == 2){
                    Main.loginTamu();
                } else if(pil == 3){
                    Main.showTamu();
                } else if(pil == 4){
                    Main.showPesan();
                } else if(pil == 5){
                    Main.logoutTamu();
                } else if(pil == 6){
                    Main.exit();
                } else {
                    System.out.println("Maaf menu tidak ditemukan.");
                }
            }
        }
    }

    private static void addTamu() {
        data tamu = new data();
        
        tamu.setId(listTamu.size() + 1);
        
        System.out.print("Masukkan nama : ");
        tamu.setNama(scn.nextLine());
        System.out.print("Masukkan email : ");
        tamu.setEmail(scn.nextLine());
        System.out.print("Apakah data yang anda masukkan sudah benar ? (Y/N) : ");
        if (scn.next().equalsIgnoreCase("Y")) {
            listTamu.add(tamu);
            System.out.println("\nPendaftaran berhasil!\nID User : " + tamu.getId() + "\nNAMA : " + tamu.getNama() + "\nEMAIL : " + tamu.getEmail() + "\n");
        }
    }

    private static void loginTamu() {
        data tamus = new data();
        System.out.print("Masukkan id user : ");
        tamus.setId(scn.nextInt());
        scn.nextLine();
        System.out.print("Masukkan email : ");
        tamus.setEmail(scn.nextLine());
        boolean found = false;
        for (data list : listTamu) {
            if (list.getId() == tamus.getId() && list.getEmail().equalsIgnoreCase(tamus.getEmail())) {
                System.out.println("Login Berhasil!");
                loggedID = tamus.getId();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("User tidak ditemukan");
        }
    }

    private static void isiPesan() {
        data2 pesan = new data2();
        System.out.print("Kepada : ");
        pesan.setKepada(scn.nextLine());
        System.out.print("Isi Pesan : ");
        pesan.setPesan(scn.nextLine());
        pesan.setId_tamu(loggedID - 1);
        System.out.print("Apakah data yang anda masukkan sudah benar ? (Y/N) : ");
        if (scn.next().equalsIgnoreCase("Y")) {
            
            pesanTamu.add(data2);
            System.out.println("Pesan berhasil di tambahkan!");
        }
    }
    
    private static void showTamu(){
        for(data tamu : listTamu){
            System.out.println("=============================");
            System.out.println("ID : " + tamu.getId());
            System.out.println("Nama : " + tamu.getNama());
            System.out.println("Email : " + tamu.getEmail());
            System.out.println("=============================");
        }
    }

    private static void showPesan() {
        if (loggedID > 0) {
            System.out.println("Anda telah login dengan akun : " + listTamu.get(loggedID - 1).getNama() + " list pesan akan difilter berdasarkan id anda.\n Jika anda ingin melihat pesan dari tamu lain silahkan logout.");
            for (data2 pesans : pesanTamu) {
                if (pesans.getId_tamu() == (loggedID - 1)) {
                    System.out.println("===========================");
                    System.out.println("Kepada : " + pesans.getKepada());
                    System.out.println("Dari : " + listTamu.get(pesans.getId_tamu()).getNama());
                    System.out.println("Isi Pesan : " + pesans.getPesan());
                    System.out.println("===========================");
                }
            }
        } else {
            for (data2 pesans : pesanTamu) {
                System.out.println("===========================");
                System.out.println("Kepada : " + pesans.getKepada());
                System.out.println("Dari : " + listTamu.get(pesans.getId_tamu()).getNama());
                System.out.println("Isi Pesan : " + pesans.getPesan());
                System.out.println("===========================");
            }
        }
    }

    private static void logoutTamu() {
        loggedID = 0;
        System.out.println("Anda telah logout.");
    }
    
    private static void exit(){
        System.exit(0);
    }
}

