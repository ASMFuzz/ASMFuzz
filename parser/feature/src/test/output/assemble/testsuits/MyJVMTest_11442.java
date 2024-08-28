import java.io.*;

public class MyJVMTest_11442 {

    static String dirParam1 = "gdx][OT*d$";

    static File dir = new File(dirParam1);

    static String name = "b0\\gxuVeP<";

    boolean accept(File dir, String name) {
        if (name.endsWith(".java"))
            return false;
        if (name.indexOf("CVS") != -1)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11442().accept(dir, name));
    }
}
