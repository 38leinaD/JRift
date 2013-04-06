package de.fruitfly.ovr;


public class OculusRift implements IOculusRift {
	
	private boolean initialized = false;
	
	private HMDInfo hmdInfo = new HMDInfo();
	
	public OculusRift() {
		
	}
	
	public boolean init() {
		initialized = initSubsystem();
		
		hmdInfo.HResolution = _getHResolution();
		hmdInfo.VResolution = _getVResolution();
		hmdInfo.HScreenSize = _getHScreenSize();
		hmdInfo.VScreenSize = _getVScreenSize();
		hmdInfo.HScreenSize = _getVScreenCenter();
		hmdInfo.EyeToScreenDistance =  _getEyeToScreenDistance();
		hmdInfo.LensSeperationDistance = _getLensSeparationDistance();
		hmdInfo.InterpupillaryDistance = _getInterpupillaryDistance();
		hmdInfo.DistortionK[0] = _getDistortionK0();
		hmdInfo.DistortionK[1] = _getDistortionK1();
		hmdInfo.DistortionK[2] = _getDistortionK2();
		hmdInfo.DistortionK[3] = _getDistortionK3();
		
		return initialized;
	}
	
	public boolean isInitialized() {
		return initialized;
	}
	
	public void poll() {
		pollSubsystem();
	}
	
	public HMDInfo getHMDInfo() {
		return hmdInfo;
	}
	
	public SensorInfo getSensorInfo() {
		return null;
	}
	
	public float getYaw() {
		return _getYaw();
	}
	
	public float getPitch() {
		return _getPitch();
	}
	
	public float getRoll() {
		return _getRoll();
	}
	
	public void destroy() {
		destroySubsystem();
	}

	private native boolean initSubsystem();
	private native void pollSubsystem();
	private native void destroySubsystem();

	private native int _getHResolution();
	private native int _getVResolution();
	private native float _getHScreenSize();
	private native float _getVScreenSize();
	private native float _getVScreenCenter();
	private native float _getEyeToScreenDistance();
	private native float _getLensSeparationDistance();
	private native float _getInterpupillaryDistance();
	private native float _getDistortionK0();
	private native float _getDistortionK1();
	private native float _getDistortionK2();
	private native float _getDistortionK3();
	
	private native float _getYaw();
	private native float _getPitch();
	private native float _getRoll();
	
	static {
		System.loadLibrary("JRiftLibrary");
    }
	
	public static void main(String[] args) {
		OculusRift or = new OculusRift();
		or.init();
		
		HMDInfo hmdInfo = or.getHMDInfo();
		System.out.println(hmdInfo);
		
		while (or.isInitialized()) {
			or.poll();
			
			System.out.println("Yaw: " + or.getYaw() + " Pitch: " + or.getPitch() + " Roll: " + or.getRoll());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		or.destroy();
	}
}
