public class MyJVMTest_7144 {

    static int len = 9;

    static String[] garbage_array = {"!H`Ez]q|:^","~iL|26a}ZA",")+rFFNe^p-","+$tfQ'c7R)","Z$u\"q:$M+T","t@a&P`{]v>","2TT{;yP>Mg",".~jA~OsB)<","|&F|oSVz4c","</34dPk/(&"};

    int create_garbage(int len) {
        len = Math.max(len, 1024);
        String[] array = new String[len];
        for (int index = 0; index < len; index++) {
            array[index] = "String " + index;
        }
        garbage_array = array;
        return len;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7144().create_garbage(len);
    }
}
