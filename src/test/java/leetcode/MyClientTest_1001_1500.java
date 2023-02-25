package leetcode;

import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:48:49
 */
public class MyClientTest_1001_1500 {

    MySolution_1001_1500 solution = new MySolution_1001_1500();

    /**
     * 1138. 字母板上的路径
     * 中等
     * https://leetcode.cn/problems/alphabet-board-path/
     */
    @Test
    public void no1138() {
        Assertions.assertEquals(solution.alphabetBoardPath("leet"), "DDR!UURRR!!DDD!");
        Assertions.assertEquals(solution.alphabetBoardPath("code"), "RR!DDRR!UUL!R!");
        Assertions.assertEquals(solution.alphabetBoardPath("buzz"), "R!DDDDL!D!!");
    }

    /**
     * （正在写）1139. 最大的以 1 为边界的正方形
     * 中等
     * https://leetcode.cn/problems/largest-1-bordered-square/
     */
    @Test
    public void no1139() {
        Assertions.assertEquals(solution.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}), 9);
        Assertions.assertEquals(solution.largest1BorderedSquare(new int[][]{{1, 1, 0, 0}}), 1);
    }

    /**
     * 1161. 最大层内元素和
     * 中等
     * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
     */
    @Test
    public void no1161() {
        TreeNode five = new TreeNode(7, null, null);
        TreeNode six = new TreeNode(-8, null, null);
        TreeNode two = new TreeNode(7, five, six);
        TreeNode three = new TreeNode(0, null, null);
        TreeNode one = new TreeNode(1, two, three);
        int maxLevelSum = solution.maxLevelSum(one);
        System.out.println("maxLevelSum = " + maxLevelSum);
        Assertions.assertEquals(maxLevelSum, 2);
    }

    /**
     * 1224. 最大相等频率
     * 困难
     * https://leetcode.cn/problems/maximum-equal-frequency/
     * 需要优化时间复杂度
     */
    @Test
    public void no1224() {
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}), 7);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5}), 13);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}), 8);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 1}), 2);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), 9);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}), 7);
    }

    /**
     * （正在写）1233. 删除子文件夹
     * 中等
     * https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
     */
    @Test
    public void no1233() {
        Assertions.assertEquals(solution.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}).stream().sorted().toString(), "[/a, /c/d, /c/f]");
        Assertions.assertEquals(solution.removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"}).stream().sorted().toString(), "[/a]");
        Assertions.assertEquals(solution.removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}).stream().sorted().toString(), "[/a/b/c, /a/b/ca, /a/b/d]");
    }

    /**
     * （正在写）1234. 替换子串得到平衡字符串
     * 中等
     * https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
     */
    @Test
    public void no1234() {
        Assertions.assertEquals(solution.balancedString("QWER"), 0);
        Assertions.assertEquals(solution.balancedString("QQWE"), 1);
        Assertions.assertEquals(solution.balancedString("QQQW"), 2);
        Assertions.assertEquals(solution.balancedString("QQQQ"), 3);
    }

    /**
     * 1282. 用户分组
     * 中等
     * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
     */
    @Test
    public void no1282() {
        int[] groupSizes1 = {3, 3, 3, 3, 3, 1, 3};
        assertGroupPeople(groupSizes1);
        int[] groupSizes2 = {2, 1, 3, 3, 3, 2};
        assertGroupPeople(groupSizes2);
    }

    /**
     * 1247. 交换字符使得字符串相同
     * 中等
     * https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
     */
    @Test
    public void no1247() {
        Assertions.assertEquals(solution.minimumSwap("xx", "yy"), 1);
        Assertions.assertEquals(solution.minimumSwap("xy", "yx"), 2);
        Assertions.assertEquals(solution.minimumSwap("xx", "xy"), -1);
        Assertions.assertEquals(solution.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"), 4);
    }

    /**
     * 验证这个数组的每个元素所在的list的大小都等于以数字为下表的原数组的值
     *
     * @param groupSizes 数组大小
     */
    public void assertGroupPeople(int[] groupSizes) {
        List<List<Integer>> peopleListList = solution.groupThePeople(groupSizes);
        for (List<Integer> peopList : peopleListList) {
            int size = peopList.size();
            for (Integer peop : peopList) {
                Assertions.assertEquals(groupSizes[peop], size);
            }
        }
    }

    /**
     * 1302. 层数最深叶子节点的和
     * 中等
     * https://leetcode.cn/problems/deepest-leaves-sum/
     */
    @Test
    public void no1302() {
        //array2TreeNode方法需要支持传null
        TreeNode treeNode1 = TreeNode.array2TreeNode2(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        Assertions.assertEquals(solution.deepestLeavesSum(treeNode1), 15);
        TreeNode treeNode2 = TreeNode.array2TreeNode(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        Assertions.assertEquals(solution.deepestLeavesSum(treeNode2), 19);
    }

    /**
     * 1331. 数组序号转换
     * 简单
     * https://leetcode.cn/problems/rank-transform-of-an-array/
     */
    @Test
    public void no1331() {
        int[] arr = {40, 10, 10, 20, 30};
        int[] transform = solution.arrayRankTransform(arr);
        System.out.println("transform = " + Arrays.toString(transform));
        //预期结果：[5,1,1,3,4]
    }

    /**
     * 1374. 生成每种字符都是奇数个的字符串
     * 简单
     * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
     */
    @Test
    public void no1374() {
        int n = 4;
        String generateTheString = solution.generateTheString(n);
        System.out.println("generateTheString = " + generateTheString);
    }

    /**
     * 1403. 非递增顺序的最小子序列
     * 简单
     * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
     */
    @Test
    public void no1403() {
        int[] nums = new int[]{4, 3, 10, 9, 8};
        List<Integer> subsequence = solution.minSubsequence(nums);
        Assertions.assertEquals(subsequence.get(0), 10);
        Assertions.assertEquals(subsequence.get(1), 9);
        int[] nums2 = new int[]{4, 4, 7, 6, 7};
        List<Integer> subsequence2 = solution.minSubsequence(nums2);
        Assertions.assertEquals(subsequence2.get(0), 7);
        Assertions.assertEquals(subsequence2.get(1), 7);
        Assertions.assertEquals(subsequence2.get(2), 6);
    }

    /**
     * 1408. 数组中的字符串匹配
     * 简单
     * https://leetcode.cn/problems/string-matching-in-an-array/
     */
    @Test
    public void no1408() {
        String[] words1 = new String[]{"mass", "as", "hero", "superhero"};
        List<String> matching1 = solution.stringMatching(words1);
        Assertions.assertEquals(matching1.get(0), "as");
        Assertions.assertEquals(matching1.get(1), "hero");

        String[] words2 = new String[]{"leetcode", "et", "code"};
        List<String> matching2 = solution.stringMatching(words2);
        Assertions.assertEquals(matching2.get(0), "et");
        Assertions.assertEquals(matching2.get(1), "code");

        String[] words3 = new String[]{"blue", "green", "bu"};
        List<String> matching3 = solution.stringMatching(words3);
        Assertions.assertEquals(matching3.size(), 0);
    }

    /**
     * 1413. 逐步求和得到正数的最小值
     * 简单
     * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
     */
    @Test
    public void no1413() {
        int[] nums1 = new int[]{-3, 2, -3, 4, 2};
        int value1 = solution.minStartValue(nums1);
        Assertions.assertEquals(value1, 5);

        int[] nums2 = new int[]{1, 2};
        int value2 = solution.minStartValue(nums2);
        Assertions.assertEquals(value2, 1);

        int[] nums3 = new int[]{1, -2, -3};
        int value3 = solution.minStartValue(nums3);
        Assertions.assertEquals(value3, 5);
    }

    /**
     * 1417. 重新格式化字符串
     * 简单
     * https://leetcode.cn/problems/reformat-the-string/
     */
    @Test
    public void no1417() {
        assertReformat("a0b1c2");
        Assertions.assertEquals(solution.reformat("leetcode"), "");
        Assertions.assertEquals(solution.reformat("1229857369"), "");
        assertReformat("covid2019");
        assertReformat("ab123");
    }

    /**
     * assert：排序等于原字符串排序，且交替是字母或字符串
     *
     * @param input 输入字符串
     */
    public void assertReformat(String input) {
        String output = solution.reformat(input);
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        char[] outputArr = output.toCharArray();
        Arrays.sort(outputArr);
        Assertions.assertEquals(Arrays.toString(inputArr), Arrays.toString(outputArr));
        //是否是字母
        if (output.length() < 1) {
            return;
        }
        boolean flag = MySolution_1001_1500.isAlphabet(output.charAt(0));
        for (int i = 1; i < output.length(); i++) {
            if (flag) {
                Assertions.assertTrue(MySolution_1001_1500.isNumber(output.charAt(i)));
                flag = false;
            } else {
                Assertions.assertTrue(MySolution_1001_1500.isAlphabet(output.charAt(i)));
                flag = true;
            }
        }
    }

    /**
     * 1422. 分割字符串的最大得分
     * 简单
     * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
     */
    @Test
    public void no1422() {
        Assertions.assertEquals(solution.maxScore("011101"), 5);
        Assertions.assertEquals(solution.maxScore("00111"), 5);
        Assertions.assertEquals(solution.maxScore("1111"), 3);
        Assertions.assertEquals(solution.maxScore("00"), 1);
    }

    /**
     * 1441. 用栈操作构建数组
     * 中等
     * https://leetcode.cn/problems/build-an-array-with-stack-operations/
     */
    @Test
    public void no1441() {
        Assertions.assertEquals(Arrays.toString(solution.buildArray(new int[]{1, 3}, 3).toArray()), "[Push, Push, Pop, Push]");
        Assertions.assertEquals(Arrays.toString(solution.buildArray(new int[]{1, 2, 3}, 3).toArray()), "[Push, Push, Push]");
        Assertions.assertEquals(Arrays.toString(solution.buildArray(new int[]{1, 2}, 4).toArray()), "[Push, Push]");
    }

    /**
     * 1450. 在既定时间做作业的学生人数
     * 简单
     * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
     */
    @Test
    public void no1450() {
        Assertions.assertEquals(solution.busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4), 1);
        Assertions.assertEquals(solution.busyStudent(new int[]{4}, new int[]{4}, 4), 1);
        Assertions.assertEquals(solution.busyStudent(new int[]{4}, new int[]{4}, 5), 0);
        Assertions.assertEquals(solution.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7), 0);
        Assertions.assertEquals(solution.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5), 5);
    }

    /**
     * 1455. 检查单词是否为句中其他单词的前缀
     * 简单
     * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
     */
    @Test
    public void no1455() {
        Assertions.assertEquals(solution.isPrefixOfWord("i love eating burger", "burg"), 4);
        Assertions.assertEquals(solution.isPrefixOfWord("this problem is an easy problem", "pro"), 2);
        Assertions.assertEquals(solution.isPrefixOfWord("i am tired", "you"), -1);
        Assertions.assertEquals(solution.isPrefixOfWord("i use triple pillow", "pill"), 4);
        Assertions.assertEquals(solution.isPrefixOfWord("i dumb", "jiezcqu"), -1);
        Assertions.assertEquals(solution.isPrefixOfWord("b bu bur burg burger", "burg"), 4);
    }

    /**
     * 1460. 通过翻转子数组使两个数组相等
     * 简单
     * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
     */
    @Test
    public void no1460() {
        Assertions.assertTrue(solution.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        Assertions.assertTrue(solution.canBeEqual(new int[]{7}, new int[]{7}));
        Assertions.assertFalse(solution.canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
    }

    /**
     * 1464. 数组中两元素的最大乘积
     * 简单
     * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
     */
    @Test
    public void no1464() {
        Assertions.assertEquals(solution.maxProduct(new int[]{3, 4, 5, 2}), 12);
        Assertions.assertEquals(solution.maxProduct(new int[]{1, 5, 4, 5}), 16);
        Assertions.assertEquals(solution.maxProduct(new int[]{3, 7}), 12);
    }

    /**
     * 1470. 重新排列数组
     * 简单
     * https://leetcode.cn/problems/shuffle-the-array/
     */
    @Test
    public void no1470() {
        Assertions.assertEquals(Arrays.toString(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)), "[2, 3, 5, 4, 1, 7]");
        Assertions.assertEquals(Arrays.toString(solution.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)), "[1, 4, 2, 3, 3, 2, 4, 1]");
        Assertions.assertEquals(Arrays.toString(solution.shuffle(new int[]{1, 1, 2, 2}, 2)), "[1, 2, 1, 2]");
    }

    /**
     * 1475. 商品折扣后的最终价格
     * 简单
     * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
     */
    @Test
    public void no1475() {
        Assertions.assertEquals(Arrays.toString(solution.finalPrices(new int[]{8, 4, 6, 2, 3})), "[4, 2, 4, 2, 3]");
        Assertions.assertEquals(Arrays.toString(solution.finalPrices(new int[]{1, 2, 3, 4, 5})), "[1, 2, 3, 4, 5]");
        Assertions.assertEquals(Arrays.toString(solution.finalPrices(new int[]{10, 1, 1, 6})), "[9, 0, 1, 6]");
    }

}
