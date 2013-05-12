package de.fruitfly.ovr;

import java.util.Arrays;

public class HMDInfo {
	public int HResolution;
	public int VResolution;
	public float HScreenSize;
	public float VScreenSize;
	public float VScreenCenter;
	public float EyeToScreenDistance;
	public float LensSeparationDistance;
	public float InterpupillaryDistance;
	public float[] DistortionK = new float[4];
    public float[] ChromaticAb = new float[4];
	
	public int DesktopX; // Not queried from OVR AP yet
	public int DesktopY; // Not queried from OVR API yet
	public String DisplayDeviceName = "Oculus Rift"; // Not queried from OVR API yet
	public long DisplayId = 0; // Not queried from OVR API yet
	
	@Override
	public String toString() {
		return "HMDInfo [HResolution=" + HResolution + ", VResolution="
				+ VResolution + ", HScreenSize=" + HScreenSize
				+ ", VScreenSize=" + VScreenSize + ", VScreenCenter="
				+ VScreenCenter + ", EyeToScreenDistance="
				+ EyeToScreenDistance + ", LensSeperationDistance="
				+ LensSeparationDistance + ", InterpupillaryDistance="
				+ InterpupillaryDistance + ", DistortionK="
				+ Arrays.toString(DistortionK) + ", ChromaticAb="
                + Arrays.toString(ChromaticAb) + ", DesktopX=" + DesktopX
				+ ", DesktopY=" + DesktopY + ", DisplayDeviceName="
				+ DisplayDeviceName + ", DisplayId=" + DisplayId + "]";
	}
}
