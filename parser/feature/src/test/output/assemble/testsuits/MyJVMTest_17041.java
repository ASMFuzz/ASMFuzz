import javax.security.auth.x500.X500Principal;

public class MyJVMTest_17041 {

    static String name = "iY-QQz@]Us";

    static boolean expectedResult = false;

    void run() throws Exception {
        Exception f = null;
        try {
            System.out.println("Parsing: \"" + name + "\"");
            new X500Principal(name);
            if (expectedResult == false) {
                f = new Exception("Successfully parsed invalid name");
            }
        } catch (IllegalArgumentException e) {
            if (expectedResult == true) {
                throw e;
            }
        }
        if (f != null) {
            throw f;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17041().run();
    }
}
