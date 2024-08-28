import java.io.File;
import javax.swing.JApplet;

public class MyJVMTest_8983 {

    File getHomeDirectory() {
        return bug6698013.root;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8983().getHomeDirectory());
    }
}
