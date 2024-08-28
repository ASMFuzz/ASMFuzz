import java.util.Arrays;
import java.util.stream.Collectors;

public class MyJVMTest_14575 {

    static String params = ")xLgT7DXx;";

    static String cmd = "FX! ]X Y=W";

    JdbCommand run(String... params) {
        return new JdbCommand("run " + Arrays.stream(params).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14575().run(params));
    }
}
