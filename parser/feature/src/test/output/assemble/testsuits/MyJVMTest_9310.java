public class MyJVMTest_9310 {

    static int num = 0;

    boolean more() {
        return num-- > 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9310().more());
    }
}
