
package mainc;

import java.util.Scanner;

public class C {
    
    private int len;
    private int[] contents;
        
    public C(int i) 
    
    {
        len = i;
        
        Scanner input = new Scanner(System.in);
        
        contents = new int[len];
        
        
        for(int x = 0; x < len; x++)
        {
            System.out.println("Enter a value:");
            contents[x] = input.nextInt();
        }  
    }
    
    public int getIndex(int x)
    {
        int index = 0;
        
        for(int i = 0; i < contents.length; i++)
        {
            if(contents[i] == x)
                index = i;
        }
        
        return index;
            
    }
    
    public int Display(int x)
    {
        return contents[x];
    }
}