import java.util.EmptyStackException;

public class Stack {


    private class Node{
        private String value;
        private Node link;

        public Node(String value, Node link) {
            this.value = value;
            this.link = link;
        }
    }

    private Node head;

    public void push(String value){
        head = new Node(value, head);
    }

    public void pop(){
        if (head == null){
            throw new EmptyStackException();
        }
        head = head.link;
    }

    public boolean empty() {
        return (head == null);
    }

    public String peek(){
        if (head == null){
            throw new EmptyStackException();
        }
        return head.value;
    }
}
