package com.wei;

/**把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author 为为
 * @create 9/17
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int i = 0;
        int p = array.length-1;
        while(i != p){
            if(array[i] < array[(i+p)/2]){
                i = (i+p)/2;
            }else if(array[i] > array[(i+p)/2]){
                p = (i+p)/2;
            }else{
                int temp = array[i];
                for(int k = i;  k<=p;k++){
                    if(array[k] != temp){
                        i = k;
                        break;
                    }
                }
            }
            if(p-i==1 || p ==i){
                break;
            }
        }
        return array[p];
    }

    public static void main(String[]args){
        int [] arr = {1,1,1,1,1,0};
        int i = new MinNumberInRotateArray().minNumberInRotateArray(arr);
        System.out.println(i);
    }
}