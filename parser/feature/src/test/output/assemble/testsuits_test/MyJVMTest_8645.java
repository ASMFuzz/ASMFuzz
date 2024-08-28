import java.io.File;

public class MyJVMTest_8645 {

    static String jar = "8W%^JHk{:@";

    String getTestJar(String jar) {
        File dir = new File(System.getProperty("test.classes", "."));
        File jarFile = new File(dir, jar);
        if (!jarFile.exists()) {
            throw new RuntimeException("Cannot find " + jarFile.getPath());
        }
        if (!jarFile.isFile()) {
            throw new RuntimeException("Not a regular file: " + jarFile.getPath());
        }
        return jarFile.getPath();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8645().getTestJar(jar));
    }
}
