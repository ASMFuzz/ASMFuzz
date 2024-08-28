public class MyJVMTest_6970 {

    static String name = "jlH}whCc>;";

    static double least = 0d;

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6970().classify());
    }
}
