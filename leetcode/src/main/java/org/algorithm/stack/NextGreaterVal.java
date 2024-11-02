package org.algorithm.stack;

import org.algorithm.ListNode;

import java.util.*;

/**
 * 1019
 * 链表中下一个比它大的元素
 */
public class NextGreaterVal {

    public int[] nextLargerNodes(ListNode head) {

        // [{val,postion},{val,postion}]
        Stack<int[]> stack = new Stack<>();

        List<Integer> list = new ArrayList<>();

        int pos=0;

        while(head!=null){

            // 处理满足需求节点
            while(!stack.isEmpty() && head.val > stack.peek()[0]){
                int[] element = stack.pop();
                // 更新大于的值
                list.set(element[1],head.val);
            }

            // 默认值为0
            list.add(0);
            stack.push(new int[]{head.val,pos});
            pos++;
            head = head.next;
        }

        // 结果处理
        int[] ret = new int[list.size()];

        for(int i=0;i<ret.length;i++){
            ret[i]=list.get(i);
        }

        return ret;
    }
}
