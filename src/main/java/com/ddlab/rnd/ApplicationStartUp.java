package com.ddlab.rnd;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.util.CommonUtil;

@Component
public class ApplicationStartUp {

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {
		System.out.println("Application Started at : " + CommonUtil.timeNow());
	}
}
