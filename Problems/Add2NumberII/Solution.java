/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode pseduo1 = l1;
        while(pseduo1 != null){
            s1.push(pseduo1.val);
            pseduo1 = pseduo1.next;
        }
        ListNode pseduo2 = l2;
        while(pseduo2 != null){
            s2.push(pseduo2.val);
            pseduo2 = pseduo2.next;
        }
        if(s1.size() == 0){
            return l2;
        }
        if(s2.size() == 0){
            return l1;
        }
        if(s1.size() > s2.size())
            return popAndAdd(s1, s2);
        return popAndAdd(s2, s1);
    }
    
    public ListNode popAndAdd(Stack<Integer> s1, Stack<Integer> s2){
        
        List<Integer> l1 = new ArrayList<>();
        int s = 0;
        int c = 0;
        while(!s2.isEmpty()){
            int a = s1.pop();
            int b = s2.pop();
            s = a + b + c;
            c = s/10;
            s = s % 10;
            l1.add(s);
            s = 0;
        }
        while(!s1.isEmpty()){
            int a = s1.pop();
            s = a + c;
            c = s/10;
            s = s % 10;
            l1.add(s);
            s = 0;
        }
        if(c == 1){
            l1.add(1);
        }
        ListNode ans = new ListNode(0);
        ListNode out = ans;
        Collections.reverse(l1);
        for(Integer a : l1){
            ans.next = new ListNode(a);
            ans = ans.next;
        }
        return out.next;
    }
}
