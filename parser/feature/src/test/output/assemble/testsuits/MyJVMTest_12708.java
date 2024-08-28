import java.io.File;

public class MyJVMTest_12708 {

    static String dirParam1 = "8Ut+\"qbL6C";

    static File dir = new File(dirParam1);

    static String name = "YVX)N<1dXO";

    String path(File dir, String name) {
        return new File(dir, name).getPath();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12708().path(dir, name));
    }
}
