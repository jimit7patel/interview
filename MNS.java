/*https://community.topcoder.com/stat?c=problem_statement&pm=1744&rd=4545*/

import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public boolean nextPermutation(int[] nums) {
    if(nums == null || nums.length<2)
        return false;
 
    int p=0;            
    for(int i=nums.length-2; i>=0; i--){
        if(nums[i]<nums[i+1]){
            p=i;
            break;
        }    
    }
 
    int q = 0;
    for(int i=nums.length-1; i>p; i--){
        if(nums[i]> nums[p]){
            q=i;
            break;
        }    
    }
 
    if(p==0 && q==0){
        reverse(nums, 0, nums.length-1);
        return false;
    }
 
    int temp=nums[p];
    nums[p]=nums[q];
    nums[q]=temp;
 
    if(p<nums.length-1){
        reverse(nums, p+1, nums.length-1);
    }
    return true;
}
 
public void reverse(int[] nums, int left, int right){
    while(left<right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        left++;
        right--;
    }
}
public int combos(int[] nums){
	if(nums.length!=9){
		return 0;
	}
	Arrays.sort(nums);
	ArrayList t = new ArrayList();
	int sum=0;
	for( int num : nums) {
          sum = sum+num;
      }
    sum = sum/3;  
    do{
	if((nums[0]+nums[1]+nums[2]==sum)&&(nums[3]+nums[4]+nums[5]==sum)&&(nums[6]+nums[7]+nums[8]==sum)&&(nums[0]+nums[3]+nums[6]==sum)&&(nums[1]+nums[4]+nums[7]==sum)&&(nums[2]+nums[5]+nums[8]==sum)){
		t.add(nums);
	}
	}while(nextPermutation(nums));
    return t.size();
}

    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Solution id = new Solution();
		int nums[]={1,2,6,6,6,4,2,6,4};
		int s = id.combos(nums);
		System.out.println("s"+s);
	}
    
}
