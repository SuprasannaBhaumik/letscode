package com.learn.code.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringConcatnationOfAllStrings {

    public static void main(String[] args) {
        findSubstring(
            "ababababab",
            new String[]{"ababa","babab"}
        )
        .stream()
        .forEach(x -> {
            System.out.println(x);
        });
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Word> wordMap = constructWordMap(s, words);

        wordMap.keySet().forEach( key -> {
            Word checkWord = wordMap.get(key);
            int temp = key;
            List<String> individualWords = new ArrayList<>(Arrays.asList(words));
            individualWords.remove(individualWords.indexOf(checkWord.getWord()));
            boolean flag = true;
            while(individualWords.size() != 0) {
                int newWordKey = key + checkWord.length;
                if(wordMap.containsKey(newWordKey) && individualWords.contains(wordMap.get(newWordKey).getWord())) {
                    checkWord = wordMap.get(newWordKey);
                    key = newWordKey;
                    individualWords.remove(wordMap.get(newWordKey).getWord());
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                resultList.add(temp);
            }
        });

        return resultList;
    }

    private static Map<Integer, Word> constructWordMap(String s, String[] words) {
        Map<Integer, Word> wordMap = new HashMap<>();
        for(String word : words) {
            String originalWord = s;
            int start = 0;
            while(originalWord.indexOf(word) > -1) {
                int position = originalWord.indexOf(word) + start;
                wordMap.put(position, new Word(word, word.length()));
                start = position + word.length();
                if(originalWord.length() >= start) {
                    originalWord = s.substring(start);
                } else {
                    break;
                }
            }
        }
        return wordMap;
    }


    static class Word {

        private String word;
        private int length;

        public Word(String word, int length) {
            this.word = word;
            this.length = length;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }
}
