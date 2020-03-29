package com.yi.interviewquestions.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {

            List<String> result = new ArrayList<>();
            for(int i = 0; i< words.length; i++){

                int wordLen = maxWidth;
                int SpaceCount = 0;
                while(i < words.length && wordLen >= words[i].length()){
                    wordLen -= words[i].length();
                    wordLen -= 1;
                    i++;
                    SpaceCount++;
                }
                i--;
                int extraSpace = 0;
                int correction = 0;
                if(SpaceCount > 1){
                    extraSpace = (wordLen+SpaceCount)/(SpaceCount-1);
                    correction = (wordLen+SpaceCount)%(SpaceCount-1);
                }else if(SpaceCount == 1){
                    wordLen++;
                    extraSpace = wordLen;

                }


                String temp ="";
                for(int j = i+1-SpaceCount; j<i+1; j++){
                    temp += words[j];
                    if(i+1 == words.length){
                        if(j == i){
                            for(int w = 0; w< extraSpace; w++){
                                temp += " ";
                            }
                            while(correction != 0 ){
                                temp += " ";
                                correction--;
                            }
                        }
                    }else{
                        if(SpaceCount>1 && j < i){
                            for(int w = 0; w< extraSpace; w++){
                                temp += " ";
                            }
                            if(correction != 0 ){
                                temp += " ";
                                correction--;
                            }
                        }else if(SpaceCount==1){
                            for(int w = 0; w< extraSpace; w++){
                                temp += " ";
                            }
                            if(correction != 0 ){
                                temp += " ";
                                correction--;
                            }
                        }

                    }

                }

                result.add(temp);

            }

            return result;
        }

    }
}
