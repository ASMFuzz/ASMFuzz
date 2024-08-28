public class MyJVMTest_13336 {

    static double v = Double.MIN_VALUE;

    void randomize() {
        v = Math.random() * 100;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13336().randomize();
    }
}
