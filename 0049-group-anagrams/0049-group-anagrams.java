class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars= word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            map.putIfAbsent(sortedWord, new LinkedList<>());
            map.get(sortedWord).add(word);
        }
        return new LinkedList<>(map.values());
    }
}