package com.learn.no_5.multiCaster;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof TestEvent){
			TestEvent eventOne = (TestEvent) event;
			eventOne.print();
		}
	}
}
