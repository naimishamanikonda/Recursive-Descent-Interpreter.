
/*compile the program and run it enter the path of the file which has your string to be evaluated .enter only the string you want to evaaluate
in your file 
 *
 */
/**
 *
 * @author naimisha manikonda
 */
import java.util.*;
import java.io.*;
import java.lang.*;
import java.nio.charset.Charset;
//import java.util.Stack;


public class Syntax {

     public static String myfile;//path of the file
    public static String str;//string to be evaluate
    public static int i=0;
    public static char current;//charecter which holds current token
    public static char[]items;
    public static  StringBuffer current1;
    //public static Stack output;
   public static Stack output = new Stack();//a stack for evaluting the string
    public static char value;
    public static void main(String[] args)throws IOException {
       Scanner sc = new Scanner(System.in);
        System.out.println("enter the path of the file which has the expressions to be read");
        myfile = sc.nextLine(); 
         try {
       // FileInputStream in  =  new FileInputStream(myfile); 
        BufferedReader br = new BufferedReader(new FileReader(myfile));//for reading from the file checking if it is null first
                if (br.readLine() == null ) 
                {
    System.out.println("No errors, and file empty");//checking to see if there is something to be evaluated in the file
                }
               else
               {
                System.out.println("file has contents");
                get();
                System.out.println("the string being read is"+ str);
               if(b())
                {
                 System.out.println("the synatx of expression is correct ");
                 value = (char)output.peek();
                 System.out.println("value of string is"+value);
                }
               else
               {
               System.out.println("fatal error -errors occured while parsing due to illegal syntax");
               }
    }
     }
        
       catch(Exception e){
            System.out.println("file not found or unkown item has been returned");
        
    }
   
}
 public static void get() throws FileNotFoundException
 {   
Scanner sc = new Scanner(new File(myfile));
while (sc.hasNext())
{  
 str = sc.nextLine();//read the string from file
  current = (str.charAt(i));//for storing the present token 
 }
   
}

 public static boolean A() throws IOException
    {
                 if(current == 'T' )
                   //check to see if next charecter is a T  
                 {      
                        
                         i=i+1;//fetching next charecter
                         get();
                         if(current == ' ')
                         {//checking for white spaces
                         i =i+1;//fetching next charecter if the previous charecter was a white space
                         get();
                         output.push('T');
                         }
                    else
                     {
                            current = current;
                            output.push('T');
                         }
                        
                         return true;
                    }
                        else if(current == 'F' )
                             {
                               //check if next charecter is an f
                                 i=i+1;
                                 get();
                                 if(current == ' ')
                         {
                         i =i+1;
                         get();
                         output.push('F');
                         }
                    else
                     {
                            current = current;//the current charecter remains the same
                            output.push('F');
                         }
                                 return true;
                                 
                             }
                         else if (current == '(' )//checks if current charecter to be a '('
                            {   
                                i=i+1; // get the next charecter
                                get();
                                if(current == ' ')//compare if the next charecter is a white space
                                {
                                i =i+1; // if the previous charecter was a white space we try to find the next charecter
                                get();
                                }
                               else
                               {
                                current = current;
                               }
                                
                                
                                if (it())
                                {
                                    if(current == ')' )//checks if current charecter is (
                                    {
                                    i = i+1;
                                    get();
                                        if(current == ' ')
                                         {
                                            i =i+1;
                                            get();
                                         }
                                        else
                                         {
                                            current = current;
                                          }
                                    return true;
                                     }
                                     else
                                    {
                                    System.out.println("missing ) paranthesis");
                                    return false;
                                    }
                                }
                                else{
                                return false;
                                    }
                            }
                        else
                        {
               
                       return false;
                        }
           }
    
    public static boolean L() throws IOException
    { 
        char value1;
        
                    if (A())
                    {
                    return true;
                    }
                        else  if (current == '~')//checks for negation
                        { 
                           
                            i =i+1;
                            get();
                            if(current == ' ')
                         {
                         i =i+1;
                         get();
                         output.push('~');
                         }
                        else
                         {
                            current = current;
                            output.push('~');
                         }
                            
                                if (L())
                                {
                                    value1 = (char)output.pop();
                                    if(value1 == 'T')
                                        {
                                         output.push('F');
                                        }
                                    else
                                        {
                                         output.push('T');
                                        }
                                
                                return true;
                                }
                                else
                                {
                                 
                                 return false;
                                }
                        }
                     else
                    {
                       
                        return false;
     
                    }
    
    }
    public static boolean at_tail() throws IOException
    {
            if(current == '^')//checks for an and
            {
                
              char value1,value2;
              i=i+1;
              get();
              if(current == ' ')
                         {
                         i =i+1;
                         get();
                         }
                    else
                     {
                            current = current;
                         }
              if(L())
                    {
                        value2 = (char)output.pop();
                        value1 = (char)output.pop();
                            if(value1=='T' && value2 == 'F')
                            {
                            output.push('F');
                            }
                            else
                            {
                            output.push('T');
                            }
                  
                        if(at_tail())
                        {
                        return true;
                        }
                        else
                        {
                    return false;
                        }
                    }
                 else
                {
                  return false;
                }
            }
    
            else if (current == '.' || current == 'v' ||current ==')')
        {
           return true;
        }
            
            else if(current =='-')//checks for an-> sign first checks for a tail of arrow then head of the arrow head
            {
            i=i+1;
            get();
            if(current == '>')
            {  
                i=i-1;
                get();
                return true;
            }
            else
            { 
                return false;
            }
            }
       else
       {
        System.out.println("error occured required .,v or ->");
        return false;
       }
       
    }
    
 public static boolean at() throws IOException 
 {
        if(L())
        {
            if(at_tail())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            
            return false;
        
        }
   
 }
 public static boolean ot_tail() throws IOException 
 {
     char value1,value2;
         if(current == 'v')//checks for an 'or' sign
            { 
             i =i+1;
             get();
             if(current == ' ')
                         {
                         i =i+1;
                         get();
                         }
                    else
                     {
                            current = current;
                         }
            if(at())
            {
                value2 = (char)output.pop();
                value1 = (char)output.pop();
                    if( value1 =='F' && value2 =='F')
                    {
                    output.push('F');
                    }
                    else
                    {
                    output.push('T');
                    }
                if(ot_tail())
                {
                return true;
                }
                else
                {
                return false;
                }  
             }
            else
            {
            return false;
            }
            }
         else if(current == '.'||current ==')')
         {
         return true;
         }
         else if(current == '-')
         {//checks for an-> sign charecter by charecter if space found it returns false
         i=i+1;
         get();
            if(current == '>')
            {
             i=i-1;
               get();
                return true;
            }
            else
            {
                return false;
            }
         }   
             
          else
         {
             System.out.println("error occured while parsing expected an -> ,. or ");
             return false;
         }
 }
  public static boolean ot() throws IOException
 {
  if(at())
  {
    if(ot_tail())
    {return true;}
    else
    {return false;}
  }
  else
  {
      return false;
  }
 }
  public static boolean it_tail() throws IOException
  {
      char value1,value2;
        if(current == '-' )
        {
            i =i+1;
            get();
           
                    if(current == '>')
                    {
                        i = i+1;
                        get();
                        if(current == ' ')
                                {
                                i =i+1;
                                get();
                                }
                               else
                               {
                                current = current;
                               }
                        if(ot())
                        {
                            value2 = (char)output.pop();
                            value1 = (char)output.pop();
                              if(value1 == 'T'&& value2  =='F')
                              {
                              output.push('F');
                              }
                              else
                              {
                              output.push('T');        
                              }
                            
                            if(it_tail())
                            {
                            return true;
                             }
                             else
                            {
                            return false;
                            }
                        }
            
                         else
                         {
                         return false;        
                         }
                    }
                    else
                    {
                    return false;
                    }
               }  
        else if(current == '.'||current == ')' )
        {
        return true;
        }
        else
        {
        System.out.println("expecting >,.,) but unexpected charecter found");
          return false;      
        }  
  
        }
  
 
   public static boolean it() throws IOException
  {
            if(ot())
            {
                if(it_tail())
                {
                    return true;
                }
                else
                {return false;}
            }
            else
            {
                return false;
            }
  }
    public static boolean b() throws IOException
    {
    if(it())
    {
    if(current == '.' )
    { 
    return true;}
    else
    return false;
    }
    else
    return false;
    }
}
 


