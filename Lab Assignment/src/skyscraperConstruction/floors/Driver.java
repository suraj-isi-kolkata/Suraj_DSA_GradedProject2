package skyscraperConstruction.floors;
import skyscraperConstruction.floors.OrderOfConstruction;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> floors = new LinkedList<>();

        //Taking input for floor count
        int floorCount;
        boolean invalidInput = false;
        do {
            if(invalidInput) {
                System.out.println("Please enter a positive numeric value");
            }else {
                System.out.println("Enter the total no. of floors in the building.");
            }

            while (!in.hasNextInt()) {
                System.out.println("Please enter a numeric value");
                in.next();
            }

            floorCount = in.nextInt();
            invalidInput = floorCount < 0;
        } while (invalidInput);

        //Taking floor sizes
        for (int i = 0; i < floorCount;i++) {
            int nextFloor;
            boolean invalidFloor = false;
            do {
                if(invalidFloor) {
                    System.out.println("Please enter a positive numeric value");
                }else {
                    System.out.println("Enter the floor size on day " + (i + 1) + ":");
                }

                //check if entered input is a number
                while (!in.hasNextInt()) {
                    System.out.println("Please enter a numeric value");
                    in.next();
                }

                nextFloor = in.nextInt();
                //check if size of floor is greater than 0 or not
                invalidFloor = nextFloor < 0;

                //check if floor size has already been constructed
                if(floors.contains(nextFloor)){
                    System.out.println("Size " +nextFloor + " already exists in the building. Please enter a different size.");
                    i--;
                }
                else if(nextFloor != 0){
                    floors.add(nextFloor);
                }
            } while (invalidFloor);
        }
        List<Integer> sortedFloors = new LinkedList<>(floors);
        Collections.sort(sortedFloors);
        Collections.reverse(sortedFloors);
        System.out.println("The order of construction is as follows: ");
        OrderOfConstruction.findOrderOfConstruction(floors, sortedFloors);
        in.close();
    }
}