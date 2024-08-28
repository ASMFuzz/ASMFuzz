import java.io.File;

public class MyJVMTest_8690 {

    File getParentFile() {
        int index = path.lastIndexOf('/');
        if (index == -1) {
            return null;
        }
        return new VirtualFile(path.substring(0, index), true);
    }

    String getPath() {
        return path;
    }

    static String path = "E]q|]ZJG#?";

    static boolean directory = true;

    String getParent() {
        File parent_file = getParentFile();
        return parent_file == null ? null : parent_file.getPath();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8690().getParent());
    }
}
