public class MyJVMTest_15401 {

    static Short j1 = 14442;

    short remi_sump2(Short j1) {
        Short j2 = Short.valueOf((short) 1);
        for (int i = 0; i < 1000; i++) {
            j1 = new Short((short) (j1 + 1));
            j2 = (short) (j2 + 2);
        }
        return (short) (j1 + j2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15401().remi_sump2(j1));
    }
}
