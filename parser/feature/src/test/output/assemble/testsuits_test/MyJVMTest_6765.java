import java.util.Objects;

public class MyJVMTest_6765 {

    static Object lhs = 4;

    static Object rhs = 9;

    static String message = ",W;,pK0d!s";

    static String relation = "E+S(:6C6W*";

    String format(Object lhs, Object rhs, String message, String relation) {
        StringBuilder sb = new StringBuilder(80);
        if (message != null) {
            sb.append(message);
            sb.append(' ');
        }
        sb.append("<");
        sb.append(Objects.toString(lhs));
        sb.append("> ");
        sb.append(Objects.toString(relation, ","));
        sb.append(" <");
        sb.append(Objects.toString(rhs));
        sb.append(">");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6765().format(lhs, rhs, message, relation));
    }
}
