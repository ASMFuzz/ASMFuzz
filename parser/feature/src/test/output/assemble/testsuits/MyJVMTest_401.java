import java.util.ArrayList;

public class MyJVMTest_401 {

    static List<? super Integer> l = new ArrayList<? super Integer>();

    java.util.List<? super Integer> f(java.util.List<? super Integer> l) {
        l.add(new Integer(3));
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_401().f(l);
    }
}
