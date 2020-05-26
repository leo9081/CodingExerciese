package com.yi.interviewquestions.Facebook;

public class NestedListWeightSumII {
    /*
        int height;
    int sum;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        height = 0;
        sum = 0;
        for(int i = 0; i< nestedList.size(); i++) getHeight(nestedList.get(i),1);
        for(int i = 0; i< nestedList.size(); i++) getSum(nestedList.get(i),height);
        return sum;
    }

    public void getSum(NestedInteger n, int dep){
        if(n.isInteger()){
            sum += n.getInteger()*dep;
            return;
        }

        for(int i = 0 ; i < n.getList().size();i++){
            getSum(n.getList().get(i), dep-1);
        }

        return;
    }

    public void getHeight(NestedInteger n, int dep){
        if(n.isInteger()){
            height = Math.max(height,dep);
            return;
        }

        for(int i = 0 ; i < n.getList().size();i++){
            getHeight(n.getList().get(i), dep+1);
        }

        return;
    }
     */
}
