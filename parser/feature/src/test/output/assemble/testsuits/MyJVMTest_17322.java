import static java.awt.image.BufferedImage.*;

public class MyJVMTest_17322 {

    static int t = 2;

    static int w = 10, h = 10;

    String textFor(int t) {
        switch(t) {
            case TYPE_INT_ARGB:
                return "ARGB";
            case TYPE_INT_RGB:
                return "RGB";
            case TYPE_4BYTE_ABGR:
                return "4BYTEABGR";
            case TYPE_3BYTE_BGR:
                return "3BYTEBGR";
            case TYPE_USHORT_555_RGB:
                return "USHORT_555_RGB";
            case TYPE_USHORT_565_RGB:
                return "USHORT_565_RGB";
            case TYPE_USHORT_GRAY:
                return "USHORT_GRAY";
            default:
                return "OTHER";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17322().textFor(t));
    }
}
