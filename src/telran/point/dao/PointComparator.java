package telran.point.dao;

import java.util.Comparator;

import telran.point.model.Point;

public class PointComparator implements Comparator<Point> {
	Point relPoint;

	public PointComparator(Point relPoint) {
		this.relPoint = relPoint;
	}

	@Override
	public int compare(Point o1, Point o2) {
	 double cordX1 = o1.getX() - relPoint.getX();
	 double cordX2 = o2.getX() - relPoint.getX();
	 double cordY1 = o1.getY() - relPoint.getY();
	 double cordY2 = o1.getY() - relPoint.getY();
	 
	 double distance1 = cordX1*cordX1+cordY1*cordY1;
	 double distance2 = cordX2*cordX2+cordY2*cordY2;
	 
	 
	 if(distance1 < distance2) {
		 return -1;
	 }else if(distance1 > distance2) {
		 return 1;
	 }else {
		 return 0;
	 }
	}
}
