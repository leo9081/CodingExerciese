package com.yi.interviewquestions.Facebook;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementinanArray {
    /*优先级队列是无界的，但是有一个内部容量，控制着用于存储队列元素的数组大小。它通常至少等于队列的大小。
    随着不断向优先级队列添加元素，其容量会自动增加。无需指定容量增加策略的细节。
    既然无界，为啥还要给size呢？
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }

    //Quickselect： ! Please notice that this algorithm works well even for arrays with duplicates.
    class Solution {
        int [] nums;

        public void swap(int a, int b) {
            int tmp = this.nums[a];
            this.nums[a] = this.nums[b];
            this.nums[b] = tmp;
        }


        public int partition(int left, int right, int pivot_index) {
            int pivot = this.nums[pivot_index];
            // 1. move pivot to end
            swap(pivot_index, right);
            int store_index = left;

            // 2. move all smaller elements to the left
            for (int i = left; i <= right; i++) {
                if (this.nums[i] < pivot) {
                    swap(store_index, i);
                    store_index++;
                }
            }

            // 3. move pivot to its final place
            swap(store_index, right);

            return store_index;
        }

        public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

            if (left == right) // If the list contains only one element,
                return this.nums[left];  // return that element

            // select a random pivot_index
            Random random_num = new Random();
            int pivot_index = left + random_num.nextInt(right - left);

            pivot_index = partition(left, right, pivot_index);

            // the pivot is on (N - k)th smallest position
            if (k_smallest == pivot_index)
                return this.nums[k_smallest];
                // go left side
            else if (k_smallest < pivot_index)
                return quickselect(left, pivot_index - 1, k_smallest);
            // go right side
            return quickselect(pivot_index + 1, right, k_smallest);
        }

        public int findKthLargest(int[] nums, int k) {
            this.nums = nums;
            int size = nums.length;
            // kth largest is (N - k)th smallest
            return quickselect(0, size - 1, size - k);
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{3,2,1,5,6,4};
        PriorityQueue<Integer> pq = new PriorityQueue<>(2);

        for(int i = 0; i < input.length; i++){
            pq.offer(input[i]);
        }
    }
}
