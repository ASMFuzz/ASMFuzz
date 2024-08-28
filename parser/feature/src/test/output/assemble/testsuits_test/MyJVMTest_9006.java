import java.io.File;

public class MyJVMTest_9006 {

    String getCacerts() {
        String sep = File.separator;
        return System.getProperty("java.home") + sep + "lib" + sep + "security" + sep + "cacerts";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9006().getCacerts());
    }
}
