import java.util.List;
import java.util.stream.Collectors;

public class MyJVMTest_5512 {

    static String message = "wv8k>N5WW!";

    static String inputTag = "uojQ2o>Hs=";

    static String input = " )f{72)yV!";

    static String outputTag = "l\"'1`5lo;i";

    static String output = "YcGG l6yE0";

    String report(String message, String inputTag, String input, String outputTag, String output) {
        System.err.println(message);
        System.err.println();
        System.err.println(inputTag);
        System.err.println(input.codePoints().mapToObj(c -> (Integer) c).collect(Collectors.toList()));
        System.err.println();
        System.err.println(outputTag);
        System.err.println(output.codePoints().mapToObj(c -> (Integer) c).collect(Collectors.toList()));
        throw new RuntimeException();
        return inputTag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5512().report(message, inputTag, input, outputTag, output);
    }
}
