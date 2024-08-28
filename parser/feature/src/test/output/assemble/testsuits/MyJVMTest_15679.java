import static java.awt.Color.RED;

public class MyJVMTest_15679 {

    int getIconWidth() {
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15679().getIconWidth());
    }
}
