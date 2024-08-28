import java.net.URL;

public class MyJVMTest_16146 {

    static String path = ">dP=-Z!`oD";

    URL find(String path) {
        return T6257443.class.getClassLoader().getSystemResource(path);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16146().find(path));
    }
}
