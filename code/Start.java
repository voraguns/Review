class Start {
    public static void main(String[] data) {
        int[] a = { 8, 5, 4, 2, 7, 1, 9, 3 };
        
        Element list = create(a);
        showList(list);
        
        System.out.println();
        System.out.println("The number of node is " + countNode(list));
        System.out.println("Total sum of element is " + findSum(list));
        System.out.println("The maximum value in linked list is " + findMax(list).value);
 
        showReverseList(list);
    }
    
    
    // create linked list
    static Element createList(int ... data) {
        Element head = null;
        Element tail = null;
        
        for(int i = 0; i < data.length; i++){
            if(tail == null) {
                tail = new Element();
                tail.value = data[i];
                head = tail;
            } else {
                tail.next = new Element();
                tail.next.value = data[i];
                tail = tail.next;
            }
        }       
        return head;
    }
    
    static Element create(int ... data) {
        Element head = null;
        Element tail = null;
        
        for (int i = 0; i < data.length; i++) {
            Element current = new Element();
            current.value = data[i];
            if(head == null) {
                head = current;
                tail = current;
            } else {
                tail.next = current;
                tail = current;
            }
        }
        
        return head;
    }
    
    // print all value in element
    static void showList(Element e) {
        if(e == null) return;
        System.out.print(" " + e.value);
        showList(e.next);
    }
    
    // print reverse all value in element
    static void showReverseList(Element e) {
        if (e == null) return;
        showReverseList(e.next);
        System.out.print(" " + e.value);
    }
    
    static int countNode(Element e) {
        if (e == null) return 0;
        return 1 + countNode(e.next);
    }
    
    static int findSum(Element e) {
        int result = 0;
        Element current = e;
        for (Element c = e; c != null; c = c.next) {
            result += c.value;
        }
        return result;
    }
    
    static Element findMax(Element e) {
        Element result = e;
        for (Element c = e; c != null; c = c.next) {
            if(result.value < c.value) {
                result = c;
            }
        }
        return result;
    }
    
    static Element reverse(Element first) {
        if (first == null) return null;           // No element
        if (first.next == null) return first;     // One element
        Element second = first.next;
        first.next = null;                        // Cut
        Element result = reverse(second);         // Link again
        second.next = result;
        return result;
    }
}

class Element {
    String name;
    int value;
    Element next;
}