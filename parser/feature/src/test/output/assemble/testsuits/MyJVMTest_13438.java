import java.util.Arrays;

public class MyJVMTest_13438 {

    static String hex = "JeQ2a_p>SW";

    static String testName = "WLwp@Vp-vY";

    static String algName = "=)X>>l&'-C";

    static byte[] IKM = {-90,89,-108,22,-8,-80,43,-58,96,89};

    static byte[] salt = {-71,58,-36,-5,42,-25,50,14,-26,121};

    static byte[] info = {-80,-38,-67,-96,87,1,-81,-60,-51,-104};

    static int outLen = 0;

    static byte[] expectedPRK = {-104,-123,115,-49,45,-93,-27,102,12,-23};

    static byte[] expectedOKM = {42,97,-45,-96,64,-97,-15,31,68,45};

    byte[] hex2bin(String hex) {
        int i;
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13438().hex2bin(hex)));
    }
}
