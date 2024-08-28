public class MyJVMTest_9820 {

    static long i = 0;

    long testb(long i) {
        Long ib = i;
        if ((i & 1) == 0)
            ib = (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9820().testb(i));
    }
}
