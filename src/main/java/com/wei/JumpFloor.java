package com.wei;

/**一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author 为为
 * @create 9/17
 */
public class JumpFloor {
    public int JumpFloor(int target) {
      /*  if(target==0){
            return 0;
        }
        if(target==1 || target==2){
            return target;
        }
        else{
            int first = 1;
            int second = 2;
            int result =0;
            for(int i =3; i<= target;i++){
                result = first+second;
                first = second;
                second = result;
            }
            return result;
        }*/
        return (int) Math.pow(2,target);
    }
}