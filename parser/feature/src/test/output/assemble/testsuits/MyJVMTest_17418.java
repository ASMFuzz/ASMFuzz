public class MyJVMTest_17418 {

    static int outputStartLine = -1;

    int setOutputStartLine(int outputStartLine) {
        if (outputStartLine < 0)
            throw new IllegalArgumentException("" + outputStartLine);
        this.outputStartLine = outputStartLine;
        return outputStartLine;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17418().setOutputStartLine(outputStartLine);
    }
}
