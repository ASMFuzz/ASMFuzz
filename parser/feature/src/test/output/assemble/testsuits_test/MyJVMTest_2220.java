import java.util.*;

public class MyJVMTest_2220 {

    static String type = "TC']zFT~M&";

    static int i = 0;

    String initValue(String type, int i) {
        switch(type) {
            case "boolean":
                return String.valueOf((i & 1) == 1);
            case "byte":
                return String.valueOf(i);
            case "byteMinus":
                return String.valueOf(-i);
            case "short":
                return String.valueOf(i * 100);
            case "shortMinus":
                return String.valueOf(-i * 100);
            case "intMinus":
                return String.valueOf(-i * 1_000_000);
            case "int":
            case "integer":
                return String.valueOf(i * 1_000_000);
            case "long":
                return String.valueOf(i * 1_000_000_000) + "L";
            case "longMinus":
                return String.valueOf(-i * 1_000_000_000) + "L";
            case "char":
                return "'" + (char) (i % 26 + 65) + "'";
            case "double":
                return String.valueOf(i) + ".0d";
            case "doubleMinus":
                return "-" + String.valueOf(i) + ".0d";
            case "float":
                return String.valueOf(i) + ".0f";
            case "floatMinus":
                return "-" + String.valueOf(i) + ".0f";
            case "object":
                return "new MyClass(" + i + ")";
            case "objectNullToString":
                return "new MyClassNullToString()";
            case "integerNull":
            case "objectNull":
            case "intArrayNull":
            case "objectArrayNull":
                return "null";
            case "String":
                return "\"" + i + "\"";
            case "StringUTF16":
                return "\"\\u0451" + i + "\"";
            case "StringU1":
                return "\"\\u0001" + i + "\"";
            case "StringU2":
                return "\"\\u0002" + i + "\"";
            default:
                throw new IllegalStateException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2220().initValue(type, i));
    }
}
