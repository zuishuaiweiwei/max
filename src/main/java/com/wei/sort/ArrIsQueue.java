package com.wei.sort;

/**数组当作队列
 * @author 为为
 * @create 9/4
 */
public class ArrIsQueue {

    private int[] arr = new int[5];
    private int start = 0;
    private int end = 0;
    private int size = 0;
    public void add(int item){
        if(size>=arr.length){
            throw new ArrayIndexOutOfBoundsException(" 队列已满");
        }
        arr[end] = item;
        end++;
       if(end > arr.length-1){
           end =0;
       }
        size++;
    }
    public int poll(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("队列为空");
        }
        int ret = arr[start];
        start++;
        if(start > arr.length-1){
            start =0;
        }
        size--;
        return ret;
    }
    public static  void main(String[] args){
        ArrIsQueue queue = new ArrIsQueue();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(1);
        queue.add(5);
        for(int i =0;i<queue.arr.length;i++){
            int poll = queue.poll();
            System.out.println(poll);
        }
        int poll = queue.poll();
    }
}