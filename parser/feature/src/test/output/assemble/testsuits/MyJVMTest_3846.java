public class MyJVMTest_3846 {

    static int outputLineIncrement = 1;

    int setOutputLineIncrement(int outputLineIncrement) {
        if (outputLineIncrement < 0)
            throw new IllegalArgumentException("" + outputLineIncrement);
        this.outputLineIncrement = outputLineIncrement;
        return outputLineIncrement;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3846().setOutputLineIncrement(outputLineIncrement);
    }
}
