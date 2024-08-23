package streams;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

public class SpliteratorInternal {
    static public void main(String[] argv) {
        // Create a list of strings containing words from a famous
        // quote from the Shakespeare play "Hamlet."
        List<String> bardQuote =
                List.of("This ", "above ", "all");

        // Show the various spliterator examples.
        showTryAdvance(bardQuote);
       /* showTrySplit(bardQuote);
        showStream(bardQuote);
        showParallelStream(bardQuote);
        showStreamSupport(bardQuote);*/
    }

    /**
     * Show how the Spliterator tryAdvance() method can be use
     * to traverse through a collection.
     */
    private static void showTryAdvance(List<String> quote) {
        System.out.println("\n++Showing the tryAdvance() method:");

        // Traverse through the words in the quote and print each one.
        // Keep iterating until there are no more words.
        for (Spliterator<String> s = quote.spliterator();s.tryAdvance(SpliteratorInternal::display);){

            continue;
        }
    }

    /**
     * Show how the Spliterator trySplit() method can be use to
     * traverse through two halves of a collection.
     */
    private static void showTrySplit(List<String> quote) {
        System.out.println("\n\n++Showing the trySplit() method:");

        // Create a spliterator.
        Spliterator<String> secondHalf = quote.spliterator();

        // Split the spliterator in half.
        Spliterator<String> firstHalf = secondHalf.trySplit();

        System.out.println("--Traversing the first half of the spliterator");

        // Use the bulk forEachRemaining() method to print out the
        // first half of the spliterator.
        firstHalf.forEachRemaining(SpliteratorInternal::display);

        System.out.println("\n--Traversing the second half of the spliterator");

        // Use the bulk forEachRemaining() method to print out the
        // second half of the spliterator.
        secondHalf.forEachRemaining(SpliteratorInternal::display);
    }

    /**
     * Show how the stream() factory method can implicitly use a
     * spliterator to create a sequential stream.
     */
    private static void showStream(List<String> quote) {
        System.out.println("\n\n++Showing the stream() factory method:");

        quote
                // Implicitly use a spliterator to create a sequential
                // stream.
                .stream()

                // Print out each element of the stream.
                .forEach(SpliteratorInternal::display);
    }

    /**
     * Show how the parallelStream() factory method can implicitly use a
     * spliterator to create a parallel stream.
     */
    private static void showParallelStream(List<String> quote) {
        System.out.println("\n\n++Showing the parallel() factory method:");

        quote
                // Implicitly use a spliterator to create a parallel
                // stream.
                .parallelStream()

                // Print out each element of the stream.
                .forEach(SpliteratorInternal::display);
    }

    /**
     * Show how the StreamSupport.stream() method can be used to
     * explicitly create a stream from a spliterator.
     */
    private static void showStreamSupport(List<String> quote) {
        System.out.println("\n\n++Showing the StreamSupport.stream() method:");

        StreamSupport
                // Explicitly use a spliterator to create a sequential
                // stream.
                .stream(quote.spliterator(),
                        false)

                // Print out each element of the stream.
                .forEach(SpliteratorInternal::display);
    }

    /**
     * Print the {@link String}.
     */
    private static void display(String string) {
        System.out.println("["
                + Thread.currentThread().getId()
                + "] "
                + string);
    }
}