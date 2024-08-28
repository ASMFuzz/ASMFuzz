public class MyJVMTest_13251 {

    static String[] array = {">rJ:|/s-|E","dHDr|Kf<ZU","F%#o[8/r&;","}SJ1~MT Bf","0z^a9/eNdj","!9vyT-0nv1","WG %^Pu2?>","],*@-TLg09","a]=J`M]|t!","HgP>twT/c+"};

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
        new MyJVMTest_13251().test(array);
    }
}
