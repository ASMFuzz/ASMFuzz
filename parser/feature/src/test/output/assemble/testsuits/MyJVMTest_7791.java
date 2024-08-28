import java.io.File;

public class MyJVMTest_7791 {

    static String filename = "ye>J!Qc\"*9";

    File rm(String filename) throws Exception {
        File f = new File(filename);
        f.delete();
        if (f.exists())
            throw new Exception(filename + ": couldn't remove");
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7791().rm(filename);
    }
}
