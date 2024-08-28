public class MyJVMTest_16035 {

    static int j = 0;

    static int i = 1082432664;

    void m() {
        i = 0;
        System.out.println(j);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16035().m();
    }
}
