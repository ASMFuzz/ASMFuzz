public class MyJVMTest_11492 {

    static long i = 2871543195640599408L;

    long simpleb(long i) {
        Long ib = Long.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11492().simpleb(i));
    }
}
