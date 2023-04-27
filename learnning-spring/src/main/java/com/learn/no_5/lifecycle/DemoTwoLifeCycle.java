package com.learn.no_5.lifecycle;

import org.springframework.context.SmartLifecycle;

public class DemoTwoLifeCycle implements SmartLifecycle {
	private boolean running = false;

	@Override
	public void start() {
		this.running = true;
		System.out.println("-------Demo TWO is Start !!! ******");
	}

	@Override
	public void stop() {
		this.running = false;
		System.out.println("========== Demo TWO is Stop !!! ********");
	}

	@Override
	public boolean isRunning() {
		return running;
	}
}
