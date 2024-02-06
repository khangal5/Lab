package main;

import java.util.*;

public class StackFunctions {

    private static Scanner scanner = new Scanner(System.in);

    // Function 1: Push Element onto Stack
    public static void pushElement(Stack<Integer> stack) {
        System.out.println("Enter the element to push onto the stack:");
        int element = scanner.nextInt();
        stack.push(element);
        System.out.println("Element " + element + " pushed onto the stack.");
    }

    // Function 2: Pop Element from Stack
    public static void popElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
        } else {
            int poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);
        }
    }

    // Function 3: Display Stack Elements
    public static void displayStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements: " + stack);
        }
    }

    // Function 4: Check if Stack is Empty
    public static void checkIfEmpty(Stack<Integer> stack) {
        System.out.println("Is the stack empty? " + stack.isEmpty());
    }

    // Function 5: Clear Stack
    public static void clearStack(Stack<Integer> stack) {
        stack.clear();
        System.out.println("Stack cleared.");
    }
    
 // Function 7: Find Minimum Element in Stack
    public static void findMinElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. No minimum element.");
        } else {
            int minElement = Collections.min(stack);
            System.out.println("Minimum element in the stack: " + minElement);
        }
    }
    
    // Function 6: Exit Program
    public static void exitProgram() {
        System.out.println("Exiting program. Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push Element onto Stack");
            System.out.println("2. Pop Element from Stack");
            System.out.println("3. Display Stack Elements");
            System.out.println("4. Check if Stack is Empty");
            System.out.println("5. Clear Stack");
            System.out.println("6. Find Minimum Element in Stack");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    pushElement(stack);
                    break;
                case 2:
                    popElement(stack);
                    break;
                case 3:
                    displayStack(stack);
                    break;
                case 4:
                    checkIfEmpty(stack);
                    break;
                case 5:
                    clearStack(stack);
                    break;
                case 6:
                	findMinElement(stack);
                	break;
                case 7:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}//5:19
