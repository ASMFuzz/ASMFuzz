import java.util.Arrays;

public class MyJVMTest_6055 {

    static String in = "?$(2s+mo_~";

    static String[] asciiIn = { "xn--egbpdaj6bu4bxfgehfvwxn", "xn--ihqwcrb4cv8a8dqg056pqjye", "xn--Proprostnemluvesky-uyb24dma41a", "xn--4dbcagdahymbxekheh6e0a7fei0b", "xn--i1baa7eci9glrd9b2ae1bj0hfcgg6iyaf8o0a1dig0cd", "xn--n8jok5ay5dzabd5bym9f0cm5685rrjetr6pdxa", "xn--b1abfaaepdrnnbgefbaDotcwatmq2g4l", "xn--PorqunopuedensimplementehablarenEspaol-fmd56a", "xn--ihqwctvzc91f659drss3x8bo0yb", "xn--TisaohkhngthchnitingVit-kjcr8268qyxafd2f1b9g", "xn--3B-ww4c5e180e575a65lsy2b", "xn---with-SUPER-MONKEYS-pc58ag80a8qai00g7n9n", "xn--Hello-Another-Way--fc4qua05auwb3674vfr0b", "xn--2-u9tlzr9756bt3uc0v", "xn--MajiKoi5-783gue6qz075azm5e", "xn--de-jg4avhby1noc0d", "xn--d9juau41awczczp", "XN--097CCDEKGHQJK", "XN--db8CBHEJLGH4E0AL", "xn--hxargifdar", "xn--bonusaa-5bb1da", "xn--b1abfaaepdrnnbgefbadotcwatmq2g4l" };

    static char[] unicode = {Character.MAX_VALUE,'0',Character.MAX_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0','z',Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE};

    static String ascii = "e/Lh+naOhM";

    static Exception expected = null;

    static boolean useSTD3ASCIIRules = false;

    static boolean testToUnicode = true;

    static boolean testLabel = true;

    static String comment = "5Tx;W\"Nk)_";

    static String input = "hL%;=~D$y,";

    static String output = "2p{{^(xg!x";

    static String profile = "_?eR~$o4*X";

    static int flags = 6;

    byte[] getBytes(String in) {
        if (in == null) {
            return null;
        }
        byte[] bytes = new byte[in.length()];
        for (int i = 0; i < in.length(); i++) {
            bytes[i] = (byte) in.charAt(i);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6055().getBytes(in)));
    }
}
