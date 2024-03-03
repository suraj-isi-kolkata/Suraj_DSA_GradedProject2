package skyscraperConstruction.floors;

import java.util.List;

public class FindLargestFloor {
    public static int findLargest(List<Integer> floors){
        int greatest=0;
        int g_index = 0;
        for(int i=0; i<floors.size(); i++){
            if(floors.get(i) > greatest){
                greatest = floors.get(i);
                g_index=i;
            }
        }
        return g_index;
    }
}