package nyc.c4q.andrade.helloworld;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int option;

    static Stack<String> historyStack= new Stack<>();
    static Stack<String> deletedStack= new Stack<>();

    public static void main(String[] args) {

        menu();


    }

    public static void menu( ){


        //Show Menu unless Exit(5) is choosen, Repeats it while the 5 is not pressed
        //If user inputs unexpected it will ask hagain to the user
            System.out.println("\t\t\t\t\t\t\t.:MENU:.\n");

        do{
            System.out.print("1. Input String,\t");
            System.out.print("2. Copy,\t");
            System.out.print("3. Delete,\t");
            System.out.print("4. Undo,\t");
            System.out.println("5. quit");
            System.out.println();
            System.out.print("Enter Option number : ");

            option = scanner.nextInt();
            System.out.println();

            //Switch statement that acts depending on number entered
            switch(option){
                case 1:
                    //call method
                    inputString();
                    System.out.println();
                    break;
                case 2:
                    //call method
                    copyString();
                    System.out.println();
                    break;
                case 3:
                    //Call method
                    deleteString();
                    System.out.println();
                    break;
                case 4:
                    //Call method
                    undoString();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("'5' was pressed the program will END ");
                    quitShow();
                    break;
                default:
                    System.out.println("\t\t\t\tError, wrong menu option");
                    System.out.println();
                    break;
            }

        }while (option != 5);


//        System.out.print("The last String in the Stack is : ");
//        System.out.println(historyStack.peek());


    }



    public static   void inputString(){

        System.out.print("Enter the string you wish to add to the stack: ");
        String input = scanner.next();
        scanner.nextLine();

        historyStack.push(input);

        System.out.println("We added "+ historyStack.peek()+" to the Stack");
        //System.out.println(historyStack.peek());

    }

    public static void copyString(){
        if (historyStack.empty()) {
            System.out.println("!!!Cant copy any String because you havent input any, Please input a String first ");
        }

        else {
        String copiedStr= historyStack.peek();
        historyStack.push(copiedStr);
        System.out.println("We copied "+ historyStack.peek()+" to the Stack");
        }

    }

    public static void deleteString(){

        if(historyStack.empty()){
            System.out.println("!!!Cant delete any string, because the stack is empty," +
                                 " Please Enter a string before.");
        }
        else{

            System.out.println("You will delete the last entered String");
            String deletedStr = historyStack.peek();
            deletedStack.push(deletedStr);
            System.out.println("We deleted "+ historyStack.peek()+" from the Stack");
            historyStack.pop();


        }

    }

    public static void undoString(){

        if(deletedStack.empty()){
            System.out.println("Your History is empty, cant undo ");
        }

        else{
            System.out.println("You will recover deleted String");
            String recoverStr = deletedStack.peek();
            historyStack.push(recoverStr);
            System.out.println();
            System.out.println("We recovered "+ recoverStr+" to the Stack");

        }

    }


    public static void quitShow(){

        if (historyStack.empty()) {
            System.out.println("You QUIT the program. \n" +
                    "Your stack is empty and we can not display its content");
        }

        else{
            System.out.print("The last String in the Stack is : ");
            System.out.println(historyStack.peek());

        }


    }

}




