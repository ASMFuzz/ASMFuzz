public class MyJVMTest_16182 {

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

    static String name = "ZhIyVuRJpd";

    static long numOps = -9223372036854775808L;

    static long startTime = 9223372036854775807L;

    static String cname = "rt.[=9YL`a";

    String start(String name, long numOps) {
        this.name = name;
        this.cname = classify();
        this.numOps = numOps;
        startTime = System.currentTimeMillis();
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16182().start(name, numOps);
    }
}
