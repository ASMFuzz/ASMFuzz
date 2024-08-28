import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_10636 {

    static int button = 7;

    static int modifiers = 7;

    static int modifiersStandard = 0;

    static int modifiersEx = 9;

    static int modifiersExStandard = 0;

    static Frame f = null;

    int dumpValues(int button, int modifiers, int modifiersStandard, int modifiersEx, int modifiersExStandard) {
        System.out.println("Button = " + button + "Modifiers = " + modifiers + " standard = " + modifiersStandard);
        System.out.println("                   ModifiersEx = " + modifiersEx + " standardEx = " + modifiersExStandard);
        return modifiersStandard;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10636().dumpValues(button, modifiers, modifiersStandard, modifiersEx, modifiersExStandard);
    }
}
