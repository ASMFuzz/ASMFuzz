public class MyJVMTest_4386 {

    static long i = 0;

    long simple(long i) {
        Long ib = new Long(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4386().simple(i));
    }
}
