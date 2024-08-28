public class MyJVMTest_13423 {

    static byte[] data = { 21, -55, -17, -51, 87, -75, 95, -20, 14, -12 };

    String getMessageString(byte[] data) {
        String s;
        if (data == null) {
            s = "<null>";
        } else if (data.length == 0) {
            s = "0-sized array";
        } else {
            int status = data[0] & 0xFF;
            if (data.length <= 3) {
                if (status < 240) {
                    s = "command 0x" + Integer.toHexString(status & 0xF0) + " channel " + (status & 0x0F);
                } else {
                    s = "status 0x" + Integer.toHexString(status);
                }
                if (data.length > 1) {
                    s += " data 0x" + Integer.toHexString(data[1] & 0xFF);
                    if (data.length > 2) {
                        s += " 0x" + Integer.toHexString(data[2] & 0xFF);
                    }
                }
            } else {
                s = "status " + Integer.toHexString(status) + " and length " + data.length + " bytes";
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13423().getMessageString(data));
    }
}
