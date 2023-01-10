package com.code.dictionaryTree;
//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。 
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数 
//
// 
//
// 示例： 
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
// 
//
// 提示： 
//
// 
// 0 <= len(sentence) <= 1000 
// dictionary中总字符数不超过 150000。 
// 你可以认为dictionary和sentence中只包含小写字母。 
// 
//
// Related Topics 字典树 数组 哈希表 字符串 动态规划 哈希函数 滚动哈希


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution_17_13 {
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        // 注意数组为n+1
        int[] dp = new int[n+1];
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        for (int i = 1; i < n + 1; i++) {
            // 初始化dp[i]
            dp[i] = dp[i-1] + 1;
            /*// n^2算法
            for (int j = 0; j < i; j++) {
                if (sentence.substring(j,i+1) in dictionary) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }*/
            // 传入i-1为字符索引位置
            for (Integer search : trie.search(sentence, i - 1)) {
                dp[i] = Math.min(dp[i], dp[search]);
            }
        }

        return dp[n];
    }
    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = word.length()-1; i >=0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isEnd = true;
        }

        /**
         *
         * @param sentence
         * @param j 末尾字符index
         * @return 返回的为字典单词首字母索引列表
         */
        public List<Integer> search(String sentence, int j) {
            List<Integer> collet = new ArrayList<>();
            TrieNode cur = root;
            for (int i = j; i >=0; i--) {
                int index = sentence.charAt(i) - 'a';
                if (cur.children[index]==null) {
                    break;
                }
                cur = cur.children[index];
                if (cur.isEnd) {
                    collet.add(i);
                }
            }

            return collet;
        }

        class TrieNode {
            boolean isEnd = false;
            TrieNode[] children = new TrieNode[26];
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
