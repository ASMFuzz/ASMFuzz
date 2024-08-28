public class MyJVMTest_15731 {

    static String msg = "{6b]L%\"m+|";

    String throwException(String msg) {
        throw new RuntimeException("test failed. " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15731().throwException(msg);
    }
}
