import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_6822 {

    static ColorUIResource primary1 = new ColorUIResource(66, 33, 66);

    ColorUIResource getPrimary1() {
        return primary1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6822().getPrimary1());
    }
}
