public class MyJVMTest_6116 {

    static String s = "'-ep$=#pDI";

    String failed(String s) {
        throw new RuntimeException("Failed: " + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6116().failed(s);
    }
}
