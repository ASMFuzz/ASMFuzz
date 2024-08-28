public class MyJVMTest_17132 {

    static byte[] data = { -17, 31, 66, -106, -68, -124, -102, -2, -92, 17 };

    static int itemsPerLine = 0;

    static String lineDelim = "/ic~Ao7qTK";

    static String itemDelim = "U1oY6+o*jl";

    static String testName = "N3$!N>.3H\\";

    static String algName = "A xND*9^9-";

    static byte[] IKM = {121,8,-4,21,-44,-77,55,-68,-70,17};

    static byte[] salt = {1,-114,64,56,64,24,-58,88,-30,121};

    static byte[] info = {106,-73,49,-36,-6,29,-54,-25,70,60};

    static int outLen = 0;

    static byte[] expectedPRK = {108,-35,-35,-14,-51,-24,26,63,85,-50};

    static byte[] expectedOKM = {-54,-53,-21,-124,77,-48,14,36,18,116};

    String dumpHexBytes(byte[] data, int itemsPerLine, String lineDelim, String itemDelim) {
        StringBuilder sb = new StringBuilder();
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                if (i % itemsPerLine == 0 && i != 0) {
                    sb.append(lineDelim);
                }
                sb.append(String.format("%02X", data[i])).append(itemDelim);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17132().dumpHexBytes(data, itemsPerLine, lineDelim, itemDelim));
    }
}
