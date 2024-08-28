public class MyJVMTest_11184 {

    static int inputLineCount = 1;

    int setInputLineCount(int inputLineCount) {
        if (inputLineCount < 0)
            throw new IllegalArgumentException("" + inputLineCount);
        this.inputLineCount = inputLineCount;
        return inputLineCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11184().setInputLineCount(inputLineCount);
    }
}
