import java.awt.Image;

public class MyJVMTest_15624 {

    static String name = ":cz=uKjYm^";

    static Image image = null;

    String print(String name, Image image) {
        if (image != null) {
            System.out.println(name + " icon is exist");
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15624().print(name, image);
    }
}
