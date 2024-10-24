package com.figures_pack.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.figures_pack.entities.Point;
import com.figures_pack.entities.Rectangle;
import com.figures_pack.entities.Shape;
import com.figures_pack.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;
import com.figures_pack.exceptions.PlaceholderException;
import com.figures_pack.exceptions.PointsDontFormRectangeleException;

public class RectnagleFactoryTest {
	
	@Test
	public void testCreateMethodIdAutoIincremntion() throws Exception{
		ShapeFactory rectangleFactory = new RectangleFactory();

		List<Point> points1 = new ArrayList<>();
		Point p1 = new Point(0D, 0D);
		Point p2 = new Point(0d, 1d);
		Point p3 = new Point(1d, 1d);
		Point p4 = new Point(1d, 0d);
		points1.add(p1);
		points1.add(p2);
		points1.add(p3);
		points1.add(p4);

		Shape rect1 = rectangleFactory.createShape(points1);
		Shape rect2 = rectangleFactory.createShape(points1);

		assertEquals(rect1.getId(), 0);
		assertEquals(rect2.getId(), 1);
	}

	@Test()
	public void createExceptionsTest(){
		Point point1 = new Point(0d, 0d);
		Point point2 = new Point(0d, 1d);
		Point point3 = new Point(1d, 1d);
		Point point4 = new Point(1d, 0d);
		Point point5 = new Point(3d, 0d);
		
		List<Point> points1 = new ArrayList<>();
		List<Point> points2 = new ArrayList<>();

		points1.add(point1);
		points1.add(point2);
		points1.add(point3);

		points2.add(point1);
		points2.add(point2);
		points2.add(point3);
		points2.add(point4);
		points2.add(point5);

		ShapeFactory rectangleFactory = new RectangleFactory();
		assertThrows(IncorrectNumberOfPointsHasBeenReceivedAtTheInputException.class, () -> rectangleFactory.createShape(points1));
		assertThrows(IncorrectNumberOfPointsHasBeenReceivedAtTheInputException.class, () -> rectangleFactory.createShape(points2));
		assertThrows(NullPointerException.class, () -> rectangleFactory.createShape(null));
	}

	@Test
	void testCreateMethod()
		throws IncorrectNumberOfPointsHasBeenReceivedAtTheInputException,
		PointsDontFormRectangeleException,
		PlaceholderException
	{
		// System.out.println("\n\n\nsome message\n\n\n");
		ShapeFactory rectangleFactory = new RectangleFactory();
		List<Point> points1 = Arrays.asList(
			new Point(0d, 0d),
			new Point(0d, 1d),
			new Point(1d, 1d),
			new Point(1d, 0d)
		);
		List<Point> points2 = Arrays.asList(
			new Point(0d, 1d),
			new Point(1d, 1d),
			new Point(1d, 0d),
			new Point(0d, 0d)
		);
		Rectangle expecRec1 = new Rectangle(points1);

		assertEquals(expecRec1, rectangleFactory.createShape(points1));
		assertEquals(expecRec1, rectangleFactory.createShape(points2));
	}
}
