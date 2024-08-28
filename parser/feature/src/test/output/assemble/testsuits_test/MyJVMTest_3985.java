public class MyJVMTest_3985 {

    static double v = 0.7300305916733689;

    void randomize() {
        v = Math.random() * 100;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3985().randomize();
    }
}
