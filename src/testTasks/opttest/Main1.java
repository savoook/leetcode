package testTasks.opttest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        User user = new User();
        //user.setData(null);
        Data data5 = new Data(5);
        //user.setData(new Data(1));
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 3, 5));
        user.setSet(set);
        //boolean match = user.getSet().stream().anyMatch(data -> user.getData().equals(new Data(1)));
        //System.out.println(match);


        switch (user.getUid()) {
            case "data5":
                System.out.println("new");;
            case "data1":
                System.out.println("data5");;
            default:
                throw new IllegalArgumentException("Unknown service type: " + user.getData());
        }
    }
}
