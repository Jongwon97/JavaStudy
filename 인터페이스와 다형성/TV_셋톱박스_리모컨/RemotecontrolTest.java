package com.ssafy.remotecontrol;

public class RemotecontrolTest {

	public static void main(String[] args) {

		remoteControl r;
		television t=new television();
		settopbox s=new settopbox();
		
		// TV on
		r=t;
		r.turnOn();
		r.volume_Down();
		r.volume_Up();
		r.volume_Up();
		r.volume_Up();
		r.volume_Up();
		r.volume_Up();
		r.volume_Up();		
		r.turnOff();
		
		System.out.println();
		// 셋톱박스 on
		r=s;
		r.turnOn();
		r.volume_Down();
		r.volume_Up();
		r.volume_Up();
		r.volume_Up();
		r.volume_Up();
		r.volume_Up();		
		r.turnOff();
		
	}

}
