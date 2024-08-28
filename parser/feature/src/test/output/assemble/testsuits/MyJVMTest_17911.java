import java.beans.XMLDecoder;

public class MyJVMTest_17911 {

    static char ch = '.';

    static String name = "Yi<K++@n35";

    static int depth = 4;

    StringBuilder print(char ch, String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.depth; i++) sb.append(' ');
        sb.append(ch).append(' ').append(name);
        System.out.println(sb.toString());
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17911().print(ch, name);
    }
}
