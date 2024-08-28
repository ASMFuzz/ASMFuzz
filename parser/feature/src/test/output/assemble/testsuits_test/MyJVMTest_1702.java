public class MyJVMTest_1702 {

    static int i = -163511881;

    static int i3 = 863252673;

    static int i4 = 712032620;

    int m_helper(int i, int i3, int i4) {
        return i3 == 4 ? i4 : i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1702().m_helper(i, i3, i4));
    }
}
