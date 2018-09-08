package uk.me.suriar.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class TowersOfHanoi {
	public static String move(final Tower tower1, final Tower tower2, final Tower tower3) {
		final Steps steps = new Steps(tower1, tower2, tower3);
		steps.addStep();
		move(steps, tower1, tower1.height(), tower2, tower3);
		return steps.toString();
	}

	private static void move(final Steps steps,
			final Tower tower1, final int height1, final Tower tower2, final Tower tower3)
	{
		//System.out.println(String.format("move:%s%s%s, height= %s", tower1,tower2,tower3,height1));
		if (height1 == 0) return;
		
		if (height1 > 1)
		{
			move(steps, tower1, height1-1, tower3, tower2);
		}
		tower3.addFirst(tower1.removeFirst());
		steps.addStep();
		move(steps, tower2, height1-1, tower1, tower3);
	}

	private static class Steps
	{
		final List<String> steps = new ArrayList<>();
		final Tower tower1;
		final Tower tower2;
		final Tower tower3;
		
		Steps(final Tower tower1, final Tower tower2, final Tower tower3)
		{
			this.tower1 = tower1;
			this.tower2 = tower2;
			this.tower3 = tower3;
		}
		
		private void addStep()
		{
			final String nextStep = String.format("{%s%s%s}", tower1, tower2, tower3);
			System.out.println(nextStep);
			steps.add(nextStep);
		}
		
		public String toString()
		{
			return steps.stream().collect(Collector.of(
					StringBuffer::new, StringBuffer::append, (l,r)->{l.append(r); return l;})).toString();
		}
	}
}
