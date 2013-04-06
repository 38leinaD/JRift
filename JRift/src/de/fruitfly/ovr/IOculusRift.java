package de.fruitfly.ovr;

public interface IOculusRift {
	public boolean init();
	public boolean isInitialized();
	public void poll();
	public HMDInfo getHMDInfo();
	public SensorInfo getSensorInfo();
	public void destroy();
}
