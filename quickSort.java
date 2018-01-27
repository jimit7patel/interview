package com.epi;
import java.util.*;

public class quickSort{
	public static void quick(int[] input,int l,int r){
		
		
		 quickSort(input,l,r);
	}
	
	 public static void quickSort(int[] input,int l,int r) {
		
		 if (r ==-1){
			 return ;
		 }
		 if(l>=r){
			 return ;
		 }
		 
		 int m = l+(r-l)/2;
		 int pivot = input[m];
		 int tmp;
		 int leftIndex=l,midIndex=0,rightIndex=r;
		while(leftIndex<rightIndex){
			 if(input[leftIndex]<pivot){
				 leftIndex++;
				 
			 }
			 else if(input[leftIndex]>pivot){
				 tmp=input[rightIndex];
				 input[rightIndex]=input[leftIndex];
				 input[leftIndex] = tmp;
				 rightIndex--;
			 }
			 else{
				 input[leftIndex]=input[l+midIndex];
				 input[l+midIndex]=pivot;
				 midIndex++;
				 leftIndex++;
			 }
		 }
		if(input[leftIndex]<pivot){
			rightIndex++;
		}else {
			leftIndex--;
		}
		 for(int i=0;i<midIndex;i++){
			 input[l+i]=input[leftIndex-i];
			 input[leftIndex-i]=pivot;
		 }
		 quickSort(input,l,leftIndex);
		 quickSort(input,leftIndex+1,r);
		     
	    }
	 
	
	 public static void main(String[] args){
		int []input={100,1203,0,1,3,56,2,3,2,5,10};
		
		if(input.length!=0){
			quick(input,0,input.length-1);
		 for (int t:input){
			 System.out.println(t);
		 }
		}
	 }
}
