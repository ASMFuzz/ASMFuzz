public class MyJVMTest_12968 {

    static String s = "";

    void m() {
        s += "a";
        s += 'a';
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12968().m();
    }
}
