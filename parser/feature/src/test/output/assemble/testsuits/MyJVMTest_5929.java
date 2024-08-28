import java.util.Set;
import java.util.HashSet;

public class MyJVMTest_5929 {

    static Set<String> keys = new HashSet<String>();

    Set<String> getKeysCopy() {
        return new HashSet<String>(keys);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5929().getKeysCopy());
    }
}
