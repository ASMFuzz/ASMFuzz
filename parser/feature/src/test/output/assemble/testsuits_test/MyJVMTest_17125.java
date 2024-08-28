public class MyJVMTest_17125 {

    static String str = "cHKI_H'rxS";

    static char R = '\u202F';

    static String ArabicABC = "\u0627\u0628\u0629";

    static String Arabic123 = "\u0661\u0662\u0663";

    static String PArabicABC = "\uFE97\uFE92\uFE8E";

    static String HebrewABC = "\u05D0\u05D1\u05D2";

    static String KharoshthiABC = new String(Character.toChars(0x10A10)) + new String(Character.toChars(0x10A11)) + new String(Character.toChars(0x10A12));

    static String Kharoshthi123 = new String(Character.toChars(0x10A40)) + new String(Character.toChars(0x10A41)) + new String(Character.toChars(0x10A42));

    static String NKoABC = "\u07CA\u07CB\u07CC";

    static String NKo123 = "\u07C1\u07C2\u07C3";

    static String OsmanyaABC = new String(Character.toChars(0x10480)) + new String(Character.toChars(0x10481)) + new String(Character.toChars(0x10482));

    static String Osmanya123 = new String(Character.toChars(0x104A0)) + new String(Character.toChars(0x104A1)) + new String(Character.toChars(0x104A2));

    String toReadableString(String str) {
        String s = str;
        s = s.replaceAll(ArabicABC, "ArabicABC");
        s = s.replaceAll(Arabic123, "Arabic123");
        s = s.replaceAll(PArabicABC, "ArabicABC(Presentation form)");
        s = s.replaceAll(HebrewABC, "HebrewABC");
        s = s.replaceAll(KharoshthiABC, "KharoshthiABC");
        s = s.replaceAll(Kharoshthi123, "Kharoshthi123");
        s = s.replaceAll(NKoABC, "NKoABC");
        s = s.replaceAll(NKo123, "NKo123");
        s = s.replaceAll(OsmanyaABC, "OsmanyaABC");
        s = s.replaceAll(Osmanya123, "Osmanya123");
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17125().toReadableString(str));
    }
}
