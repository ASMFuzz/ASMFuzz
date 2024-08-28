import javax.swing.*;
import java.io.File;

public class MyJVMTest_2999 {

    static String fParam1 = "xHbA;[D71|";

    static File f = new File(fParam1);

    boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2999().accept(f));
    }
}
