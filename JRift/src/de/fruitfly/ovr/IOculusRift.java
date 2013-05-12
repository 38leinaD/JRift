package de.fruitfly.ovr;

public interface IOculusRift {
    public String getVersion();
	public boolean init();
	public boolean isInitialized();
	public void poll();
    public float getYawDegrees_LH();
    public float getPitchDegrees_LH();
    public float getRollDegrees_LH();
	public HMDInfo getHMDInfo();
	public SensorInfo getSensorInfo();
    public EyeRenderParams getEyeRenderParams(int viewPortX, int viewPortY, int viewPortWidth, int viewPortHeight, float nearClip, float farClip);
    public EyeRenderParams getEyeRenderParams(int viewPortWidth, int viewPortHeight);
	public void destroy();
    public void setIPD(float ipd);
    public float getIPD();
    public void setPrediction(float delta, boolean enable);
}
