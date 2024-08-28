public class MyJVMTest_2674 {

    static String baseTestName = "`l|I]|\\Z{s";

    static int dataSize = 95647435;

    static String currentTest = "F%8Yx:*iu2";

    static int id = -1;

    int setTestName(String baseTestName, int dataSize) {
        String suffix = "B";
        int value;
        value = dataSize;
        if (value % 1024 == 0) {
            value = value / 1024;
            suffix = "K";
        }
        if (value % 1024 == 0) {
            value = value / 1024;
            suffix = "M";
        }
        currentTest = baseTestName + "_" + value + suffix;
        return value;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2674().setTestName(baseTestName, dataSize);
    }
}
