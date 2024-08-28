import java.util.Objects;

public class MyJVMTest_16262 {

    static Object lhs = 0;

    static Object rhs = -651393336;

    static String message = "Mz+u$'H}(y";

    static String relation = "9r+S2F{gX}";

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
        System.out.println(new MyJVMTest_16262().format(lhs, rhs, message, relation));
    }
}
