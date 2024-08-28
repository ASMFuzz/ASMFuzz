public class MyJVMTest_7068 {

    static int j = 0;

    static int i = 4;

    static int p = 0;

    static int r = 0;

    void m() {
        i = 0;
        System.out.println(j);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7068().m();
    }
}
