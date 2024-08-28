public class MyJVMTest_2623 {

    static long counter = 0;

    void add() {
        counter++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2623().add();
    }
}
