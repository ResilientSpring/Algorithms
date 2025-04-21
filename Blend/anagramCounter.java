import java.util.*;

public class anagramCounter {
    
    public static int countAnagramGroups(List<String> words) {
    	
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String word : words) {
            String sortedWord = sortCharacters(word);
            anagramMap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        
        int anagramGroups = 0;
        
        for (List<String> group : anagramMap.values()) {
            if (group.size() > 1) {
                anagramGroups++;
            }
        }
        
        return anagramGroups;
    }
    
    private static String sortCharacters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "salient", "kitten", "cat");
        int result = countAnagramGroups(words);
        System.out.println("Number of anagram groups: " + result);
    }
}
