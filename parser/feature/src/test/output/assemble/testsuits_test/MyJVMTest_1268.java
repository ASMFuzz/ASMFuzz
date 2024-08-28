import java.util.Arrays;

public class MyJVMTest_1268 {

    static String[] array = { "@A:lrUs_ \\", "Hf ?%5akTP", "k50(%4km@f", "A&|8a}iQ$D", "\\2SJQGsr\"!", "N35p.{fC59", "g6&[\"~pT:9", "f7nVFuv]pg", "C&4#J~cx'\\", ";#TB$R~!;Q" };

    String[] reset(String[] array) {
        if (null == array) {
            array = new String[3];
        }
        array[0] = "1";
        array[1] = "2";
        array[2] = "3";
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1268().reset(array)));
    }
}
