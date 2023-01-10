package com.code.day;
//给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单
//blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
//
// 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
//
// 实现 Solution 类:
//
//
// Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
// int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
//
//
//
//
// 示例 1：
//
//
//输入
//["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
//[[7, [2, 3, 5]], [], [], [], [], [], [], []]
//输出
//[null, 0, 4, 1, 6, 1, 0, 4]
//
//解释
//Solution solution = new Solution(7, [2, 3, 5]);
//solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
//                 // 0、1、4和6的返回概率必须相等(即概率为1/4)。
//solution.pick(); // 返回 4
//solution.pick(); // 返回 1
//solution.pick(); // 返回 6
//solution.pick(); // 返回 1
//solution.pick(); // 返回 0
//solution.pick(); // 返回 4
//
//
//
//
// 提示:
//
//
// 1 <= n <= 10⁹
// 0 <= blacklist.length <= min(10⁵, n - 1)
// 0 <= blacklist[i] < n
// blacklist 中所有值都 不同
// pick 最多被调用 2 * 10⁴ 次
//
//
// Related Topics 哈希表 数学 二分查找 排序 随机化 👍 217 👎 0

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @author zqy on 2022/6/27.
 */
public class Random_710 {
    int n_, m, idx;
    Random random = new Random();
    HashMap<Integer, Integer> map = new HashMap<>();
    // 黑名单集合(映射)
    Set<Integer> s1 = new HashSet<>();
    // 黑名单集合
    Set<Integer> s2 = new HashSet<>();

    public Random_710(int n, int[] blacklist) {
        n_ = n;
        // 可选取的总数
        m = n - blacklist.length;
        for (int b : blacklist) {
            if (b < m) {
                s1.add(b);
            } else {
                s2.add(b);
            }
        }
        idx = m;
    }

    public int pick() {
        // 只在<m的数中随机
        int nextInt = random.nextInt(m);
        // 不在映射黑名单中,直接return
        if (!s1.contains(nextInt)) {
            return nextInt;
        }
        // 在映射黑名单中, 加入映射map
        if (!map.containsKey(nextInt)) {
            // 从m开始递增寻找未被加入s2的值
            while (s2.contains(idx)) {
                idx++;
            }
            map.put(nextInt, idx++); //先赋值,再++
        }
        // 取映射map的值
        return map.get(nextInt);
    }
}
