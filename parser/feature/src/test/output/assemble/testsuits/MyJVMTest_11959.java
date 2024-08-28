public class MyJVMTest_11959 {

    static String baseTestName = "A`!U]&2S_a";

    static int dataSize = 3;

    static String currentTest = "BIdkdCsWT%";

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
        new MyJVMTest_11959().setTestName(baseTestName, dataSize);
    }
}
