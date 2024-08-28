public class MyJVMTest_7393 {

    static Object sync = 5;

    static Thread target = null;

    static long counter = 0;

    void add() {
        counter++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7393().add();
    }
}
