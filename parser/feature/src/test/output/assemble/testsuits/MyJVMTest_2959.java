import java.io.File;

public class MyJVMTest_2959 {

    static String name = "NI:y&mZ^\"*";

    static String[] paths = { "/bin", "/usr/bin" };

    String findCommand0(String name) {
        for (String path : paths) {
            File file = new File(path, name);
            if (file.canExecute()) {
                return file.getPath();
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2959().findCommand0(name));
    }
}
