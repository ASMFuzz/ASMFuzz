import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_1234 {

    static ColorUIResource secondary3 = new ColorUIResource(102, 102, 102);

    ColorUIResource getSecondary3() {
        return secondary3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1234().getSecondary3());
    }
}
