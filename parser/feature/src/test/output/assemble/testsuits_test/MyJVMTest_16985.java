import java.util.ArrayList;

public class MyJVMTest_16985 {

    static String description = "2.\\lB!@zT'";

    static List<Object[]> data = new ArrayList<Object[]>();

    static List<Integer> exp = new ArrayList<Integer>();

    StringBuilder joiner(String description) {
        return new StringBuilder(description).append(" {").append("size=").append(exp.size()).append("}");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16985().joiner(description));
    }
}
