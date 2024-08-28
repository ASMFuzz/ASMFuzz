import java.util.Arrays;

public class MyJVMTest_16539 {

    Object[] toArray() {
        return new Object[] { null };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16539().toArray()));
    }
}
