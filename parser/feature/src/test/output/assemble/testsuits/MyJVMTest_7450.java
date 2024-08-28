import java.util.ArrayList;

public class MyJVMTest_7450 {

    static String description = "ej}Dz/J907";

    static List<Object[]> data = new ArrayList<Object[]>();

    static List<Integer> exp = new ArrayList<Integer>();

    StringBuilder joiner(String description) {
        return new StringBuilder(description).append(" {").append("size=").append(exp.size()).append("}");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7450().joiner(description));
    }
}
