import java.util.*;

public class MyJVMTest_5207 {

    static String type = "?>1zj;-QE~";

    static int i = -236735582;

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
        System.out.println(new MyJVMTest_5207().typeValue(type, i));
    }
}
