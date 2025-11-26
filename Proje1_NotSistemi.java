/*
Ad Soyad = Nihal Eylül İL
No = 250541001
Proje = Not Değerlendirme Sistemi
Teslim Tarihi = 27.11.2025
 */

import java.util.Scanner;
public class Proje1_NotSistemi{

     //İstenilen formüle göre ve metot kullanılarak ortalama hesaplandı.
        public static double ortalamaHesapla(double vizenotu,double finalnotu,double odevnotu){
        double ortalama = (vizenotu * 0.3) + (finalnotu * 0.4) + (odevnotu * 0.3);
        return ortalama;
        }

     //Metot kullanılarak geçme-kalma durumu belirlendi.
        public static String gecmeDurumu(double ortalama){
            if(ortalama>=50){
                return "GEÇTİ";
            } else {
                return"KALDI";
            }
        }

     //Metot kullanılarak harf notu belirlendi.
        public static char harfNotuBelirle(double ortalama){
            if(ortalama>=90){
                return'A';
            } else if(ortalama>=80){
                return'B';
            } else if(ortalama>=70){
                return'C';
            } else if(ortalama>=60){
                return'D';
            } else {
                return'F';
            }
        }

     //Metot kullanılarak onur listine girme durumu belirlendi.
        public static String onurListesiDurumu(double ortalama, double vizenotu, double finalnotu, double odevnotu){
            if(ortalama>=85 && vizenotu>70 && finalnotu>70 && odevnotu>70){
                return"EVET";
         } else {
                return"HAYIR";}
        }

     //Metot kullanılarak bütünleme durumu belirlendi.
        public static String butunlemeHakkı(double ortalama){
            if(ortalama<=40 && ortalama<50){
                return"VAR";
            } else {
                return"YOK";
            }
        }

     //Ana metot başlatıldı ve program çalıştırıldı.
    public static void main(String[] args){

     //Scanner çağırıldı.
        Scanner input = new Scanner (System.in);

     //Kullanıcıdan not bilgileri alındı.
        System.out.print("Vize notunuzu giriniz:");
        double vizenotu = input.nextDouble();

        System.out.print("Final notunuzu giriniz:");
        double finalnotu = input.nextDouble();

        System.out.print("Ödev notunuzu giriniz:");
        double odevnotu = input.nextDouble();

     //Çıktılar ekrana formatlı şekilde yazdırıldı.
     System.out.printf("==============OGRENCİ NOT RAPORU=============\n");
     System.out.printf("Vize Notu       : %.2f\n", vizenotu);
     System.out.printf("Final Notu      : %.2f\n", finalnotu);
     System.out.printf("Ödev Notu       : %.2f\n", odevnotu);
     System.out.printf("---------------------------------------------\n");
     System.out.printf("Ortalama        : %.2f\n", ortalamaHesapla(vizenotu, finalnotu, odevnotu));
     System.out.printf("Harf Notu       : %c\n", harfNotuBelirle(ortalamaHesapla(vizenotu, finalnotu, odevnotu)));
     System.out.printf("Geçme Durumu    : %s\n", gecmeDurumu(ortalamaHesapla(vizenotu, finalnotu, odevnotu)));
     System.out.printf("Onur Listesi    : %s\n", onurListesiDurumu(ortalamaHesapla(vizenotu, finalnotu, odevnotu), vizenotu, finalnotu, odevnotu));
     System.out.printf("Bütünleme Hakkı : %s\n", butunlemeHakkı(ortalamaHesapla(vizenotu, finalnotu, odevnotu)));

        input.close();
    }
}