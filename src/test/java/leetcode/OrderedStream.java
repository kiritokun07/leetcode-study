package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OrderedStream {

    private final String[] streamList;
    private int ptr;
    private final int length;

    public OrderedStream(int n) {
        streamList = new String[n];
        ptr = 1;
        length = n;
    }

    public List<String> insert(int idKey, String value) {
        streamList[idKey - 1] = value;
        if (ptr != idKey) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>(length);
        for (int i = idKey; i <= length; i++) {
            if (streamList[i - 1] == null) {
                break;
            }
            result.add(streamList[i - 1]);
            ptr = i + 1;
        }
        return result;
    }
}