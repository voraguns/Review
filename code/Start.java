class Start {
    public static void main(String[] data) {
        int[] a = { 8, 5, 4, 2, 7, 1, 9, 3 };
        
        Element list = createList(a);
        showList(list);
        countNode(list);
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
    
    // print all value in element
    static void showList(Element e) {
        if(e == null) return;
        System.out.println(e.value);
        showList(e.next);
    }
    
    static int countNode(Element e) {
        if (e == null) return 0;
        return 1 + countNode(e.next);
    }
}

class Element {
    String name;
    int value;
    Element next;
}