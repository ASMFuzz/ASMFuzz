import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_5841 {

    static ColorUIResource primary2 = new ColorUIResource(193, 10, 44);

    ColorUIResource getPrimary2() {
        return primary2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5841().getPrimary2());
    }
}
