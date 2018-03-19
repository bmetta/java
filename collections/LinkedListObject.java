class Node {
  public Object data;
  public Node  link;
  
  public Node(Object val) {
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

class LinkedList {
  private Node head;

  public LinkedList() {
    this.head = null;
  }

  public void add(Object val) {
    Node node = new Node(val);
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

class LinkedListObject {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    for (int i = 0; i < 5; ++i) {
      list.add(i);
    }
    list.add("Hi");
    list.add("Hello");
    list.display();
  }
}
