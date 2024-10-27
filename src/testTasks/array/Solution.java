package testTasks.array;

class Solution {
    public void move(int[] array, int m) {
        if (m >= array.length || m == 0 || array.length == 0) return;
        int counter = 0;
        while (counter < m) {
            int temp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = temp;
            counter++;
        }
    }
}
