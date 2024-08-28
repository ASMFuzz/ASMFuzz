import java.util.Objects;

public class MyJVMTest_16876 {

    static Object lhs = 0;

    static Object rhs = 1;

    static String message = "OK_H!0_R#Q";

    static String relation = "Rk +.LO_bH";

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
        new MyJVMTest_16876().fail(lhs, rhs, message, relation);
    }
}
