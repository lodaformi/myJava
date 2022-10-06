public class SpherePoint {
    public static void main(String[] args) {
        Sphere s = new Sphere();
        s.r = 10;
        s.p = new Point();

        Point p2 = new Point();
        p2.setX(5);
        p2.setY(5);
        p2.setZ(5);
        System.out.println(s.isIn(p2));
    }
}

class Point {
    int x;
    int y;
    int z;

    Point() {
        x = 0;
        y = 0;
        z = 0;
    }

    public void setX(int a) {
        x = a;
    }

    public void setY(int b) {
        y = b;
    }

    public void setZ(int c) {
        z = c;
    }
}

class Sphere {
    int r;
    Point p;

    public boolean isIn(Point pit) {
        double dis = Math.sqrt(Math.pow((p.x - pit.x), 2) + Math.pow((p.y - pit.y), 2) + Math.pow((p.z - pit.z), 2));
        if (dis > r) {
            return false;
        } else {
            return true;
        }
    }
}



