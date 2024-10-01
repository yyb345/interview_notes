package org.algorithm.stack;

import java.util.Stack;

//TODO
public class BackspaceCompare {

    // problem 844
    public static boolean backspaceCompare(String S, String T) {
        boolean result = true;
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (stackS.size() > 0) {
                    stackS.pop();
                }
            } else {
                stackS.push(S.charAt(i));
            }
        }
        for (int j = 0; j < T.length(); j++) {
            if (T.charAt(j) == '#') {
                if (stackT.size() > 0) {
                    stackT.pop();
                }
            } else {
                stackT.push(T.charAt(j));
            }
        }


        if (stackS.size() != stackT.size()) {
            result = false;
        } else {
            if (stackS.size() == 0) {
                result = true;
            } else {
                while (stackS.size() > 0) {
                    Character popS = stackS.pop();
                    Character popT = stackT.pop();
                    if (!popS.equals(popT)) {
                        result = false;
                        break;
                    }

                }
            }

        }

        return result;
    }
}
