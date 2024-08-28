import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_7102 {

    static ColorUIResource primary1 = new ColorUIResource(102, 153, 153);

    ColorUIResource getPrimary1() {
        return primary1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7102().getPrimary1());
    }
}
