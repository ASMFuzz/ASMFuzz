import java.util.List;
import java.util.stream.Collectors;

public class MyJVMTest_14945 {

    static String message = "BJ(sTNwrHH";

    static String inputTag = "RvjR<K6?z&";

    static String input = "rZuV-!'RyS";

    static String outputTag = "dR@j?kp=q~";

    static String output = "kaM>FmK.dH";

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
        new MyJVMTest_14945().report(message, inputTag, input, outputTag, output);
    }
}
