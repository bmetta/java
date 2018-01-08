import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.Comparator;

class Arraylist {
 public static void main(String[] args) {
  ArrayList<String> al = new ArrayList<String>();
  /* boolean add(E e)
   * Appends the specified element to the end of this list.
   */
  al.add("One"); // {One}
  al.add("Three"); // {One, Three}
  System.out.println(al.toString()); // [One, Three]

  /* void add(int index, E element)
   * Inserts the specified element at the specified position in this list.
   */
  al.add(1, "Two"); // {One, Two, Three}
  System.out.println(al.toString()); // [One, Two, Three]

  /* boolean addAll(Collection<? extends E> c)
   * Appends all of the elements in the specified collection to the end of this list,
   * in the order that they are returned by the specified collection's Iterator.
   */
  ArrayList<String> al2 = new ArrayList<String>() {
    {add("Four");
     add("Five");
     add("Six");}};
  al.addAll(al2); // {Four, Five, Six} inserts at {One, Two, Three, ^}
  System.out.println(al.toString()); // [One, Two, Three, Four, Five, Six]

  /* boolean addAll(int index, Collection<? extends E> c)
   * Inserts all of the elements in the specified collection into this list,
   * starting at the specified position.
   */
  al.addAll(3, al2); // {Four, Five, Six} inserts at [One, Two, Three, ^, Four, Five, Six]
  System.out.println(al.toString()); // [One, Two, Three, Four, Five, Six, Four, Five, Six]

  /* void clear()
   * Removes all of the elements from this list.
   */
  //al.clear();
  //System.out.println(al.toString()); // []

  /* Object clone()
   * Returns a shallow copy of this ArrayList instance.
   */
  Object clone_al1 = al.clone(); // {One, Two, Three, Four, Five, Six, Four, Five, Six}
  System.out.println(clone_al1.toString()); // [One, Two, Three, Four, Five, Six, Four, Five, Six]

  /* boolean contains(Object o)
   * Returns true if this list contains the specified element.
   */
  boolean found = al.contains("Four");
  System.out.println("Found: " + found);  // true

  /* void ensureCapacity(int minCapacity)
   * Increases the capacity of this ArrayList instance, if necessary,
   * to ensure that it can hold at least the number of elements specified
   * by the minimum capacity argument.
   */
  al.ensureCapacity(50);
  // TODO: check for API to check the capacity

  /* void forEach(Consumer<? super E> action)
   * Performs the given action for each element of the Iterable until
   * all elements have been processed or the action throws an exception.
   */
  al.forEach(str -> System.out.print(str +  " ")); // One Two Three Four Five Six Four Five Six
  System.out.println();

  /* E get(int index)
   * Returns the element at the specified position in this list.
   */
  Object element = al.get(2); // Three
  System.out.println("get(2): " + element);

  /* int indexOf(Object o)
   * Returns the index of the first occurrence of the specified element in
   * this list, or -1 if this list does not contain the element.
   */
  int index = al.indexOf("Five"); // 4
  System.out.println("Index of Five: " + index);

  /* boolean isEmpty()
   * Returns true if this list contains no elements.
   */
  System.out.println("isEmpty: " + al.isEmpty()); // false

  /* Iterator<E> iterator()
   * Returns an iterator over the elements in this list in proper sequence.
   * universal iterator as we can apply it to any Collection object.
   * Only forward direction iterating is possible
   *
   * Iterator interface defines three methods:
   * public boolean hasNext();
   * public Object next();
   * public void remove();
   */
  Iterator it = al.iterator();
  while (it.hasNext()) {
    System.out.print(it.next() + " ");
  } System.out.println();

  /* int lastIndexOf(Object o)
   * Returns the index of the last occurrence of the specified element
   * in this list, or -1 if this list does not contain the element.
   */
  int last_index = al.lastIndexOf("Five"); // 7
  System.out.println("last index of Five: " + last_index);

  /* ListIterator<E> listIterator()
   * Returns a list iterator over the elements in this list (in proper sequence).
   * only applicable for List collection implemented classes like arraylist,
   * linkedlist etc.
   * It provides bi-directional iteration.
   *
   * ListIterator interface defines following methods:
   * public boolean hasNext();
   * public Object next();
   * public int nextIndex();
   * public boolean hasPrevious();
   * public Object previous();
   * public int previousIndex();
   * public void remove();
   * public void set(Object obj);
   * public void add(Object obj);
   */
  ListIterator litr = al.listIterator();
  while (litr.hasNext()) {
    System.out.print(litr.next() + " ");
  } System.out.println();

  /* ListIterator<E> listIterator(int index)
   * Returns a list iterator over the elements in this list (in proper sequence),
   * starting at the specified position in the list.
   */
  ListIterator litrI = al.listIterator(2);
  while (litrI.hasNext()) {
    System.out.print(litrI.next() + " ");
  } System.out.println();

  /* E remove(int index)
   * Removes the element at the specified position in this list.
   */
  Object removed_object = al.remove(6); // removes index 6 (ie: Four) from {One, Two, Three, Four, Five, Six, (Four), Five, Six}
  System.out.println("Removed object: " + removed_object);

  /* boolean remove(Object o)
   * Removes the first occurrence of the specified element from this list,
   * if it is present.
   */
  boolean isRemoved = al.remove("Two"); // removes first "Two" from {One, (Two), Three, Four, Five, Six, Five, Six}
  System.out.println("Removed Two: " + isRemoved); // true
  System.out.println(al.toString()); // {One, Three, Four, Five, Six, Five, Six}

  /* boolean removeAll(Collection<?> c)
   * Removes from this list all of its elements that are contained in the
   * specified collection.
   * returns true if atleast one element from collection removed
   */
  ArrayList<String> alNew = new ArrayList<String>() {
    {add("Two"); add("Four"); add("Five");}
  };
  boolean isAllRemoved = al.removeAll(alNew); // removes {Two, Four, Five} from {One, Three, Four, Five, Six, Five, Six}
  System.out.println("sublist removed: " + isAllRemoved); // true
  System.out.println(al.toString()); // {One, Three, Six, Six}

  /* boolean removeIf(Predicate<? super E> filter)
   * Removes all of the elements of this collection that satisfy the given predicate.
   */
  String word = "Six";
  Predicate<String> predicate = item -> item == word;
  //boolean isPredRemoved = al.removeIf(item -> item == "Six");
  boolean isPredRemoved = al.removeIf(predicate); // removes "Six" from {One, Three, Six, Six}
  System.out.println(al.toString()); // {One, Three}

  // Filling the ArrayList
  al.add(1, "Two"); // {One, Two, Three}
  al.addAll(new ArrayList<String>(){{add("Four"); add("Five"); add("Six"); add("Seven");};});
  System.out.println(al.toString()); // {One, Two, Three, Four, Five, Six, Seven}

  /* protected void removeRange(int fromIndex, int toIndex)
   * Removes from this list all of the elements whose index is between fromIndex,
   * inclusive, and toIndex, exclusive.
   * public class ArrayListDemo extends ArrayList {
   *   public static void main(String[] args) {
   *     ArrayListDemo arrlist = new ArrayListDemo();
   *     arrlist.removeRange(2, 5);
   */
  /* void replaceAll(UnaryOperator<E> operator)
   * Replaces each element of this list with the result of applying the operator
   * to that element.
   */
  UnaryOperator<String> uoRef = (x) -> x.toUpperCase();
  ArrayList<String> rList = new ArrayList<String>();
  rList.addAll(al);
  rList.replaceAll(uoRef);
  System.out.println(rList.toString()); // {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN}

  /* boolean retainAll(Collection<?> c)
   * Retains only the elements in this list that are contained in the specified collection.
   */
  ArrayList<String> retainList = new ArrayList<String>() {{add("Two"); add("Four"); add("Ten");};};
  al.retainAll(retainList);
  System.out.println(al.toString()); // {Two, Four}

  /* E set(int index, E element)
   * Replaces the element at the specified position in this list with the specified element.
   */
  al.set(0, "One"); // {One, Four}
  System.out.println(al.toString()); // {One, Four}

  /* int size()
   * Returns the number of elements in this list.
   */
  System.out.println(al.size()); // 2

  /* void sort(Comparator<? super E> c)
   * Sorts this list according to the order induced by the specified Comparator.
   */
  al.addAll(new ArrayList<String>(){{add("Four"); add("Five"); add("Six"); add("Seven");};});

  class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      return s1.compareTo(s2);
    }
  }
  StringComparator comparator = new StringComparator();
  al.sort(comparator);
  System.out.println(al.toString()); // {Five, Four, Four, One, Seven, Six}

  /* Spliterator<E> spliterator()
   * Creates a late-binding and fail-fast Spliterator over the elements in this list.
   * TODO
   */

  /* List<E> subList(int fromIndex, int toIndex)
   * Returns a view of the portion of this list between the specified fromIndex,
   * inclusive, and toIndex, exclusive.
   */
  ArrayList<String> subListAl = new ArrayList<String>(al.subList(2, 5)); // {Five, Four, [Four, One, Seven], Six}
  System.out.println(subListAl.toString()); // {Four, One, Seven}

  /* Object[] toArray()
   * Returns an array containing all of the elements in this list in proper sequence
   * (from first to last element).
   */
  Object[] objArray = al.toArray(); // {Five, Four, Four, One, Seven, Six}
  System.out.println(objArray.toString());  // displays objArray address
  for (Object value: objArray) {
    System.out.print(value + " ");
  } System.out.println(); // {Five, Four, Four, One, Seven, Six}

  /* <T> T[] toArray(T[] a)
   * Returns an array containing all of the elements in this list in proper sequence
   * (from first to last element); the runtime type of the returned array is that of
   * the specified array.
   */
  String array[] = new String[al.size()];
  array = al.toArray(array);
  for (String str : array) {
    System.out.print(str + " ");
  } System.out.println(); // [Five, Four, Four, One, Seven, Six]

  /* void trimToSize()
   * Trims the capacity of this ArrayList instance to be the list's current size.
   * create an empty array list with capacity 50
   */
  ArrayList<Integer> numbers = new ArrayList<Integer>(50);
  // add only 4 elements to array
  numbers.add(new Integer(10));
  numbers.add(new Integer(20));
  numbers.add(new Integer(30));
  numbers.add(new Integer(40));

  numbers.trimToSize();
  for (Integer num : numbers) {
    System.out.print(num + " ");
  } System.out.println(); // 10 20 30 40
 }
}
