package generic;

import java.util.List;

public class GenericClass<T extends MathNumber,M extends MathString> {

    public  T getFirstElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        T t = list.get(0);
        t.sub(1);
        return t;
    }


    public T getSub(T t,M m){
        int val = t.val;
        String sval = m.val;
        t.sub(Integer.parseInt(sval));
        return t ;
    }


}
