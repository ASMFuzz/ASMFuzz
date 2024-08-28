import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_13680 {

    static List<String> formats = new ArrayList<String>();

    ResourceBundle.Control getControl(List<String> formats) {
        return ResourceBundle.Control.getNoFallbackControl(formats);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13680().getControl(formats));
    }
}
