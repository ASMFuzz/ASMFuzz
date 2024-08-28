public class MyJVMTest_17829 {

    static long i = 9223372036854775807L;

    long simpleb2(long i) {
        Long ib1 = Long.valueOf(i);
        Long ib2 = Long.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17829().simpleb2(i));
    }
}
