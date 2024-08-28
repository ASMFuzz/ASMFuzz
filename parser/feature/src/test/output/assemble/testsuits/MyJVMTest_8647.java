public class MyJVMTest_8647 {

    static int a1 = 0;

    static int a2 = 6;

    int warnings(int a1, int a2) throws Exception {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8647().warnings(a1, a2));
    }
}
