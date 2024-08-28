public class MyJVMTest_18200 {

    static int ch = 1696290237;

    boolean isAscii(int ch) {
        return ((ch & 0xFFFFFF80) == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18200().isAscii(ch));
    }
}
