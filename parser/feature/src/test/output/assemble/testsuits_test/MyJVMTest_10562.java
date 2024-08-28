import java.util.Iterator;

public class MyJVMTest_10562 {

    static int next = 1;

    Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int next = 1;

            public boolean hasNext() {
                return next <= (1 << 12);
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Integer next() {
                try {
                    return new Integer(next);
                } finally {
                    next <<= 1;
                }
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10562().next());
    }
}
