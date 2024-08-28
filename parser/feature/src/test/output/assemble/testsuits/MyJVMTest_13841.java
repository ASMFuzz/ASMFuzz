import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_13841 {

    Action[] getActions() {
        return new Action[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13841().getActions()));
    }
}
