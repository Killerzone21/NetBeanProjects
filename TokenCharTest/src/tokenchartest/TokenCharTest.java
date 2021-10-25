
package tokenchartest;

public class TokenCharTest {

    
    public static void main(String[] args) {
        char character = 'b';
        
        int asciiVal = (int) character;
        
        System.out.printf("The ASCII value of '%s' is %d.\n", character, asciiVal);
        
        String MyString = "I like big dogs!";
        
        System.out.printf("The ASCII values of \" %s \" are:", MyString);
        
        for(int i = 0; i < MyString.length(); i++)
        {
            System.out.println((int)MyString.charAt(i));
            
        }
    }
    
}
