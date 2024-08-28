public class MyJVMTest_16544 {

    static long l = 0;

    int fcomp(long l) {
        return Long.bitCount(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16544().fcomp(l));
    }
}
