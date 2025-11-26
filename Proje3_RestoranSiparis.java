/*
Ad Soyad = Nihal Eylül İL
No = 250541001
Proje = Restoran Sipariş Uygulaması
Teslim Tarihi = 27.11.2025
 */

import java.util.Scanner;
public class Proje3_RestoranSiparis {

 //Metot ve switch case kullanılarak ana yemek fiyatları döndürüldü.
    public double anaYemekFiyatiGetir(int secim) {
        double fiyat = 0.0;
        switch (secim) {
            case 1: 
                fiyat = 85.0; // Izgara Tavuk
                break;
            case 2: 
                fiyat = 120.0; // Adana Kebap
                break;
            case 3: 
                fiyat = 110.0; // Levrek
                break;
            case 4: 
                fiyat = 65.0; // Mantı
                break;
            default: 
                fiyat = 0.0;
                break;
        }
        return fiyat;
    }

 //Metot ve switch case kullanılarak başlangıç fiyatları döndürüldü.
    public double baslangicFiyatiGetir(int secim) {
        double fiyat = 0.0;
        switch (secim) {
            case 1: 
                fiyat = 25.0; // Çorba
                break;
            case 2: 
                fiyat = 45.0; // Humus
                break;
            case 3: 
                fiyat = 55.0; // Sigara Böreği
                break;
            default: 
                fiyat = 0.0;
                break;
        }
        return fiyat;
    }

 //Metot ve switch case kullanılarak içecek fiyatları döndürüldü.
    public double icecekFiyatiGetir(int secim) {
        double fiyat = 0.0;
        switch (secim) {
            case 1: 
                fiyat = 15.0; // Kola
                break;
            case 2: 
                fiyat = 12.0; // Ayran
                break;
            case 3: 
                fiyat = 35.0; // Taze Meyve Suyu
                break;
            case 4: 
                fiyat = 25.0; // Limonata
                break;
            default: 
                fiyat = 0.0;
                break;
        }
        return fiyat;
    }

     //Metot ve switch case kullanılarak tatlı fiyatları döndürüldü.
    public double tatliFiyatiGetir(int secim) {
        double fiyat = 0.0;
        switch (secim) {
            case 1: 
                fiyat = 65.0; // Künefe
                break;
            case 2: 
                fiyat = 55.0; // Baklava
                break;
            case 3: 
                fiyat = 35.0; // Sütlaç
                break;
            default: 
                fiyat = 0.0;
                break;
        }
        return fiyat;
    }

     //Metot kullanılarak oluşturulan menüde combo sipariş olup olmadığı kontrol edildi.
    public boolean comboSiparisMi(double anaFiyat, double icecekFiyat, double tatliFiyat) {
        return anaFiyat > 0 && icecekFiyat > 0 && tatliFiyat > 0;
    }

     //Metot kullanılarak gidilen saatin happy hour içerisinde olup olmadığı kontrolü yapıldı.
    public boolean happyHourMi(int saat) {
        return saat >= 14 && saat < 17;
    }
     //Metot kullanılarak servis bahşişi önerisi hesaplandı.
    public double servisBahsisHesapla(double toplamTutar) {
        return toplamTutar * 0.10;
    }

    // Metot kullanılarak kullanıcıdan belirli bir aralıkta sayısal girdi alındı.
    private static int alGirdi(Scanner scanner, String mesaj, int min, int max) {
        int girdi;
        System.out.print(mesaj);
        girdi = scanner.nextInt(); 
        
        if (girdi >= min && girdi <= max) {
            return girdi; // Geçerli ise değeri döndürür.
        } else {
            System.out.println("Hata: Lütfen " + min + " ile " + max + " arasında bir sayı girin.");
            return alGirdi(scanner, mesaj, min, max); 
        }
    }

     //Ana metot başlatıldı.
    public static void main(String[] args) {

        //Scanner ve Proje_3 RestoranSiparis nesneleri oluşturuldu.
        Scanner scanner = new Scanner(System.in);
        Proje3_RestoranSiparis sistem = new  Proje3_RestoranSiparis();

        // Menü ve seçim aralıklarını kullanıcıya gösterildi.
        System.out.println("### Restoran Menüsü ve Seçimler ###");
        System.out.println("1. Ana Yemekler (0-4): 1: Tavuk, 2: Kebap, 3: Levrek, 4: Mantı");
        System.out.println("2. Başlangıçlar (0-3): 1: Çorba, 2: Humus, 3: Börek");
        System.out.println("3. İçecekler (0-4): 1: Kola, 2: Ayran, 3: Meyve Suyu, 4: Limonata");
        System.out.println("4. Tatlılar (0-3): 1: Künefe, 2: Baklava, 3: Sütlaç");
        System.out.println("------------------------------------");
        System.out.println("Not: 0 seçeneği 'sipariş yok' anlamına gelir.");
        
        // Kullanıcıdan gerekli tüm bilgiler alındı.
        int anaYemekSecim = alGirdi(scanner, "Ana Yemek (1-4, yoksa 0): ", 0, 4);
        int baslangicSecim = alGirdi(scanner, "Başlangıç (1-3, yoksa 0): ", 0, 3);
        int icecekSecim = alGirdi(scanner, "İçecek (1-4, yoksa 0): ", 0, 4);
        int tatliSecim = alGirdi(scanner, "Tatlı (1-3, yoksa 0): ", 0, 3);
        int saat = alGirdi(scanner, "Saat (8-23): ", 8, 23);
        int gun = alGirdi(scanner, "Hangi gün? (1: Pts, ..., 7: Paz): ", 1, 7);
        
        System.out.print("Öğrenci misiniz? (E/H): ");
        String ogrenciYanit = scanner.next().trim().toUpperCase();
        boolean ogrenci = ogrenciYanit.equals("E");

        scanner.close();
        
        // Ürün fiyatları getirildi.
        double anaYemekFiyat = sistem.anaYemekFiyatiGetir(anaYemekSecim);
        double baslangicFiyat = sistem.baslangicFiyatiGetir(baslangicSecim);
        double icecekFiyat = sistem.icecekFiyatiGetir(icecekSecim);
        double tatliFiyat = sistem.tatliFiyatiGetir(tatliSecim);

        // Ara toplam hesaplandı.
        double araToplam = anaYemekFiyat + baslangicFiyat + icecekFiyat + tatliFiyat;

        // İndirim koşulları kontrol edildi.
        boolean combo = sistem.comboSiparisMi(anaYemekFiyat, icecekFiyat, tatliFiyat);
        boolean happyHour = sistem.happyHourMi(saat);
        boolean haftaIci = gun >= 1 && gun <= 5;

        // İndirim tutarları hesaplandı.
        double toplamIndirim = 0.0;
        double comboIndirim = 0.0;
        double happyHourIndirim = 0.0;
        double ogrenciIndirim = 0.0;

        // Combo indirimi (%15) hesaplandı.
        if (combo) {
            comboIndirim = araToplam * 0.15;
            toplamIndirim += comboIndirim;
        }

        // Happy Hour indirimi hesaplandı.
        if (happyHour && icecekFiyat > 0) {
            happyHourIndirim = icecekFiyat * 0.20;
            toplamIndirim += happyHourIndirim;
        }

        // Öğrenci indirimi hesaplandı.
        if (ogrenci && haftaIci) {
            ogrenciIndirim = araToplam * 0.10;
            toplamIndirim += ogrenciIndirim;
        }
        
        // Ödenecek toplam tutar hesaplandı.
        double toplamTutar = araToplam - toplamIndirim;

        // Bahşiş önerisi hesaplandı.
        double bahsisOnerisi = sistem.servisBahsisHesapla(toplamTutar);

        // Çıktılar formatlı şekilde yazdırıldı.

        System.out.println("\n=========================================");
        System.out.println("          RESTORAN SİPARİŞ ÖZETİ          ");
        System.out.println("==========================================");

        // Girdiler
        System.out.println("### GİRDİLER ###");
        System.out.printf("%-25s: %d\n", "Ana Yemek Seçim", anaYemekSecim);
        System.out.printf("%-25s: %d\n", "Başlangıç Seçim", baslangicSecim);
        System.out.printf("%-25s: %d\n", "İçecek Seçim", icecekSecim);
        System.out.printf("%-25s: %d\n", "Tatlı Seçim", tatliSecim);
        System.out.printf("%-25s: %d (HH: %s)\n", "Saat", saat, happyHour ? "Evet" : "Hayır");
        System.out.printf("%-25s: %s\n", "Öğrenci Misiniz", ogrenci ? "Evet" : "Hayır");
        System.out.printf("%-25s: %d (Hafta İçi: %s)\n", "Gün", gun, haftaIci ? "Evet" : "Hayır");
        System.out.println("----------------------------------------");
        
        // Fiyatlar ve ara toplamı 
        System.out.println("### HESAPLAMA ###");
        System.out.printf("%-25s: %.2f TL\n", "Ana Yemek Fiyatı", anaYemekFiyat);
        System.out.printf("%-25s: %.2f TL\n", "Başlangıç Fiyatı", baslangicFiyat);
        System.out.printf("%-25s: %.2f TL\n", "İçecek Fiyatı", icecekFiyat);
        System.out.printf("%-25s: %.2f TL\n", "Tatlı Fiyatı", tatliFiyat);
        System.out.println("----------------------------------------");
        System.out.printf("%-25s: **%.2f TL**\n", "ARA TOPLAM", araToplam);
        System.out.println("----------------------------------------");
        
        // İndirimler
        System.out.printf("%-25s: %s\n", "Combo Menü Durumu", combo ? "Evet" : "Hayır");
        System.out.printf("%-25s: -%.2f TL (%%15)\n", "Combo İndirimi", comboIndirim);
        System.out.printf("%-25s: -%.2f TL (İçeceklerde %%20)\n", "Happy Hour İndirimi", happyHourIndirim);
        System.out.printf("%-25s: -%.2f TL (Hafta İçi %%10)\n", "Öğrenci İndirimi", ogrenciIndirim);
        System.out.println("----------------------------------------");
        System.out.printf("%-25s: **-%.2f TL**\n", "TOPLAM İNDİRİM", toplamIndirim);
        System.out.println("----------------------------------------");
        
        // Sonuç ve bahşiş önerisi
        System.out.printf("%-25s: **%.2f TL**\n", "ÖDENECEK TOPLAM TUTAR", toplamTutar);
        System.out.printf("%-25s: %.2f TL (%%10)\n", "Bahşiş Önerisi", bahsisOnerisi);
        System.out.println("========================================");
    }
}