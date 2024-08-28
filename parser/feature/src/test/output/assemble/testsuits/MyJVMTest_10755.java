public class MyJVMTest_10755 {

    static int a = 2;

    int dontInline(int a) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10755().dontInline(a));
    }
}
