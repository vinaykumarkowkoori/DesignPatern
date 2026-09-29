package vinaytutorial.javadesignpattern.creational.abstractfactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Enter 0 for TextBox, 1 for Button, or q to quit:");
                String input = reader.readLine();

                if (input == null || "q".equalsIgnoreCase(input.trim())) {
                    System.out.println("Exiting Abstract Factory demo.");
                    break;
                }

                final int objectType;
                try {
                    objectType = Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter 0, 1, or q.");
                    continue;
                }

                InterfaceRenderer uiObject = ClsAbstractFactory.getUIObject(objectType);
                if (uiObject == null) {
                    System.out.println("Invalid option. Please enter 0 or 1.");
                    continue;
                }

                System.out.println("Creating object for input - " + objectType);
                uiObject.render();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read console input", e);
        }
    }
}
