import java.io.File;
import java.util.ArrayList;

public class MyJVMTest_3401 {

    static List<T> elements = new ArrayList<T>();

    static boolean[] states = {false,true,true,false,false,true,true,true,true,false};

    boolean hasNext() {
        return states != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3401().hasNext());
    }
}
