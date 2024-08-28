import javax.swing.*;

public class MyJVMTest_11789 {

    String getDescription() {
        return "A description";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11789().getDescription());
    }
}
