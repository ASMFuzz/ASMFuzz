import java.util.*;

public class MyJVMTest_15816 {

    static Map<String, String> props = new HashMap<String, String>();

    Map.Entry<String, String> printProperties(Map<String, String> props) {
        Set<Map.Entry<String, String>> set = props.entrySet();
        for (Map.Entry<String, String> p : set) {
            System.out.println(p.getKey() + ": " + p.getValue());
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15816().printProperties(props);
    }
}
