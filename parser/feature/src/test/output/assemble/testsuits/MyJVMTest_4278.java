import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_4278 {

    static ColorUIResource primary3 = new ColorUIResource(244, 10, 66);

    ColorUIResource getPrimary3() {
        return primary3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4278().getPrimary3());
    }
}
