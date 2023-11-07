package app;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Words {

    public static ArrayList<WordCount> buildWordCounts(String text) {
        Map<String, WordCount> word_count = new HashMap<String, WordCount>();
        if (text.length() > 0){
            String[] words = text.replace("\n", " ").replace("\t", " ").split(" ");
            for (String word : words) {
                if (word.length() > 0){
                    if (word_count.containsKey(word)) {
                        WordCount wordCount = word_count.get(word);
                        wordCount.Count = wordCount.Count + 1;
                        word_count.put(word, wordCount);
                    } else {
                        word_count.put(word, new WordCount(word, 1));
                    }
                }
            }
        }
        return new ArrayList<>(word_count.values());
    }

    public static List<WordCount> sortedWordCounts(String text, boolean asc) {
        // BUILD WORK COUNTS
        List<WordCount> wordCounts = buildWordCounts(text);
        // SORT WORD COUNTS BY DESCENDING
        wordCounts.sort(new Comparator<WordCount>() {
            @Override
            public int compare(WordCount a, WordCount b) {
                return asc ? a.Count - b.Count : b.Count - a.Count;
            }
        }); 
        return wordCounts;
    }

}
