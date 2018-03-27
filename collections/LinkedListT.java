class Node<T> {
  public T     data;
  public Node  link;
  
  public Node(T val) {
    this.data = val;
    this.link = null;
  }
  public boolean hasNext() {
    return link != null;
  }
  public Node next() {
    return link;
  }
}

class LinkedList<T> {
  private Node head;

  public LinkedList() {
    this.head = null;
  }

  public void add(T val) {
    Node<T> node = new Node<T>(val);
    if (this.head == null) {
      this.head = node;
      return;
    }
    node.link = this.head;
    this.head = node;
  }

  public void display() {
    Node node = this.head;
    while (node.hasNext()) {
      System.out.print(node.data + " ");
      node = node.next();
    }
    System.out.println();
  }
}

class LinkedListT {
  public static void main(String[] args) {
    LinkedList<Integer> int_list = new LinkedList<Integer>();
    for (int i = 0; i < 10; ++i) {
      int_list.add(i);
    }
    int_list.display();

    LinkedList<Object> obj_list = new LinkedList<Object>();
    obj_list.add("Hi");
    obj_list.add(10);
    obj_list.add('c');
    obj_list.add("Hello");
    obj_list.display();
  }
}
