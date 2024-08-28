public class MyJVMTest_3632 {

    static String s = "";

    void m() {
        s += "a";
        s += 'a';
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3632().m();
    }
}
