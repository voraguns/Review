class Start {
    public static void main(String[] data) {
        int[] a = { 8, 5, 4, 2, 7, 1, 9, 3 };
    }
    
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
}

class Element {
    String name;
    int value;
    Element next;
}