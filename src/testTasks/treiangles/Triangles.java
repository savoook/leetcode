package testTasks.treiangles;

public class Triangles {

    private boolean isIntersect(Triangle t1, Triangle t2) {
        if (t1.getY2() > t2.getY() || t2.getY2() > t1.getY()) return false;
        if (t1.getX2() < t2.getX() || t2.getX2() < t1.getX()) return false;
        return true;
    }

    public static void main(String[] args) {
        Triangles triangles = new Triangles();
        Triangle t1 = new Triangle(1, 1, 1, 1);
        Triangle t2 = new Triangle(2, 2, 2, 2);
        System.out.println(triangles.isIntersect(t1, t2));

    }

    private static class Triangle {
        private final int x;
        private final int y;
        private final int w;
        private final int h;

        public Triangle(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getX2() {
            return x + w;
        }

        public int getY2() {
            return y + h;
        }
    }
}
