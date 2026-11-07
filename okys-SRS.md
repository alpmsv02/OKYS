# OKYS – Yazılım Gereksinimleri (SRS) Özeti

**Aktörler:** Üye, Kütüphane Görevlisi (ortak: Kullanıcı – ID, Ad, E-posta, Şifre)

**Kullanım senaryoları:** Sisteme Giriş Yap, Kitap Ara, Kitap Ödünç Al, Süre Uzat, Kitap Ekle/Güncelle, Ödünç Talebini Onayla

**Sınıflar:**
- Kitap (ISBN, Başlık, Yazar, Yayın Yılı, Durum)
- KitapKopyası (Barkod) – Kitap ile composition ilişkisi
- ÖdünçAlma / OduncKaydi (İşlemNo, ÖdünçTarihi, SonTeslimTarihi, TeslimTarihi)
- Üye ile OduncKaydi: 1 – 0..*, KitapKopyası ile OduncKaydi: 1 – 0..*
