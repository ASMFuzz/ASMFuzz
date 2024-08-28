public class MyJVMTest_7858 {

    static int outputStartLine = -1;

    int setOutputStartLine(int outputStartLine) {
        if (outputStartLine < 0)
            throw new IllegalArgumentException("" + outputStartLine);
        this.outputStartLine = outputStartLine;
        return outputStartLine;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7858().setOutputStartLine(outputStartLine);
    }
}
