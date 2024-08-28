public class MyJVMTest_3847 {

    static I i = null;

    static A1 a1 = null;

    static A2 a2 = null;

    static boolean b1 = false;

    static boolean b2 = true;

    Object crash(I i, A1 a1, A2 a2, boolean b1, boolean b2) {
        return b1 ? i : b2 ? a2 : a1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3847().crash(i, a1, a2, b1, b2));
    }
}
