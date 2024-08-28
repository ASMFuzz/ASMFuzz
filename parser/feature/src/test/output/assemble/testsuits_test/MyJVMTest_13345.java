public class MyJVMTest_13345 {

    static long i = -7214484264232351276L;

    long simplem2(long i) {
        Long ib1 = new Long(i);
        Long ib2 = Long.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13345().simplem2(i));
    }
}
