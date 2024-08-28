public class MyJVMTest_6885 {

    static long l = -5688008623409499878L;

    int lzcomp(long l) {
        return Long.numberOfLeadingZeros(l);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6885().lzcomp(l));
    }
}
