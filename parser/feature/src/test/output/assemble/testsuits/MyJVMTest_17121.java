import javax.swing.*;

public class MyJVMTest_17121 {

    String getID() {
        return "An id";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17121().getID());
    }
}
