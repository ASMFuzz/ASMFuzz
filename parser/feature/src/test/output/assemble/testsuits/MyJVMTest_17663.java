public class MyJVMTest_17663 {

    static long i = 0;

    Long foob(long i) {
        return Long.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17663().foob(i));
    }
}
