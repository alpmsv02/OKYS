import java.util.List;

/** Kutuphane gorevlisi (Kullanici'dan turer). */
public class KutuphaneGorevlisi extends Kullanici {
    public KutuphaneGorevlisi(int id, String ad, String eposta, String sifre) {
        super(id, ad, eposta, sifre);
    }

    public Kitap kitapEkle(List<Kitap> kitaplar, Kitap kitap) {
        kitaplar.add(kitap);
        return kitap;
    }

    public void kitapGuncelle(Kitap kitap, String yeniBaslik) {
        kitap.setBaslik(yeniBaslik);
    }

    public boolean oduncTalebiniOnayla(OduncKaydi kayit) {
        return kayit != null && kayit.getTeslimTarihi() == null;
    }
}
