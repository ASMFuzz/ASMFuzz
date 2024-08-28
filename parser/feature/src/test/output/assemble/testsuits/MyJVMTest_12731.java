import java.io.File;
import java.util.ArrayList;

public class MyJVMTest_12731 {

    static List<T> elements = new ArrayList<T>();

    static boolean[] states = {true,false,false,true,false,false,false,false,false,true};

    boolean hasNext() {
        return states != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12731().hasNext());
    }
}
