public class MyJVMTest_17365 {

    static long v = -7715461756539588641L;

    long test(long v) {
        return v * Long.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17365().test(v));
    }
}
