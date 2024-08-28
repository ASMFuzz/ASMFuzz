public class MyJVMTest_6542 {

    static int j = 0;

    static int i = 0;

    void m() {
        i = 0;
        System.out.println(j);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6542().m();
    }
}
