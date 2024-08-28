public class MyJVMTest_5501 {

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

    static String name = "?vcG$4nblx";

    static long numOps = 0;

    static long startTime = 9223372036854775807L;

    static String cname = "C)[-m@F*p-";

    static double least = 0d;

    String start(String name, long numOps) {
        this.name = name;
        this.cname = classify();
        this.numOps = numOps;
        startTime = System.currentTimeMillis();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5501().start(name, numOps);
    }
}
