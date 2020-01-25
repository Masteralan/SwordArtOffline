package UserInterface;

import java.awt.*;
import java.awt.event.KeyEvent;

// Class that manages user inputs
public class ControlScheme implements KeyEventDispatcher {
    private boolean[] KeyPresses = new boolean[7];   // List
    private boolean Initiated = false;

    public ControlScheme() {
        for (int i = 0; i < 7; i++)
            KeyPresses[i] = false;

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
        Initiated = true;
    }
    public void Close() {
        if (Initiated)
            KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(this);
    }


    // Finds where the given char fits in the KeyPresses array
    private int GetKeyPressIndex(char key) {
        int index;  // O is just a filler slot (receives any unused inputs)

        switch (key) {
            case 'f':   // F, Zero, or Space bar for Attack
            case '0':
            case 32:
                index = 1;
                break;
            case 'w':   // W or Up Arrow
            case 24:
                index = 2;
                break;
            case 's':   // S or Down Arrow
            case 25:
                index = 3;
                break;
            case 'a':   // A or Left Arrow
            case 27:
                index = 4;
                break;
            case 'd':   // D or Right Arrow
            case 26:
                index = 5;
                break;
            case 'x':  // TODO: Make this the Escape key, closes window
                index = 6;
                break;
            default:    // Otherwise, default to empty
                index = 0;
        }

        return index;
    }


    // Returns true if selected key is currently pressed--otherwise returns false
    public boolean IsKeyDown(char key) {
        return KeyPresses[GetKeyPressIndex(key)];
    }


    public boolean dispatchKeyEvent(KeyEvent e) {
        assert EventQueue.isDispatchThread();

        if (e.getID() == KeyEvent.KEY_PRESSED)
            KeyPresses[GetKeyPressIndex(e.getKeyChar())] = true;
        else if (e.getID() == KeyEvent.KEY_RELEASED)
            KeyPresses[GetKeyPressIndex(e.getKeyChar())] = false;

        //System.out.println("Key " + e.getKeyChar() + " is now " + KeyPresses[GetKeyPressIndex(e.getKeyChar())]);

        return false;
    }
}
