package DSA.Hw3_22000123_NguyenDucSi.bai2;

public class WordCount {
    private String word;
    private int count;

    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        ++count;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof WordCount) {
            WordCount wordCount = (WordCount) object;
            return word.equals(wordCount.getWord());
        }
        return false;
    }

    @Override
    public String toString() {
        return word + ": " + count;
    }
}
