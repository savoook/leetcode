package testTasks.array;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void moveTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Solution solution = new Solution();
        solution.move(array, 8);
        Assert.assertArrayEquals(array, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        solution.move(array, 18); //не описан случай m > длины, считаю что в таком случае массив не меняем
        Assert.assertArrayEquals(array, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        solution.move(array, 2);
        Assert.assertArrayEquals(array, new int[]{3, 4, 5, 6, 7, 8, 1, 2});
        solution.move(array, 4);
        Assert.assertArrayEquals(array, new int[]{7, 8, 1, 2, 3, 4, 5, 6,});

    }
}