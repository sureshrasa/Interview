package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import uk.me.suriar.interview.CircusTower;
import uk.me.suriar.interview.Person;

public class TestCircusTower
{
    @Test
    public void testEmpty()
    {
	assertEquals(0, new CircusTower().longestTower(new ArrayList<Person>()));
    }
    
    @Test
    public void testOne()
    {
	assertEquals(1, new CircusTower().longestTower(
		Stream.of(Person.ofWeightHeight(80, 121)).collect(Collectors.toList())));
    }
    
    @Test
    public void testThree()
    {
	assertEquals(2, new CircusTower().longestTower(
		Stream.of(Person.ofWeightHeight(45, 97),
			Person.ofWeightHeight(85, 140),
			Person.ofWeightHeight(80, 150)).collect(Collectors.toList())));
    }

    
    @Test
    public void testMany()
    {
	assertEquals(3, new CircusTower().longestTower(
		Stream.of(Person.ofWeightHeight(45, 97),
			Person.ofWeightHeight(47, 90),
			Person.ofWeightHeight(86, 145),
			Person.ofWeightHeight(65, 130),
			Person.ofWeightHeight(80, 150)).collect(Collectors.toList())));
    }
}
