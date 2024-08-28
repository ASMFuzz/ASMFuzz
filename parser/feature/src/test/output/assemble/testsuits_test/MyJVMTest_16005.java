import java.util.*;

public class MyJVMTest_16005 {

    static String s = "Y9TxGD.t=E";

    static HashMap<String, LinkedList<Integer>> m = new HashMap<String, LinkedList<Integer>>();

    Iterator<Integer> test(String s) {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        lst.add(new Integer(12));
        m.put("Hello", lst);
        lst = (m.get("Hello"));
        return lst.iterator();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16005().test(s));
    }
}
