public class MyJVMTest_11454 {

    static String str = ">#qoj\"9,/A";

    static char L = '\u200E';

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

    String getStringName(String str) {
        if (ArabicABC.equals(str))
            return "ArabicABC";
        else if (Arabic123.equals(str))
            return "Arabic123";
        else if (PArabicABC.equals(str))
            return "ArabicABC(Presentation form)";
        else if (HebrewABC.equals(str))
            return "HebrewABC";
        else if (KharoshthiABC.equals(str))
            return "KharoshthiABC(RTL)";
        else if (Kharoshthi123.equals(str))
            return "Kharoshthi123(RTL)";
        else if (NKoABC.equals(str))
            return "NKoABC(RTL)";
        else if (NKo123.equals(str))
            return "NKo123(RTL)";
        else if (OsmanyaABC.equals(str))
            return "OsmanyaABC(LTR)";
        else if (Osmanya123.equals(str))
            return "Osmanya123(LTR)";
        else
            return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11454().getStringName(str));
    }
}
