package generics;

class Node<T> {

    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

public class MyNode extends Node<Integer> {

    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
    /*public void setData(Object data) {
    	System.out.println("MyNode...");
        super.setData(data);
    }*/
    public static void main(String[] args) {
    	Node mn = new MyNode(5);
    	mn.setData("aaa");
	}
}