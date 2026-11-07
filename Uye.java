import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Kutuphane uyesi (Kullanici'dan turer). */
public class Uye extends Kullanici {
    private List<OduncKaydi> oduncListesi = new ArrayList<>();
    private static int islemSayaci = 1;

    public Uye(int id, String ad, String eposta, String sifre) {
        super(id, ad, eposta, sifre);
    }

    public Kitap kitapAra(List<Kitap> kitaplar, String metin) {
        for (Kitap k : kitaplar) {
            if (k.getBaslik().toLowerCase().contains(metin.toLowerCase())) return k;
        }
        return null;
    }

    /** Kitabin musait bir kopyasini odunc alir ve OduncKaydi olusturur. */
    public OduncKaydi oduncAl(Kitap kitap, LocalDate tarih) {
        for (KitapKopyasi kopya : kitap.getFizikselKopyalar()) {
            if (kopya.isMusait()) {
                kopya.setMusait(false);
                OduncKaydi kayit = new OduncKaydi(islemSayaci++, this, kopya, tarih, 14);
                oduncListesi.add(kayit);
                kopya.getOduncKayitlari().add(kayit);
                kitap.durumGuncelle();
                return kayit;
            }
        }
        return null; // musait kopya yok
    }

    public void sureUzat(OduncKaydi kayit, int gun) { kayit.sureUzat(gun); }

    public List<OduncKaydi> getOduncListesi() { return oduncListesi; }

    /** Uyenin odunc aldigi kitaplarin listesi (OduncKaydi -> KitapKopyasi -> Kitap uzerinden). */
    public List<Kitap> getOkudugumKitaplar() {
        List<Kitap> liste = new ArrayList<>();
        for (OduncKaydi k : oduncListesi) liste.add(k.getKopya().getKitap());
        return liste;
    }
}
