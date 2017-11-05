package org.cybercafe.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	private static final SimpleDateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private SessionService sessionService;
	
	@Scheduled(fixedRate = 60000)
	public void updateSessions(){
		System.out.println("The time is now " + dateFormate.format(new Date()));
		sessionService.completeSessions();
	}

}
