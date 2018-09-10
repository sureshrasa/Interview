package uk.me.suriar.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppointmentSchedule
{
    private final Map<Integer, Schedule> cache = new HashMap<>();

    private static class Schedule
    {
	private final int totalDuration;
	private final List<Integer> appointments;

	public Schedule(int totalDuration)
	{
	    this.totalDuration = totalDuration;
	    this.appointments = new ArrayList<>();
	}

	public Schedule(final Integer duration, final Schedule afterStart)
	{
	    totalDuration = afterStart.getTotalDuration() + duration;
	    appointments = Stream.concat(Stream.of(duration),
		    afterStart.getAppointments().stream()).collect(Collectors.toList());
	}

	public List<Integer> getAppointments()
	{
	    return appointments;
	}

	public int getTotalDuration()
	{
	    return totalDuration;
	}

    }

    public List<Integer> pick(final List<Integer> appointments)
    {
	return pickFromRange(appointments, 0).getAppointments();
    }

    private Schedule pickFromRange(List<Integer> appointments, final int start)
    {
	if (start >= appointments.size()) return new Schedule(0);
	
	final Schedule cachedResult = cache.get(start);
	if (cachedResult != null) return cachedResult;
	
	final Schedule afterStart = pickFromRange(appointments, start+2);
	final Schedule skippingStart = pickFromRange(appointments, start+1);
	
	final Schedule result =
		(afterStart.getTotalDuration() + appointments.get(start) > skippingStart.getTotalDuration())
		? new Schedule(appointments.get(start), afterStart)
		: skippingStart;
		
	cache.put(start, result);
	
	return result;
    }

}
