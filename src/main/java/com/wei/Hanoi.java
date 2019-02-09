package com.wei;

/**汉诺塔问题
 * @author 为为
 * @create 9/24
 */
public class Hanoi {

    public static void core(int i,String from,String to,String help){
        if(i ==1){
            System.out.println("Move "+ i+ " from "+from+" to "+to);
        }else{
            core(i-1,from,help,to);
            System.out.println("Move "+ i+ " from "+from+" to "+to);
            core(i-1,help,to,from);
        }
    }
    public static void main(String[]args){
        core(4,"left","right","help");
    }
}