/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolca2;

/**
 *
 * @author Jeremiah
 */

public enum MenuOption {

    SORT(1),
    SEARCH(2),
    ADD_RECORDS(3),
    CREATE_BINARY_TREE(4),
    EXIT(5);

    private final int number;

    MenuOption(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    // Convert user input into an Enum option
    public static MenuOption fromNumber(int number) {

        for (MenuOption option : MenuOption.values()) {

            if (option.getNumber() == number) {
                return option;
            }
        }

        return null;
    }
}
