package uk.me.suriar.interview;

public class Box
{
    private final int width;
    private final int height;
    private final int depth;

    public Box(int w, int h, int d)
    {
	width = w;
	height = h;
	depth = d;
    }

    public int getWidth()
    {
	return width;
    }

    public int getHeight()
    {
	return height;
    }

    public int getDepth()
    {
	return depth;
    }

    public String toString()
    {
	return String.format("[%s,%s,%s]", width, height, depth);
    }
}
