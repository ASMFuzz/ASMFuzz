public class MyJVMTest_6506 {

    static long i = 8706441856022720153L;

    long test(long i) {
        Long ib = new Long(i);
        if ((i & 1) == 0)
            ib = i + 1;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6506().test(i));
    }
}
