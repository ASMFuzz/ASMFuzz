public class MyJVMTest_10924 {

    static int i = 0;

    static int i3 = 0;

    static int i4 = -248073791;

    int m_helper(int i, int i3, int i4) {
        return i3 == 4 ? i4 : i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10924().m_helper(i, i3, i4));
    }
}
