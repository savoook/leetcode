package testTasks.array;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest {

    @Test
    public void moveTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Solution solution = new Solution();
        solution.move(array, 8);
        Assert.assertArrayEquals(array, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        solution.move(array, 18); //�� ������ ������ m > �����, ������ ��� � ����� ������ ������ �� ������
        Assert.assertArrayEquals(array, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        solution.move(array, 2);
        Assert.assertArrayEquals(array, new int[]{3, 4, 5, 6, 7, 8, 1, 2});
        solution.move(array, 4);
        Assert.assertArrayEquals(array, new int[]{7, 8, 1, 2, 3, 4, 5, 6,});

    }
}