package com.code.dictionaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// map解法
/*
class MagicDictionary {
    Map<Integer, List<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            // System.out.println(map);
            if (map.containsKey(s.length())) {
                map.get(s.length()).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(s.length(), list);
            }
        }
    }
    
    public boolean search(String searchWord) {
        int length = searchWord.length();
        if (!map.containsKey(length)) {
            return false;
        }
        for (String s : map.get(length)) {
            if (checkDic(searchWord, s)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDic(String searchWord, String s) {
        if (searchWord.equals(s)) {
            return false;
        }
        int n=0;
        for (int i = 0; i < s.length(); i++) {
            if (searchWord.charAt(i)!=s.charAt(i)) {
                n++;
                if (n>1) {
                    return false;
                }
            }
        }
        return true;
    }
}
*/
// 字典树解法
class MagicDictionary {
    TrieNode root;

    public MagicDictionary() {
        this.root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }

    public boolean search(String searchWord) {
        return match(searchWord, root, 0, false);
    }

    /**
     *
     * @param word
     * @param node
     * @param i
     * @param changed 是否改变过
     * @return
     */
    private boolean match(String word, TrieNode node, int i, boolean changed) {
        if (word.length() == i) {
            return node.isEnd && changed;
        }
        for (int j = 0; j < 26; j++) {
            int index = word.charAt(i) - 'a';
            TrieNode child = node.children[j];
            if (child != null) {
                // 字符相等
                if (index == j && match(word, child, i+1, changed)) {
                    return true;
                }
                // 字符不相等,保证未change
                if (index != j && !changed && match(word, child, i+1, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

//runtime:28 ms
//memory:42.1 MB
