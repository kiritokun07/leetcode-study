package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:48:49
 */
public class MyClientTest_1501_2000 {

    MySolution_1501_2000 solution = new MySolution_1501_2000();

    /**
     * 1656. 设计有序流
     * https://leetcode.cn/problems/design-an-ordered-stream/
     */
    @Test
    public void no1656() {
        OrderedStream orderedStream = new OrderedStream(5);
        Assertions.assertEquals(orderedStream.insert(3, "ccccc").size(), 0);
        Assertions.assertEquals(orderedStream.insert(1, "aaaaa").get(0), "aaaaa");
        List<String> bbbbb = orderedStream.insert(2, "bbbbb");
        Assertions.assertEquals(bbbbb.get(0), "bbbbb");
        Assertions.assertEquals(bbbbb.get(1), "ccccc");
        Assertions.assertEquals(orderedStream.insert(5, "eeeee").size(), 0);
        List<String> ddddd = orderedStream.insert(4, "ddddd");
        Assertions.assertEquals(ddddd.get(0), "ddddd");
        Assertions.assertEquals(ddddd.get(1), "eeeee");
    }

}
