import java.util.*;

public class MyJVMTest_14321 {

    static int elts = 2;

    BitSet makeSet(int... elts) {
        BitSet s = new BitSet();
        for (int elt : elts) s.set(elt);
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14321().makeSet(elts));
    }
}
