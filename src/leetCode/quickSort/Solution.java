package leetCode.quickSort;

class Solution {
    public void sort(int[] array) {
        sort(array, 0, array.length-1);
    }

    private void sort(int[] array, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int opora = array[mid];
        int i = lo;
        int j = hi;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (lo < j)
            sort(array, lo, j);
        if (hi > i)
            sort(array, i, hi);
    }
}
