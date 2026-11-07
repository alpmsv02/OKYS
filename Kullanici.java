/** Sistemdeki tum kullanicilarin ortak sinifi (Uye ve KutuphaneGorevlisi bu siniftan turer). */
public class Kullanici {
    private int id;
    private String ad;
    private String eposta;
    private String sifre;

    public Kullanici(int id, String ad, String eposta, String sifre) {
        this.id = id;
        this.ad = ad;
        this.eposta = eposta;
        this.sifre = sifre;
    }

    public boolean girisYap(String eposta, String sifre) {
        return this.eposta.equals(eposta) && this.sifre.equals(sifre);
    }

    public int getId() { return id; }
    public String getAd() { return ad; }
    public String getEposta() { return eposta; }

    @Override
    public String toString() {
        return "Kullanici[" + id + ", " + ad + ", " + eposta + "]";
    }
}
