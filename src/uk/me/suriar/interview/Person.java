package uk.me.suriar.interview;

public class Person
{
    public static Person ofWeightHeight(final int weight, final int height)
    {
	return new Person(weight, height);
    }

    private final int weight;
    private final int height;

    private Person(final int weight, final int height)
    {
	this.weight = weight;
	this.height = height;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean isShorterThan(final Person person)
    {
	return height < person.getHeight();
    }
}
