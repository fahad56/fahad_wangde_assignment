import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import app.Words;
import app.WordCount;
public class Main {

   
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        if (args.length > 0){
            String text = args[0];
            // BUILD WORK COUNTS
            List<WordCount> word_count = Words.sortedWordCounts(text, false);
            for (WordCount c: word_count){
                System.out.println(String.format("%s: %d", c.Word, c.Count));
            }
        }
    }

}