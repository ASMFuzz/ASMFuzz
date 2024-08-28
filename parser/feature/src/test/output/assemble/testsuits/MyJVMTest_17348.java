import java.io.File;

public class MyJVMTest_17348 {

    static String filename = "fQ:fiMAA3X";

    File rm(String filename) throws Exception {
        File f = new File(filename);
        f.delete();
        if (f.exists())
            throw new Exception(filename + ": couldn't remove");
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17348().rm(filename);
    }
}
