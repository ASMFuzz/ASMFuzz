import java.util.*;

public class MyJVMTest_5564 {

    static TreeMap<String, String[]> optionMap = null;

    String getOptionMap() {
        TreeMap<String, String[]> optmap = optionMap;
        StringBuffer sb = new StringBuffer();
        for (String opt : optmap.keySet()) {
            sb.append(opt);
            for (String spec : optmap.get(opt)) {
                sb.append(' ').append(spec);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5564().getOptionMap());
    }
}
