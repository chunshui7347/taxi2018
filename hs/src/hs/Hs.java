public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public MyLinkedList(){
        head = null;
        tail = head;
        size = 0;
    }

    public void add(E e){
        Node<E> newNode = new Node<E>(e);
        if(head == null){
            head = newNode;
            tail = head;
            size++;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        size++;
    }

    public void removeElement(E e){
        if(head==null)
            return;
        Node<E> current = head;
        if(head==tail){
            if(current.element.equals(e)){
                head = null;
                tail = head;
                size--;
                return;
            }
        }else {
            for (int i=0; i < size; i++) {
                if (current.element.equals(e)) {
                    head = head.next;
                    size--;
                    return;
                } else if (current.next == tail) {
                    if (tail.element.equals(e)) {
                        tail = current;
                        tail.next = null;
                        size--;
                        return;
                    }
                } else if (current.next.element.equals(e)) {
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
        }
    }

    public boolean contains(E e){
        if(head == null)
            return false;
        Node<E> current = head;
        for(int i=0;i<size;i++){
            if(current.element.equals(e))
                return true;
            current=current.next;
        }
        return false;
    }

    public int getSize(){
        return size;
    }

    public void printList(){
        if(head == null){
            System.out.println("The list is empty.");
            return;
        }
        Node<E> current = head;
//        System.out.println("You have entered the following students' name : ");
        for(int i=0;i<size;i++){
            if(i==size-1){
                System.out.println(current.element + ".");
                return;
            }
            System.out.print(current.element + ",");
            current = current.next;
        }
        System.out.println();
        return;
    }

    public void replace(E e, E newE){
        if(head==null){
            return;
        }
        Node<E> current = head;
        for(int i=0;i<size;i++){
            if(current.element.equals(e)){
                current.element=newE;
                return;
            }
            current = current.next;
        }
        return;
    }
}
