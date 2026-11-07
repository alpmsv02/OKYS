import java.util.ArrayList;
import java.util.List;

/** Bir kitabin bilgileri. Kitap, fiziksel kopyalarini (KitapKopyasi) icerir (Composition). */
public class Kitap {
    private String isbn;
    private String baslik;
    private String yazar;
    private int yayinYili;
    private String durum; // "Odunc Verilebilir" / "Odunc Verildi"
    private List<KitapKopyasi> fizikselKopyalar = new ArrayList<>();

    public Kitap(String isbn, String baslik, String yazar, int yayinYili) {
        this.isbn = isbn;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.durum = "Odunc Verilebilir";
    }

    /** Kopya Kitap tarafindan uretilir; kitap olmadan kopya olmaz. */
    public KitapKopyasi kopyaEkle(String barkod) {
        KitapKopyasi kopya = new KitapKopyasi(barkod, this);
        fizikselKopyalar.add(kopya);
        return kopya;
    }

    /** Musait kopya varsa durum "Odunc Verilebilir", yoksa "Odunc Verildi". */
    public void durumGuncelle() {
        boolean musaitVar = false;
        for (KitapKopyasi k : fizikselKopyalar) {
            if (k.isMusait()) { musaitVar = true; break; }
        }
        durum = musaitVar ? "Odunc Verilebilir" : "Odunc Verildi";
    }

    public String getIsbn() { return isbn; }
    public String getBaslik() { return baslik; }
    public String getYazar() { return yazar; }
    public int getYayinYili() { return yayinYili; }
    public String getDurum() { return durum; }
    public void setBaslik(String baslik) { this.baslik = baslik; }
    public List<KitapKopyasi> getFizikselKopyalar() { return fizikselKopyalar; }

    @Override
    public String toString() {
        return "Kitap[" + isbn + ", " + baslik + ", " + yazar + ", " + yayinYili
                + ", " + durum + ", kopya=" + fizikselKopyalar.size() + "]";
    }
}
