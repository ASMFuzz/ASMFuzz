import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_11559 {

    static ColorUIResource primary3 = new ColorUIResource(159, 235, 235);

    ColorUIResource getPrimary3() {
        return primary3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11559().getPrimary3());
    }
}
