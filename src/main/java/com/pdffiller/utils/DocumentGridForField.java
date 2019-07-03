package com.pdffiller.utils;

import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.IntStream.range;

public class DocumentGridForField {
    public static Logger logger
            = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public Map<String, int[]> fieldsLocation = new HashMap<>();

    public static void main(String[] args) {
        Dimension dimension = new Dimension(816, 1020);
        createGrid(11, dimension);
    }

    public static int[][] createGrid(int fieldCount, Dimension dimension) {
        if (fieldCount < 1) {
            throw new NullPointerException("minimum 1 field");
        }
        if (fieldCount > 20) {
            throw new NullPointerException("maximum 20 fields on 1 page");
        }

        int width = dimension.getWidth();
        int height = dimension.getHeight();
        int offsetX = width / 2;
        int offsetY = 2 * height / 7;

        double widthCell;
        double heightCell;

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
            resultGrid[j + (int) (height / heightCell) * n][0] = (int) ((cellCenter[0] + widthCell * n) - offsetX);
            resultGrid[j + (int) (height / heightCell) * n][1] = (int) ((cellCenter[1] + heightCell * j) - offsetY);
        }));

        return resultGrid;
    }

    public void assignFieldToLocation(String fieldName, int[][] grid) {
        int locationNumber = fieldsLocation.size();
        fieldsLocation.put(fieldName, grid[locationNumber]);
        logger.info("field: {}, coords: {}", fieldName, Arrays.toString(grid[locationNumber]));
    }
}
