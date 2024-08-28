import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_7251 {

    static ColorUIResource primary2 = new ColorUIResource(102, 193, 122);

    ColorUIResource getPrimary2() {
        return primary2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7251().getPrimary2());
    }
}
