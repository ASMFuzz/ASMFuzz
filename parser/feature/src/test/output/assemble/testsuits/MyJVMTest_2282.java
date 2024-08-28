import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_2282 {

    static ColorUIResource primary2 = new ColorUIResource(128, 192, 192);

    ColorUIResource getPrimary2() {
        return primary2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2282().getPrimary2());
    }
}
