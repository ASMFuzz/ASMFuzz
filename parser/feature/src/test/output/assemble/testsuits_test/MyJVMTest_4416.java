import java.io.File;

public class MyJVMTest_4416 {

    static ClassLoader cl = CopyClassFile.class.getClassLoader();

    static String className = "coHQK029)K";

    String cutPackageName(String className) {
        int dotIndex = className.lastIndexOf(".") + 1;
        if (dotIndex <= 0) {
            return className;
        } else {
            return className.substring(dotIndex);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4416().cutPackageName(className));
    }
}
