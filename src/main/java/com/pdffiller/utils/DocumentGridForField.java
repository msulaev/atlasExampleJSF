package com.pdffiller.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.IntStream.range;

public class DocumentGridForField {
    public Map<String, int[]> fieldsLocation = new HashMap<>();

    public static int[][] createGrid(int fieldCount) {
        
        int width = 855;
        int height = 1024;
        double widthCell;
        double heightCell;
        if (fieldCount > 20) {
            return null;
        }

        if (fieldCount > 10) {
            widthCell = Math.ceil(width / 2);
            heightCell = (height / (fieldCount + fieldCount % 2)) * 2;
        } else {
            widthCell = width;
            heightCell = height / fieldCount;
        }

        int[][] resultGrid = new int[(int) (((width / widthCell) * (height / heightCell)))][2];
        double[] cellCenter = {widthCell / 2, heightCell / 2};
        range(0, (int) (width / widthCell)).forEachOrdered(n -> range(0, (int) (height / heightCell)).forEachOrdered(j -> {
            resultGrid[j + (int) (height / heightCell) * n][0] = (int) (cellCenter[0] + widthCell * n);
            resultGrid[j + (int) (height / heightCell) * n][1] = (int) (cellCenter[1] + heightCell * j);
        }));
        return resultGrid;
    }

    public void assignFieldToLocation(String fieldName, int[][] grid) {
        int locationNumber = fieldsLocation.size();
        fieldsLocation.put(fieldName, grid[locationNumber]);
        fieldsLocation.forEach((x,y)-> {
            System.out.println(x);
            System.out.println(Arrays.toString(y));
        });
    }
}
