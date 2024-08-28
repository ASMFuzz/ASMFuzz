import java.lang.ref.Reference;

public class MyJVMTest_10335 {

    static String name = "@`gB*3.2TS";

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
        System.out.println(new MyJVMTest_10335().findThread(name));
    }
}
