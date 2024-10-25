package leetCode.fairyindex;

public class Main {
    public static void main(String[] args) {
        int [] first = {-5,1,1,2,2,2,-13};//{6,1,1,2,2,2,2}; //l8 t16
        int [] second = {6,1,1,1,1,1,1}; //l2 t5
        System.out.println(FairyIndex.findIndexCount(first, second));
    }
}
