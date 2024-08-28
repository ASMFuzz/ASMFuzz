import java.io.File;
import javax.swing.JApplet;

public class MyJVMTest_9053 {

    File getHomeDirectory() {
        return bug6698013.root;
    }

    File getDefaultDirectory() {
        return getHomeDirectory();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9053().getDefaultDirectory());
    }
}
