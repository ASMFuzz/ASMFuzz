public class MyJVMTest_1947 {

    static int inputLineCount = 1;

    int setInputLineCount(int inputLineCount) {
        if (inputLineCount < 0)
            throw new IllegalArgumentException("" + inputLineCount);
        this.inputLineCount = inputLineCount;
        return inputLineCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1947().setInputLineCount(inputLineCount);
    }
}
