import java.io.File;
import java.io.IOException;

public class MyJVMTest_9057 {

    static String className = "[lYMa. nET";

    String getClassPathFileName(String className) {
        String fileName = className.replace(".", File.separator) + ".class";
        String[] classPath = System.getProperty("java.class.path").split(File.pathSeparator);
        File target = null;
        int i;
        for (i = 0; i < classPath.length; ++i) {
            target = new File(classPath[i] + File.separator + fileName);
            System.out.println("Try: " + target);
            if (target.exists()) {
                break;
            }
        }
        if (i != classPath.length) {
            try {
                return target.getCanonicalPath();
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9057().getClassPathFileName(className));
    }
}
