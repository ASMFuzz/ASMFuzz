public class MyJVMTest_12702 {

    static int ch = 3;

    boolean isJoinControl(int ch) {
        return (ch == 0x200C || ch == 0x200D);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12702().isJoinControl(ch));
    }
}
