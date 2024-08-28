import javax.swing.*;

public class MyJVMTest_12094 {

    static String path = "]7&4[$QS^Z";

    static boolean directory = true;

    String getName() {
        int index = path.lastIndexOf('/');
        return index == -1 ? path : path.substring(index + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12094().getName());
    }
}
