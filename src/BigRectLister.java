import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Object> rectangles = new ArrayList<>();
        BigRectangleFilter recFilter = new BigRectangleFilter();

        rectangles.add(new Rectangle(1,2));
        rectangles.add(new Rectangle(2,1));
        rectangles.add(new Rectangle(2,3));
        rectangles.add(new Rectangle(3,1));
        rectangles.add(new Rectangle(1,3));

        rectangles.add(new Rectangle(3,4));
        rectangles.add(new Rectangle(4,3));
        rectangles.add(new Rectangle(3,5));
        rectangles.add(new Rectangle(4,5));
        rectangles.add(new Rectangle(11,1));

        ArrayList<Object> rect = Collect.collectAll(recFilter, rectangles);

        System.out.println("=============================================");
        System.out.println("      Rectangles with perimeter > 10: ");
        System.out.println("=============================================");
        for (Object r : rect) {
            System.out.println(r);
        }

    }
}
