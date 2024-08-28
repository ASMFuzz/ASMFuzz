import java.io.ByteArrayInputStream;

public class MyJVMTest_16683 {

    static String base64 = "{SKT17Z$c`";

    static Properties TEST_PROPS = null;

    static String TEST_SER_BASE64 = "rO0ABXNyABRqYXZhLnV0aWwuUHJvcGVydGllczkS0HpwNj6YAgABTAAIZGVmYXVs" + "dHN0ABZMamF2YS91dGlsL1Byb3BlcnRpZXM7eHIAE2phdmEudXRpbC5IYXNodGFi" + "bGUTuw8lIUrkuAMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAI" + "dwgAAAALAAAABHQAA29uZXQAA3R3b3QABHNodXR0AARkb29ydAAGYnVja2xldAAE" + "c2hvZXQABXRocmVldAAEZm91cnhw";

    static String INDENT = "   ";

    String dumpBase64SerialStream(String base64) {
        final StringBuilder sb = new StringBuilder();
        sb.append(INDENT).append(" ").append('\n');
        sb.append(INDENT).append(" private static final String TEST_SER_BASE64 = ").append("\n").append(INDENT).append("      ");
        final int last = base64.length() - 1;
        for (int i = 0; i < base64.length(); i++) {
            if (i % 64 == 0)
                sb.append("\"");
            sb.append(base64.charAt(i));
            if (i % 64 == 63 || i == last) {
                sb.append("\"");
                if (i == last)
                    sb.append(";\n");
                else
                    sb.append("\n").append(INDENT).append("    + ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16683().dumpBase64SerialStream(base64));
    }
}
