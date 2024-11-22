package DSA.Hw3_22000123_NguyenDucSi.bai2;

import java.util.Scanner;

public class WordMain {

    public static String enterString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        return sc.nextLine();
    }

    public static SimpleLinkedList<WordCount> countWords(String words) {
        SimpleLinkedList<WordCount> list = new SimpleLinkedList<>();
        String[] wordList = words.split(" ");

        for(String word : wordList) {
            WordCount wordCount = new WordCount(word);
            if(list.isContain(wordCount)) {
                list.getNode(list.indexOf(wordCount)).getData().increaseCount();
            } else {
                list.add(wordCount);
            }
        }
        return list;
    }

    public static SimpleArrayList<WordCount> countWordsArray(String words) {
        SimpleArrayList<WordCount> list = new SimpleArrayList<>();
        String[] wordList = words.split(" ");

        for(String word : wordList) {
            WordCount wordCount = new WordCount(word);
            if(list.isContain(wordCount)) {
                list.get(list.indexOf(wordCount)).increaseCount();
            } else {
                list.add(wordCount);
            }
        }
        return list;
    }

    public static void print (ListInterface<WordCount> list) {
        for(int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {

        String words = enterString();

        SimpleLinkedList<WordCount> list = countWords(words);
        print(list);

    }

}
