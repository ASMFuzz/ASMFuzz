import java.util.*;
import javax.management.*;

public class MyJVMTest_6167 {

    static String[] ss = { "0TvQ$8]?%]", ",Pxv)G>CpM", "AmzNN*g,I\\", "ytRAp~V<+a", "B=}k?:r(0O", "SZLlRjo5A*", "c'0$RK5ntb", "f'X$>,$Hyn", "d^\\Y,~k2</", "4Oz~BkAr=b" };

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
        System.out.println(new MyJVMTest_6167().scanWord(ss));
    }
}
