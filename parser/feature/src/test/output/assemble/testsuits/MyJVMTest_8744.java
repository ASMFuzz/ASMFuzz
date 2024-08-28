import java.io.File;

public class MyJVMTest_8744 {

    static String path = "*dy-o}`@nl";

    static boolean directory = false;

    String getName() {
        int index = path.lastIndexOf('/');
        return index == -1 ? path : path.substring(index + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8744().getName());
    }
}
