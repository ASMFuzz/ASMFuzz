public class MyJVMTest_7587 {

    static byte[] data = { -58, 25, 98, 99, -40, -30, 68, 87, 28, -118 };

    static int itemsPerLine = 1;

    static String lineDelim = "\"sFaAIsY)E";

    static String itemDelim = "LV2-8&>KY|";

    static String testName = "ZCjnmS8LK(";

    static String algName = "]Z1H&WAzK8";

    static byte[] IKM = {69,-96,23,29,76,-61,-125,47,-109,50};

    static byte[] salt = {-2,-71,52,-50,39,-3,96,33,107,121};

    static byte[] info = {48,-59,-107,-42,-22,-42,124,-10,-121,27};

    static int outLen = 3;

    static byte[] expectedPRK = {83,-118,112,112,-124,-86,61,116,83,52};

    static byte[] expectedOKM = {-41,59,-95,102,-49,18,68,-90,-49,11};

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
        System.out.println(new MyJVMTest_7587().dumpHexBytes(data, itemsPerLine, lineDelim, itemDelim));
    }
}
