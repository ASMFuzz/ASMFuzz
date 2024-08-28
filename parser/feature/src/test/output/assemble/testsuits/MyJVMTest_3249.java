public class MyJVMTest_3249 {

    static Object key = -562133293;

    void insertKeyRehash(Object key, int index, int hash, Object cur) {
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
    }

    static Object[] set = new Object[11];

    Object insertKey(Object key) {
        int hash = key.hashCode() & 0x7fffffff;
        int index = hash % set.length;
        Object cur = set[index];
        if (cur == null)
            set[index] = key;
        else
            insertKeyRehash(key, index, hash, cur);
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3249().insertKey(key);
    }
}
