import java.net.URL;

public class MyJVMTest_6650 {

    static String path = "3;4KabPr|C";

    URL find(String path) {
        return T6257443.class.getClassLoader().getSystemResource(path);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6650().find(path));
    }
}
