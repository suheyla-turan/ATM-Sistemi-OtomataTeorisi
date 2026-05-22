import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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

    public static final String KART_TAK = "kart_tak";
    public static final String KART_CIKAR = "kart_cikar";
    public static final String PIN_GIR = "pin_gir";
    public static final String PIN_DOGRU = "pin_dogru";
    public static final String PIN_YANLIS = "pin_yanlis";
    public static final String BAKIYE_SORGULA = "bakiye_sorgula";
    public static final String PARA_CEK = "para_cek";
    public static final String PARA_YATIR = "para_yatir";
    public static final String TRANSFER_SEC = "transfer_sec";
    public static final String TUTAR_GIR = "tutar_gir";
    public static final String GECERSİZ_TUTAR = "gecersiz_tutar";
    public static final String BAKIYE_YETERLI = "bakiye_yeterli";
    public static final String BAKIYE_YETERSIZ = "bakiye_yetersiz";
    public static final String LIMIT_OK = "limit_ok";
    public static final String LIMIT_ASILDI = "limit_asildi";
    public static final String NAKIT_ALINDI = "nakit_alindi";
    public static final String NAKIT_YATIR = "nakit_yatir";
    public static final String NAKIT_SAYILDI = "nakit_sayildi";
    public static final String HESAP_GIR = "hesap_gir";
    public static final String GECERSIZ_HESAP = "gecersiz_hesap";
    public static final String MAKBUZ_AL = "makbuz_al";
    public static final String MAKBUZ_ISTEMIYORUM = "makbuz_istemiyorum";
    public static final String IPTAL = "iptal";
    public static final String ZAMAN_ASIMI = "zaman_asimi";
    public static final String DEVAM = "devam";

    public static final String KABUL_OTURUM_SONLANDI = "q27";
    public static final String TAMAMLANMA_PARA_CEKME = "q17";
    public static final String TAMAMLANMA_PARA_YATIRMA = "q20";
    public static final String TAMAMLANMA_TRANSFER_TAMAMLANDI = "q25";
    public static final String TAMAMLANMA_BAKIYE_SORGULANDI = "q8";
    public static final String RED_YETERS_BAKIYE = "q15";
    public static final String RED_YETERS_BAKIYE_TRANS = "q24"; 
    public static final String HATA_KART_KILITLI = "q5";
    public static final String HATA_PIN_YANLIS_1 = "q3";
    public static final String HATA_PIN_YANLIS_2 = "q4";
    public static final String IPTAL_ZAMAN_ASIMI = "q28";

    public static void main(String args[]) { 
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        String currentState = Q0;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println("ATM Başlatıldı. Mevcut Durum: " + currentState);

        
        while (true) { 
            System.out.print("Giriş girin (Çıkış için 'exit'): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;
            input = input.trim();
            currentState = transition(currentState, input);
            System.out.println("Yeni Durum: " + currentState); 
        }
         
        scanner.close();
    }

        public static String transition(String currentState, String input) { 
            if (isKimlik(currentState)) return KimlikDogrulama(currentState, input);
            if (isIslemSecimi(currentState)) return IslemSecimi(currentState, input);
            if (isParaCekme(currentState)) return ParaCekme(currentState, input);
            if (isParaYatirma(currentState)) return ParaYatirma(currentState, input);
            if (isTransfer(currentState)) return Transfer(currentState, input);
            if (isOturumYonetimi(currentState)) return OturumYonetimi(currentState, input); 
            return currentState;
        }  


            private static boolean isKimlik(String s) { 
                return s.equals(Q0) || s.equals(Q1) || s.equals(Q2) || s.equals(Q3) || s.equals(Q4) || s.equals(Q5);
            }

            private static String KimlikDogrulama(String currentState, String input) {
                switch (currentState) { 
                    case Q0: if (input.equals("kart_tak")) return Q1; break;
                    case Q1: if (input.equals("pin_gir")) return Q2; break;
                    case Q2:
                        if (input.equals("pin_dogru")) return Q6;
                        else if (input.equals("pin_yanlis")) return Q3;
                        else if (input.equals("zaman_asimi")) return Q28; 
                        break; 
                    case Q3:
                        if (input.equals("pin_dogru")) return Q6; 
                        else if (input.equals("pin_yanlis")) return Q4;
                        break;
                    case Q4:
                        if (input.equals("pin_dogru")) return Q6; 
                        else if (input.equals("pin_yanlis")) return Q5; 
                        break;
                    case Q5: System.out.println("Kart kilitlendi!"); break;
                }
                return currentState;
            }

            private static boolean isIslemSecimi(String s) { 
                return s.equals(Q6) || s.equals(Q7) || s.equals(Q8);
            }

            private static String IslemSecimi(String currentState, String input) { 
                // Q6 -> Q7 epsilon geçişi: Q6'ya ulaşınca otomatik Q7'ye geç,
                // sonra gelen input Q7'de işlenir
                if (currentState.equals(Q6)) currentState = Q7;
                switch (currentState) { 
                    case Q7:
                        if (input.equals("bakiye_sorgula")) return Q8;
                        else if (input.equals("para_cek")) return Q9;
                        else if (input.equals("para_yatir")) return Q10;
                        else if (input.equals("transfer_sec")) return Q11;
                        else if (input.equals("iptal")) return Q26;
                        else if (input.equals("zaman_asimi")) return Q28;
                        break;
                    case Q8:
                        if (input.equals("devam")) return Q26;
                        break;
                } 
                return currentState;
            }

            private static boolean isParaCekme(String s) { 
                return s.equals(Q9) || s.equals(Q12) || s.equals(Q13) || s.equals(Q14) || s.equals(Q15) || s.equals(Q16) || s.equals(Q17);
            }

            private static String ParaCekme(String currentState, String input) { 
                switch (currentState) { 
                    case Q9: if (input.equals("tutar_gir")) return Q12; break;
                    case Q12:
                        if (input.equals("gecersiz_tutar")) return Q12;
                        else if (input.equals("bakiye_yeterli")) return Q13;
                        else if (input.equals("bakiye_yetersiz")) return Q15;
                        break;
                    case Q13:
                        if (input.equals("limit_ok")) return Q16;
                        else if (input.equals("limit_asildi")) return Q14;
                        break;
                    case Q14: if (input.equals("devam")) return Q7; break;
                    case Q15: if (input.equals("devam")) return Q7; break;
                    case Q16: if (input.equals("nakit_alindi")) return Q17; break;
                    case Q17: if (input.equals("devam")) return Q26; break;
                }
                return currentState;
            }

            private static boolean isParaYatirma(String s) { 
                return s.equals(Q10) || s.equals(Q18) || s.equals(Q19) || s.equals(Q20);
            }

            private static String ParaYatirma(String currentState, String input) {
                switch (currentState) { 
                    case Q10: if (input.equals("nakit_yatir")) return Q18; break;
                    case Q18: if (input.equals("nakit_sayildi")) return Q19; break;
                    case Q19: if (input.equals("devam")) return Q20; break;
                    case Q20: if (input.equals("devam")) return Q26; break;
                }
                return currentState;
            }

            private static boolean isTransfer(String s) { 
                return s.equals(Q11) || s.equals(Q21) || s.equals(Q22) || s.equals(Q23) || s.equals(Q24) || s.equals(Q25);
            }

            private static String Transfer(String currentState, String input) { 
                // Q21 -> Q22 epsilon geçişi
                if (currentState.equals(Q21)) currentState = Q22;
                switch (currentState) { 
                case Q11:
                     if (input.equals("hesap_gir")) return Q21;
                     else if (input.equals("gecersiz_hesap")) return Q11;
                    break;
                case Q22:
                     if (input.equals("tutar_gir")) return Q23;
                     else if (input.equals("gecersiz_tutar")) return Q22;
                    break;
                case Q23:
                    if (input.equals("bakiye_yeterli")) return Q25;
                    else if (input.equals("bakiye_yetersiz")) return Q24;
                    break;
                case Q24: if (input.equals("devam")) return Q7; break;
                case Q25: if (input.equals("devam")) return Q26; break;
            }
            return currentState;
        }

        private static boolean isOturumYonetimi(String s) { 
                return s.equals(Q26) || s.equals(Q27) || s.equals(Q28);
            }

        private static String OturumYonetimi(String currentState, String input) { 
            switch (currentState) { 
                case Q26:
                     if (input.equals("makbuz_al")) return Q27;
                     else if (input.equals("makbuz_istemiyorum")) return Q27;
                     break;
                case Q27: if (input.equals("kart_cikar")) return Q0; break;
                case Q28: return Q0;
            }
            return currentState;
        }
    }
