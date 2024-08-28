public class MyJVMTest_1313 {

    static long i = 9223372036854775807L;

    long simple2(long i) {
        Long ib1 = new Long(i);
        Long ib2 = new Long(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1313().simple2(i));
    }
}
