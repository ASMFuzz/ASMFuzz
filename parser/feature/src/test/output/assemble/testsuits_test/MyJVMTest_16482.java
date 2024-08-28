public class MyJVMTest_16482 {

    static String name = "ZZPJ+_VG+>";

    static double least = Double.NaN;

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
        System.out.println(new MyJVMTest_16482().classify());
    }
}
