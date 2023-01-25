package com.ssafy.remotecontrol;

public interface remoteControl {

	// abstract를 쓰지 않아도 컴파일러가 자동으로 추가함
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void volume_Up();
	public abstract void volume_Down();
	public abstract String toString();
}