package org.algorithm;

import org.algorithm.binarytree.TreeNode;
import org.algorithm.tool.TreeTool;

import java.util.*;

public class Solution {


    //problem 463
    public int islandPerimeter(int[][] grid) {
        int length = 0;
        int numland = 0;
        int subNum = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    numland++;
                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] > 0)
                            subNum++;
                    }
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] > 0)
                            subNum++;
                    }
                    if (i + 1 < grid.length) {
                        if (grid[i + 1][j] > 0)
                            subNum++;
                    }
                    if (j + 1 < grid[0].length) {
                        if (grid[i][j + 1] > 0)
                            subNum++;
                    }


                }

            }

        length = 4 * numland - subNum;


        return length;
    }


    //problem 566
    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int sumElement = nums.length * nums[0].length;
        int reshape[][] = new int[r][c];
        if ((r * c) != sumElement) {
            return nums;
        } else {
            int rowNum = 0;
            int colNum = 0;
            int iteration = 0;
            for (int i = 0; i < nums.length; i++)
                for (int j = 0; j < nums[0].length; j++) {
                    reshape[rowNum][iteration % c] = nums[i][j];
                    iteration++;
                    if (iteration % c == 0) {
                        rowNum++;
                    }
                    colNum++;

                }

            return reshape;

        }

    }

    // problem 338
    public static int[] countBits(int num) {

        int[] result = new int[num + 1];

        if (num > 0) {


            result[0] = 0;
            result[1] = 1;

            for (int i = 2; i <= num; i++) {
                if (i % 2 == 0) {
                    result[i] = result[i / 2];
                } else {
                    result[i] = result[i - 1] + 1;
                }
            }

            return result;


        } else {
            result[0] = 0;
            return result;
        }


    }


    // problem 791

    public static String customSortString(String S, String T) {

        String result = "";
        Map<String, Integer> a = new HashMap<String, Integer>();
        for (int i = 0; i < T.length(); i++) {
            String tmp = T.substring(i, i + 1);
            if (S.contains(tmp)) {
                if (a.containsKey(tmp))
                    a.put(tmp, a.get(tmp) + 1);
                else
                    a.put(tmp, 1);

            } else {
                result = result + tmp;
            }


        }
        for (int j = 0; j < S.length(); j++) {
            String tmp1 = S.substring(j, j + 1);
            if (a.get(tmp1) != null) {
                for (int k = 0; k < a.get(tmp1); k++) {
                    result = result + tmp1;
                }
            }


        }
        return result;

    }


    // problem 841

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean all = true;
        Stack<Integer> s = new Stack<>();
        int[] array = new int[rooms.size()];

        int k = 0;
        List<Integer> keys = rooms.get(k++);
        for (int j = 0; j < keys.size(); j++) {
            int key = keys.get(j);
            s.push(key);
        }
        array[0] = 1;


        while (!s.empty()) {
            int room = s.pop();
            array[room] = 1;
            List<Integer> keys11 = rooms.get(room);
            for (int j = 0; j < keys11.size(); j++) {
                int key = keys11.get(j);
                if (array[key] == 0)
                    s.push(key);
            }

        }

        for (int arr : array) {
            if (arr == 0) {
                all = false;
                break;
            }

        }

        return all;
    }


    //problem 647
    public static int countSubstrings(String s) {

        int count = 0;

        if (s.length() > 1) {
            String next = s.substring(0, s.length() - 1);
            int sum = 0;

            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1))
                    sum = sum + 1;
                else
                    break;
            }

            count = sum + 1 + countSubstrings(next);

        } else
            count = 1;


        return count;

    }


    //problem 526
    public static int countArrangement(int N) {
        int totalMatchNum = 0;

        boolean array[] = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            array[i] = true;
        }
        totalMatchNum = countArr(1, N, array);
        return totalMatchNum;
    }

    public static int countArr(int start, int N, boolean array[]) {

        int index = start;
        int sum = 0;
        if (start == N) {
            for (int i = 1; i <= N; i++) {
                if (array[i]) {
                    int value = i;
                    if (value % index == 0 || index % value == 0) {
                        sum = 1;

                    } else {
                        sum = 0;
                    }
                }
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (array[i]) {
                    int value = i;
                    if (value % index == 0 || index % value == 0) {
                        array[i] = false;
                        sum += countArr(index + 1, N, array);
                        array[i] = true;

                    }

                }
            }

        }


        return sum;

    }


    //problem 739
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        List<Integer> index = new ArrayList<>();

        int currentValue = T[0];
        for (int i = 1; i < T.length; i++) {

            if (currentValue >= T[i]) {
                key.add(currentValue);
                value.add(1);
                index.add(i - 1);
            } else if (currentValue < T[i]) {
                result[i - 1] = 1;
                while (key.size() > 0) {
                    int pop = key.get(key.size() - 1);
                    if (pop < T[i]) {
                        result[index.get(index.size() - 1)] = value.get(key.size() - 1);
                        result[index.get(index.size() - 1)] = i - (index.get(index.size() - 1));
                        key.remove(key.size() - 1);
                        value.remove(value.size() - 1);
                        index.remove(index.size() - 1);
                    } else {
                        break;
                    }
                }


            }

            currentValue = T[i];
        }


        while (index.size() > 0) {
            result[index.get(index.size() - 1)] = 0;
            index.remove(index.size() - 1);
        }

        return result;
    }


    //problem 669

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // problem 287

    public static int findDuplicate(int[] nums) {

        int uniqNumber;

        int N = nums.length - 1;
        int sum = N * (N + 1) / 2;
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        uniqNumber = totalSum - sum;
        return uniqNumber;
    }




    static class Result {
        List<Integer> result;
        int sum;
    }

    public static int[] findFrequentTreeSum(TreeNode root) {

        if (root != null) {
            Result result = subTreeSum(root);
            List<Integer> collect = result.result;
            List<Integer> finalResult = new ArrayList<>();
            Map<Integer, Integer> freq = new HashMap<>();
            int MAX = 1;
            for (int sum : collect) {
                if (freq.containsKey(sum)) {
                    int newValue = freq.get(sum) + 1;
                    if (newValue >= MAX)
                        MAX = newValue;
                    freq.put(sum, newValue);
                } else {
                    freq.put(sum, 1);
                }
            }

            for (Map.Entry<Integer, Integer> a : freq.entrySet()) {
                if (a.getValue() == MAX) {
                    finalResult.add(a.getKey());
                }
            }
            int[] array = finalResult.stream().mapToInt(i -> i).toArray();
            return array;
        } else {
            int[] array = new int[]{};
            return array;
        }

    }


    public static Result subTreeSum(TreeNode root) {

        Result result = new Result();
        if (root != null) {
            List<Integer> tmp = new ArrayList<>();
            int leftSum, rightSum;
            if (root.left != null) {
                Result left = subTreeSum(root.left);
                List<Integer> leftList = left.result;
                tmp.addAll(leftList);
                leftSum = left.sum;
            } else {
                leftSum = 0;
            }
            if (root.right != null) {
                Result right = subTreeSum(root.right);
                List<Integer> rightList = right.result;
                tmp.addAll(rightList);
                rightSum = right.sum;
            } else {
                rightSum = 0;
            }

            result.sum = leftSum + rightSum + root.val;
            if (root.left == null && root.right == null) {
                tmp.add(root.val);
            } else {
                tmp.add(result.sum);
            }

            result.result = tmp;
        }

        return result;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static boolean isPalindrome(ListNode head) {
        boolean result = true;
        ListNode first = head;
        ListNode second = head;

        if (head != null) {
            ListNode reverse = new ListNode(head.val);
            while (second != null && second.next != null) {

                first = first.next;
                second = second.next.next;
                //逆转链表
                ListNode tmp = reverse;
                ListNode newTmp = new ListNode(first.val);
                newTmp.next = tmp;

                reverse = newTmp;
            }
            ListNode left, right;
            if (second != null) {
                left = reverse;
                right = first;
            } else {
                left = reverse.next;
                right = first;
            }

            while (right != null) {
                if (left.val != right.val) {
                    result = false;
                    break;
                }
                left = left.next;
                right = right.next;
            }

        }

        return result;

    }


    public static int longestPalindrome(String s) {

        int result = 0;
        if (s.length() > 0) {
            int[] values = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                values[c - 'a'] += 1;
            }
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < values.length; j++) {
                if (values[j] > 0) {
                    if (values[j] == 1) {
                        count1++;
                    } else {
                        count2 += (values[j] / 2);
                    }
                }
            }

            if (count1 > 0)
                result += 1;
            result += (count2 * 2);

        } else {
            result = 0;
        }


        return result;
    }

    public static boolean isSubsequence(String s, String t) {
        boolean result = false;
        if (s.length() > 1) {
            char c1 = s.charAt(0);
            //所有出现的位置
            List<Integer> indexs = findIndexs(t, c1);
            for (int index : indexs) {
                String subT = t.substring(index + 1);
                String subS = s.substring(1);
                boolean subsequence = isSubsequence(subS, subT);
                if (subsequence) {
                    result = true;
                    break;
                }
            }

        } else if (s.length() == 1) {
            char c1 = s.charAt(0);
            if (findIndexs(t, c1).size() > 0) {
                result = true;
            }

        } else if (s.length() == 0) {
            result = true;
        }

        return result;
    }

    public static List<Integer> findIndexs(String s, char target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                result.add(i);
            }
        }
        return result;
    }



    class FreqWord {
        String word;
        int freq;

        FreqWord(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        Queue<FreqWord> queue = new PriorityQueue<>(k, new Comparator<FreqWord>() {
            @Override
            public int compare(FreqWord o1, FreqWord o2) {
                int result;
                if (o1.freq != o2.freq) {
                    result = (o1.freq - o2.freq);
                } else {
                    result = o2.word.compareTo(o1.word);
                }
                return result;
            }


        });

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> tmp : map.entrySet()) {
            FreqWord freqWord = new FreqWord(tmp.getKey(), tmp.getValue());
            if (queue.size() < k) {
                queue.add(freqWord);
            } else {
                if (freqWord.freq > queue.peek().freq) {
                    queue.poll();
                    queue.add(freqWord);
                } else if (freqWord.freq == queue.peek().freq) {
                    if (freqWord.word.compareTo(queue.peek().word) < 0) {
                        queue.poll();
                        queue.add(freqWord);
                    }
                }
            }
        }

        while (queue.size() > 0) {
            stack.push(queue.poll().word);
        }
        while (stack.size() > 0) {
            result.add(stack.pop());
        }


        return result;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] value = new int[days.length];

        for (int i = 0; i < days.length; i++) {
            if (i == 0) {
                value[i] = costs[0];
            } else {
                int day1 = findPreIndex(days, i, 1);
                int day7 = findPreIndex(days, i, 7);
                int day30 = findPreIndex(days, i, 30);
                int value1, value7, value30;
                if (day1 == -1) {
                    value1 = costs[0];
                } else {
                    value1 = value[day1] + costs[0];
                }
                if (day7 == -1) {
                    value7 = costs[1];
                } else {
                    value7 = value[day7] + costs[1];
                }
                if (day30 == -1) {
                    value30 = costs[2];
                } else {
                    value30 = value[day30] + costs[2];
                }

                int tmp = Math.min(value1, value7);
                value[i] = Math.min(value30, tmp);
            }

        }
        return value[days.length - 1];
    }

    public int findPreIndex(int[] days, int endIndex, int backDay) {
        int index = endIndex;
        int startDay = days[index] - backDay + 1;
        int i;

        Boolean find = false;
        for (i = index; i >= 0; i--) {
            int currentDay = days[i];
            if (currentDay < startDay) {
                find = true;
                break;
            }
        }
        if (find)
            return i;
        else
            return -1;

    }


    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) curCnt++;
            else curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public int GetNumberOfK(int[] array, int k) {

        int small = 0, big = 0;
        int l = 0, h = array.length;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (array[mid] >= k)
                h = mid;
            else if (array[mid] < k)
                l = mid + 1;
        }
        small = l;
        System.out.println(small);
        /////////
        l = 0;
        h = array.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (array[mid] >= (k + 1))
                h = mid;
            else if (array[mid] < (k + 1))
                l = mid + 1;
        }
        big = l;

        if (small == array.length || array[small] != k)
            return 0;

        return big - small;

    }


    public int ladderLength(String start, String end, HashSet<String> dict) {

        int dis = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        dict.remove(start);
        dict.add(end);

        while (queue.size() > 0) {

            dis++;
            int cnt = queue.size();
            while (cnt-- > 0) {
                String poll = queue.poll();
                List<String> delete = new ArrayList<>();
                if (distance(poll, end) == 1) return dis;
                for (String dic : dict) {
                    if (distance(poll, dic) == 1) {
                        queue.add(dic);
                        delete.add(dic);
                    }
                }

                for (String del : delete) {
                    dict.remove(del);
                }
            }

        }
        return 0;
    }


    public int distance(String s1, String s2) {

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 1) {
                break;
            }
        }

        return count;
    }


    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        if (s == null || s.length() == 0)
            return true;
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (isChar(s.charAt(start))) {
                start++;
                continue;
            }
            if (isChar(s.charAt(end))) {
                end--;
                continue;
            }

            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                break;
            }
        }

        if (start >= end)
            return true;
        else
            return false;
    }

    boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || Character.isDigit(c);
    }


    int index = 1;

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] ret = new int[R * C][2];
        int distance = 1;
        boolean[][] visited = new boolean[R][C];

        ret[0][0] = r0;
        ret[0][1] = c0;
        visited[r0][c0] = true;

        while (index < (R * C)) {

            for (int i = 0; i <= distance; i++) {
                int j = distance - i;
                DFS(R, C, ret, visited, r0 + i, c0 + j);
                DFS(R, C, ret, visited, r0 - i, c0 + j);
                DFS(R, C, ret, visited, r0 + i, c0 - j);
                DFS(R, C, ret, visited, r0 - i, c0 - j);
            }

            distance++;
        }

        return ret;

    }


    void DFS(int R, int C, int[][] ret, boolean[][] visited, int r, int c) {
        if (r < R && r >= 0 && c < C && c >= 0 && !visited[r][c]) {
            visited[r][c] = true;
            ret[index][0] = r;
            ret[index][1] = c;
            index++;
        }
    }

    public static void main(String[] args) {


        org.algorithm.binarytree.TreeNode treeNode = TreeTool.buildTree(new Integer[]{4, 1, null, 2, null, 3});
        System.out.println(treeNode.val);
    }
}
