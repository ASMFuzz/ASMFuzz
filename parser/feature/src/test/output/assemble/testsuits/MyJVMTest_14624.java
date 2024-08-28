import java.util.*;

public class MyJVMTest_14624 {

    static String type = "eFAfe=u{R.";

    static int i = -1707006169;

    String typeValue(String type, int i) {
        switch(type) {
            case "boolean":
            case "byte":
            case "byteMinus":
            case "char":
            case "short":
            case "shortMinus":
            case "int":
            case "intMinus":
            case "float":
            case "floatMinus":
            case "long":
            case "longMinus":
            case "double":
            case "doubleMinus":
                return type.replace("Minus", "");
            case "String":
            case "StringUTF16":
            case "StringU1":
            case "StringU2":
                return "String";
            case "object":
            case "objectNull":
            case "objectNullToString":
                return "Object";
            case "integer":
            case "integerNull":
                return "Integer";
            case "intArrayNull":
                return "int[]";
            case "objectArrayNull":
                return "Object[]";
            default:
                throw new IllegalStateException();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14624().typeValue(type, i));
    }
}
