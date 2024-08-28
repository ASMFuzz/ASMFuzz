import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_3523 {

    Document createDefaultDocument() {
        return new CodeBugDocument();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3523().createDefaultDocument());
    }
}
