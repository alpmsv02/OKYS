import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** OKYS (Online Kutuphane Yonetim Sistemi) deneme programi. */
public class Main {
    public static void main(String[] args) {
        List<Kitap> kitaplar = new ArrayList<>();

        KutuphaneGorevlisi gorevli = new KutuphaneGorevlisi(1, "Ayse Yilmaz", "ayse@okys.com", "1234");
        Uye uye = new Uye(2, "Nurasyl Utepbergen", "nurasyl@okys.com", "abcd");

        // Gorevli kitap ve kopyalarini ekler
        Kitap kitap1 = gorevli.kitapEkle(kitaplar, new Kitap("978-1", "Nesneye Yonelik Programlama", "Ali Demir", 2020));
        kitap1.kopyaEkle("B-001");
        kitap1.kopyaEkle("B-002");
        Kitap kitap2 = gorevli.kitapEkle(kitaplar, new Kitap("978-2", "Yazilim Muhendisligi", "Can Kaya", 2018));
        kitap2.kopyaEkle("B-003");

        System.out.println("Giris: " + uye.girisYap("nurasyl@okys.com", "abcd"));
        System.out.println(uye);
        System.out.println(gorevli);

        // Uye kitap arar ve odunc alir
        Kitap bulunan = uye.kitapAra(kitaplar, "nesneye");
        System.out.println("Aranan kitap: " + bulunan);
        OduncKaydi k1 = uye.oduncAl(bulunan, LocalDate.of(2026, 10, 5));
        OduncKaydi k2 = uye.oduncAl(kitap2, LocalDate.of(2026, 10, 5));
        System.out.println("Onay: " + gorevli.oduncTalebiniOnayla(k1));
        uye.sureUzat(k1, 7);

        for (OduncKaydi k : uye.getOduncListesi()) System.out.println(k);
        for (Kitap k : kitaplar) System.out.println(k);

        // Teslim
        k2.teslimEt(LocalDate.of(2026, 10, 12));
        System.out.println(k2);
        System.out.println(kitap2);
        System.out.println("Okudugum kitaplar: " + uye.getOkudugumKitaplar().size());
    }
}
