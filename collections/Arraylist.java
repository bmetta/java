import java.util.*;
import java.util.function.Predicate;

class Arraylist {
 public static void main(String[] args) {
  ArrayList<String> al1 = new ArrayList<String>();
  // boolean add(E e)
  // Appends the specified element to the end of this list.
  al1.add("One");
  al1.add("Three");
  System.out.println(al1.toString());

  // void add(int index, E element)
  // Inserts the specified element at the specified position in this list.
  al1.add(1, "Two");
  System.out.println(al1.toString());

  // boolean addAll(Collection<? extends E> c)
  // Appends all of the elements in the specified collection to the end of this list,
  // in the order that they are returned by the specified collection's Iterator.
  ArrayList<String> al = new ArrayList<String>() {
    {
      add("Four");
      add("Five");
      add("Six");
    }
  };
  al1.addAll(al);
  System.out.println(al1.toString());

  // boolean addAll(int index, Collection<? extends E> c)
  // Inserts all of the elements in the specified collection into this list,
  // starting at the specified position.
  al1.addAll(3, al);
  System.out.println(al1.toString());

  // void clear()
  // Removes all of the elements from this list.
  //al1.clear();
  //System.out.println(al1.toString());

  // Object clone()
  // Returns a shallow copy of this ArrayList instance.
  Object clone_al1 = al1.clone();
  System.out.println(clone_al1.toString());

  // boolean contains(Object o)
  // Returns true if this list contains the specified element.
  boolean found = al1.contains("Four");
  System.out.println("Found: " + found);

  // void ensureCapacity(int minCapacity)
  // Increases the capacity of this ArrayList instance, if necessary,
  // to ensure that it can hold at least the number of elements specified
  // by the minimum capacity argument.
  al1.ensureCapacity(100);
  // TODO: check for API to check the capacity

  // void forEach(Consumer<? super E> action)
  // Performs the given action for each element of the Iterable until 
  // all elements have been processed or the action throws an exception.
  al1.forEach(str -> System.out.print(str + " "));
  System.out.println();

  // E get(int index)
  // Returns the element at the specified position in this list.
  Object element = al1.get(2);
  System.out.println("get(2): " + element);

  // int indexOf(Object o)
  // Returns the index of the first occurrence of the specified element in
  // this list, or -1 if this list does not contain the element.
  int index = al1.indexOf("Five");
  System.out.println("Index of Five: " + index);

  // boolean isEmpty()
  // Returns true if this list contains no elements.
  System.out.println("isEmpty: " + al1.isEmpty());

  // Iterator<E> iterator()
  // Returns an iterator over the elements in this list in proper sequence.
  // universal iterator as we can apply it to any Collection object.
  // Only forward direction iterating is possible
  //
  // Iterator interface defines three methods:
  // public boolean hasNext();
  // public Object next();
  // public void remove();
  Iterator it = al1.iterator();
  while (it.hasNext()) {
    System.out.print(it.next() + " ");
  }
  System.out.println();

  // int lastIndexOf(Object o)
  // Returns the index of the last occurrence of the specified element
  // in this list, or -1 if this list does not contain the element.
  int last_index = al1.lastIndexOf("Five");
  System.out.println("last index of Five: " + last_index);

  // ListIterator<E> listIterator()
  // Returns a list iterator over the elements in this list (in proper sequence).
  // only applicable for List collection implemented classes like arraylist,
  // linkedlist etc.
  // It provides bi-directional iteration.
  //
  // ListIterator interface defines following methods:
  // public boolean hasNext();
  // public Object next();
  // public int nextIndex();
  // public boolean hasPrevious();
  // public Object previous();
  // public int previousIndex();
  // public void remove();
  // public void set(Object obj);
  // public void add(Object obj);
  ListIterator litr = al1.listIterator();
  while (litr.hasNext()) {
    System.out.print(litr.next() + " ");
  }
  System.out.println();

  // ListIterator<E> listIterator(int index)
  // Returns a list iterator over the elements in this list (in proper sequence),
  // starting at the specified position in the list.
  ListIterator litrI = al1.listIterator(2);
  while (litrI.hasNext()) {
    System.out.print(litrI.next() + " ");
  }
  System.out.println();

  // E remove(int index)
  // Removes the element at the specified position in this list.
  Object removed_object = al1.remove(6);
  System.out.println("Removed object: " + removed_object);

  // boolean remove(Object o)
  // Removes the first occurrence of the specified element from this list,
  // if it is present.
  boolean isRemoved = al1.remove("Two");
  System.out.println("Removed Two: " + isRemoved);
  System.out.println(al1.toString());

  // boolean removeAll(Collection<?> c)
  // Removes from this list all of its elements that are contained in the
  // specified collection.
  // returns true if atleast one element from collection removed
  ArrayList<String> alNew = new ArrayList<String>() {
    {add("Two"); add("Four"); add("Five");}
  };
  boolean isAllRemoved = al1.removeAll(alNew);
  System.out.println("sublist removed: " + isAllRemoved);
  System.out.println(al1.toString());

  // boolean removeIf(Predicate<? super E> filter)
  // Removes all of the elements of this collection that satisfy the given predicate.
  String word = "Six";
  Predicate<String> predicate = item -> item == word;
  //boolean isPredRemoved = al1.removeIf(item -> item == "Six");
  boolean isPredRemoved = al1.removeIf(predicate);
  System.out.println(al1.toString());
  
  // Filling the ArrayList
  al1.add(1, "Two");
  al1.addAll(new ArrayList<String>(){{add("Four"); add("Five"); add("Six"); add("Seven");};});
  System.out.println(al1.toString());

  // protected void removeRange(int fromIndex, int toIndex)
  // Removes from this list all of the elements whose index is between fromIndex,
  // inclusive, and toIndex, exclusive.
  //
  // public class ArrayListDemo extends ArrayList {
  //   public static void main(String[] args) {
  //     ArrayListDemo arrlist = new ArrayListDemo();
  //     arrlist.removeRange(2, 5);

  // void replaceAll(UnaryOperator<E> operator)
  // Replaces each element of this list with the result of applying the operator
  // to that element.

  // boolean retainAll(Collection<?> c)
  // Retains only the elements in this list that are contained in the specified collection.

  // E set(int index, E element)
  // Replaces the element at the specified position in this list with the specified element.

  // int size()
  // Returns the number of elements in this list.
  
  // void sort(Comparator<? super E> c)
  // Sorts this list according to the order induced by the specified Comparator.

  // Spliterator<E> spliterator()
  // Creates a late-binding and fail-fast Spliterator over the elements in this list.

  // List<E> subList(int fromIndex, int toIndex)
  // Returns a view of the portion of this list between the specified fromIndex,
  // inclusive, and toIndex, exclusive.

  // Object[] toArray()
  // Returns an array containing all of the elements in this list in proper sequence
  // (from first to last element).
  
  // <T> T[] toArray(T[] a)
  // Returns an array containing all of the elements in this list in proper sequence
  // (from first to last element); the runtime type of the returned array is that of
  // the specified array.

  // void trimToSize()
  // Trims the capacity of this ArrayList instance to be the list's current size.
 }
}
