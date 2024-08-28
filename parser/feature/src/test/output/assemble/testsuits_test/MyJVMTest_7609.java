import java.util.*;

public class MyJVMTest_7609 {

    static String type = "C$GMwOsRDl";

    String typeSig(String type) {
        switch(type) {
            case "boolean":
                return "bl";
            case "byte":
                return "b";
            case "byteMinus":
                return "bM";
            case "short":
                return "s";
            case "shortMinus":
                return "sM";
            case "char":
                return "c";
            case "int":
                return "i";
            case "intMinus":
                return "iM";
            case "integer":
                return "I";
            case "integerNull":
                return "IN";
            case "float":
                return "f";
            case "floatMinus":
                return "fM";
            case "long":
                return "l";
            case "longMinus":
                return "lM";
            case "double":
                return "d";
            case "doubleMinus":
                return "dM";
            case "String":
                return "str";
            case "StringUTF16":
                return "strU";
            case "StringU1":
                return "strU1";
            case "StringU2":
                return "strU2";
            case "object":
                return "o";
            case "objectNull":
                return "oN";
            case "objectNullToString":
                return "oNtS";
            case "intArrayNull":
                return "iAN";
            case "objectArrayNull":
                return "oAN";
            default:
                throw new IllegalStateException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7609().typeSig(type));
    }
}
