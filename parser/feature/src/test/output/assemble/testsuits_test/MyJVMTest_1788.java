public class MyJVMTest_1788 {

    static long l = 0;

    int fint(long l) {
        return Long.bitCount(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1788().fint(l));
    }
}
