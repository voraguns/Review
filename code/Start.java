class Start {
    public static void main(String[] data) {
        int[] value =  { 2, 5, 7, 1, 4, 9, 6 };
        System.out.println("This is data in array : ");
        for (int i = 0; i < value.length; i++) {            
            System.out.print(" " + value[i]);
        }
        
        System.out.println();    
        Element chain = createLinkedlist(value);
        System.out.println("Create Linked list : ");
        printLinkedlist(chain);
        
        System.out.println();
        System.out.println("Reverse Linked List :");
        showReverseLinkedlist(chain);
        
        System.out.println();
        System.out.println("Maximum value in data is : " + maxValue(chain).value);
        System.out.println("Minimum value in data is : " + minValue(chain).value);
        System.out.println("Total value in data is : " + sumValue(chain));
    }
    
    static void printLinkedlist(Element e) {
        if (e == null) return;
        printLinkedlist(e.next);
        System.out.print(" " + e.value);    
    }
    
    static Element createLinkedlist(int ... data) {
        Element head = null;
        Element tail = null;
        for (int i = 0; i < data.length; i++){
            Element current = new Element();
            current.value = data[i];
            if (head == null) {
                head = current;
                tail = current;
            } else {
                tail.next = current;
                tail = current;
            }
        }
        return head;
    }
    
    static Element maxValue(Element e) {
        Element result = e;
        for (Element current = e; current != null; current = current.next) {
            if (result.value < current.value) {
                result = current;
            }
        }
        return result;
    }
    
    static Element minValue(Element e) {
        Element result = e;
        for (Element current = e; current != null; current = current.next) {
            if (result.value > current.value) {
                result = current;
            }
        }
        return result;
    }
    
    static int sumValue(Element e) {
        int result = 0;
        for (Element current = e; current != null; current = current.next) {
            result += current.value;
        }
        return result;
    }
    
    static void showReverseLinkedlist(Element e) {
        if (e == null) return;
        System.out.print(" " + e.value);
        showReverseLinkedlist(e.next);
    }
    
}

class Element {
    String name;
    int value;
    Element next;
}