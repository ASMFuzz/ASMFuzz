import java.util.Iterator;

public class MyJVMTest_3608 {

    Iterator<String> iterator() {
        return new Iterator<String>() {

            public void remove() {
            }

            public boolean hasNext() {
                return true;
            }

            public String next() {
                return "a";
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3608().next());
    }
}
