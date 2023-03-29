package leetcode;

import leetcode.node.AuthenticationManager;
import leetcode.node.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:48:49
 */
public class MyClientTest_1501_2000 {

    MySolution_1501_2000 solution = new MySolution_1501_2000();

    /**
     * （正在写）1574. 删除最短的子数组使剩余数组有序
     * 中等
     * https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
     */
    @Test
    public void no1574() {
        Assertions.assertEquals(solution.findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}), 3);
        Assertions.assertEquals(solution.findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}), 4);
        Assertions.assertEquals(solution.findLengthOfShortestSubarray(new int[]{1, 2, 3}), 0);
        Assertions.assertEquals(solution.findLengthOfShortestSubarray(new int[]{1}), 0);
    }

    /**
     * 1582. 二进制矩阵中的特殊位置
     * 简单
     * https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
     */
    @Test
    public void no1582() {
        Assertions.assertEquals(solution.numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}), 1);
        Assertions.assertEquals(solution.numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}), 3);
        Assertions.assertEquals(solution.numSpecial(new int[][]{{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}), 2);
        Assertions.assertEquals(solution.numSpecial(new int[][]{{0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}}), 3);
    }

    /**
     * （正在写）1590. 使数组和能被 P 整除
     * 中等
     * https://leetcode.cn/problems/make-sum-divisible-by-p/
     */
    @Test
    public void no1590() {
        Assertions.assertEquals(solution.minSubarray(new int[]{3, 1, 4, 2}, 6), 1);
        Assertions.assertEquals(solution.minSubarray(new int[]{6, 3, 5, 2}, 9), 2);
        Assertions.assertEquals(solution.minSubarray(new int[]{1, 2, 3}, 3), 0);
        Assertions.assertEquals(solution.minSubarray(new int[]{1, 2, 3}, 7), -1);
        Assertions.assertEquals(solution.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3), 0);
    }

    /**
     * 1592. 重新排列单词间的空格
     * 简单
     * https://leetcode.cn/problems/rearrange-spaces-between-words/
     */
    @Test
    public void no1592() {
        Assertions.assertEquals(solution.reorderSpaces("  this   is  a sentence "), "this   is   a   sentence");
        Assertions.assertEquals(solution.reorderSpaces(" practice   makes   perfect"), "practice   makes   perfect ");
        Assertions.assertEquals(solution.reorderSpaces("hello   world"), "hello   world");
        Assertions.assertEquals(solution.reorderSpaces("  walks  udp package   into  bar a"), "walks  udp  package  into  bar  a ");
        Assertions.assertEquals(solution.reorderSpaces("a"), "a");
    }

    /**
     * 1598. 文件夹操作日志搜集器
     * 简单
     * https://leetcode.cn/problems/crawler-log-folder/
     */
    @Test
    public void no1598() {
        Assertions.assertEquals(solution.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}), 2);
        Assertions.assertEquals(solution.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}), 3);
        Assertions.assertEquals(solution.minOperations(new String[]{"d1/", "../", "../", "../"}), 0);
        Assertions.assertEquals(solution.minOperations(new String[]{"./", "../", "./"}), 0);
    }

    /**
     * （正在写）1604. 警告一小时内使用相同员工卡大于等于三次的人
     * 中等
     * https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
     */
    @Test
    public void no1604() {
        Assertions.assertEquals(solution.alertNames(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"}, new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}).toString(), "[daniel]");
        Assertions.assertEquals(solution.alertNames(new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"}, new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}).toString(), "[bob]");
        Assertions.assertEquals(solution.alertNames(new String[]{"john", "john", "john"}, new String[]{"23:58", "23:59", "00:01"}).toString(), "[]");
        Assertions.assertEquals(solution.alertNames(new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"}, new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}).toString(), "[clare, leslie]");
    }

    /**
     * 1608. 特殊数组的特征值
     * 简单
     * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
     */
    @Test
    public void no1608() {
        Assertions.assertEquals(solution.specialArray(new int[]{3, 5}), 2);
        Assertions.assertEquals(solution.specialArray(new int[]{0, 0}), -1);
        Assertions.assertEquals(solution.specialArray(new int[]{0, 4, 3, 0, 4}), 3);
        Assertions.assertEquals(solution.specialArray(new int[]{3, 6, 7, 7, 0}), -1);
    }

    /**
     * 1615. 最大网络秩
     * 中等
     * https://leetcode.cn/problems/maximal-network-rank/
     */
    @Test
    public void no1615() {
        Assertions.assertEquals(solution.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}), 4);
        Assertions.assertEquals(solution.maximalNetworkRank(5, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}), 5);
        Assertions.assertEquals(solution.maximalNetworkRank(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}}), 5);
    }

    /**
     * 1619. 删除某些元素后的数组均值
     * 简单
     * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
     */
    @Test
    public void no1619() {
        MyUtils.doubleEqual(solution.trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}), 2.00000);
        MyUtils.doubleEqual(solution.trimMean(new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0}), 4.00000);
        MyUtils.doubleEqual(solution.trimMean(new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4}), 4.77778);
        MyUtils.doubleEqual(solution.trimMean(new int[]{9, 7, 8, 7, 7, 8, 4, 4, 6, 8, 8, 7, 6, 8, 8, 9, 2, 6, 0, 0, 1, 10, 8, 6, 3, 3, 5, 1, 10, 9, 0, 7, 10, 0, 10, 4, 1, 10, 6, 9, 3, 6, 0, 0, 2, 7, 0, 6, 7, 2, 9, 7, 7, 3, 0, 1, 6, 1, 10, 3}), 5.27778);
        MyUtils.doubleEqual(solution.trimMean(new int[]{4, 8, 4, 10, 0, 7, 1, 3, 7, 8, 8, 3, 4, 1, 6, 2, 1, 1, 8, 0, 9, 8, 0, 3, 9, 10, 3, 10, 1, 10, 7, 3, 2, 1, 4, 9, 10, 7, 6, 4, 0, 8, 5, 1, 2, 1, 6, 2, 5, 0, 7, 10, 9, 10, 3, 7, 10, 5, 8, 5, 7, 6, 7, 6, 10, 9, 5, 10, 5, 5, 7, 2, 10, 7, 7, 8, 2, 0, 1, 1}), 5.29167);
    }

    /**
     * 1624. 两个相同字符之间的最长子字符串
     * 简单
     * https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
     */
    @Test
    public void no1624() {
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("aa"), 0);
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("abca"), 2);
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("cbzxy"), -1);
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("cabbac"), 4);
    }

    /**
     * 1636. 按照频率将数组升序排序
     * 简单
     * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
     */
    @Test
    public void no1636() {
        Assertions.assertEquals(Arrays.toString(solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3})), "[3, 1, 1, 2, 2, 2]");
        Assertions.assertEquals(Arrays.toString(solution.frequencySort(new int[]{2, 3, 1, 3, 2})), "[1, 3, 3, 2, 2]");
        Assertions.assertEquals(Arrays.toString(solution.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})), "[5, -1, 4, 4, -6, -6, 1, 1, 1]");
    }

    /**
     * 1640. 能否连接形成数组
     * 简单
     * https://leetcode.cn/problems/check-array-formation-through-concatenation/
     * 理解：不断选择二维数组的当前的首位，拼接成一维数组
     */
    @Test
    public void no1640() {
        Assertions.assertTrue(solution.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
        Assertions.assertFalse(solution.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
        Assertions.assertTrue(solution.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
    }

    /**
     * 1641. 统计字典序元音字符串的数目
     * 中等
     * https://leetcode.cn/problems/count-sorted-vowel-strings/
     */
    @Test
    public void no1641() {
        Assertions.assertEquals(solution.countVowelStrings(1), 5);
        Assertions.assertEquals(solution.countVowelStrings(2), 15);
        Assertions.assertEquals(solution.countVowelStrings(33), 66045);
    }

    /**
     * 1652. 拆炸弹
     * 简单
     * https://leetcode.cn/problems/defuse-the-bomb/
     */
    @Test
    public void no1652() {
        Assertions.assertEquals(Arrays.toString(solution.decrypt(new int[]{5, 7, 1, 4}, 3)), "[12, 10, 16, 13]");
        Assertions.assertEquals(Arrays.toString(solution.decrypt(new int[]{1, 2, 3, 4}, 0)), "[0, 0, 0, 0]");
        Assertions.assertEquals(Arrays.toString(solution.decrypt(new int[]{2, 4, 9, 3}, -2)), "[12, 5, 6, 13]");
        Assertions.assertEquals(Arrays.toString(solution.decrypt(new int[]{10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6}, -4)), "[22, 26, 22, 28, 29, 22, 19, 22, 18, 21, 28, 19]");
    }

    /**
     * 1656. 设计有序流
     * 简单
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

    /**
     * 1662. 检查两个字符串数组是否相等
     * 简单
     * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
     */
    @Test
    public void no1662() {
        Assertions.assertTrue(solution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        Assertions.assertFalse(solution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        Assertions.assertTrue(solution.arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    /**
     * 1664. 生成平衡数组的方案数
     * 中等
     * https://leetcode.cn/problems/ways-to-make-a-fair-array/
     */
    @Test
    public void no1664() {
        Assertions.assertEquals(solution.waysToMakeFair(new int[]{2, 1, 6, 4}), 1);
        Assertions.assertEquals(solution.waysToMakeFair(new int[]{1, 1, 1}), 3);
        Assertions.assertEquals(solution.waysToMakeFair(new int[]{1, 2, 3}), 0);
    }

    /**
     * 1669. 合并两个链表
     * 中等
     * https://leetcode.cn/problems/merge-in-between-linked-lists/
     */
    @Test
    public void no1669() {
        ListNode listNode1 = solution.mergeInBetween(MyUtils.array2ListNode(new Integer[]{0, 1, 2, 3, 4, 5}), 3, 4, MyUtils.array2ListNode(new Integer[]{1000000, 1000001, 1000002}));
        Assertions.assertTrue(MyUtils.listNodeEqual(listNode1, MyUtils.array2ListNode(new Integer[]{0, 1, 2, 1000000, 1000001, 1000002, 5})));
        ListNode listNode2 = solution.mergeInBetween(MyUtils.array2ListNode(new Integer[]{0, 1, 2, 3, 4, 5, 6}), 2, 5, MyUtils.array2ListNode(new Integer[]{1000000, 1000001, 1000002, 1000003, 1000004}));
        Assertions.assertTrue(MyUtils.listNodeEqual(listNode2, MyUtils.array2ListNode(new Integer[]{0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6})));
    }

    /**
     * 1684. 统计一致字符串的数目
     * 简单
     * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
     */
    @Test
    public void no1684() {
        Assertions.assertEquals(solution.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}), 2);
        Assertions.assertEquals(solution.countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}), 7);
        Assertions.assertEquals(solution.countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}), 4);
    }

    /**
     * 1694. 重新格式化电话号码
     * 简单
     * https://leetcode.cn/problems/reformat-phone-number/
     */
    @Test
    public void no1694() {
        Assertions.assertEquals(solution.reformatNumber("1-23-45 6"), "123-456");
        Assertions.assertEquals(solution.reformatNumber("123 4-567"), "123-45-67");
        Assertions.assertEquals(solution.reformatNumber("123 4-5678"), "123-456-78");
        Assertions.assertEquals(solution.reformatNumber("12"), "12");
        Assertions.assertEquals(solution.reformatNumber("--17-5 229 35-39475 "), "175-229-353-94-75");
    }

    /**
     * 1700. 无法吃午餐的学生数量
     * 简单
     * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
     */
    @Test
    public void no1700() {
        Assertions.assertEquals(solution.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}), 0);
        Assertions.assertEquals(solution.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}), 3);
        Assertions.assertEquals(solution.countStudents(new int[]{0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0}), 1);
    }

    /**
     * 1704. 判断字符串的两半是否相似
     * 简单
     * https://leetcode.cn/problems/determine-if-string-halves-are-alike/
     */
    @Test
    public void no1704() {
        Assertions.assertTrue(solution.halvesAreAlike("book"));
        Assertions.assertFalse(solution.halvesAreAlike("textbook"));
    }

    /**
     * 1710. 卡车上的最大单元数
     * 简单
     * https://leetcode.cn/problems/maximum-units-on-a-truck/
     */
    @Test
    public void no1710() {
        Assertions.assertEquals(solution.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4), 8);
        Assertions.assertEquals(solution.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10), 91);
    }

    /**
     * 1742. 盒子中小球的最大数量
     * 简单
     * https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/
     */
    @Test
    public void no1742() {
        Assertions.assertEquals(solution.countBalls(1, 10), 2);
        Assertions.assertEquals(solution.countBalls(5, 15), 2);
        Assertions.assertEquals(solution.countBalls(19, 28), 2);
    }

    /**
     * 1768. 交替合并字符串
     * 简单
     * https://leetcode.cn/problems/merge-strings-alternately/
     */
    @Test
    public void no1768() {
        Assertions.assertEquals(solution.mergeAlternately("abc", "pqr"), "apbqcr");
        Assertions.assertEquals(solution.mergeAlternately("ab", "pqrs"), "apbqrs");
        Assertions.assertEquals(solution.mergeAlternately("abcd", "pq"), "apbqcd");
    }

    /**
     * 1773. 统计匹配检索规则的物品数量
     * 简单
     * https://leetcode.cn/problems/count-items-matching-a-rule/
     */
    @Test
    public void no1773() {
        List<List<String>> itemList1 = new ArrayList<>(3);
        itemList1.add(new ArrayList<String>() {{
            add("phone");
            add("blue");
            add("pixel");
        }});
        itemList1.add(new ArrayList<String>() {{
            add("computer");
            add("silver");
            add("lenovo");
        }});
        itemList1.add(new ArrayList<String>() {{
            add("phone");
            add("gold");
            add("iphone");
        }});
        Assertions.assertEquals(solution.countMatches(itemList1, "color", "silver"), 1);
        List<List<String>> itemList2 = new ArrayList<>(3);
        itemList2.add(new ArrayList<String>() {{
            add("phone");
            add("blue");
            add("pixel");
        }});
        itemList2.add(new ArrayList<String>() {{
            add("computer");
            add("silver");
            add("phone");
        }});
        itemList2.add(new ArrayList<String>() {{
            add("phone");
            add("gold");
            add("iphone");
        }});
        Assertions.assertEquals(solution.countMatches(itemList2, "type", "phone"), 2);
    }

    /**
     * 1790. 仅执行一次字符串交换能否使两个字符串相等
     * 简单
     * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/
     */
    @Test
    public void no1790() {
        Assertions.assertTrue(solution.areAlmostEqual("bank", "kanb"));
        Assertions.assertFalse(solution.areAlmostEqual("attack", "defend"));
        Assertions.assertTrue(solution.areAlmostEqual("kelb", "kelb"));
        Assertions.assertFalse(solution.areAlmostEqual("abcd", "dcba"));
    }

    /**
     * 1797. 设计一个验证系统
     * 中等
     * https://leetcode.cn/problems/design-authentication-manager/
     */
    @Test
    public void no1797() {
        AuthenticationManager manager = new AuthenticationManager(5);
        manager.renew("aaa", 1);
        manager.generate("aaa", 2);
        Assertions.assertEquals(manager.countUnexpiredTokens(6), 1);
        manager.generate("bbb", 7);
        manager.renew("aaa", 8);
        manager.renew("bbb", 10);
        Assertions.assertEquals(manager.countUnexpiredTokens(15), 0);
    }

    /**
     * 1798. 你能构造出连续值的最大数目
     * 中等
     * https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/
     */
    @Test
    public void no1798() {
        Assertions.assertEquals(solution.getMaximumConsecutive(new int[]{1, 3}), 2);
        Assertions.assertEquals(solution.getMaximumConsecutive(new int[]{1, 1, 1, 4}), 8);
        Assertions.assertEquals(solution.getMaximumConsecutive(new int[]{1, 4, 10, 3, 1}), 20);
    }

    /**
     * 1800. 最大升序子数组和
     * 简单
     * https://leetcode.cn/problems/maximum-ascending-subarray-sum/
     */
    @Test
    public void no1800() {
        Assertions.assertEquals(solution.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}), 65);
        Assertions.assertEquals(solution.maxAscendingSum(new int[]{10, 20, 30, 40, 50}), 150);
        Assertions.assertEquals(solution.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}), 33);
        Assertions.assertEquals(solution.maxAscendingSum(new int[]{100, 10, 1}), 100);
    }

    /**
     * 1805. 字符串中不同整数的数目
     * 简单
     * https://leetcode.cn/problems/number-of-different-integers-in-a-string/
     */
    @Test
    public void no1805() {
        Assertions.assertEquals(solution.numDifferentIntegers("a123bc34d8ef34"), 3);
        Assertions.assertEquals(solution.numDifferentIntegers("leet1234code234"), 2);
        Assertions.assertEquals(solution.numDifferentIntegers("a1b01c001"), 1);
    }

    /**
     * 1807. 替换字符串中的括号内容
     * 中等
     * https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
     */
    @Test
    public void no1807() {
        List<List<String>> k1 = new ArrayList<>();
        k1.add(Arrays.asList("name", "bob"));
        k1.add(Arrays.asList("age", "two"));
        Assertions.assertEquals(solution.evaluate("(name)is(age)yearsold", k1), "bobistwoyearsold");
        List<List<String>> k2 = new ArrayList<>();
        k2.add(Arrays.asList("a", "b"));
        Assertions.assertEquals(solution.evaluate("hi(name)", k2), "hi?");
        List<List<String>> k3 = new ArrayList<>();
        k3.add(Arrays.asList("a", "yes"));
        Assertions.assertEquals(solution.evaluate("(a)(a)(a)aaa", k3), "yesyesyesaaa");
    }

    /**
     * 1813. 句子相似性 III
     * 中等
     * https://leetcode.cn/problems/sentence-similarity-iii/
     */
    @Test
    public void no1813() {

    }

    /**
     * 1817. 查找用户活跃分钟数
     * 中等
     * https://leetcode.cn/problems/finding-the-users-active-minutes/
     */
    @Test
    public void no1817() {
        Assertions.assertEquals(Arrays.toString(solution.findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5)), "[0, 2, 0, 0, 0]");
        Assertions.assertEquals(Arrays.toString(solution.findingUsersActiveMinutes(new int[][]{{1, 1}, {2, 2}, {2, 3}}, 4)), "[1, 1, 0, 0]");
    }

    /**
     * 1822. 数组元素积的符号
     * 简单
     * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
     */
    @Test
    public void no1822() {
        Assertions.assertEquals(solution.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}), 1);
        Assertions.assertEquals(solution.arraySign(new int[]{1, 5, 0, 2, -3}), 0);
        Assertions.assertEquals(solution.arraySign(new int[]{-1, 1, -1, 1, -1}), -1);
    }

    /**
     * 1824. 最少侧跳次数
     * 中等
     * https://leetcode.cn/problems/minimum-sideway-jumps/
     */
    @Test
    public void no1824() {
        Assertions.assertEquals(solution.minSideJumps(new int[]{0, 1, 2, 3, 0}), 2);
        Assertions.assertEquals(solution.minSideJumps(new int[]{0, 1, 1, 3, 3, 0}), 0);
        Assertions.assertEquals(solution.minSideJumps(new int[]{0, 2, 1, 0, 3, 0}), 2);
    }

    /**
     * 1945. 字符串转化后的各位数字之和
     * 简单
     * https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
     */
    @Test
    public void no1945() {
        Assertions.assertEquals(solution.getLucky("iiii", 1), 36);
        Assertions.assertEquals(solution.getLucky("leetcode", 2), 6);
    }

}
