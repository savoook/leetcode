package leetCode.excelSheetColumnTitle;

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            builder.insert(0, (char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return builder.toString();
    }
}
