import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_7147 {

    static ColorUIResource primary1 = new ColorUIResource(80, 10, 22);

    ColorUIResource getPrimary1() {
        return primary1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7147().getPrimary1());
    }
}
