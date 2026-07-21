import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        // Use ArrayDeque as a high-performance stack
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Step 1: Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Step 2: Handle closing brackets
            else {
                // If stack is empty, we have a closing bracket with no opening pair
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check for a mismatch between closing and opening types
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        
        // Step 3: The string is only valid if all opened brackets were successfully closed
        return stack.isEmpty();
    }
}
