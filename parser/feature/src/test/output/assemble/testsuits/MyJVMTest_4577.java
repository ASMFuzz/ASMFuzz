import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Arrays;

public class MyJVMTest_4577 {

    static String name = "<&jr3,Tbb+";

    static String classPath = "'Jn|joWh~7";

    Path findClassFile(String name, String classPath) {
        return Arrays.stream(classPath.split(File.pathSeparator)).map(java.nio.file.Paths::get).map(p -> p.resolve(name.replace('.', File.separatorChar) + ".class")).filter(p -> java.nio.file.Files.exists(p)).map(Path::toAbsolutePath).findAny().orElse(null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4577().findClassFile(name, classPath));
    }
}
