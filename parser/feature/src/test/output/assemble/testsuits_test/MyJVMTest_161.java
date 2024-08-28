public class MyJVMTest_161 {

    static int num = 0;

    boolean more() {
        return num-- > 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_161().more());
    }
}
