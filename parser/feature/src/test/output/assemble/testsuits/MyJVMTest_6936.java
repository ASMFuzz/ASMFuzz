import javax.sound.midi.MidiDevice;

public class MyJVMTest_6936 {

    static MidiDevice device = null;

    static int successfulTests = 0;

    MidiDevice testDevice(MidiDevice device) throws Exception {
        boolean timestampsAvailable = false;
        boolean timestampPrecisionOk = false;
        try {
            device.open();
            long timestamp = device.getMicrosecondPosition();
            timestampsAvailable = (timestamp != -1);
            long systemTime1 = System.currentTimeMillis();
            long deviceTime1 = device.getMicrosecondPosition();
            Thread.sleep(5000);
            long systemTime2 = System.currentTimeMillis();
            long deviceTime2 = device.getMicrosecondPosition();
            long systemDuration = systemTime2 - systemTime1;
            long deviceDuration = (deviceTime2 - deviceTime1) / 1000;
            long delta = Math.abs(systemDuration - deviceDuration);
            timestampPrecisionOk = (delta <= 500);
        } catch (Throwable t) {
            System.out.println("  - Caught exception. Not failed.");
            System.out.println("  - " + t.toString());
            return;
        } finally {
            device.close();
        }
        if (!timestampsAvailable) {
            throw new Exception("timestamps are not supported");
        }
        if (!timestampPrecisionOk) {
            throw new Exception("device timer not precise enough");
        }
        successfulTests++;
        return device;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6936().testDevice(device);
    }
}
