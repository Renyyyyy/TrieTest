package org.example;

public class Main {
    public static String findLongestCommonPrefix(String[] strings) {
        Trie trie = new Trie();

        for (String str : strings) {
            trie.insert(str);
        }

        StringBuilder prefix = new StringBuilder();
        TrieNode node = trie.getRoot();
        while (node != null && node.children.getSize() == 1) {
            char nextChar = node.children.keySet().iterator().next();
            prefix.append(nextChar);
            node = node.children.get(nextChar);
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"egg","flower", "flow", "flight" };
        String longestCommonPrefix = findLongestCommonPrefix(strings);
        if (longestCommonPrefix.equals("")){
            System.out.println("Самый длинный общий префикс отсутствует");
        }else {
            System.out.println("Самый длинный общий префикс: " + longestCommonPrefix);
        }

    }
}