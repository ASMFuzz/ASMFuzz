import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_15287 {

    static ColorUIResource primary2 = new ColorUIResource(193, 10, 44);

    ColorUIResource getPrimary2() {
        return primary2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15287().getPrimary2());
    }
}
