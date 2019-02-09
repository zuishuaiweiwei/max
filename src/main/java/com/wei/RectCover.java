package com.wei;

/**我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author 为为
 * @create 9/18
 */
public class RectCover {

    public int RectCover(int target) {
        if(target==1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for(int i =3; i<=target; i++){
            result = first + second;
            first = second;
            second  = result;
        }
        return result;
    }
    public static void main(String []args){
        int i = new RectCover().RectCover(4);
        System.out.println(i);
    }
}