// Time Complexity : O(length of word)
// Space Complexity : O(max length of words * number of words)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Trie {

        class TrieNode {
            private TrieNode[] links;

            private final int R = 26;

            private boolean isEnd;

            public TrieNode(){
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch){
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch){
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node){
                links[ch - 'a'] = node;
            }

            public void setEnd(){
                isEnd = true;
            }

            public boolean isEnd(){
                return isEnd;
            }
        }


        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        // Time: O(m) m is word length
        public void insert(String word) {
            TrieNode node = root;
            for(int i=0; i < word.length(); i++){
                char currentChar = word.charAt(i);
                if(!node.containsKey(currentChar)){
                    node.put(currentChar, new TrieNode());
                }

                node = node.get(currentChar);
            }

            node.setEnd();
        }

        // search a prefix or whole key in trie and
        // returns the node where search ends
        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char currentChar = word.charAt(i);

                if(node.containsKey(currentChar)){
                    node = node.get(currentChar);
                } else {
                    return null;
                }
            }

            return node;
        }

        /** Returns if the word is in the trie. */
        // Time: O(m)
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return (node != null && node.isEnd());
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        // Time: O(m)
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

