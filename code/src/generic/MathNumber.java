package generic;

import lombok.Builder;
import lombok.Data;


@Data
public class MathNumber {

    int val;

   public MathNumber(int val){
        this.val=val;
    }

   public void sub(int num){
       this.val=this.val-num;
   }




}
