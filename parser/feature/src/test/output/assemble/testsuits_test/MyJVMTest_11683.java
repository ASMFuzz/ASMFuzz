public class MyJVMTest_11683 {

    static String packageField = "<d;RiZ0)'w";

    void m() {
        packageField = "";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11683().m();
    }
}
