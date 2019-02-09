package com.wei.sort;

/**数组作为栈结构
 * @author 为为
 * @create 9/4
 */
public class ArrIsStack {

    private  int[] arr = new int[5];
    private  int end = 0;
    private  int size = 0;
    public void push(int item){
        if(size>= arr.length){
            throw new ArrayIndexOutOfBoundsException(" 栈满");
        }
        arr[end] = item;
        end++;
        size++;
    }
    public int pop(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException(" 栈空");
        }
        int ret = arr[--end];
        size--;
        return ret;
    }
    public int peel(){
        return 1;
    }
    public static void main(String[] args){
        ArrIsStack stack = new ArrIsStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        for(int i = 0;i<stack.arr.length;i++){
            int pop = stack.pop();
            System.out.println(pop);
        }


    }
}