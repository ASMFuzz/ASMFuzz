public class MyJVMTest_16924 {

    static Object sync = 7;

    static Thread target = null;

    static long counter = 0;

    void add() {
        counter++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16924().add();
    }
}
