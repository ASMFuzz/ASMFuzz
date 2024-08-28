import javax.sound.midi.MetaMessage;

public class MyJVMTest_13634 {

    static byte[] msgParam1 = { -8, -29, -9, 62, 79, 75, -74, -5, 29, 54 };

    static MetaMessage msg = new MetaMessage(msgParam1);

    void printMsg(MetaMessage msg, byte[] data) {
        System.out.println("" + msg.getLength() + " total bytes, type=" + msg.getType() + ", dataLength=" + data.length);
    }

    MetaMessage checkClone(MetaMessage msg) throws Exception {
        System.out.print("Original: ");
        byte[] msgData = msg.getData();
        printMsg(msg, msgData);
        MetaMessage msg2 = (MetaMessage) msg.clone();
        byte[] msg2Data = msg2.getData();
        System.out.print("Clone:    ");
        printMsg(msg2, msg2Data);
        if (msg2.getLength() != msg.getLength() || msg.getType() != msg2.getType() || msgData.length != msg2Data.length) {
            throw new Exception("cloned MetaMessage is not equal.");
        }
        int max = Math.min(msgData.length, 10);
        for (int i = 0; i < max; i++) {
            if (msgData[i] != msg2Data[i]) {
                throw new Exception("Cloned MetaMessage data is not equal.");
            }
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13634().checkClone(msg);
    }
}
