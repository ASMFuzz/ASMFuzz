import java.util.*;

public class MyJVMTest_6514 {

    static String s = "Q6C_8|qI`r";

    static HashMap<String, LinkedList<Integer>> m = new HashMap<String, LinkedList<Integer>>();

    Iterator<Integer> test(String s) {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        lst.add(new Integer(12));
        m.put("Hello", lst);
        lst = (m.get("Hello"));
        return lst.iterator();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6514().test(s));
    }
}
