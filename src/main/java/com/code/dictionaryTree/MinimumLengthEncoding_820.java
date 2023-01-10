package com.code.dictionaryTree;//单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
//
// 
// words.length == indices.length 
// 助记字符串 s 以 '#' 字符结尾 
// 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 
//words[i] 相等 
// 
//
// 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["time", "me", "bell"]
//输出：10
//解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
//words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
//words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
//words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
// 
//
// 示例 2： 
//
// 
//输入：words = ["t"]
//输出：2
//解释：一组有效编码为 s = "t#" 和 indices = [0] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// words[i] 仅由小写字母组成 
// 
//
// Related Topics 字典树 数组 哈希表 字符串 👍 297 👎 0

import java.util.Arrays;

// 字典树
//leetcode submit region begin(Prohibit modification and deletion)
public class MinimumLengthEncoding_820 {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        Trie trie = new Trie();
        int res = 0;
        for (String word : words) {
            if (trie.insert(word)) {
                res += word.length() +1;
            }
        }
        return res;
    }
    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public boolean insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;
            for (int i = word.length()-1; i >=0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                    isNew = true;
                }
                cur = cur.children[index];
            }
            cur.isEnd = true;
            return isNew;
        }


        class TrieNode {
            boolean isEnd = false;
            TrieNode[] children = new TrieNode[26];
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
