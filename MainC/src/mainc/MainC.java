package mainc;

public class MainC {

    public static void main(String[] args) 
    {
        C array = new C(10);
        
        System.out.printf("The index of this value is: %d\n", array.getIndex(10));
        System.out.printf("The value located at this index is: %d\n", array.Display(5));
    }
    
}
