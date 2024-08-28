import java.io.File;

public class MyJVMTest_9025 {

    static String filename = ")Q+ Fx6A' ";

    File rm(String filename) throws Exception {
        File f = new File(filename);
        f.delete();
        if (f.exists())
            throw new Exception(filename + ": couldn't remove");
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9025().rm(filename);
    }
}
