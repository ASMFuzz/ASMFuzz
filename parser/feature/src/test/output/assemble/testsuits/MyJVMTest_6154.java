import java.awt.Image;

public class MyJVMTest_6154 {

    static String name = "Gdw}-WXP3p";

    static Image image = null;

    String print(String name, Image image) {
        if (image != null) {
            System.out.println(name + " icon is exist");
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6154().print(name, image);
    }
}
