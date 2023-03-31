package testTasks.opttest;

public class Data {

    public Data() {
    }

    public Data(int number) {
        this.number = number;
    }

    private Block block;

    private int number;

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public int getNumber() {
        return number;
    }
}
