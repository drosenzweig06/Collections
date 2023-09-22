/**
 * Write a description of class Stacks here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stacks
{
    // instance variables - replace the example below with your own
    private int top;
    private int elementmemory;
    private int size;
    private int[] stack;
    /**
     * Constructor for objects of class Stacks
     */
    public Stacks(int elementmemory){
        size = 0;
        stack = new int[elementmemory];
        top = -1;
    }
    public void push(int element)
    {
        if(isFull() == false){
            size++;
            top++;
            stack[top] = element;
        }
        else{
           System.out.println("Sorry your stack is full"); 
        }
    }
    public int pop(){
        int num = 0;
        if(isEmpty() == false){
            num = stack[top];
            stack[top] = 0;
            size--;
            top--;
        }
        return num;
    }
    public boolean isEmpty(){
        boolean isEmpty = false;
        if(top == -1)
        {
            isEmpty = true;
        }
        return isEmpty;
    }
    public int top(){
         return stack[top];
    }
    public int size(){
        return size;
    }
    public boolean isFull(){
        boolean isFull = false;
        if(top >= stack.length - 1)
        {
            isFull = true;
        }
        return isFull;
    }
    public String toString(){
        String array = "";
        for(int i = 0; i < size; i++){
            array += stack[i] + ",";
        }
        return array;
    }
}


