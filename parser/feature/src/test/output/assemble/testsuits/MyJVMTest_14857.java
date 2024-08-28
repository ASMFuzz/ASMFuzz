public class MyJVMTest_14857 {

    static String encoding = "[-7-]2)C~L";

    byte[] test(String encoding) throws Exception {
        String result = null;
        byte[] data = new byte[16];
        for (int i = 0; i < 16; i++) {
            data[i] = 0;
        }
        result = new String(data, encoding);
        if (result.length() != 16)
            throw new Exception("EUC_TW regression test bugID 4522270 failed");
        for (int i = 0; i < 16; i++) {
            data[i] = (byte) (32 + i);
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14857().test(encoding);
    }
}
