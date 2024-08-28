public class MyJVMTest_3373 {

    static int ch = 1056243967;

    boolean isJoinControl(int ch) {
        return (ch == 0x200C || ch == 0x200D);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3373().isJoinControl(ch));
    }
}
