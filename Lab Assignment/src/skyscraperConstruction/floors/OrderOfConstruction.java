package skyscraperConstruction.floors;

import java.util.List;

public class OrderOfConstruction {
    public static void findOrderOfConstruction(List<Integer> floors,List<Integer> sortedFloors){
        int indexLargest = FindLargestFloor.findLargest(floors);
        int indexSortedFloors =0;

        for(int indexFloors=0; indexFloors<floors.size(); indexFloors++){

            System.out.println("Day: " + (indexFloors+1));

            //check if indexFloors is greater than or equal to largest index
            if(indexFloors>=indexLargest){

                //check if value of sortedFloors at given index is equal to value of floors at indexFloors
                if(sortedFloors.get(indexSortedFloors).equals(floors.get(indexFloors))){
                    System.out.println(sortedFloors.get(indexSortedFloors));
                    indexSortedFloors++;

                    //check for all the values preceding largest floor and print the floors that can be assembled for the day
                    for(int d=0; d<indexFloors;d++){
                        if ( indexSortedFloors<sortedFloors.size() && sortedFloors.get(indexSortedFloors).equals(floors.get(d))) {
                            System.out.println(sortedFloors.get(indexSortedFloors));
                            indexSortedFloors++;
                            d = -1;
                        }
                    }
                }
                else{
                    for(int j=0; j<= indexFloors; j++){
                        if( indexSortedFloors<sortedFloors.size() && floors.get(j).equals(sortedFloors.get(indexSortedFloors))){
                            System.out.println(sortedFloors.get(indexSortedFloors));
                            j=0;
                            indexSortedFloors++;
                        }
                    }
                }
            }
        }
    }
}