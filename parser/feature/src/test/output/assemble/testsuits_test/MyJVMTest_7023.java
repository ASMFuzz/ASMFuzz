import java.util.Arrays;

public class MyJVMTest_7023 {

    Object[] toArray() {
        return new Object[] { null };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7023().toArray()));
    }
}
