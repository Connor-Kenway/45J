package labs.lab8;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Main {
	
	
	/**
	 * Given a Map<K, V>, as a parameter, returns a List<Pair<K, V>> of the
	 * key/value pairs in the map
	 *
	 * @param <K>    type of the key
	 * @param <V>    type of the value
	 * @param map    input map
	 * @param colors
	 * @return a List<Pair<K, V>> of the  key/value pairs in the map
	 */
	// WRITE YOUR PROBLEM 1 METHOD HERE
	public static <K, V> List<Pair<K, V>> problem1_mapToList(Map<K, V> map) {
		List<Pair<K, V>> list = new ArrayList<>();
		for (Map.Entry<K, V> entry: map.entrySet()) {
			list.add(new Pair<>(entry.getKey(), entry.getValue()));
		}
		return list;
	}
	
	/**
	 * Takes a Pair, swaps the two elements, and returns it
	 * 
	 * @param <T>	type of the first element in the pair
	 * @param <S>	type of the second element in the pair
	 * @param p		the pair to swap
	 * 
	 * @return		the swapped pair
	 */
	public static <T, S> Pair<T, S> problem2_swap(Pair<S, T> p){
        return new Pair<>(p.getSecond(), p.getFirst());
	}
	
	
	/**
	 * Takes a generic list and returns true if it its elements are in decreasing
	 * order, or false if not. Decreasing order in this case means non-increasing,
	 * so there can be multiple equivalent elements next to each other (e.g., 4, 2,
	 * 2, 0) and it will still be considered decreasing.
	 * 
	 * @param <T> the type of element in the list
	 * @param a   the list to check for decreasing order
	 * 
	 * @return true if decreasing, false if not
	 */
	// WRITE PROBLEM 4 METHOD HERE
	public static <T extends Comparable<T>> boolean problem4_isDecreasing(List<T> a) {
		if (a == null || a.isEmpty()) {
			return true;
		}

		for (int i = 0; i < a.size() - 1; i++) {
			T current = a.get(i);
			T next = a.get(i + 1);

			if (current.compareTo(next) < 0) {
				return false;
			}
		}

		return true;
	}

//	public static void main(String[] args) {
}
