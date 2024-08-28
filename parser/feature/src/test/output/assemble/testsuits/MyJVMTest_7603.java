import java.io.File;

public class MyJVMTest_7603 {

    static String className = "g~\"`yvsd:o";

    String getClassPath(String className) {
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
            return classPath[i];
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7603().getClassPath(className));
    }
}
