public class MyJVMTest_9082 {

    static String result = "wtjGGtG|N|";

    static String string = ")H@'.p,.0i";

    static int repeat = 8;

    String truncate(String string) {
        if (string.length() < 80) {
            return string;
        }
        return string.substring(0, 80) + "...";
    }

    String verify(String result, String string, int repeat) {
        if (string.isEmpty() || repeat == 0) {
            if (!result.isEmpty()) {
                System.err.format("\"%s\".repeat(%d)%n", truncate(string), repeat);
                System.err.format("Result \"%s\"%n", truncate(result));
                System.err.format("Result expected to be empty, found string of length %d%n", result.length());
                throw new RuntimeException();
            }
        } else {
            int expected = 0;
            int count = 0;
            for (int offset = result.indexOf(string, expected); 0 <= offset; offset = result.indexOf(string, expected)) {
                count++;
                if (offset != expected) {
                    System.err.format("\"%s\".repeat(%d)%n", truncate(string), repeat);
                    System.err.format("Result \"%s\"%n", truncate(result));
                    System.err.format("Repeat expected at %d, found at = %d%n", expected, offset);
                    throw new RuntimeException();
                }
                expected += string.length();
            }
            if (count != repeat) {
                System.err.format("\"%s\".repeat(%d)%n", truncate(string), repeat);
                System.err.format("Result \"%s\"%n", truncate(result));
                System.err.format("Repeat count expected to be %d, found %d%n", repeat, count);
                throw new RuntimeException();
            }
        }
        return string;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9082().verify(result, string, repeat);
    }
}
