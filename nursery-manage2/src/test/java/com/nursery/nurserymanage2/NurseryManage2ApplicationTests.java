package com.nursery.nurserymanage2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//@SpringBootTest
class NurseryManage2ApplicationTests {

    @Test
    void test01() {
        /*int length = reverse(1534236863);
        System.out.println(length);*/
//        System.out.println(isPalindrome(12221));
        double medianSortedArrays = findMedianSortedArrays(new int[]{0,0,0,0,0}, new int[]{-1,0,0,0,0,0,1});
        System.out.println(medianSortedArrays);
    }


    //中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length+ nums2.length];
        for (int i = 0; i < nums1.length+nums2.length; i++) {
            if (i < nums1.length) {
                res[i] = nums1[i];
            } else {
                res[i] = nums2[i - nums1.length];
            }
        }
        Arrays.sort(res);
        if (res.length%2==0){
            double x = (double) (1 + res.length)/2;
            return (double) (res[(int) Math.floor(x) - 1] + res[(int) Math.round(x) - 1])/2;
        }else {
            return  res[((1 + res.length) / 2) - 1];
        }
    }

    //到尾整数
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        int x_ = x;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev==x_?true:false;
    }

    //
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (int) rev == rev ? (int) rev : 0;
    }

    //链表
    @Test
    void contextLoads() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sumVal = l1val + l2val + carry;
            carry = sumVal / 10;
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test05(){
        long l = System.currentTimeMillis();
        System.out.println(l);
    }
}
