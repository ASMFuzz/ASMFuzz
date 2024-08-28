import java.util.*;

public class MyJVMTest_2643 {

    static String[] args = { "?a9.2;sbFh", "t3`|Z5odW\"", "=6<oF3nom#", "<E`ej},6S;", "/,IL6YWq!g", "J3nziND9sn", "I5I^sJt`^&", "o3#:jGk?>J", "k;.]S3=Y>[", "PyW}(kYv5R" };

    static int i = 1894847868;

    static int defaultValue = 0;

    int intArg(String[] args, int i, int defaultValue) {
        return args.length > i ? Integer.parseInt(args[i]) : defaultValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2643().intArg(args, i, defaultValue));
    }
}
