package leetcode.slidewindow;

//TODO 重新理解一下
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;
        for(int i=0;i<gas.length;i++){
            sum+= (gas[i]-cost[i]);
        }
        if(sum<0){
            return -1;
        }

        if(gas.length==1){
            return 0;
        }


        int slideSum=0;
        int l = 0;

        for(int k=0;k<gas.length;){
            slideSum = slideSum +(gas[k]-cost[k]);
            if(slideSum<0){
                k++;
                l=k;
                slideSum = 0;
            }else {
                k++;
            }
        }

        return l;

    }
}
