package telran.point.dao;

import java.util.Arrays;
import java.util.Comparator;

import telran.point.model.Point;

public class PointSpace {
    private Point[] points;
    private Comparator<Point> comparator;

    public PointSpace(Point relPoint, Point[] points) {
        this.points = Arrays.copyOf(points, points.length);
        this.comparator = new PointComparator(relPoint);
        Arrays.sort(this.points, comparator);
    }

    public Point[] getPoints() {
        return points;
    }

    public void addPoint(Point point) {
       
        int insertIndex = findInsertionIndex(point);

      
        Point[] newPoints = new Point[points.length + 1];

      
        System.arraycopy(points, 0, newPoints, 0, insertIndex);

    
        newPoints[insertIndex] = point;

       
        System.arraycopy(points, insertIndex, newPoints, insertIndex + 1, points.length - insertIndex);

     
        points = newPoints;
    }

    private int findInsertionIndex(Point point) {
        int left = 0;
        int right = points.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = comparator.compare(point, points[mid]);

            if (comparison == 0) {
                return mid; 
            } else if (comparison < 0) {
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return left; 
    }

}
