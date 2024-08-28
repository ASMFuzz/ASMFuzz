public class MyJVMTest_6686 {

    String classify() {
        if (name.startsWith("Get"))
            return "Get                    ";
        else if (name.startsWith("Put"))
            return "Put                    ";
        else if (name.startsWith("Remove"))
            return "Remove                 ";
        else if (name.startsWith("Iter"))
            return "Iter                   ";
        else
            return null;
    }

    static String name = " c1Uvo@/@^";

    static long numOps = 0;

    static long startTime = 0;

    static String cname = "AoDEeung$~";

    String start(String name, long numOps) {
        this.name = name;
        this.cname = classify();
        this.numOps = numOps;
        startTime = System.currentTimeMillis();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6686().start(name, numOps);
    }
}
