public class MyJVMTest_16376 {

    static String file = "=t</l.?sOT";

    static String err = "sorry - checkRead()";

    String checkRead(String file) {
        throw new SecurityException(err);
        return file;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16376().checkRead(file);
    }
}
