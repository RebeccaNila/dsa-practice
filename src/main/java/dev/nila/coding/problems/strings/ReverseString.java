package dev.nila.coding.problems.strings;

public class ReverseString {
    //Q. Write a function that returns the reverse of a string?

    /**
     * Handle the edge cases after successfully running the program.
     * Set the initial values blank rings and replace them with result later.
     *
     */
    public static void main(String[] args) {
        String str = "Interview Happy";
        String result = reverseString(str);
        System.out.println("Reverse String: "+result);
    }

    private static String reverseString(String str){
        if(str == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        int n = str.length();
        //Iterate all elements in reverse order
        for(int i=n-1; i>=0; i--){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }




}
