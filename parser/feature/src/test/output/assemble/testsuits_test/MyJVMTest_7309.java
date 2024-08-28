public class MyJVMTest_7309 {

    static String[] o = { ":Y3YU~@(PR", "ARZ A(k:QI", ")-2F?)X8Gv", "Ccf%Pb,l+$", "d3[H&u[\"A3", "~~dAr{owKt", "w[~C 8{N\"z", "sY08%SD.bK", "^:yhAH:\"%G", "kp <PFKd~/" };

    static int nonStaticPublicField = 203050107;

    static int nonStaticFinalPublicField = 6;

    int getLengthStatic(String[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7309().getLengthStatic(o));
    }
}
