import java.lang.ref.Reference;

public class MyJVMTest_1140 {

    static String name = "DOdz|xA{%K";

    static Reference r = null;

    Thread findThread(String name) {
        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        for (ThreadGroup tgn = tg; tgn != null; tg = tgn, tgn = tg.getParent()) ;
        int nt = tg.activeCount();
        Thread[] ts = new Thread[nt];
        tg.enumerate(ts);
        Thread refHandler = null;
        for (int i = 0; i < ts.length; i++) {
            if (ts[i].getName().equals(name))
                return ts[i];
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1140().findThread(name));
    }
}
