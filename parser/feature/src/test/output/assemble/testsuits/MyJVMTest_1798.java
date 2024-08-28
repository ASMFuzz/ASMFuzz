public class MyJVMTest_1798 {

    static int ch = 0;

    boolean isPrint(int ch) {
        return ((ch - 0x20) | (0x7E - ch)) >= 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1798().isPrint(ch));
    }
}
