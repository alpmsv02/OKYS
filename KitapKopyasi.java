import java.util.ArrayList;
import java.util.List;

/** Bir kitabin fiziksel kopyasi (kendine ait barkodu vardir). */
public class KitapKopyasi {
    private String barkod;
    private Kitap kitap;               // hangi kitabin kopyasi
    private boolean musait = true;
    private List<OduncKaydi> oduncKayitlari = new ArrayList<>();

    public KitapKopyasi(String barkod, Kitap kitap) {
        this.barkod = barkod;
        this.kitap = kitap;
    }

    public String getBarkod() { return barkod; }
    public Kitap getKitap() { return kitap; }
    public boolean isMusait() { return musait; }
    public void setMusait(boolean musait) { this.musait = musait; }
    public List<OduncKaydi> getOduncKayitlari() { return oduncKayitlari; }

    @Override
    public String toString() {
        return "KitapKopyasi[" + barkod + ", " + kitap.getBaslik() + ", musait=" + musait + "]";
    }
}
