public class MyJVMTest_1536 {

    static int a = 0;

    int dontInline(int a) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1536().dontInline(a));
    }
}
