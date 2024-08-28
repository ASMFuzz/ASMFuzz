import java.util.*;

public class MyJVMTest_11546 {

    static String type = "qS_@D}x*#=";

    static int i = -1255518465;

    String stringValue(String type, int i) {
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
                return String.valueOf(i * 1_000_000_000);
            case "longMinus":
                return String.valueOf(-i * 1_000_000_000);
            case "char":
                return String.valueOf((char) (i % 26 + 65));
            case "double":
            case "float":
                return String.valueOf(i) + ".0";
            case "doubleMinus":
            case "floatMinus":
                return "-" + String.valueOf(i) + ".0";
            case "object":
                return "C(" + i + ")";
            case "integerNull":
            case "objectNull":
            case "objectNullToString":
            case "intArrayNull":
            case "objectArrayNull":
                return "null";
            case "String":
                return "" + i;
            case "StringUTF16":
                return "\u0451" + i;
            case "StringU1":
                return "\u0001" + i;
            case "StringU2":
                return "\u0002" + i;
            default:
                throw new IllegalStateException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11546().stringValue(type, i));
    }
}
