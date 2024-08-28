import java.util.*;
import javax.management.*;

public class MyJVMTest_15638 {

    static String[] ss = { "kE}JE(fv~/", ".U%q13Fk'V", "[A0%+^Y;tT", "%xfVhap&0!", "wA~>%\\-CRt", "F?<|$CB'eO", "i80_p}+_05", "9zG68H2qq9", "]NZ:&=jln:", "R^%RDu/mwt" };

    String scanWord(String[] ss) throws Exception {
        String s = ss[0];
        int space = s.indexOf(' ');
        int rpar = s.indexOf(')');
        if (space < 0 && rpar < 0) {
            ss[0] = "";
            return s;
        }
        int stop;
        if (space >= 0 && rpar >= 0)
            stop = Math.min(space, rpar);
        else
            stop = Math.max(space, rpar);
        String word = s.substring(0, stop);
        ss[0] = s.substring(stop);
        return word;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15638().scanWord(ss));
    }
}
