import java.beans.XMLDecoder;

public class MyJVMTest_8333 {

    static char ch = 'P';

    static String name = "<(7Z <Otmr";

    static int depth = 3;

    StringBuilder print(char ch, String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.depth; i++) sb.append(' ');
        sb.append(ch).append(' ').append(name);
        System.out.println(sb.toString());
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8333().print(ch, name);
    }
}
