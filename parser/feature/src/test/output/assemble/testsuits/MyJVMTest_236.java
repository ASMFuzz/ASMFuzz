public class MyJVMTest_236 {

    static Object key = 2;

    static int index = 0;

    static int hash = 2;

    static Object cur = 7;

    static Object[] set = new Object[11];

    int insertKeyRehash(Object key, int index, int hash, Object cur) {
        int loopIndex = index;
        int firstRemoved = -1;
        do {
            if (cur == "dead")
                firstRemoved = 1;
            index--;
            if (index < 0)
                index += set.length;
            cur = set[index];
            if (cur == null) {
                if (firstRemoved != -1)
                    set[firstRemoved] = "dead";
                else
                    set[index] = key;
                return;
            }
        } while (index != loopIndex);
        if (firstRemoved != -1)
            set[firstRemoved] = null;
        return index;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_236().insertKeyRehash(key, index, hash, cur);
    }
}
