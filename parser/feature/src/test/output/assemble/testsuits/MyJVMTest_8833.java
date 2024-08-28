import java.io.File;
import javax.swing.JApplet;
import java.util.Arrays;

public class MyJVMTest_8833 {

    File[] getRoots() {
        return new File[] { bug6698013.root };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8833().getRoots()));
    }
}
