package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import uk.me.suriar.interview.Box;
import uk.me.suriar.interview.BoxStacker;

public class TestBoxStacker
{
    @Test
    public void testSingleBox()
    {
	assertEquals(4, new BoxStacker().stack(Stream.of(new Box(5, 4, 3)).collect(Collectors.toList())));
    }

    @Test
    public void testTwoBoxes()
    {
	assertEquals(7,
		new BoxStacker().stack(Stream.of(new Box(3, 3, 2), new Box(5, 4, 3)).collect(Collectors.toList())));
    }

    @Test
    public void testThreeBoxes()
    {
	assertEquals(9, new BoxStacker()
		.stack(Stream.of(new Box(4, 6, 3), new Box(3, 3, 2), new Box(5, 4, 3)).collect(Collectors.toList())));
    }

    @Test
    public void testManyBoxes()
    {
	assertEquals(10,
		new BoxStacker().stack(Stream
			.of(new Box(1, 1, 1), new Box(4, 6, 3), new Box(2, 2, 2), new Box(3, 3, 3), new Box(5, 4, 4))
			.collect(Collectors.toList())));
    }

}
