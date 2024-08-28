import java.util.Random;

public class MyJVMTest_2922 {

    // static int length = 816827863;
    static int length = 8168;

    String randomString(int length) throws Exception {
        char[] chars = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            chars[i] = (char) ('0' + r.nextInt(26));
        }
        return new String(chars);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2922().randomString(length));
    }
}
