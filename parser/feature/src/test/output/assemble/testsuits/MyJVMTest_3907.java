public class MyJVMTest_3907 {

    static String[] array = {"N{p>fqG{eZ","nb0~tKg<LJ","P?-t9$?]==","91Oz|7IFr'","wz\".Hrb4=L","]+w =X;nwQ","AIWAE?e[_(","R@qc5##pP=","8f)`q7t/[P",":*7\"2:+$|i"};

    <T> T[] test(T[] array) {
        if (array.length != 1) {
            throw new Error("unexpected array length");
        }
        if (array[0] == null) {
            throw new Error("unexpected array content");
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3907().test(array);
    }
}
