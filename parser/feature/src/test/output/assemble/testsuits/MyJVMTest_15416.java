import java.awt.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_15416 {

    static DecimalFormatSymbols _decFormatSymbols = new DecimalFormatSymbols();

    char Update() {
        return _decFormatSymbols.getDigit();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15416().Update());
    }
}
