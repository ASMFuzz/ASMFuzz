import javax.swing.*;

public class MyJVMTest_2800 {

    static String path = "ty?Z<?ZjY|";

    static boolean directory = false;

    String getName() {
        int index = path.lastIndexOf('/');
        return index == -1 ? path : path.substring(index + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2800().getName());
    }
}
