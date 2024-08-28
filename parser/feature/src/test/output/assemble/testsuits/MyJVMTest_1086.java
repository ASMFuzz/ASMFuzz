public class MyJVMTest_1086 {

    static int inputStartLine = -1;

    int setInputStartLine(int inputStartLine) {
        if (inputStartLine < 0)
            throw new IllegalArgumentException("" + inputStartLine);
        this.inputStartLine = inputStartLine;
        return inputStartLine;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1086().setInputStartLine(inputStartLine);
    }
}
