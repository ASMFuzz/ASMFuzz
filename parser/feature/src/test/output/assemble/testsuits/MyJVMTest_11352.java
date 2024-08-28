import javax.sound.midi.Instrument;

public class MyJVMTest_11352 {

    static Instrument inst = null;

    static Instrument[] insts = { null, null, null, null, null, null, null, null, null, null };

    boolean isInstrumentExist(Instrument inst, Instrument[] insts) {
        for (int i = 0; i < insts.length; i++) {
            if (inst.equals(insts[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11352().isInstrumentExist(inst, insts));
    }
}
