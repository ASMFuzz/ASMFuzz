import javax.swing.plaf.ColorUIResource;

public class MyJVMTest_10434 {

    static ColorUIResource secondary3 = new ColorUIResource(102, 102, 102);

    ColorUIResource getSecondary3() {
        return secondary3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10434().getSecondary3());
    }
}
