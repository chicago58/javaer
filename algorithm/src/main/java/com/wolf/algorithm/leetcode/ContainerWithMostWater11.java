package com.wolf.algorithm.leetcode;

/**
 * @Author: liu lei
 * @Date: 2019/7/23
 */
public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }
    private static int maxArea(int[] height)
    {
        int l=0,r=height.length-1,maxArea=0;//maxarea表示最大的面积，不断地记录
        while(l<r)
        {
            maxArea=Math.max(maxArea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r])//如果左边木板是短木板，那么l往里面走
                l++;
            else//如果右边木板是短木板，那么r往里面走
                r--;
        }
        return maxArea;
    }
}
/**
 * 盛最多水的容器
 * 题目描述：
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 说明：
 * 1、这道题挺有意思的，给定一组木板的高度，每块木板间隔一个单位，这些木板有长有短。
 * 要求出两块木板中间最多能容纳多少水。
 *
 * 2、很明显这道题不能暴力解法，时间肯定花费太大。
 * 那么我们只能看一下有没有什么窍门可以解这道题。
 * 我们直觉都是从木板长度最大的找起，接着逐步变小，但会发现这样子其实还是要遍历全部情况。
 * 而且这种情况下写代码还挺复杂的。
 * 不如从另外一个变量，木板之间的间隔长度找起，从两端这个最大的长度找起。
 * 接着逐步缩小两端长度，但是两边的木板长度就要增加了，这种情况下似乎有点可能性。
 * 我们逐步减小木板之间的距离，想要再增加面积，必须提高最短木板的长度，所以我们从短木板这一侧往里面走。
 * 只有这样，才能在减小木板间距的时候，增大面积。
 */
