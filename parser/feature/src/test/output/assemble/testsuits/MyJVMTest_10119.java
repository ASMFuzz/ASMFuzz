import java.util.*;

public class MyJVMTest_10119 {

    static List<? super A> l = new ArrayList<? super A>();

    static List<A> la = new ArrayList<A>();

    <A> List<? super A> add(List<? super A> l, List<A> la) {
        l.addAll(la);
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10119().add(l, la);
    }
}
