import java.awt.Dialog;
import java.util.Arrays;

public class MyJVMTest_6361 {

    String[] getFontList() {
        return new String[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6361().getFontList()));
    }
}
