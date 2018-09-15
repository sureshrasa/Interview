package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collector;

import org.junit.Test;

import uk.me.suriar.interview.RobotPaths;

public class TestRobotPaths
{
    @Test
    public void testSinglePath()
    {
	List<String> paths = new RobotPaths().paths(1, 1, (r, c) -> false);
	assertEquals(1, paths.size());
	assertEquals("{[1,1]}", buildString(paths));
    }

    @Test
    public void test2by2Path()
    {
	assertEquals("{[1,1][1,2][2,2]}{[1,1][2,1][2,2]}", buildString(new RobotPaths().paths(2, 2, (r, c) -> false)));
    }

    @Test
    public void test3by3PathAvoidSumOf4()
    {
	assertEquals("", buildString(new RobotPaths().paths(3, 3, (r, c) -> ((r + c) == 4))));
    }

    @Test
    public void test3by3PathAvoidCentre()
    {
	assertEquals("{[1,1][1,2][1,3][2,3][3,3]}{[1,1][2,1][3,1][3,2][3,3]}",
		buildString(new RobotPaths().paths(3, 3, (r, c) -> (r == 2 && c == 2))));
    }

    private String buildString(final List<String> paths)
    {
	return paths.stream().map((s) -> "{" + s + "}")
		.collect(Collector.of(StringBuilder::new, StringBuilder::append, (l, r) -> {
		    l.append(r);
		    return l;
		})).toString();
    }

}
