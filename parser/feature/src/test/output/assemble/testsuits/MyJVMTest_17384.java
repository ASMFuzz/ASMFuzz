import javax.swing.*;

public class MyJVMTest_17384 {

    String getName() {
        return "A name";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17384().getName());
    }
}
