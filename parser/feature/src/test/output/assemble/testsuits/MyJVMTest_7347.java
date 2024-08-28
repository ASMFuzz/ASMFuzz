import java.util.Objects;

public class MyJVMTest_7347 {

    static Object lhs = 0;

    static Object rhs = 3;

    static String message = "eKSR'`C9\"&";

    static String relation = "cn0KKmsH/#";

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

    String fail(Object lhs, Object rhs, String message, String relation) {
        throw new RuntimeException(format(lhs, rhs, message, relation));
        return relation;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7347().fail(lhs, rhs, message, relation);
    }
}
