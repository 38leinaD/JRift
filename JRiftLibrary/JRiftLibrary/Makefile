UNAME := $(shell uname)

all: libJRiftLibrary.jnilib

clean:
	rm -f *.o
	rm -f a.out
	rm -f *.jnilib

ifeq ($(UNAME), Darwin)

JRiftLibrary.o:
	g++ \
	-fno-rtti \
	"-I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers" \
	"-I/Developer/SDKs/MacOSX10.6.sdk/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers" \
	"-I${OCULUS_SDK}/LibOVR/Include" \
	-c JRiftLibrary.cpp

libJRiftLibrary.jnilib: JRiftLibrary.o
	g++ \
		-dynamiclib \
		-fno-rtti \
		-framework ApplicationServices \
		-framework IOKit \
		-o libJRiftLibrary.jnilib \
		JRiftLibrary.o \
	 	${OCULUS_SDK}/LibOVR/Lib/MacOS/Release/libovr.a

endif