package io.jovi.gyaradoseu.algorithm.primary.array;

/**
 * <p>
 * Title:删除排序数组中的重复项
 * </p>
 * <p>
 * Description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-01-08.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class DuplicatesRemove {
    /**
     * 排序数组去重
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i=1;i<nums.length;i++){

            if(nums[i]!=nums[i-1]) {
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int index = removeDuplicates(nums);
        System.out.println(index);
    }

}
