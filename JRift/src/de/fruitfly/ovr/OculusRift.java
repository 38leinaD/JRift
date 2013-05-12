package de.fruitfly.ovr;


public class OculusRift implements IOculusRift {
	
	private boolean initialized = false;

    public final String VERSION = "1.1";
	
	private HMDInfo hmdInfo = new HMDInfo();

    public float testYawAngle;
    public float testPitchAngle;
    public float testRollAngle;

    public final float MAXPITCH = (90 * 0.98f);
    public final float MAXROLL = (180 * 0.98f);

    public float rawYaw;
    public float rawPitch;
    public float rawRoll;

    public float yawAngleDegrees;
    public float pitchAngleDegrees;
    public float rollAngleDegrees;

    public float testPitchAngleDelta = 0.0f;
    public float testRollAngleDelta = 0.0f;
    public float testYawAngleDelta = 0.0f;

    public boolean directionPos = true;

    public String _initSummary = "Not initialised";

    public boolean use = true;
	
	public OculusRift()
    {
        use = true;
        testYawAngle = 0.0F;
        testPitchAngle = 0.0F;
        testRollAngle = 0.0F;

        resetHMDInfo();
	}

    private void resetHMDInfo()
    {
        // Initialize "fake" default HMD values for testing without HMD plugged in.
        // These default values match those returned by the HMD.
        hmdInfo.HResolution            = 1280;
        hmdInfo.VResolution            = 800;
        hmdInfo.HScreenSize            = 0.14976f;
        hmdInfo.VScreenSize            = hmdInfo.HScreenSize / (1280.0f / 800.0f);
        hmdInfo.InterpupillaryDistance = 0.0635f;
        hmdInfo.LensSeparationDistance = 0.064f;
        hmdInfo.EyeToScreenDistance    = 0.041f;
        hmdInfo.DistortionK[0]         = 1.0f;
        hmdInfo.DistortionK[1]         = 0.22f;
        hmdInfo.DistortionK[2]         = 0.24f;
        hmdInfo.DistortionK[3]         = 0.0f;
        hmdInfo.ChromaticAb[0]         = 1.0f;
        hmdInfo.ChromaticAb[1]         = 0.0f;
        hmdInfo.ChromaticAb[2]         = 1.0f;
        hmdInfo.ChromaticAb[3]         = 0.0f;
    }

    public String getVersion()
    {
        return VERSION;
    }
	
	public boolean init() {

        _initSummary = "Last initialisation attempt failed";

		initialized = initSubsystem();
        //initialized = true;

        if (initialized)
        {
            hmdInfo.HResolution = _getHResolution();
            hmdInfo.VResolution = _getVResolution();
            hmdInfo.HScreenSize = _getHScreenSize();
            hmdInfo.VScreenSize = _getVScreenSize();
            hmdInfo.HScreenSize = _getVScreenCenter();
            hmdInfo.EyeToScreenDistance =  _getEyeToScreenDistance();
            hmdInfo.LensSeparationDistance = _getLensSeparationDistance();
            hmdInfo.InterpupillaryDistance = _getInterpupillaryDistance();
            hmdInfo.DistortionK[0] = _getDistortionK0();
            hmdInfo.DistortionK[1] = _getDistortionK1();
            hmdInfo.DistortionK[2] = _getDistortionK2();
            hmdInfo.DistortionK[3] = _getDistortionK3();
           // hmdInfo.ChromaticAb[0] = _getChromaticAb0();    // TODO: Get chromatic aberration values
           // hmdInfo.ChromaticAb[1] = _getChromaticAb1();
           // hmdInfo.ChromaticAb[2] = _getChromaticAb2();
           // hmdInfo.ChromaticAb[3] = _getChromaticAb3();

            _initSummary = "OK";
        }
        else
        {
            resetHMDInfo();
        }
		
		return initialized;
	}
	
	public boolean isInitialized() {
		return initialized;
	}

    public void setIPD(float ipd)
    {
        _setInterpupillaryDistance(ipd);
        hmdInfo.InterpupillaryDistance = ipd;
    }

    public float getIPD()
    {
        if (initialized)
            return _getInterpupillaryDistance();

        return hmdInfo.InterpupillaryDistance;
    }

	public void poll()
    {
		if (initialized)
        {
            pollSubsystem();

            // Yaw
            rawYaw = _getYaw();   // -PI to PI, RH
            yawAngleDegrees = (float)Math.toDegrees(-rawYaw);

            // Pitch
            rawPitch = _getPitch();  // -PI/2 to PI/2, RH
            pitchAngleDegrees = (float)Math.toDegrees(-rawPitch);
            if (pitchAngleDegrees > MAXPITCH)
                pitchAngleDegrees = MAXPITCH;
            if (pitchAngleDegrees < -MAXPITCH)
                pitchAngleDegrees = -MAXPITCH;

            // Roll
            rawRoll = _getRoll();  // -PI to PI, RH
            rollAngleDegrees = (float)Math.toDegrees(-rawRoll);
            if (rollAngleDegrees > MAXROLL)
                rollAngleDegrees = MAXROLL;
            if (rollAngleDegrees < -MAXROLL)
                rollAngleDegrees = -MAXROLL;
        }
        else
        {
            testPitchAngle += testPitchAngleDelta;
            testRollAngle += testRollAngleDelta;
            testYawAngle += testYawAngleDelta;
        }
	}
	
	public HMDInfo getHMDInfo() {
		return hmdInfo;
	}
	
	public SensorInfo getSensorInfo() {
		return null; // TODO: Support get sensor info
	}
	
	public float getYawDegrees_LH()
    {
	    if (initialized)
        {
            return yawAngleDegrees;
        }
        else
        {
            return testYawAngle;
        }
	}
	
	public float getPitchDegrees_LH()
    {
        if (initialized)
        {
            return pitchAngleDegrees;
        }
        else
        {
            return testPitchAngle;
        }
    }

	public float getRollDegrees_LH()
    {
        if (initialized)
        {
            return rollAngleDegrees;
        }
        else
        {
//            if (directionPos)
//            {
//                testRollAngle+= 0.01f;
//                if (testRollAngle >= 89)
//                    directionPos = !directionPos;
//            }
//            else
//            {
//                testRollAngle-= 0.01f;
//                if (testRollAngle <= -89)
//                    directionPos = !directionPos;
//            }

            return testRollAngle;
        }
	}

    public void setPrediction(float delta, boolean enable)
    {
        if (initialized)
        {
            _setPredictionEnabled(delta, enable);
        }
    }

	public void destroy() {

        if (initialized)
        {
            destroySubsystem();
        }

        _initSummary = "Not initialised";
        initialized = false;
	}

    public EyeRenderParams getEyeRenderParams(int viewPortWidth, int viewPortHeight)
    {
        return getEyeRenderParams(0, 0, viewPortWidth, viewPortHeight, 0.05f, 1000.0f);
    }

    public EyeRenderParams getEyeRenderParams(int viewPortX, int viewPortY, int viewPortWidth, int viewPortHeight, float clipNear, float clipFar)
    {
        return _getEyeRenderParams(viewPortX, viewPortY, viewPortWidth, viewPortHeight, clipNear, clipFar);
    }

	private native boolean initSubsystem();
	private native void pollSubsystem();
	private native void destroySubsystem();

    private native void _setPredictionEnabled(float delta, boolean enable);
	private native int _getHResolution();
	private native int _getVResolution();
	private native float _getHScreenSize();
	private native float _getVScreenSize();
	private native float _getVScreenCenter();
	private native float _getEyeToScreenDistance();
	private native float _getLensSeparationDistance();
	private native float _getInterpupillaryDistance();
    private native void  _setInterpupillaryDistance(float ipd);
	private native float _getDistortionK0();
	private native float _getDistortionK1();
	private native float _getDistortionK2();
	private native float _getDistortionK3();
	
	private native float _getYaw();
	private native float _getPitch();
	private native float _getRoll();

    private native EyeRenderParams _getEyeRenderParams(int currentViewportX,
                                                       int currentViewportY,
                                                       int currentViewportWidth,
                                                       int currentViewportHeight,
                                                       float clipNear,
                                                       float clipFar);
	
	static {
        String dataModel = System.getProperty("sun.arch.data.model");

        if (dataModel.equalsIgnoreCase("64"))
        {
            System.out.println("Loading JRiftLibrary64.dll (64-bit)");
            System.loadLibrary("JRiftLibrary64");
            System.out.println("JRiftLibrary64.dll loaded");
        }
        else
        {
            System.out.println("Loading JRiftLibrary.dll (32-bit)");
            System.loadLibrary("JRiftLibrary");
            System.out.println("JRiftLibrary.dll loaded");
        }
    }
	
	public static void main(String[] args) {
		OculusRift or = new OculusRift();
		or.init();
		
		HMDInfo hmdInfo = or.getHMDInfo();
		System.out.println(hmdInfo);
		
		while (or.isInitialized()) {
			or.poll();
			
			System.out.println("Yaw: " + or.getYawDegrees_LH() + " Pitch: " + or.getPitchDegrees_LH() + " Roll: " + or.getRollDegrees_LH());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		or.destroy();
	}
}
