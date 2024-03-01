package labs.lab8;

import java.util.Iterator;

public class IterableUtil {
    /**
     * Takes as input any object that implements the Iterable<E> interface and
     * returns
     * a string containing the object's elements, each one separated by a comma
     * and a
     * space
     *
     * @param <T>      type of object that implements Iterable
     * @param <E>      the Iterable type
     * @param iterable the object that is Iterable
     * @return a string containing the object's elements, each one separated by
     * a
     * comma and a space
     */

    public static <E> String print(Iterable<E> iterable) {
        if (iterable == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (E element : iterable) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(element.toString());
        }
        return builder.toString();
    }
}
