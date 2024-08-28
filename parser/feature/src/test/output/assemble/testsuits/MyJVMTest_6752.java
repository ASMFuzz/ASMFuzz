import java.io.Reader;

public class MyJVMTest_6752 {

    static String key = "[c\":%B4S()";

    Object get(String key) {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6752().get(key));
    }
}
