public class MyJVMTest_12571 {

    static String name = "#)jcJt,uk3";

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
        System.out.println(new MyJVMTest_12571().classify());
    }
}
