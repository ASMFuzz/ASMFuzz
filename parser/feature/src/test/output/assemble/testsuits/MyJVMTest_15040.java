import java.io.*;
import java.net.URI;

public class MyJVMTest_15040 {

    static String cfileParam1Param1Param1 = "mC\"U=3OT~c";

    static String cfileParam1Param1Param2 = "7FCs2|@^YI";

    static String cfileParam1Param1Param3 = "QhT~kpsn0;";

    static String cfileParam1Param1Param4 = "ughOZS-{Y2";

    static String cfileParam1Param1Param5 = "[IQlm){P:B";

    static URI cfileParam1Param1 = new URI(cfileParam1Param1Param1, cfileParam1Param1Param2, cfileParam1Param1Param3, cfileParam1Param1Param4, cfileParam1Param1Param5);

    static File cfileParam1 = new File(cfileParam1Param1);

    static String cfileParam2 = "@7-s\"R+\\IM";

    static RandomAccessFile cfile = new RandomAccessFile(cfileParam1, cfileParam2);

    long getFirstAttributePos(RandomAccessFile cfile) throws Exception {
        cfile.seek(0);
        int v1, v2;
        v1 = cfile.readInt();
        v1 = cfile.readUnsignedShort();
        v2 = cfile.readUnsignedShort();
        v1 = cfile.readUnsignedShort();
        for (; v1 > 1; v1--) {
            byte tag = cfile.readByte();
            switch(tag) {
                case 7:
                case 8:
                    cfile.skipBytes(2);
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    cfile.skipBytes(4);
                    break;
                case 5:
                case 6:
                    cfile.skipBytes(8);
                    break;
                case 1:
                    v2 = cfile.readUnsignedShort();
                    cfile.skipBytes(v2);
                    break;
                default:
                    throw new Exception("Unexpected tag in CPool: [" + tag + "] at " + Long.toHexString(cfile.getFilePointer()));
            }
        }
        cfile.skipBytes(6);
        v1 = cfile.readUnsignedShort();
        cfile.skipBytes(3 * v1);
        v1 = cfile.readUnsignedShort();
        for (; v1 > 0; v1--) {
            cfile.skipBytes(6);
            v2 = cfile.readUnsignedShort();
            if (v2 > 0) {
                return cfile.getFilePointer();
            }
        }
        v1 = cfile.readUnsignedShort();
        for (; v1 > 0; v1--) {
            cfile.skipBytes(6);
            v2 = cfile.readUnsignedShort();
            if (v2 > 0) {
                return cfile.getFilePointer();
            }
        }
        v1 = cfile.readUnsignedShort();
        if (v1 > 0) {
            return cfile.getFilePointer();
        }
        return -1L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15040().getFirstAttributePos(cfile));
    }
}
