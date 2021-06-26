# double linked list
```java
public class Node(){
  private Node previous;
  private Node next;
  private int val;
  
  public Node getPrevious(){
    return this.previous;
  }
  
  public Node getNext(){
    return this.next;
  }
  
  public void setNext(Node next){
    this.next = next;
  }
  
  public void setPrevious(Node previous){
    this.previous = previous;
  }
  
  public int getVal(){
    return this.val;
  }
  
  public Node(int val){
    this.val = val;
  }
}
```