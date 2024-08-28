public class MyJVMTest_16586 {

    static int j = 0;

    static int i = 1789808779;

    static int p = 0;

    static int r = 0;

    void m() {
        i = 0;
        System.out.println(j);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16586().m();
    }
}
