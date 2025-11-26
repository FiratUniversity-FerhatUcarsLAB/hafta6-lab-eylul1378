/*
Ad Soyad = Nihal Eylül İL
No = 250541001
Proje = Sinema Bileti Fiyatlandırma Sistemi
Teslim Tarihi = 27.11.2025
 */

import java.util.Scanner;
public class Proje2_SinemaBileti {

 //Metot kullanılarak haftasonu olup olmadığını kontrol edildi.
    public boolean haftasonuMu(int gun) {
        return gun == 6 || gun == 7;
    }

 //Metot kullanılarak matine olup olmadığını kontrol edildi.
    public boolean matineMi(int saat) {
        return saat < 12;
    }

 // Metot kullanılarak temel bilet fiyatını hesaplandı.  
    public double temelFiyatHesapla(int gun, int saat) {
        boolean haftasonu = haftasonuMu(gun);
        boolean matine = matineMi(saat);

        if (!haftasonu && matine) {
            return 45.0; 
        } else if (!haftasonu && !matine) {
            return 65.0; 
        } else if (haftasonu && matine) {
            return 55.0; 
        } else {
            return 85.0; 
        }
    }

 //Metot kullanılarak indirim miktarı hesaplandı.
    public double indirimHesapla(int yas, int meslek, int gun, double temelFiyat) {
        double indirimOrani = 0.0;

        // Öğrenci indirimi (Meslek kodu: 1)
        if (meslek == 1) { 
            if (gun >= 1 && gun <= 4) { // Pzt(1)-Perşembe(4): %20
                indirimOrani = 0.20;
            } 
            else { // Cuma(5)-Pazar(7): %15
                indirimOrani = 0.15;
            }
        } 
        
        // Yaş indirimleri 
        else if (yas >= 65) {
            indirimOrani = 0.30; 
        } 
        else if (yas <= 12) {
            indirimOrani = 0.25; 
        } 
        
        // Öğretmen indirimi (Meslek kodu: 2) (Çarşamba=3)
        else if (meslek == 2 && gun == 3) {
            indirimOrani = 0.35; 
        }
        
        return temelFiyat * indirimOrani;
    }

 //Metot kullanılarak format ekstra ücretleri hesaplandı.
    public double formatEkstraUcretiGetir(int filmTuru) {
        switch (filmTuru) {
            case 1: // 2D
                return 0.0;
            case 2: // 3D (+25 TL)
                return 25.0; 
            case 3: // IMAX (+35 TL)
                return 35.0; 
            case 4: // 4DX (+50 TL)
                return 50.0; 
            default:
                return 0.0; 
        }
    }

 //Metot kullanılarak nihai bilet fiyatı hesaplandı.   
    public double finalFiyatHesapla(int gun, int saat, int yas, int meslek, int filmTuru) {
        double temelFiyat = temelFiyatHesapla(gun, saat);
        double indirim = indirimHesapla(yas, meslek, gun, temelFiyat);
        double ekstraUcret = formatEkstraUcretiGetir(filmTuru);

        double indirimliFiyat = temelFiyat - indirim;
        if (indirimliFiyat < 0) {
            indirimliFiyat = 0;
        }

        return indirimliFiyat + ekstraUcret;
    }

   //Yardımcı metotlar: Gün adı, Meslek adı ve Film türü adı getirildi.
    private String gunAdiGetir(int gun) {
        if (gun == 1) return "Pazartesi";
        else if (gun == 2) return "Salı";
        else if (gun == 3) return "Çarşamba";
        else if (gun == 4) return "Perşembe";
        else if (gun == 5) return "Cuma";
        else if (gun == 6) return "Cumartesi";
        else if (gun == 7) return "Pazar";
        else return "Geçersiz Gün";
    }

    private String meslekAdiGetir(int meslek) {
        if (meslek == 1) return "Öğrenci";
        else if (meslek == 2) return "Öğretmen";
        else if (meslek == 3) return "Diğer";
        else return "Geçersiz Meslek";
    }
    
    private String filmTuruAdiGetir(int filmTuru) {
        if (filmTuru == 1) return "2D";
        else if (filmTuru == 2) return "3D";
        else if (filmTuru == 3) return "IMAX";
        else if (filmTuru == 4) return "4DX";
        else return "Geçersiz Tür";
    }

 //Ana metot başlatıldı ve program çalıştırıldı.
    public static void main(String[] args) {
        //Scanner çağırıldı.
        Scanner tarayici = new Scanner(System.in);
        Proje2_SinemaBileti sistem = new Proje2_SinemaBileti();

        System.out.println("--- Sinema Bileti Hesaplama Sistemi ---");

        System.out.print("\nLütfen yaşınızı girin: ");
        int yas = tarayici.nextInt();

        System.out.println("\nHaftanın Gününü Seçin (1=Pzt, 2=Sal, ..., 7=Paz):");
        System.out.print("Seçiminiz (1-7): ");
        int gun = tarayici.nextInt();

        System.out.println("\nGösterim saatini girin (Örn: 10, 15, 21): ");
        System.out.print("Seçiminiz (0-23):");
        int saat = tarayici.nextInt();

        System.out.println("\nMesleğinizi Seçin (1=Öğrenci, 2=Öğretmen, 3=Diğer):");
        System.out.print("Seçiminiz (1-3): ");
        int meslek = tarayici.nextInt();

        System.out.println("\nFilm Türünü Seçin (1=2D, 2=3D, 3=IMAX, 4=4DX):");
        System.out.print("Seçiminiz (1-4): ");
        int filmTuru = tarayici.nextInt();

       // 1. Hesaplamalar (Metotlar çağrılır, değerler alınır)
        double temelFiyat = sistem.temelFiyatHesapla(gun, saat);
        double indirim = sistem.indirimHesapla(yas, meslek, gun, temelFiyat);
        double ekstraUcret = sistem.formatEkstraUcretiGetir(filmTuru);
        double nihaiFiyat = sistem.finalFiyatHesapla(gun, saat, yas, meslek, filmTuru); // Final hesaplama metodu çağrılır

        // 2. Metin Çevrimleri (Yardımcı metotlar çağrılır)
        String gunAdi = sistem.gunAdiGetir(gun);
        String meslekAdi = sistem.meslekAdiGetir(meslek);
        String filmTuruAdi = sistem.filmTuruAdiGetir(filmTuru);
        
        // 3. Boolean Kontrolleri
        String matineDurumu = sistem.matineMi(saat) ? "Matine" : "Normal";
        String haftasonuDurumu = sistem.haftasonuMu(gun) ? "Hafta Sonu" : "Hafta İçi";
        
        // 4. Çıktı Oluşturma ve Yazdırma 
        System.out.println("\n***************************************");
        System.out.println("********* SİNEMA BİLET ÖZETİ **********");
        System.out.println("***************************************");
        System.out.println(" Tarih/Saat: " + gunAdi + " (" + haftasonuDurumu + "), " + saat + ":00 (" + matineDurumu + ")");
        System.out.println(" Müşteri Bilgisi: Yaş=" + yas + ", Meslek=" + meslekAdi);
        System.out.println(" Film Türü: " + filmTuruAdi +  " (Ekstra Ücret: " + String.format("%.2f", ekstraUcret) + " TL)");
        System.out.println("---------------------------------------");
        System.out.println(" Temel Bilet Fiyatı: " + String.format("%.2f", temelFiyat) + " TL");
        System.out.println(" Uygulanan İndirim:  " + String.format("%.2f", indirim) + " TL");
        System.out.println("---------------------------------------");
        System.out.println(" Nihai Ödenecek Tutar: " + String.format("%.2f", nihaiFiyat) + " TL");
        System.out.println("***************************************");

        tarayici.close(); 
    }
}