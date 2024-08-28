import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_8484 {

    static ColorUIResource primary2 = new ColorUIResource(90, 86, 99);

    ColorUIResource getPrimary2() {
        return primary2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8484().getPrimary2());
    }
}
