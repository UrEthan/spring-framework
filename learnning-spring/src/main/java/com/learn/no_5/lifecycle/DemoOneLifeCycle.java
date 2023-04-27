package com.learn.no_5.lifecycle;

import org.springframework.context.Lifecycle;

public class DemoOneLifeCycle implements Lifecycle {
	private boolean running = false;

	@Override
	public void start() {
		this.running = true;
		System.out.println("-------Demo One is Start !!!");
	}

	@Override
	public void stop() {
		this.running = false;
		System.out.println("========== Demo One is Stop !!!");
	}

	@Override
	public boolean isRunning() {
		return running;
	}
}
