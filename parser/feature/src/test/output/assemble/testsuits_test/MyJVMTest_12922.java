import java.io.*;

public class MyJVMTest_12922 {

    static String fParam1 = "_sTwfOC0 w";

    static String fParam2 = "Os|Ur!7+X}";

    static File f = new File(fParam1, fParam2);

    boolean accept(File f) {
        return f.getPath().endsWith(".class");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12922().accept(f));
    }
}
