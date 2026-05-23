import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.function.Consumer;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class otomata_teorisi {

    public static final String Q0 = "q0";
    public static final String Q1 = "q1";
    public static final String Q2 = "q2";
    public static final String Q3 = "q3";
    public static final String Q4 = "q4";
    public static final String Q5 = "q5";
    public static final String Q6 = "q6";
    public static final String Q7 = "q7";
    public static final String Q8 = "q8";
    public static final String Q9 = "q9";
    public static final String Q10 = "q10";
    public static final String Q11 = "q11";
    public static final String Q12 = "q12";
    public static final String Q13 = "q13";
    public static final String Q14 = "q14";
    public static final String Q15 = "q15";
    public static final String Q16 = "q16";
    public static final String Q17 = "q17";
    public static final String Q18 = "q18";
    public static final String Q19 = "q19";
    public static final String Q20 = "q20";
    public static final String Q21 = "q21";
    public static final String Q22 = "q22";
    public static final String Q23 = "q23";
    public static final String Q24 = "q24";
    public static final String Q25 = "q25";
    public static final String Q26 = "q26";
    public static final String Q27 = "q27";
    public static final String Q28 = "q28";

    public static final String KART_TAK          = "kart_tak";
    public static final String KART_CIKAR         = "kart_cikar";
    public static final String PIN_GIR            = "pin_gir";
    public static final String PIN_DOGRU          = "pin_dogru";
    public static final String PIN_YANLIS         = "pin_yanlis";
    public static final String BAKIYE_SORGULA     = "bakiye_sorgula";
    public static final String PARA_CEK           = "para_cek";
    public static final String PARA_YATIR         = "para_yatir";
    public static final String TRANSFER_SEC       = "transfer_sec";
    public static final String TUTAR_GIR          = "tutar_gir";
    public static final String GECERSIZ_TUTAR     = "gecersiz_tutar";
    public static final String BAKIYE_YETERLI     = "bakiye_yeterli";
    public static final String BAKIYE_YETERSIZ    = "bakiye_yetersiz";
    public static final String LIMIT_OK           = "limit_ok";
    public static final String LIMIT_ASILDI       = "limit_asildi";
    public static final String NAKIT_ALINDI       = "nakit_alindi";
    public static final String NAKIT_YATIR        = "nakit_yatir";
    public static final String NAKIT_SAYILDI      = "nakit_sayildi";
    public static final String HESAP_GIR          = "hesap_gir";
    public static final String GECERSIZ_HESAP     = "gecersiz_hesap";
    public static final String MAKBUZ_AL          = "makbuz_al";
    public static final String MAKBUZ_ISTEMIYORUM = "makbuz_istemiyorum";
    public static final String IPTAL              = "iptal";
    public static final String ZAMAN_ASIMI        = "zaman_asimi";
    public static final String DEVAM              = "devam";

    public static final String KABUL_OTURUM_SONLANDI        = "q27";
    public static final String TAMAMLANMA_PARA_CEKME        = "q17";
    public static final String TAMAMLANMA_PARA_YATIRMA      = "q20";
    public static final String TAMAMLANMA_TRANSFER          = "q25";
    public static final String TAMAMLANMA_BAKIYE_SORGULANDI = "q8";
    public static final String RED_YETERSIZ_BAKIYE          = "q15";
    public static final String RED_YETERSIZ_BAKIYE_TRANS    = "q24";
    public static final String HATA_KART_KILITLI            = "q5";
    public static final String HATA_PIN_YANLIS_1            = "q3";
    public static final String HATA_PIN_YANLIS_2            = "q4";
    public static final String IPTAL_ZAMAN_ASIMI            = "q28";

    // ---------------------------------------------------------------
    // YARDIMCI: durum açıklaması
    // ---------------------------------------------------------------
    private static String durumAciklama(String s) {
        switch (s) {
            case Q0:  return "Bekleniyor — Kart takılmadı";
            case Q1:  return "Kart takıldı — PIN bekleniyor";
            case Q2:  return "PIN girişi — 1. deneme";
            case Q3:  return "PIN yanlış — 2. deneme";
            case Q4:  return "PIN yanlış — 3. deneme";
            case Q5:  return "HATA: Kart kilitlendi";
            case Q6:  return "Kimlik doğrulandı (epsilon-geçiş)";
            case Q7:  return "İşlem seçimi menüsü";
            case Q8:  return "Bakiye sorgulandı";
            case Q9:  return "Para çekme — Tutar bekleniyor";
            case Q10: return "Para yatırma — Nakit bekleniyor";
            case Q11: return "Transfer — Hesap bekleniyor";
            case Q12: return "Para çekme — Tutar kontrolü";
            case Q13: return "Para çekme — Limit kontrolü";
            case Q14: return "RED: Çekim limiti aşıldı";
            case Q15: return "RED: Yetersiz bakiye";
            case Q16: return "Nakit veriliyor";
            case Q17: return "Para çekme tamamlandı";
            case Q18: return "Para yatırma — Nakit sayılıyor";
            case Q19: return "Para yatırma — Onay bekleniyor";
            case Q20: return "Para yatırma tamamlandı";
            case Q21: return "Transfer — Hesap doğrulandı (epsilon-geçiş)";
            case Q22: return "Transfer — Tutar bekleniyor";
            case Q23: return "Transfer — Bakiye kontrolü";
            case Q24: return "RED: Transfer için yetersiz bakiye";
            case Q25: return "Transfer tamamlandı";
            case Q26: return "Oturum kapanışı — Makbuz seçimi";
            case Q27: return "KABUL: Oturum başarıyla sonlandı";
            case Q28: return "İPTAL: Zaman aşımı";
            default:  return "Bilinmeyen durum";
        }
    }

    // ---------------------------------------------------------------
    // YARDIMCI: geçerli komutlar (geçersiz giriş mesajı için)
    // ---------------------------------------------------------------
    private static String gecerliKomutlar(String s) {
        switch (s) {
            case Q0:  return "kart_tak";
            case Q1:  return "pin_gir";
            case Q2:
            case Q3:
            case Q4:  return "pin_dogru | pin_yanlis | zaman_asimi";
            case Q5:  return "(Kart kilitli, işlem yapılamaz)";
            case Q7:  return "bakiye_sorgula | para_cek | para_yatir | transfer_sec | iptal | zaman_asimi";
            case Q8:  return "devam";
            case Q9:  return "tutar_gir";
            case Q12: return "gecersiz_tutar | bakiye_yeterli | bakiye_yetersiz";
            case Q13: return "limit_ok | limit_asildi";
            case Q14:
            case Q15: return "devam";
            case Q16: return "nakit_alindi";
            case Q17: return "devam";
            case Q10: return "nakit_yatir";
            case Q18: return "nakit_sayildi";
            case Q19: return "devam";
            case Q20: return "devam";
            case Q11: return "hesap_gir | gecersiz_hesap";
            case Q22: return "tutar_gir | gecersiz_tutar";
            case Q23: return "bakiye_yeterli | bakiye_yetersiz";
            case Q24: return "devam";
            case Q25: return "devam";
            case Q26: return "makbuz_al | makbuz_istemiyorum";
            case Q27: return "kart_cikar";
            case Q28: return "(Zaman aşımı, oturum sıfırlanıyor)";
            default:  return "—";
        }
    }

    // ---------------------------------------------------------------
    // GUI: etiketler, ekran mesajları, senaryolar
    // ---------------------------------------------------------------
    private static String komutEtiket(String komut) {
        switch (komut) {
            case KART_TAK:          return "Kart Tak";
            case KART_CIKAR:        return "Kartı Çıkar";
            case PIN_GIR:           return "PIN Gir";
            case PIN_DOGRU:         return "PIN Doğru";
            case PIN_YANLIS:        return "PIN Yanlış";
            case BAKIYE_SORGULA:    return "Bakiye Sorgula";
            case PARA_CEK:          return "Para Çek";
            case PARA_YATIR:        return "Para Yatır";
            case TRANSFER_SEC:      return "Transfer";
            case TUTAR_GIR:         return "Tutar Gir";
            case GECERSIZ_TUTAR:    return "Geçersiz Tutar";
            case BAKIYE_YETERLI:    return "Bakiye Yeterli";
            case BAKIYE_YETERSIZ:   return "Bakiye Yetersiz";
            case LIMIT_OK:          return "Limit OK";
            case LIMIT_ASILDI:      return "Limit Aşıldı";
            case NAKIT_ALINDI:      return "Nakit Alındı";
            case NAKIT_YATIR:       return "Nakit Yatır";
            case NAKIT_SAYILDI:     return "Nakit Sayıldı";
            case HESAP_GIR:         return "Hesap Gir";
            case GECERSIZ_HESAP:    return "Geçersiz Hesap";
            case MAKBUZ_AL:         return "Makbuz Al";
            case MAKBUZ_ISTEMIYORUM: return "Makbuz İstemiyorum";
            case IPTAL:             return "İptal";
            case ZAMAN_ASIMI:       return "Zaman Aşımı";
            case DEVAM:             return "Devam";
            default:                return komut;
        }
    }

    private static String ekranMesaji(String state) {
        switch (state) {
            case Q0:  return "Hoş geldiniz.\nLütfen kartınızı takın.";
            case Q1:  return "Kart okundu.\nPIN kodunuzu girin.";
            case Q2:  return "PIN girişi (1. deneme)";
            case Q3:  return "PIN hatalı.\n2. deneme hakkınız kaldı.";
            case Q4:  return "PIN hatalı.\nSon deneme!";
            case Q5:  return "KART KİLİTLENDİ\nBankanızla iletişime geçin.";
            case Q6:
            case Q7:  return "İşlem menüsü\nBakiye | Çekim | Yatırım | Transfer";
            case Q8:  return "Bakiyeniz ekranda.\nDevam için tuşa basın.";
            case Q9:  return "Para çekme\nÇekmek istediğiniz tutarı girin.";
            case Q10: return "Para yatırma\nNakit yatırın.";
            case Q11: return "Transfer\nAlıcı hesap numarasını girin.";
            case Q12: return "Tutar kontrol ediliyor...";
            case Q13: return "Günlük limit kontrol ediliyor...";
            case Q14: return "Günlük çekim limiti aşıldı.";
            case Q15: return "Yetersiz bakiye.";
            case Q16: return "Lütfen paranızı alın.";
            case Q17: return "Para çekme tamamlandı.";
            case Q18: return "Nakit sayılıyor...";
            case Q19: return "Yatırma onayı bekleniyor.";
            case Q20: return "Para yatırma tamamlandı.";
            case Q21:
            case Q22: return "Transfer tutarını girin.";
            case Q23: return "Transfer bakiye kontrolü...";
            case Q24: return "Transfer için yetersiz bakiye.";
            case Q25: return "Transfer tamamlandı.";
            case Q26: return "Makbuz almak ister misiniz?";
            case Q27: return "İşlem bitti.\nKartınızı alabilirsiniz.";
            case Q28: return "Zaman aşımı.\nOturum kapatıldı.";
            default:  return durumAciklama(state);
        }
    }

    private static String sonucKategorisi(String state) {
        if (state.equals(Q0))  return "Beklemede — Kart takılmadı";
        if (state.equals(Q27)) return "KABUL — Oturum tamamlandı";
        if (state.equals(Q5))  return "HATA — Kart kilitlendi";
        if (state.equals(Q28)) return "İPTAL — Zaman aşımı";
        if (state.equals(Q15) || state.equals(Q24)) return "RED — Yetersiz bakiye";
        if (state.equals(Q14)) return "RED — Çekim limiti aşıldı";
        if (state.equals(Q17) || state.equals(Q20) || state.equals(Q25) || state.equals(Q8)) {
            return "İşlem tamamlandı (" + state + ")";
        }
        return "Devam ediyor";
    }

    private static Color sonucArkaPlan(String kategori) {
        if (kategori.startsWith("KABUL"))     return new Color(220, 252, 231);
        if (kategori.startsWith("HATA"))      return new Color(254, 226, 226);
        if (kategori.startsWith("İPTAL"))     return new Color(254, 243, 199);
        if (kategori.startsWith("RED"))       return new Color(255, 237, 213);
        if (kategori.startsWith("Beklemede")) return new Color(241, 245, 249);
        return new Color(224, 242, 254);
    }

    private static Color sonucYaziRengi(String kategori) {
        if (kategori.startsWith("KABUL"))     return new Color(21, 128, 61);
        if (kategori.startsWith("HATA"))      return new Color(185, 28, 28);
        if (kategori.startsWith("İPTAL"))     return new Color(161, 98, 7);
        if (kategori.startsWith("RED"))       return new Color(194, 65, 12);
        if (kategori.startsWith("Beklemede")) return new Color(51, 65, 85);
        return new Color(29, 78, 216);
    }

    private static void nimbusTemaYukle() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {
        }
    }

    private static void arayuzRenkleriAyarla(Color metin, Color zemin, Color secimArka, Font yaziFontu) {
        UIManager.put("TextArea.background", zemin);
        UIManager.put("TextArea.foreground", metin);
        UIManager.put("TextArea.font", yaziFontu);
        UIManager.put("TextField.background", zemin);
        UIManager.put("TextField.foreground", metin);
        UIManager.put("TextField.font", yaziFontu);
        UIManager.put("ComboBox.background", zemin);
        UIManager.put("ComboBox.foreground", metin);
        UIManager.put("ComboBox.font", yaziFontu);
        UIManager.put("ComboBox.selectionBackground", secimArka);
        UIManager.put("ComboBox.selectionForeground", metin);
        UIManager.put("List.background", zemin);
        UIManager.put("List.foreground", metin);
        UIManager.put("List.selectionBackground", secimArka);
        UIManager.put("List.selectionForeground", metin);
    }

    private static void stilGecisLog(JTextArea log, Font font, Color metin, Color zemin) {
        log.setFont(font);
        log.setOpaque(true);
        log.setBackground(zemin);
        log.setForeground(metin);
        log.setCaretColor(metin);
        log.setDisabledTextColor(metin);
        log.setSelectionColor(new Color(191, 219, 254));
        log.setSelectedTextColor(metin);
    }

    @SuppressWarnings("unchecked")
    private static JComboBox<Senaryo> stilSenaryoCombo(
            Senaryo[] senaryolar, Font font, Color metin, Color zemin, Color secimArka) {
        JComboBox<Senaryo> combo = new JComboBox<>(senaryolar);
        combo.setEditable(false);
        combo.setFont(font);
        combo.setOpaque(true);
        combo.setBackground(zemin);
        combo.setForeground(metin);

        JTextField editor = (JTextField) combo.getEditor().getEditorComponent();
        editor.setFont(font);
        editor.setOpaque(true);
        editor.setBackground(zemin);
        editor.setForeground(metin);
        editor.setDisabledTextColor(metin);
        editor.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(148, 163, 184), 1),
            new EmptyBorder(6, 10, 6, 10)));

        combo.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel lbl = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
                lbl.setFont(font);
                lbl.setOpaque(true);
                if (value instanceof Senaryo) {
                    lbl.setText(((Senaryo) value).ad);
                }
                if (isSelected && index >= 0) {
                    lbl.setBackground(secimArka);
                    lbl.setForeground(metin);
                } else {
                    lbl.setBackground(zemin);
                    lbl.setForeground(metin);
                }
                return lbl;
            }
        });
        return combo;
    }

    private static final class Senaryo {
        final String ad;
        final String[] adimlar;

        Senaryo(String ad, String... adimlar) {
            this.ad = ad;
            this.adimlar = adimlar;
        }
    }

    private static final Senaryo[] SENARYOLAR = {
        new Senaryo("Başarılı: Bakiye sorgulama",
            KART_TAK, PIN_GIR, PIN_DOGRU, BAKIYE_SORGULA, DEVAM, MAKBUZ_AL, KART_CIKAR),
        new Senaryo("Başarılı: Para çekme",
            KART_TAK, PIN_GIR, PIN_DOGRU, PARA_CEK, TUTAR_GIR, BAKIYE_YETERLI, LIMIT_OK,
            NAKIT_ALINDI, DEVAM, MAKBUZ_ISTEMIYORUM, KART_CIKAR),
        new Senaryo("RED: Yetersiz bakiye (çekim)",
            KART_TAK, PIN_GIR, PIN_DOGRU, PARA_CEK, TUTAR_GIR, BAKIYE_YETERSIZ, DEVAM,
            IPTAL, MAKBUZ_ISTEMIYORUM, KART_CIKAR),
        new Senaryo("RED: Çekim limiti aşıldı",
            KART_TAK, PIN_GIR, PIN_DOGRU, PARA_CEK, TUTAR_GIR, BAKIYE_YETERLI, LIMIT_ASILDI,
            DEVAM, IPTAL, MAKBUZ_AL, KART_CIKAR),
        new Senaryo("HATA: 3 yanlış PIN",
            KART_TAK, PIN_GIR, PIN_YANLIS, PIN_YANLIS, PIN_YANLIS),
        new Senaryo("İPTAL: Zaman aşımı (PIN)",
            KART_TAK, PIN_GIR, ZAMAN_ASIMI),
        new Senaryo("Başarılı: Para yatırma",
            KART_TAK, PIN_GIR, PIN_DOGRU, PARA_YATIR, NAKIT_YATIR, NAKIT_SAYILDI, DEVAM,
            DEVAM, MAKBUZ_ISTEMIYORUM, KART_CIKAR),
        new Senaryo("Başarılı: Transfer",
            KART_TAK, PIN_GIR, PIN_DOGRU, TRANSFER_SEC, HESAP_GIR, TUTAR_GIR, BAKIYE_YETERLI,
            DEVAM, MAKBUZ_AL, KART_CIKAR),
        new Senaryo("RED: Transfer yetersiz bakiye",
            KART_TAK, PIN_GIR, PIN_DOGRU, TRANSFER_SEC, HESAP_GIR, TUTAR_GIR, BAKIYE_YETERSIZ,
            DEVAM, IPTAL, MAKBUZ_ISTEMIYORUM, KART_CIKAR),
        new Senaryo("İPTAL: Menüden iptal",
            KART_TAK, PIN_GIR, PIN_DOGRU, IPTAL, MAKBUZ_ISTEMIYORUM, KART_CIKAR),
    };

    // ---------------------------------------------------------------
    // MAIN — varsayılan arayüz (F5, Run, calistir.bat)
    // Konsol: --konsol veya calistir-konsol.bat
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        if (args.length > 0 && ("--konsol".equals(args[0]) || "-konsol".equals(args[0]))) {
            baslatKonsol();
        } else {
            baslatArayuz();
        }
    }

    public static void baslatArayuz() {
        System.setProperty("java.awt.headless", "false");
        try {
            SwingUtilities.invokeAndWait(otomata_teorisi::runGui);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "ATM arayüzü açılamadı:\n" + ex.getMessage(),
                "Başlatma Hatası",
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public static void baslatKonsol() {
        configureKonsolKodlamasi();
        runConsole();
    }

    private static final String UTF_8 = "UTF-8";
    private static String konsolCharset = UTF_8;

    private static void configureKonsolKodlamasi() {
        konsolCharset = algilaKonsolCharset();
        try {
            System.setOut(new PrintStream(System.out, true, konsolCharset));
            System.setErr(new PrintStream(System.err, true, konsolCharset));
        } catch (Exception ignored) {
        }
        if (UTF_8.equals(konsolCharset)) {
            System.out.println("[Bilgi] UTF-8 modu. Turkce bozuksa terminalde: chcp 65001");
        } else {
            System.out.println("[Bilgi] Konsol kodlamasi: " + konsolCharset
                + " (UTF-8 icin: chcp 65001 veya calistir-konsol.bat)");
        }
    }

    /** Konsolda Cp857/Cp1254 ile uyumlu metin (uzun tire vb.). */
    private static String konsolMetin(String metin) {
        if (UTF_8.equals(konsolCharset)) {
            return metin;
        }
        return metin.replace('\u2014', '-');
    }

    /** Windows konsol kod sayfasina (chcp) uygun charset secer. */
    private static String algilaKonsolCharset() {
        String zorla = System.getenv("ATM_CHARSET");
        if (zorla != null && !zorla.trim().isEmpty()) {
            return zorla.trim();
        }
        String os = System.getProperty("os.name", "").toLowerCase();
        if (!os.contains("win")) {
            return UTF_8;
        }
        // Cursor / VS Code / Windows Terminal genelde UTF-8 kullanir
        if (ideTerminaliUtf8Mi()) {
            return UTF_8;
        }
        int codePage = okuWindowsCodePage();
        if (codePage == 65001) {
            return UTF_8;
        }
        if (codePage == 857) {
            return "Cp857";
        }
        if (codePage == 1254) {
            return "Cp1254";
        }
        if (codePage == 28599) {
            return "ISO-8859-9";
        }
        return "Cp1254";
    }

    private static boolean ideTerminaliUtf8Mi() {
        return System.getenv("VSCODE_PID") != null
            || System.getenv("VSCODE_IPC_HOOK") != null
            || System.getenv("CURSOR_TRACE_ID") != null
            || System.getenv("WT_SESSION") != null
            || "1".equals(System.getenv("ATM_UTF8"));
    }

    private static int okuWindowsCodePage() {
        Process p = null;
        try {
            p = new ProcessBuilder("cmd", "/c", "chcp").redirectErrorStream(true).start();
            InputStream in = p.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[256];
            int n;
            while ((n = in.read(buf)) > 0) {
                sb.append(new String(buf, 0, n, "Cp857"));
            }
            p.waitFor();
            String cikti = sb.toString();
            for (int i = 0; i < cikti.length(); i++) {
                if (Character.isDigit(cikti.charAt(i))) {
                    int j = i;
                    while (j < cikti.length() && Character.isDigit(cikti.charAt(j))) {
                        j++;
                    }
                    return Integer.parseInt(cikti.substring(i, j));
                }
            }
        } catch (Exception ignored) {
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
        return 1254;
    }

    private static Font turkceFont(int style, int size) {
        String[] adaylar = {"Segoe UI", "Arial Unicode MS", Font.SANS_SERIF};
        for (String ad : adaylar) {
            Font f = new Font(ad, style, size);
            if (f.canDisplay('ş') && f.canDisplay('ğ') && f.canDisplay('İ')) {
                return f;
            }
        }
        return new Font(Font.SANS_SERIF, style, size);
    }

    private static void runConsole() {
        String currentState = Q0;
        try (Scanner scanner = new Scanner(System.in, konsolCharset)) {
            runConsoleLoop(scanner, currentState);
        }
    }

    private static void runConsoleLoop(Scanner scanner, String currentState) {

        System.out.println("========================================");
        System.out.println("        ATM SİMÜLATÖRÜ BAŞLADI");
        System.out.println("========================================");
        System.out.println("Başlangıç Durumu: " + currentState + " -> " + konsolMetin(durumAciklama(currentState)));
        System.out.println("----------------------------------------");

        while (true) {
            String epsilonOncesi = currentState;
            currentState = autoEpsilon(currentState);
            if (!currentState.equals(epsilonOncesi)) {
                System.out.println("  [epsilon] " + epsilonOncesi + " --epsilon--> " + currentState + " (otomatik geçiş)");
            }

            System.out.println("Geçerli komutlar: " + gecerliKomutlar(currentState));
            System.out.print("Giriş girin (Çıkış için 'exit'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;
            input = input.trim();

            String oncekiDurum = currentState;
            String araDurum = transition(currentState, input);
            durumBildirimi(araDurum);
            epsilonOncesi = araDurum;
            currentState = autoEpsilon(araDurum);
            if (!currentState.equals(epsilonOncesi)) {
                System.out.println("  [epsilon] " + epsilonOncesi + " --epsilon--> " + currentState + " (otomatik geçiş)");
            }

            // Adım adım geçiş gösterimi
            if (!currentState.equals(oncekiDurum)) {
                System.out.println("  [OK]  " + oncekiDurum + " --" + input + "--> " + currentState);
                System.out.println("     Yeni Durum: " + currentState + " -> " + konsolMetin(durumAciklama(currentState)));
            } else {
                System.out.println("  [!!]  Geçersiz giriş: '" + input + "'");
                System.out.println("     Durum değişmedi: " + currentState + " -> " + konsolMetin(durumAciklama(currentState)));
            }

            System.out.println("----------------------------------------");
        }

        // SONUÇ KATEGORİSİ
        System.out.println();
        System.out.println("========================================");
        if (currentState.equals(Q27) || currentState.equals(Q0)) {
            System.out.println("|  SONUÇ: KABUL                        |");
            System.out.println("|  Oturum başarıyla tamamlandı.        |");
        } else if (currentState.equals(Q5)) {
            System.out.println("|  SONUÇ: HATA                         |");
            System.out.println("|  Kart kilitlendi (3 hatalı PIN).     |");
        } else if (currentState.equals(Q28)) {
            System.out.println("|  SONUÇ: İPTAL                        |");
            System.out.println("|  Zaman aşımı - oturum sonlandı.      |");
        } else if (currentState.equals(Q15) || currentState.equals(Q24)) {
            System.out.println("|  SONUÇ: RED                          |");
            System.out.println("|  Yetersiz bakiye nedeniyle reddedildi|");
        } else if (currentState.equals(Q14)) {
            System.out.println("|  SONUÇ: RED                          |");
            System.out.println("|  Çekim limiti aşıldı.                |");
        } else {
            System.out.println("|  SONUÇ: TAMAMLANMADI                 |");
            System.out.println("|  Son durum: " + currentState + "                    |");
        }
        System.out.println("========================================");
    }

    private static void uygulaTurkceFont(Container root, Font font) {
        for (Component c : root.getComponents()) {
            c.setFont(font);
            if (c instanceof Container) {
                uygulaTurkceFont((Container) c, font);
            }
        }
    }

    private static void runGui() {
        nimbusTemaYukle();

        // Okunaklı açık tema — geçiş/senaryo: siyah yazı, beyaz zemin
        Color arkaPlan      = new Color(236, 240, 245);
        Color panelBeyaz    = Color.WHITE;
        Color logZemin      = new Color(255, 255, 255);
        Color logMetin      = new Color(0, 0, 0);
        Color kenar         = new Color(148, 163, 184);
        Color metinKoyu     = new Color(0, 0, 0);
        Color metinOrta     = new Color(30, 41, 59);
        Color baslikBarRenk = new Color(30, 58, 95);
        Color vurguMavi     = new Color(37, 99, 235);
        Color vurguKoyu     = new Color(29, 78, 216);
        Color baslikYazi    = new Color(15, 23, 42);
        Color secimAcikMavi = new Color(219, 234, 254);

        Font ekranFont  = turkceFont(Font.BOLD, 20);
        Font logFont    = turkceFont(Font.PLAIN, 15);
        Font etiketFont = turkceFont(Font.PLAIN, 15);
        Font baslikFont = turkceFont(Font.BOLD, 15);
        Font dugmeFont  = turkceFont(Font.BOLD, 14);

        arayuzRenkleriAyarla(logMetin, logZemin, secimAcikMavi, etiketFont);

        JFrame frame = new JFrame("ATM Otomata Simülatörü — Test Arayüzü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000, 680));
        frame.setLocationRelativeTo(null);

        JTextArea atmEkran = new JTextArea(6, 28);
        atmEkran.setEditable(false);
        atmEkran.setFont(ekranFont);
        atmEkran.setBackground(panelBeyaz);
        atmEkran.setForeground(metinKoyu);
        atmEkran.setMargin(new Insets(20, 20, 20, 20));
        atmEkran.setLineWrap(true);
        atmEkran.setWrapStyleWord(true);

        JLabel durumKodu = new JLabel("q0", SwingConstants.CENTER);
        durumKodu.setFont(turkceFont(Font.BOLD, 26));
        durumKodu.setForeground(Color.WHITE);
        durumKodu.setOpaque(true);
        durumKodu.setBackground(baslikBarRenk);
        durumKodu.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(vurguKoyu, 2),
            new EmptyBorder(10, 20, 10, 20)));

        JLabel durumAcik = new JLabel();
        durumAcik.setFont(etiketFont);
        durumAcik.setForeground(metinOrta);

        JLabel sonucEtiket = new JLabel();
        sonucEtiket.setFont(turkceFont(Font.BOLD, 15));
        sonucEtiket.setOpaque(true);
        sonucEtiket.setBorder(new EmptyBorder(10, 14, 10, 14));

        JTextArea gecisLog = new JTextArea();
        gecisLog.setEditable(false);
        stilGecisLog(gecisLog, logFont, logMetin, logZemin);
        gecisLog.setMargin(new Insets(14, 14, 14, 14));
        gecisLog.setTabSize(4);
        gecisLog.setLineWrap(false);
        JScrollPane logScroll = new JScrollPane(gecisLog);
        logScroll.getViewport().setOpaque(true);
        logScroll.getViewport().setBackground(logZemin);
        logScroll.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(kenar, 2),
            "Geçiş Günlüğü (otomata adımları)",
            TitledBorder.LEFT, TitledBorder.TOP, baslikFont, baslikYazi));

        JPanel komutPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        komutPanel.setBackground(panelBeyaz);
        komutPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JComboBox<Senaryo> senaryoSec = stilSenaryoCombo(
            SENARYOLAR, etiketFont, logMetin, logZemin, secimAcikMavi);

        JButton senaryoCalistir = stilDugme("Senaryoyu Otomatik Çalıştır", dugmeFont, vurguMavi, vurguKoyu);
        JButton senaryoAdim = stilDugme("Senaryoda Tek Adım", dugmeFont, vurguMavi, vurguKoyu);
        JButton sifirla = stilDugme("Oturumu Sıfırla (q0)", dugmeFont, vurguMavi, vurguKoyu);
        JButton temizle = stilDugme("Günlüğü Temizle", dugmeFont, vurguMavi, vurguKoyu);

        final String[] currentState = {Q0};
        final int[] senaryoIndex = {0};
        final Timer[] senaryoTimer = {null};
        final Runnable[] refresh = new Runnable[1];
        final Runnable[] guncelleEkran = new Runnable[1];

        Consumer<String> komutUygula = command -> {
            currentState[0] = autoEpsilon(currentState[0]);
            String oncekiDurum = currentState[0];
            String araDurum = transition(currentState[0], command);
            String epsilonOncesi = araDurum;
            String yeniDurum = autoEpsilon(araDurum);
            int adimNo = gecisLog.getLineCount() + 1;

            if (!yeniDurum.equals(oncekiDurum)) {
                gecisLog.append(String.format("%3d) %s --[%s]--> %s%n",
                    adimNo, oncekiDurum, command, araDurum));
                if (!yeniDurum.equals(epsilonOncesi)) {
                    gecisLog.append(String.format("     ε-geçiş: %s → %s%n", epsilonOncesi, yeniDurum));
                }
                gecisLog.append(String.format("     → %s | %s%n%n", yeniDurum, durumAciklama(yeniDurum)));
                durumBildirimi(gecisLog, araDurum);
            } else {
                gecisLog.append(String.format("%3d) [GEÇERSİZ] '%s' @ %s%n%n", adimNo, command, oncekiDurum));
            }
            currentState[0] = yeniDurum;
            refresh[0].run();
            gecisLog.setCaretPosition(gecisLog.getDocument().getLength());
        };

        guncelleEkran[0] = () -> {
            atmEkran.setText(ekranMesaji(currentState[0]));
            durumKodu.setText(currentState[0]);
            durumAcik.setText(durumAciklama(currentState[0]));
            String sonuc = sonucKategorisi(currentState[0]);
            sonucEtiket.setText("Sonuç: " + sonuc);
            sonucEtiket.setBackground(sonucArkaPlan(sonuc));
            sonucEtiket.setForeground(sonucYaziRengi(sonuc));
        };

        refresh[0] = () -> {
            currentState[0] = autoEpsilon(currentState[0]);
            guncelleEkran[0].run();
            komutPanel.removeAll();
            String[] commands = availableCommands(currentState[0]);
            if (commands.length == 0) {
                JLabel bos = new JLabel("Bu durumda komut yok", SwingConstants.CENTER);
                bos.setForeground(metinOrta);
                bos.setFont(etiketFont);
                komutPanel.add(bos);
            } else {
                for (String command : commands) {
                    JButton cmdButton = stilDugme(komutEtiket(command), dugmeFont, vurguMavi, vurguKoyu);
                    cmdButton.setToolTipText(command);
                    cmdButton.addActionListener(e -> komutUygula.accept(command));
                    komutPanel.add(cmdButton);
                }
            }
            komutPanel.revalidate();
            komutPanel.repaint();
        };

        Runnable senaryoDurdur = () -> {
            if (senaryoTimer[0] != null) {
                senaryoTimer[0].stop();
                senaryoTimer[0] = null;
            }
            senaryoCalistir.setEnabled(true);
            senaryoAdim.setEnabled(true);
        };

        senaryoCalistir.addActionListener(e -> {
            Senaryo secilen = (Senaryo) senaryoSec.getSelectedItem();
            if (secilen == null) return;
            senaryoDurdur.run();
            currentState[0] = Q0;
            senaryoIndex[0] = 0;
            gecisLog.append("\n════ Senaryo: " + secilen.ad + " ════\n");
            refresh[0].run();
            senaryoCalistir.setEnabled(false);
            senaryoAdim.setEnabled(false);
            senaryoTimer[0] = new Timer(750, ev -> {
                if (senaryoIndex[0] >= secilen.adimlar.length) {
                    senaryoDurdur.run();
                    gecisLog.append("════ Senaryo bitti — " + sonucKategorisi(currentState[0]) + " ════\n\n");
                    return;
                }
                komutUygula.accept(secilen.adimlar[senaryoIndex[0]++]);
            });
            senaryoTimer[0].start();
        });

        senaryoAdim.addActionListener(e -> {
            Senaryo secilen = (Senaryo) senaryoSec.getSelectedItem();
            if (secilen == null) return;
            if (senaryoIndex[0] == 0 && currentState[0].equals(Q0)) {
                gecisLog.append("\n──── Senaryo (adım): " + secilen.ad + " ────\n");
            }
            if (senaryoIndex[0] < secilen.adimlar.length) {
                komutUygula.accept(secilen.adimlar[senaryoIndex[0]++]);
            } else {
                gecisLog.append("Senaryo adımları tükendi. Sıfırlayıp yeniden başlatın.\n");
            }
        });

        sifirla.addActionListener(e -> {
            senaryoDurdur.run();
            currentState[0] = Q0;
            senaryoIndex[0] = 0;
            gecisLog.append("\n[SIFIRLA] Oturum q0'a döndü.\n");
            refresh[0].run();
        });

        temizle.addActionListener(e -> {
            gecisLog.setText("");
            senaryoIndex[0] = 0;
        });

        JScrollPane ekranScroll = new JScrollPane(atmEkran);
        ekranScroll.getViewport().setBackground(panelBeyaz);
        ekranScroll.setBorder(BorderFactory.createEmptyBorder());

        JPanel ekranCerceve = new JPanel(new BorderLayout(0, 10));
        ekranCerceve.setBackground(panelBeyaz);
        ekranCerceve.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(kenar, 2),
            "ATM Müşteri Ekranı",
            TitledBorder.CENTER, TitledBorder.TOP, baslikFont, baslikYazi));
        ekranCerceve.add(ekranScroll, BorderLayout.CENTER);
        ekranCerceve.add(durumKodu, BorderLayout.SOUTH);

        JPanel durumPanel = new JPanel(new GridLayout(2, 1, 8, 8));
        durumPanel.setBackground(panelBeyaz);
        durumPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(kenar),
            new EmptyBorder(10, 12, 10, 12)));
        durumPanel.add(durumAcik);
        durumPanel.add(sonucEtiket);

        JPanel solUst = new JPanel(new BorderLayout(12, 12));
        solUst.setOpaque(false);
        solUst.add(ekranCerceve, BorderLayout.CENTER);
        solUst.add(durumPanel, BorderLayout.SOUTH);

        JPanel senaryoPanel = new JPanel(new GridBagLayout());
        senaryoPanel.setOpaque(true);
        senaryoPanel.setBackground(logZemin);
        senaryoPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(kenar, 2),
            "Test Senaryoları",
            TitledBorder.LEFT, TitledBorder.TOP, baslikFont, baslikYazi));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 6, 4, 6);
        gbc.weightx = 1;
        senaryoPanel.add(senaryoSec, gbc);
        senaryoPanel.add(senaryoCalistir, gbc);
        senaryoPanel.add(senaryoAdim, gbc);
        senaryoPanel.add(sifirla, gbc);
        senaryoPanel.add(temizle, gbc);

        JLabel komutBaslik = new JLabel("Geçerli Girişler (Σ)", SwingConstants.CENTER);
        komutBaslik.setFont(baslikFont);
        komutBaslik.setForeground(baslikYazi);

        JScrollPane komutScroll = new JScrollPane(komutPanel);
        komutScroll.getViewport().setBackground(panelBeyaz);
        komutScroll.setBorder(BorderFactory.createLineBorder(kenar));

        JPanel sagPanel = new JPanel(new BorderLayout(10, 10));
        sagPanel.setBackground(arkaPlan);
        sagPanel.setPreferredSize(new Dimension(300, 0));
        sagPanel.setBorder(new EmptyBorder(0, 0, 0, 4));
        sagPanel.add(komutBaslik, BorderLayout.NORTH);
        sagPanel.add(komutScroll, BorderLayout.CENTER);
        sagPanel.add(senaryoPanel, BorderLayout.SOUTH);

        JPanel merkez = new JPanel(new BorderLayout(12, 12));
        merkez.setOpaque(false);
        merkez.setBorder(new EmptyBorder(12, 12, 12, 12));
        merkez.add(solUst, BorderLayout.NORTH);
        merkez.add(logScroll, BorderLayout.CENTER);

        JPanel kok = new JPanel(new BorderLayout(0, 0));
        kok.setBackground(arkaPlan);
        kok.add(merkez, BorderLayout.CENTER);
        kok.add(sagPanel, BorderLayout.EAST);

        JPanel baslikPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 12));
        baslikPanel.setBackground(baslikBarRenk);
        JLabel logo = new JLabel("ATM Otomata Test Paneli");
        logo.setFont(turkceFont(Font.BOLD, 18));
        logo.setForeground(Color.WHITE);
        baslikPanel.add(logo);
        JLabel alt = new JLabel("Manuel tuşlar veya hazır senaryolarla q0–q28 durumlarını test edin");
        alt.setFont(turkceFont(Font.PLAIN, 14));
        alt.setForeground(new Color(226, 232, 240));
        baslikPanel.add(alt);

        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(arkaPlan);
        frame.add(baslikPanel, BorderLayout.NORTH);
        frame.add(kok, BorderLayout.CENTER);
        frame.pack();

        gecisLog.setText("Simülatör hazır. Sağdaki tuşlarla manuel test veya senaryo seçin.\n\n");
        refresh[0].run();
        frame.setVisible(true);

        // Windows/Nimbus sonrası renkleri tekrar kilitle
        SwingUtilities.invokeLater(() -> {
            stilGecisLog(gecisLog, logFont, logMetin, logZemin);
            JTextField editor = (JTextField) senaryoSec.getEditor().getEditorComponent();
            editor.setForeground(logMetin);
            editor.setBackground(logZemin);
        });
    }

    private static JButton stilDugme(String metin, Font font, Color arka, Color kenarRenk) {
        JButton b = new JButton(metin);
        b.setFont(font);
        b.setBackground(arka);
        b.setForeground(Color.WHITE);
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setFocusPainted(false);
        b.setBorderPainted(true);
        b.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(kenarRenk, 1),
            BorderFactory.createEmptyBorder(12, 10, 12, 10)));
        b.setMinimumSize(new Dimension(130, 48));
        return b;
    }

    private static String[] availableCommands(String state) {
        if (state.equals(Q6)) state = Q7;
        if (state.equals(Q21)) state = Q22;
        String raw = gecerliKomutlar(state);
        if (raw == null || raw.startsWith("(") || raw.equals("—")) {
            return new String[0];
        }
        String[] parts = raw.split(" \\| ");
        List<String> commands = new ArrayList<>();
        for (String part : parts) {
            part = part.trim();
            if (!part.isEmpty()) commands.add(part);
        }
        return commands.toArray(new String[0]);
    }

    private static String autoEpsilon(String state) {
        if (state.equals(Q6) || state.equals(Q21) || state.equals(Q28)) {
            return transition(state, "");
        }
        return state;
    }

    private static void durumBildirimi(String state) {
        if (state.equals(Q5)) {
            System.out.println("  [!]  Kart kilitlendi! Lütfen bankanızla iletişime geçin.");
        } else if (state.equals(Q14)) {
            System.out.println("  [!]  Günlük çekim limitiniz aşıldı. Farklı bir tutar girebilirsiniz.");
        } else if (state.equals(Q15)) {
            System.out.println("  [!]  Hesabınızda yeterli bakiye bulunmuyor.");
        } else if (state.equals(Q24)) {
            System.out.println("  [!]  Transfer için yeterli bakiye bulunmuyor.");
        } else if (state.equals(Q28)) {
            System.out.println("  [!]  Zaman aşımı! Oturum güvenlik nedeniyle sonlandırıldı.");
        } else if (state.equals(Q8)) {
            System.out.println("  [i]  Bakiye bilgisi ekranda gösterildi.");
        } else if (state.equals(Q17)) {
            System.out.println("  [i]  Para çekme işlemi tamamlandı. Lütfen paranızı alın.");
        } else if (state.equals(Q20)) {
            System.out.println("  [i]  Para yatırma işlemi tamamlandı. Bakiyenize yansıtıldı.");
        } else if (state.equals(Q25)) {
            System.out.println("  [i]  Transfer işlemi tamamlandı.");
        }
    }

    private static void durumBildirimi(JTextArea logArea, String state) {
        if (state.equals(Q5)) {
            logArea.append("[!] Kart kilitlendi! Lütfen bankanızla iletişime geçin.\n");
        } else if (state.equals(Q14)) {
            logArea.append("[!] Günlük çekim limitiniz aşıldı. Farklı bir tutar girebilirsiniz.\n");
        } else if (state.equals(Q15)) {
            logArea.append("[!] Hesabınızda yeterli bakiye bulunmuyor.\n");
        } else if (state.equals(Q24)) {
            logArea.append("[!] Transfer için yeterli bakiye bulunmuyor.\n");
        } else if (state.equals(Q28)) {
            logArea.append("[!] Zaman aşımı! Oturum güvenlik nedeniyle sonlandırıldı.\n");
        } else if (state.equals(Q8)) {
            logArea.append("[i] Bakiye bilgisi ekranda gösterildi.\n");
        } else if (state.equals(Q17)) {
            logArea.append("[i] Para çekme işlemi tamamlandı. Lütfen paranızı alın.\n");
        } else if (state.equals(Q20)) {
            logArea.append("[i] Para yatırma işlemi tamamlandı. Bakiyenize yansıtıldı.\n");
        } else if (state.equals(Q25)) {
            logArea.append("[i] Transfer işlemi tamamlandı.\n");
        }
    }

    // ---------------------------------------------------------------
    // TRANSITION
    // ---------------------------------------------------------------
    public static String transition(String currentState, String input) {
        if (isKimlik(currentState))        return KimlikDogrulama(currentState, input);
        if (isIslemSecimi(currentState))   return IslemSecimi(currentState, input);
        if (isParaCekme(currentState))     return ParaCekme(currentState, input);
        if (isParaYatirma(currentState))   return ParaYatirma(currentState, input);
        if (isTransfer(currentState))      return Transfer(currentState, input);
        if (isOturumYonetimi(currentState)) return OturumYonetimi(currentState, input);
        return currentState;
    }

    // ---------------------------------------------------------------
    // KİMLİK DOĞRULAMA  (q0–q5)
    // ---------------------------------------------------------------
    private static boolean isKimlik(String s) {
        return s.equals(Q0) || s.equals(Q1) || s.equals(Q2)
            || s.equals(Q3) || s.equals(Q4) || s.equals(Q5);
    }

    private static String KimlikDogrulama(String currentState, String input) {
        switch (currentState) {
            case Q0: if (input.equals(KART_TAK))   return Q1; break;
            case Q1: if (input.equals(PIN_GIR))    return Q2; break;
            case Q2:
                if (input.equals(PIN_DOGRU))       return Q6;
                else if (input.equals(PIN_YANLIS)) return Q3;
                else if (input.equals(ZAMAN_ASIMI)) return Q28;
                break;
            case Q3:
                if (input.equals(PIN_DOGRU))       return Q6;
                else if (input.equals(PIN_YANLIS)) return Q4;
                else if (input.equals(ZAMAN_ASIMI)) return Q28;
                break;
            case Q4:
                if (input.equals(PIN_DOGRU))       return Q6;
                else if (input.equals(PIN_YANLIS)) return Q5;
                else if (input.equals(ZAMAN_ASIMI)) return Q28;
                break;
            case Q5: break; // kilitli — geçiş yok
        }
        return currentState;
    }

    // ---------------------------------------------------------------
    // İŞLEM SEÇİMİ  (q6–q8)
    // ---------------------------------------------------------------
    private static boolean isIslemSecimi(String s) {
        return s.equals(Q6) || s.equals(Q7) || s.equals(Q8);
    }

    private static String IslemSecimi(String currentState, String input) {
        // Q6 -> Q7 epsilon-geçişi: otomatik
        if (currentState.equals(Q6)) currentState = Q7;
        switch (currentState) {
            case Q7:
                if (input.equals(BAKIYE_SORGULA))  return Q8;
                else if (input.equals(PARA_CEK))   return Q9;
                else if (input.equals(PARA_YATIR)) return Q10;
                else if (input.equals(TRANSFER_SEC)) return Q11;
                else if (input.equals(IPTAL))      return Q26;
                else if (input.equals(ZAMAN_ASIMI)) return Q28;
                break;
            case Q8:
                if (input.equals(DEVAM))           return Q26;
                break;
        }
        return currentState;
    }

    // ---------------------------------------------------------------
    // PARA ÇEKME  (q9, q12–q17)
    // ---------------------------------------------------------------
    private static boolean isParaCekme(String s) {
        return s.equals(Q9)  || s.equals(Q12) || s.equals(Q13)
            || s.equals(Q14) || s.equals(Q15) || s.equals(Q16) || s.equals(Q17);
    }

    private static String ParaCekme(String currentState, String input) {
        switch (currentState) {
            case Q9:  if (input.equals(TUTAR_GIR))       return Q12; break;
            case Q12:
                if (input.equals(GECERSIZ_TUTAR))        return Q12;
                else if (input.equals(BAKIYE_YETERLI))   return Q13;
                else if (input.equals(BAKIYE_YETERSIZ))  return Q15;
                break;
            case Q13:
                if (input.equals(LIMIT_OK))              return Q16;
                else if (input.equals(LIMIT_ASILDI))     return Q14;
                break;
            case Q14: if (input.equals(DEVAM))           return Q7;  break;
            case Q15: if (input.equals(DEVAM))           return Q7;  break;
            case Q16: if (input.equals(NAKIT_ALINDI))    return Q17; break;
            case Q17: if (input.equals(DEVAM))           return Q26; break;
        }
        return currentState;
    }

    // ---------------------------------------------------------------
    // PARA YATIRMA  (q10, q18–q20)
    // ---------------------------------------------------------------
    private static boolean isParaYatirma(String s) {
        return s.equals(Q10) || s.equals(Q18) || s.equals(Q19) || s.equals(Q20);
    }

    private static String ParaYatirma(String currentState, String input) {
        switch (currentState) {
            case Q10: if (input.equals(NAKIT_YATIR))    return Q18; break;
            case Q18: if (input.equals(NAKIT_SAYILDI))  return Q19; break;
            case Q19: if (input.equals(DEVAM))          return Q20; break;
            case Q20: if (input.equals(DEVAM))          return Q26; break;
        }
        return currentState;
    }

    // ---------------------------------------------------------------
    // TRANSFER  (q11, q21–q25)
    // ---------------------------------------------------------------
    private static boolean isTransfer(String s) {
        return s.equals(Q11) || s.equals(Q21) || s.equals(Q22)
            || s.equals(Q23) || s.equals(Q24) || s.equals(Q25);
    }

    private static String Transfer(String currentState, String input) {
        // Q21 -> Q22 epsilon-geçişi: otomatik
        if (currentState.equals(Q21)) currentState = Q22;
        switch (currentState) {
            case Q11:
                if (input.equals(HESAP_GIR))            return Q21;
                else if (input.equals(GECERSIZ_HESAP))  return Q11;
                break;
            case Q22:
                if (input.equals(TUTAR_GIR))            return Q23;
                else if (input.equals(GECERSIZ_TUTAR))  return Q22;
                break;
            case Q23:
                if (input.equals(BAKIYE_YETERLI))       return Q25;
                else if (input.equals(BAKIYE_YETERSIZ)) return Q24;
                break;
            case Q24: if (input.equals(DEVAM))          return Q7;  break;
            case Q25: if (input.equals(DEVAM))          return Q26; break;
        }
        return currentState;
    }

    // ---------------------------------------------------------------
    // OTURUM YÖNETİMİ  (q26–q28)
    // ---------------------------------------------------------------
    private static boolean isOturumYonetimi(String s) {
        return s.equals(Q26) || s.equals(Q27) || s.equals(Q28);
    }

    private static String OturumYonetimi(String currentState, String input) {
        switch (currentState) {
            case Q26:
                if (input.equals(MAKBUZ_AL))           return Q27;
                else if (input.equals(MAKBUZ_ISTEMIYORUM)) return Q27;
                break;
            case Q27: if (input.equals(KART_CIKAR))    return Q0; break;
            case Q28: return Q0;
        }
        return currentState;
    }
}