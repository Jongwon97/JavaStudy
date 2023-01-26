package com.ssafy.remotecontrol;

class settopbox implements remoteControl{
	
	final static int max_Volume=20;
	final static int min_Volume=0;
	private int volume;

	public void turnOn() {
		System.out.println(toString()+"를 켭니다.");
	}
	public void turnOff() {
		System.out.println(toString()+"를 끕니다.");
	}

	public void volume_Up() {
		if(this.volume>=max_Volume) {
			this.volume=max_Volume;
			System.out.println("볼륨 증가! -> 볼륨이 최대 크기 입니다. 현재볼륨: "+max_Volume);
		}
		else {
			this.volume+=5;
			System.out.println("볼륨 증가! -> 현재 볼륨: "+this.volume);
		}
	}

	public void volume_Down() {
		if(this.volume<=min_Volume) {
			this.volume=min_Volume;
			System.out.println("볼륨 감소! -> 볼륨이 최소 크기 입니다. 현재볼륨: "+min_Volume);
		}
		else {
			this.volume-=5;
			System.out.println("볼륨 감소! -> 현재 볼륨: "+this.volume);
		}
	}

	public String toString() {
		return "셋톱박스";
	}

}
