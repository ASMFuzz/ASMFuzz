import java.util.Set;
import java.util.HashSet;

public class MyJVMTest_15381 {

    static Set<String> keys = new HashSet<String>();

    Set<String> getKeysCopy() {
        return new HashSet<String>(keys);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15381().getKeysCopy());
    }
}
