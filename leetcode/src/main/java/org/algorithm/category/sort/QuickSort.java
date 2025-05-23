package org.algorithm.category.sort;

public class QuickSort {

    // 主函数，开始排序
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    // 快速排序的递归函数
    private void quickSort(int[] array, int low, int high) {
        if (low > high) {
            return;
        }

        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1); // 对左部分进行排序
        quickSort(array, pivotIndex + 1, high); // 对右部分进行排序
    }

    // 分区函数，返回枢轴的最终位置
//    private int partition(int[] array, int low, int high) {
//        int pivot = array[high]; // 选择最后一个元素作为枢轴
//        int i = low; // 小于枢轴的元素的边界
//
//        for (int j = low; j < high; j++) {
//            if (array[j] < pivot) { // 如果当前元素小于枢轴
//                swap(array, i, j); // 交换当前元素和小于枢轴的元素
//                i++;
//            }
//        }
//        swap(array, i , high); // 将枢轴元素放到正确的位置
//        return i ; // 返回枢轴的索引
//    }

    int partition(int[] nums,int l,int h){

        int target = nums[l];
        int i = l; // 左指针
        int j = h+1; // 右指针
        while(true){

            while(nums[++i]<=target && i<h);
            while(nums[--j]>target && j>l);
            if(i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    // 交换数组中两个元素的辅助函数
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 测试主程序
    public static void main(String[] args) {



    }
}
