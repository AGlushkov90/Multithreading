package src.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Foo Foo = new Foo();
        try (
                ExecutorService executor = Executors.newFixedThreadPool(3)
        ) {
            executor.submit(Foo::first);
            executor.submit(Foo::second);
            executor.submit(Foo::third);
        }
    }
}
