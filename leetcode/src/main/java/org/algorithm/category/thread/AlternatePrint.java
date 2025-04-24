package org.algorithm.category.thread;

public class AlternatePrint {
    private static final Object lock = new Object();
    private static int count = 1;
    private static final int MAX = 10;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count > MAX) break;
                    System.out.println("Thread A: " + count++);
                    lock.notify();  // 唤醒 B
                    if (count <= MAX) {
                        try {
                            lock.wait();  // 自己挂起
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count > MAX) break;
                    System.out.println("Thread B: " + count++);
                    lock.notify();  // 唤醒 A
                    if (count <= MAX) {
                        try {
                            lock.wait();  // 自己挂起
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}

