JRift
=====

Java Wrapper (JNI) for the Oculus Rift HMD and Sensors.

Currently exposes the [HMDInfo](https://developer.oculusvr.com/doc/html/class_o_v_r_1_1_h_m_d_info.html) and yaw/pitch/roll angles of the sensors.

You can get a first alpha build (32-bit JRE) for Windows from here:
https://dl.dropbox.com/u/8241387/OVR/JRift_alpha.zip

Want to build it yourself?
Compile the Java-part into a JAR (JRift) and compile the C++ part into a .dll (JRiftLibrary).
The JRiftLibrary comes with a Visual Studio 2010 solution project so it should build by only properly setting up two depenencies:
* jni.h header include of your installed JDK (include <jdk-dir>/include and <jdk-dir>/win32
* OVR SDK headers and library references. Get the SDK from [Oculus VR](https://developer.oculusvr.com) and see [this wiki entry](https://developer.oculusvr.com/wiki/Minimal_Oculus_Application) on how to set up the includes and library references properly.

Thanks to krisds, MacOSX is supported as well; need to build native library yourself via Makefile, though.