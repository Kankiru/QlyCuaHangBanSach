/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Home;

import java.util.Stack;

/**
 *
 * @author pc
 */
public class WindowManager {

    private static Stack<javax.swing.JFrame> windowStack = new Stack<>();

    public static void push(javax.swing.JFrame frame) {
        windowStack.push(frame);
    }

    public static void pop() {
        if (!windowStack.isEmpty()) {
            windowStack.pop();
            if (!windowStack.isEmpty()) {
                windowStack.peek().setVisible(true);
            }
        }
    }
}
