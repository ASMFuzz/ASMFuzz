import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_8193 {

    static ColorUIResource primary3 = new ColorUIResource(153, 244, 173);

    ColorUIResource getPrimary3() {
        return primary3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8193().getPrimary3());
    }
}
