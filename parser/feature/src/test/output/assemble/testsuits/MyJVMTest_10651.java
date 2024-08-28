import java.util.*;
import javax.tools.*;
import java.io.File;

public class MyJVMTest_10651 {

    static String path = "nz =}[MlR^";

    static List<File> defaultPath = new ArrayList<File>();

    List<File> pathToFiles(String path, List<File> defaultPath) {
        List<File> files = new ArrayList<>();
        for (String f : path.split(File.pathSeparator)) {
            if (f.isEmpty())
                continue;
            File file = new File(f);
            if (file.exists())
                files.add(file);
        }
        if (files.isEmpty())
            files.addAll(defaultPath);
        return files;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10651().pathToFiles(path, defaultPath));
    }
}
