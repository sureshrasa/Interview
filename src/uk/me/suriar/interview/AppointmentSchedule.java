package uk.me.suriar.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppointmentSchedule
{
    private static final Logger logger = Logger.getLogger(AppointmentSchedule.class.getName());
    
    private final Map<Integer, Schedule> cache = new HashMap<>();

    private static class Schedule
    {
	private final int totalDuration;
	private final List<Integer> appointments;

	public static Schedule oneOf(final int totalDuration)
	{
	    return new Schedule(totalDuration, new ArrayList<>());
	}

	public static Schedule concat(final int duration, final Schedule rest)
	{
	    return new Schedule(rest.getTotalDuration() + duration,
		    Stream.concat(Stream.of(duration), rest.getAppointments().stream()).collect(Collectors.toList()));
	}

	private Schedule(final int totalDuration, final List<Integer> appointments)
	{
	    this.totalDuration = totalDuration;
	    this.appointments = appointments;
	}

	public List<Integer> getAppointments()
	{
	    return appointments;
	}

	public int getTotalDuration()
	{
	    return totalDuration;
	}

	@Override
	public String toString()
	{
	    return String.format("Schedule(%s, %s)", totalDuration, appointments);
	}
    }

    public List<Integer> pick(final List<Integer> appointments)
    {
	logger.info(() -> String.format("pick: %s", appointments));

	return pickFromRange(appointments, 0).getAppointments();
    }

    private Schedule pickFromRange(List<Integer> appointments, final int start)
    {
	logger.info(() -> String.format("pickFromRange: %s -> %s", start, appointments.size()));
	
	if (start >= appointments.size()) return Schedule.oneOf(0);

	return cache.computeIfAbsent(start, k -> {
	    final Schedule includingStart = pickFromRange(appointments, start + 2);
	    final Schedule skippingStart = pickFromRange(appointments, start + 1);

	    logger.info(() -> String.format("pickFromRange: including:%s excluding:%s", includingStart, skippingStart));

	    return (includingStart.getTotalDuration() + appointments.get(start) > skippingStart.getTotalDuration())
		    ? Schedule.concat(appointments.get(start), includingStart)
		    : skippingStart;
	});
    }
}
