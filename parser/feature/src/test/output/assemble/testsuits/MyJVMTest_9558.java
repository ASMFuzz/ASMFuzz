import java.util.ArrayList;

public class MyJVMTest_9558 {

    static List<? super Integer> l = new ArrayList<? super Integer>();

    java.util.List<? super Integer> f(java.util.List<? super Integer> l) {
        l.add(new Integer(3));
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9558().f(l);
    }
}
