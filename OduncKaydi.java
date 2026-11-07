import java.time.LocalDate;

/** Bir uyenin bir kitap kopyasini odunc almasi (her kopya icin ayri kayit). */
public class OduncKaydi {
    private int islemNo;
    private LocalDate oduncTarihi;
    private LocalDate sonTeslimTarihi;
    private LocalDate teslimTarihi;    // teslim edilene kadar null
    private Uye uye;                   // tam olarak bir Uye
    private KitapKopyasi kopya;        // tam olarak bir KitapKopyasi

    public OduncKaydi(int islemNo, Uye uye, KitapKopyasi kopya, LocalDate oduncTarihi, int gunSayisi) {
        this.islemNo = islemNo;
        this.uye = uye;
        this.kopya = kopya;
        this.oduncTarihi = oduncTarihi;
        this.sonTeslimTarihi = oduncTarihi.plusDays(gunSayisi);
    }

    public void sureUzat(int gun) { sonTeslimTarihi = sonTeslimTarihi.plusDays(gun); }

    public void teslimEt(LocalDate tarih) {
        this.teslimTarihi = tarih;
        kopya.setMusait(true);
        kopya.getKitap().durumGuncelle();
    }

    public int getIslemNo() { return islemNo; }
    public Uye getUye() { return uye; }
    public KitapKopyasi getKopya() { return kopya; }
    public LocalDate getSonTeslimTarihi() { return sonTeslimTarihi; }
    public LocalDate getTeslimTarihi() { return teslimTarihi; }

    @Override
    public String toString() {
        return "OduncKaydi[" + islemNo + ", " + uye.getAd() + ", " + kopya.getBarkod()
                + ", odunc=" + oduncTarihi + ", sonTeslim=" + sonTeslimTarihi
                + ", teslim=" + (teslimTarihi == null ? "-" : teslimTarihi) + "]";
    }
}
