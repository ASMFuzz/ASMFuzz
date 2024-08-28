public class MyJVMTest_12048 {

    void testp() {
        Object a = new Object();
        Object b = new Object();
        ;
        int total = 0;
        for (int i = 0; i < 10000; i++) {
            total += ((i % 4 != 0) ? a : b).hashCode();
        }
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12048().testp();
    }
}
