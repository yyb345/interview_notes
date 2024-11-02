package org.algorithm.stack;

import java.util.Stack;

public class BrowserHistory {

    Stack<String> history;
    Stack<String> forward;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        forward = new Stack<>();
        history.push(homepage);
    }

    public void visit(String url) {
        forward.clear();
        history.push(url);
    }

    public String back(int steps) {
        while(history.size()>1 && steps>0){
            forward.push(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while(!forward.isEmpty() && steps>0){
            history.push(forward.pop());
            steps--;
        }
        return history.peek();
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));

    }
}
