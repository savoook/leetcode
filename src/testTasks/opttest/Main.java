package testTasks.opttest;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Data data = new Data();
        user.setData(data);
        Optional<Block> action = action(user);
        System.out.println(action.isPresent());
        System.out.println(action.isEmpty());
        action1(user);
    }

    public static Optional<Block> action(User user) {
        return Optional.ofNullable(user.getData().getBlock());
    }

    public static Block action1(User user) {
        if (user.getData().getBlock() != null) return user.getData().getBlock();
        else throw new RuntimeException("no data");
    }
}
