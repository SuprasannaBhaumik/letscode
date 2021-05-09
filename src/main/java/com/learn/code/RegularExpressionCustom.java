package com.learn.code;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionCustom {

    public static void main(String[] args) {

        String s ="aaa";
        String p = "ab*ac*a";
        /*String s ="missisaippi";
        String p = "mis.is.ip*.";*/
        System.out.println("string -> " + s);
        System.out.println("pattern -> " + p);
        System.out.println(RegularExpressionCustom.isMatch(s, p));
    }

    public static List<Pattern> getPattern(String pattern) {
        List<Pattern> patternList = new ArrayList<>();

        char[] patternArray = pattern.toCharArray();

        int count = 0;
        for(int i=0; i < patternArray.length; i++) {
            boolean isStarSymbol = checkNextAsSymbol(patternArray, i, '*');
            Pattern p = new Pattern();
            p.setIndex(count);
            p.setLetter(patternArray[i]);
            if(isStarSymbol) {
                p.setRepeat(true);
                i++;
            } else {
                p.setRepeat(false);
            }
            patternList.add(p);
            count++;
        }

        for(Pattern p: patternList) {
            System.out.println( "Index {" + p.getIndex() +"} " + "char [" + p.getLetter() + "] to be repeated -> " + p.isRepeat() );
        }


        return patternList;
    }

    private static boolean checkNextAsSymbol(char[] patternArray, int i, char symbol) {
        if( i+1 > patternArray.length - 1) {
            return false;
        } else {
            if(patternArray[i+1] == symbol) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isMatch(String s, String p) {
        boolean isMatch = true;
        //.* is special case, needs to be handled separately
        List<Pattern> myPatternList = getPattern(p);
        char[] stringToCompare = s.toCharArray();
        int stringToCompareCurrentIndex = 0;
        Pattern prevPattern = new Pattern();
        if(myPatternList.size() == 1 && stringToCompare.length > myPatternList.size()) {
            boolean flag = true;
            if(myPatternList.get(0).isRepeat()) {
                Pattern myPattern = myPatternList.get(0);
                boolean isDotPresent = myPattern.getLetter() == '.';
                if(isDotPresent) {
                    return flag;
                } else {
                    for(char c: stringToCompare) {
                        if (c != myPatternList.get(0).getLetter()) {
                            flag = false;
                            break;
                        }
                    }
                }
            } else {
                flag = false;
            }
            return flag;
        }

        int count = 0;
        for(int i=0; i< myPatternList.size(); i++,count++) {

            if(myPatternList.size() > stringToCompare.length) {
                if(i == myPatternList.size() - 1 && !myPatternList.get(i).isRepeat()) {
                    return false;
                }
            }

            if(stringToCompareCurrentIndex >= stringToCompare.length) {
                break;
            }
            Pattern currentPattern = myPatternList.get(i);
            boolean stringComparisonReqd = true;
            if(currentPattern.getLetter() == '.') {
                stringComparisonReqd = false;
            }
            System.out.println("--------------");
            System.out.println("str advance -> " +stringToCompareCurrentIndex);
            System.out.println("pattern advance -> " + i);
            System.out.println("pattern -> "+currentPattern.getLetter());
            System.out.println("string -> "+stringToCompare[stringToCompareCurrentIndex]);
            System.out.println("to repeat -> "+currentPattern.isRepeat());
            System.out.println("isDot -> "+!stringComparisonReqd);

            if(currentPattern.getLetter() == prevPattern.getLetter() &&
                    prevPattern.isRepeat()
            ) {
                System.out.println("A");
                prevPattern = currentPattern;
                continue;
            } else if((!stringComparisonReqd || currentPattern.getLetter() != stringToCompare[stringToCompareCurrentIndex])
                && currentPattern.isRepeat() == true && currentPattern.getLetter() == '.'
            ) {
                System.out.println("B");
                prevPattern = currentPattern;
                continue;
            } else if((!stringComparisonReqd || currentPattern.getLetter() != stringToCompare[stringToCompareCurrentIndex])
            ) {
                System.out.println("C");
                if (currentPattern.getLetter() == '.') {
                    System.out.println(1);
                    if(!currentPattern.isRepeat()) {
                        stringToCompareCurrentIndex++;
                    }

                    continue;
                } else if (currentPattern.isRepeat()) {
                    if (currentPattern.getLetter() == stringToCompare[stringToCompareCurrentIndex + 1]) {
                        isMatch = false;
                        break;
                    } else {
                        continue;
                    }
                } else {
                    isMatch = false;
                    break;
                }
            } else if ((!stringComparisonReqd || currentPattern.getLetter() == stringToCompare[stringToCompareCurrentIndex])
                && currentPattern.isRepeat() == false
            ){
                System.out.println("D");
                prevPattern = currentPattern;
                if( i != myPatternList.size() - 1) {
                    stringToCompareCurrentIndex++;
                }
                continue;
            } else if ((!stringComparisonReqd || currentPattern.getLetter() == stringToCompare[stringToCompareCurrentIndex])
                    && currentPattern.isRepeat() == true
            ) {
                System.out.println("E");
                while(stringToCompareCurrentIndex < stringToCompare.length && currentPattern.getLetter() == stringToCompare[stringToCompareCurrentIndex]) {
                    stringToCompareCurrentIndex++;
                }
                prevPattern = currentPattern;
                continue;
            } else {
                System.out.println("F");
                isMatch = false;
                break;
            }

        }

        System.out.println(stringToCompareCurrentIndex);
        if(count == myPatternList.size() && stringToCompareCurrentIndex < stringToCompare.length - 1 ) {
            isMatch = false;
        }
        return isMatch;
    }

    static class Pattern {
        private int index;
        private char letter;
        private boolean repeat;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public char getLetter() {
            return letter;
        }

        public void setLetter(char letter) {
            this.letter = letter;
        }

        public boolean isRepeat() {
            return repeat;
        }

        public void setRepeat(boolean repeat) {
            this.repeat = repeat;
        }
    }
}
