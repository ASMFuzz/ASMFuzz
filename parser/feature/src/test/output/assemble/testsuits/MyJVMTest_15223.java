import java.awt.Color;

public class MyJVMTest_15223 {

    int getHeight() {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15223().getHeight());
    }
}
