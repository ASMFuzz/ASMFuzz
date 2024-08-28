public class MyJVMTest_3993 {

    static long i = -340669022350614498L;

    long simplem2(long i) {
        Long ib1 = new Long(i);
        Long ib2 = Long.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3993().simplem2(i));
    }
}
