import java.util.*;

public class MyJVMTest_4919 {

    static int elts = -440366877;

    BitSet makeSet(int... elts) {
        BitSet s = new BitSet();
        for (int elt : elts) s.set(elt);
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4919().makeSet(elts));
    }
}
