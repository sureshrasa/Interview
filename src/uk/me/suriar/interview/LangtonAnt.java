package uk.me.suriar.interview;

import java.util.Set;
import java.util.TreeSet;

public class LangtonAnt
{
    public static class Point implements Comparable<Point>
    {
	private final int x;
	private final int y;

	public static Point xy(final int x, final int y)
	{
	    return new Point(x, y);
	}

	private Point(final int x, final int y)
	{
	    this.x = x;
	    this.y = y;
	}

	@Override
	public int compareTo(final Point o)
	{
	    if (o.y < y)
		return -1;
	    if (o.y > y)
		return 1;

	    if (o.x > x)
		return -1;
	    if (o.x < x)
		return 1;

	    return 0;
	}

	@Override
	public String toString()
	{
	    return String.format("(%s,%s)", x, y);
	}

	@Override
	public int hashCode()
	{
	    return x << 16 + y;
	}

	@Override
	public boolean equals(final Object o)
	{
	    if (o == this)
		return true;

	    if (!(o instanceof Point))
		return false;

	    final Point other = (Point) o;
	    return other.x == x && other.y == y;
	}
    }

    private static enum Direction
    {
	NORTH(0), EAST(1), SOUTH(2), WEST(3);

	private final int ordinal;

	private static final Direction[] ordinalMap = { NORTH, EAST, SOUTH, WEST };

	Direction(final int ordinal)
	{
	    this.ordinal = ordinal;
	}

	Direction rotateClockwise()
	{
	    return ordinalMap[(ordinal + 1) % 4];
	}

	Direction rotateAntiClockwise()
	{
	    return ordinalMap[(ordinal + 3) % 4];
	}
    };

    private final Set<Point> blackSquares = new TreeSet<>();

    private Direction currDirection = Direction.WEST;
    private Point currPos = Point.xy(0, 0);

    private Point topLeft = currPos;
    private Point botRight = currPos;

    public String walkBlacks(final int totalSteps)
    {

	walkSteps(totalSteps);

	return blackSquares.toString();
    }

    private void walkSteps(final int totalSteps)
    {
	for (int step = 0; step < totalSteps; ++step)
	{
	    if (blackSquares.contains(currPos))
	    {
		blackToWhiteStep();
	    } else
	    {
		whiteToBlackStep();
	    }

	}
    }

    public void print(final int totalSteps)
    {
	walkSteps(totalSteps);

	System.out.println(String.format("curr=%s, top left = %s, bot right = %s", currPos, topLeft, botRight));

	for (int y = topLeft.y; y >= botRight.y; --y)
	{
	    for (int x = topLeft.x; x <= botRight.x; ++x)
	    {
		final Point p = Point.xy(x, y);
		if (blackSquares.contains(p))
		{
		    System.out.print(p.equals(currPos) ? "O" : "X");
		} else
		{
		    System.out.print(p.equals(currPos) ? "A" : ".");
		}
	    }
	    System.out.println("");
	}
    }

    private void whiteToBlackStep()
    {
	blackSquares.add(currPos);
	currDirection = currDirection.rotateClockwise();
	stepForward();
    }

    private void blackToWhiteStep()
    {
	blackSquares.remove(currPos);
	currDirection = currDirection.rotateAntiClockwise();
	stepForward();
    }

    private void stepForward()
    {
	switch (currDirection)
	{
	case NORTH:
	    currPos = Point.xy(currPos.x, currPos.y + 1);
	    if (topLeft.y < currPos.y)
		topLeft = Point.xy(topLeft.x, currPos.y);
	    break;

	case EAST:
	    currPos = Point.xy(currPos.x + 1, currPos.y);
	    if (botRight.x < currPos.x)
		botRight = Point.xy(currPos.x, botRight.y);
	    break;

	case SOUTH:
	    currPos = Point.xy(currPos.x, currPos.y - 1);
	    if (botRight.y > currPos.y)
		botRight = Point.xy(botRight.x, currPos.y);
	    break;

	case WEST:
	    currPos = Point.xy(currPos.x - 1, currPos.y);
	    if (topLeft.x > currPos.x)
		topLeft = Point.xy(currPos.x, topLeft.y);
	    break;
	}
    }

    public Point getTopLeft()
    {
	return topLeft;
    }

    public Point getBotRight()
    {
	return botRight;
    }
}
