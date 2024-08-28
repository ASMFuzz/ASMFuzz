import java.io.*;

public class MyJVMTest_3169 {

    static char ch = Character.MAX_VALUE;

    int hexToBin(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        }
        if ('A' <= ch && ch <= 'F') {
            return ch - 'A' + 10;
        }
        if ('a' <= ch && ch <= 'f') {
            return ch - 'a' + 10;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3169().hexToBin(ch));
    }
}
