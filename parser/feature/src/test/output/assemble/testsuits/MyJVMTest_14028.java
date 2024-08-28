import static java.awt.Color.RED;

public class MyJVMTest_14028 {

    int getIconHeight() {
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14028().getIconHeight());
    }
}
