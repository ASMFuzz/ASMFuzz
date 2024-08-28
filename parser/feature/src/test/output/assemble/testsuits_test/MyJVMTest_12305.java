import javax.swing.*;
import java.io.File;

public class MyJVMTest_12305 {

    static String fParam1Param1 = "/DO?\"4H,%l";

    static File fParam1 = new File(fParam1Param1);

    static String fParam2 = "7Y:REZ-0@v";

    static File f = new File(fParam1, fParam2);

    boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12305().accept(f));
    }
}
