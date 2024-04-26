import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordSet {
    private TreeSet<String> words;

    public WordSet(String[] wordSet) {
        words = new TreeSet<String>();
        for(String word: wordSet) {
            words.add(word);
        }

    }
    public void print() {
        System.out.println(words);
    }

    public int size() {
        return words.size();
    }
    public void insert(String word) {
        words.add(word);
    }
    public void remove(String word) {
        words.remove(word);
    }
    public String findkth(int k) {
        Iterator it = words.iterator();
        k --;
        for(int i=0; i < k; i++) {
            if(it.hasNext())
                it.next();
        }
        return (String) it.next();
    }
    public boolean contains(String word) {
        return words.contains(word);
    }
    public int countA() {
        int count = 0;
        for(int i = 0; i < words.size(); i ++) {
            String firstA = findkth(i+1).substring(0,1);
            if ("A".equals(firstA))
                count ++;
            else
                break;
        }
        return count;
    }
    public void removeA() {
        int count = countA();
        for(int i = 0; i < count; i ++) {
            String str = findkth(1);
            remove(str);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"PEAR", "APPLE", "ADD",
                "GRAPE", "FIG", };
        WordSet ws = new WordSet(arr);
        ws.print();

        System.out.println("CountA="+ws.countA());
        ws.removeA();
        ws.print();
    }
}
