package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GTest {

    Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args){

        GenericClass genericClass = new GenericClass();

        List<MathNumber> numberList = new ArrayList<>();
        numberList.add(new MathNumber(1));
        numberList.add(new MathNumber(2));
        numberList.add(new MathNumber(3));

        System.out.println( genericClass.getFirstElement(numberList).val);
    }
}
