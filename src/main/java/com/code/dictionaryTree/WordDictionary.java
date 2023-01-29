package com.code.dictionaryTree;//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictioEnary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 10⁴ 次 addWord 和 search 
// 
//
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 479 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
    }
    
    public boolean search(String word) {
        // 传统方法时间复杂度会很高
        // TrieNode cur = root;
        // for (char c : word.toCharArray()) {
        //     int i = c - 'a';
        //     if (cur.children[i] == null) {
        //         return false;
        //     }
        //     cur = cur.children[i];
        // }
        // return cur.isEnd;
        return match(word, root, 0);
    }

    /**
     * 传统递归match写法
     * @param word
     * @param trieNode
     * @param i
     * @return
     */
    private boolean match(String word, TrieNode trieNode, int i) {
        if (i == word.length()) {
            return trieNode.isEnd;
        }
        if (word.charAt(i) == '.') {
            for (TrieNode child : trieNode.children) {
                if (child!=null && match(word, child, i+1)) {
                    return true;
                }
            }
            return false;
        } else {
            int c = word.charAt(i) - 'a';
            return trieNode.children[c] != null && match(word, trieNode.children[c], i+1);
        }
    }

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
