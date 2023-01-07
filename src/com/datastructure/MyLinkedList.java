package com.datastructure;

public class MyLinkedList {
    public class Node {
        private Integer item;
        private Node next;

        public Node(Integer item) {
            this.item = item;
        }
    }
    private Node head = null;
    // add, delete, printall
    public void add(Integer item) {
        Node node = this.head;
        Node prev = this.head;
        if (head != null) {
            while(node != null) {
                if(node.item > item) {
                    if(prev == node) {
                        Node newNode = new Node(item);
                        newNode.next = head;
                        head = newNode;
                        return;
                    } else {
                        Node newNode = new Node(item);
                        newNode.next = prev.next;
                        prev.next = newNode;
                        return;
                    }
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(item);
        } else {
            head = new Node(item);
        }
    }

    public boolean delete(Integer item) {
        if(this.head != null) {
            Node node = this.head;
            if(node.item == item) {
                this.head = this.head.next;
                return true;
            } else {
                while(node.next != null) {
                    if(node.next.item == item) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        } else {
            return false;
        }
    }

    public void printAll() {
        Node node = this.head;
        if(head != null) {
            System.out.println(node.item);
            while(node.next != null) {
                node = node.next;
                System.out.println(node.item);
            }
        } else {
            System.out.println("No items.");
        }
    }

    public static void main(String[] args){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(5);
        myLinkedList.add(3);
        myLinkedList.add(6);
        myLinkedList.add(2);
        myLinkedList.add(1);
        myLinkedList.add(4);
        myLinkedList.add(7);

        myLinkedList.printAll();

        myLinkedList.delete(5);
        myLinkedList.delete(2);
        myLinkedList.delete(7);
        myLinkedList.delete(1);
        myLinkedList.printAll();
    }

}


/*
package com.datastructure;

public class MyLinkedList<T> {
    public class Node<T> {
        T item;
        Node<T> next = null;

        public Node(T item) {
            this.item = item;
        }
    }

    private Node<T> head = null;

    public void add(T item) {
        if(this.head == null) {
            this.head = new Node<T>(item);
        } else {
            Node<T> node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(item);
        }
    }

    public Node<T> search(T item){
        if(this.head == null) {
            return null;
        } else {
            Node<T> node = head;
            while(node != null) {
                if(node.item == item) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void addInside(T item, T isItem) {
        Node<T> searchedNode = this.search(isItem);

        if(searchedNode == null) {
            this.add(item);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(item);
            searchedNode.next.next = nextNode;
        }
    }

    public boolean delete(T isItem) {
        if(this.head == null) return false;
        else {
            Node<T> node = head;
            if(node.item == isItem) {
                this.head = this.head.next;
                return true;
            } else {
                while(node.next != null) {
                    if(node.next.item == isItem) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public void printAll() {
        if(this.head != null) {
            Node<T> node = head;
            System.out.println(node.item);
            while(node.next != null) {
                node = node.next;
                System.out.println(node.item);
            }
        } else {
            System.out.println("No item");
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        myLinkedList.printAll();
        myLinkedList.delete(1);
        myLinkedList.delete(3);
        myLinkedList.delete(20);
        myLinkedList.printAll();
    }
}
 */