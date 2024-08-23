package concurrency;


import java.util.List;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class StructuredConcurrency {
    record Shelter(String name) {
    }

    record Dog(String name) {
    }

    record Response(Shelter shelter, List<Dog> dogs) {
    }

    private static Shelter getShelter() {
        return new Shelter("Shelter");
    }

    private static List<Dog> getDogs() {
        return List.of(new Dog("Buddy"), new Dog("Simba"));
    }

    public static void main(String[] args) throws InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<Shelter> shelter = scope.fork(StructuredConcurrency::getShelter);
            Supplier<List<Dog>> dogs = scope.fork(StructuredConcurrency::getDogs);
            scope.join();
            Response response = new Response(shelter.get(), dogs.get());
            System.out.println(response);
        }
    }
}
