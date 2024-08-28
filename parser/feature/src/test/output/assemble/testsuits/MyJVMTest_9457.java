import javax.script.*;
import java.util.*;

public class MyJVMTest_9457 {

    List<String> getMimeTypes() {
        List<String> list = new ArrayList<String>();
        list.add("application/bad");
        list.add(null);
        list.add("");
        return list;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9457().getMimeTypes());
    }
}
