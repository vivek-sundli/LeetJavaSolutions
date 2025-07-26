class TrieNode{
    TrieNode[] children;
    boolean isEnding;
    public TrieNode(){
        isEnding = false;
        children = new TrieNode[26];
    }
    static void insert(TrieNode root, String key){
        TrieNode curr = root;

        for(char c : key.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.children[c-'a'] = newNode;
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnding = true;
    }

    static boolean searchWord(TrieNode root, String key){
        TrieNode curr = root;
        for(char c : key.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnding;
    }
}