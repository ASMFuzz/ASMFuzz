public class MyJVMTest_8608 {

    static int ch = 3;

    boolean isAscii(int ch) {
        return ((ch & 0xFFFFFF80) == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8608().isAscii(ch));
    }
}
