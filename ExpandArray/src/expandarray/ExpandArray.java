
package expandarray;

public class ExpandArray 
{


    public static void main(String[] args) 
    {
        
        int[] MyArray1 = {1,2,3,4,5};
        
        
        printArray(MyArray1);
        
        int[] CopyArray = MyArray1;
        
        printArray(CopyArray);
        
        MyArray1 = new int[10];
        
        printArray(MyArray1);
        
        for(int i = 0; i < CopyArray.length;i++)
        {
            MyArray1[i] = CopyArray[i];
            
        }
        
        printArray(MyArray1);
    }
    
    public static void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]);
        System.out.println();
    }
    
}
