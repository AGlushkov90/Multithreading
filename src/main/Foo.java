package src.main;

import java.util.concurrent.Semaphore;

public class Foo {
    private final Semaphore SECOND_SEMAPHORE = new Semaphore(0);
    private final Semaphore THIRD_SEMAPHORE = new Semaphore(0);

    public void first() {
        try {
            System.out.print("first");
        } finally {
            SECOND_SEMAPHORE.release();
        }
    }

    public void second() {
        try {
            SECOND_SEMAPHORE.acquire();
            System.out.print("second");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            THIRD_SEMAPHORE.release();
        }
    }

    public void third() {
        try {
            THIRD_SEMAPHORE.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("third");
    }
}
