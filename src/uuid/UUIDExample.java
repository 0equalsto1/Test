package uuid;

import java.util.UUID;
import java.util.stream.IntStream;

import static java.lang.Thread.*;

public class UUIDExample {
    public static void main(String[] args) {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();
        System.out.println("Random UUID: " + uuid.toString());
        IntStream.range(1,10).forEach(UUIDExample::accept);

    }

    private static void accept(int e) {
        ofPlatform().start(() -> System.out.println("Random UUID: " + UUID.randomUUID()));
    }
}
