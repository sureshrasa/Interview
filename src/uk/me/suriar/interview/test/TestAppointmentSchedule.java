package uk.me.suriar.interview.test;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import uk.me.suriar.interview.AppointmentSchedule;

public class TestAppointmentSchedule
{
    @Test
    public void testEmpty()
    {
	assertTrue(new AppointmentSchedule().pick(new ArrayList<Integer>()).isEmpty());
    }
    
    @Test
    public void testSingle()
    {
	assertEquals("[15]", new AppointmentSchedule().pick(Stream.of(15).collect(Collectors.toList())).toString());
    }
    
    @Test
    public void testPair()
    {
	assertEquals("[30]", new AppointmentSchedule().pick(Stream.of(15, 30).collect(Collectors.toList())).toString());
    }
    
    @Before
    public void setup()
    {
	Logger.getLogger(AppointmentSchedule.class.getName()).setLevel(Level.OFF);
    }

    @Test
    public void testMany()
    {
	Logger.getLogger(AppointmentSchedule.class.getName()).setLevel(Level.INFO);

	assertEquals("[30, 60, 45, 45, 60, 90]", new AppointmentSchedule().pick(Stream.of(30, 15, 60, 75, 45, 15, 15, 45, 30, 60, 120, 90).collect(Collectors.toList())).toString());	//logger.setLevel(Level.OFF);
    }

}
