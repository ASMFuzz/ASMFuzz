import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_16285 {

    static ColorUIResource primary3 = new ColorUIResource(99, 99, 99);

    ColorUIResource getPrimary3() {
        return primary3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16285().getPrimary3());
    }
}
