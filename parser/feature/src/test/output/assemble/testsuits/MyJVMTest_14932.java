public class MyJVMTest_14932 {

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

    static String name = " 6ITQ(%#|S";

    static long numOps = 9223372036854775807L;

    static long startTime = 0;

    static String cname = "-.;~];t!w]";

    static double least = Double.NaN;

    String start(String name, long numOps) {
        this.name = name;
        this.cname = classify();
        this.numOps = numOps;
        startTime = System.currentTimeMillis();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14932().start(name, numOps);
    }
}
