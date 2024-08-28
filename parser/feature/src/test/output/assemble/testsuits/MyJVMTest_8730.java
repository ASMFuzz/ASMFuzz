import java.io.File;

public class MyJVMTest_8730 {

    static String path = "*1dE3A{ZHX";

    static boolean directory = true;

    File getParentFile() {
        int index = path.lastIndexOf('/');
        if (index == -1) {
            return null;
        }
        return new VirtualFile(path.substring(0, index), true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8730().getParentFile());
    }
}
