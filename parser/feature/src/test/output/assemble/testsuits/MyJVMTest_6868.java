public class MyJVMTest_6868 {

    static String file = "+g\" |=fh)h";

    static String err = "sorry - checkRead()";

    String checkRead(String file) {
        throw new SecurityException(err);
        return file;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6868().checkRead(file);
    }
}
