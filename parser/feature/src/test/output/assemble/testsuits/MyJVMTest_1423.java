import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1423 {

    static int button = 0;

    static int modifiers = 0;

    static int modifiersStandard = 0;

    static int modifiersEx = 0;

    static int modifiersExStandard = 665050013;

    static Frame f = null;

    int dumpValues(int button, int modifiers, int modifiersStandard, int modifiersEx, int modifiersExStandard) {
        System.out.println("Button = " + button + "Modifiers = " + modifiers + " standard = " + modifiersStandard);
        System.out.println("                   ModifiersEx = " + modifiersEx + " standardEx = " + modifiersExStandard);
        return modifiersStandard;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1423().dumpValues(button, modifiers, modifiersStandard, modifiersEx, modifiersExStandard);
    }
}
