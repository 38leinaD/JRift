UNAME := $(shell uname)
ARCH := $(shell uname -m)

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

ifeq ($(UNAME), Linux)

    ifneq ($(ARCH), x86_64)
        ARCH:=i386
    endif

JRiftLibrary.o:
	g++ \
	-fno-rtti \
	-fPIC \
	"-I${JAVA_HOME}/include" \
	"-I${JAVA_HOME}/include/linux" \
	"-I${OCULUS_SDK}/LibOVR/Include" \
	-c JRiftLibrary.cpp

libJRiftLibrary.jnilib: JRiftLibrary.o
	g++ \
	-fno-rtti \
	-fPIC \
	-shared \
	-lpthread \
	-o libJRiftLibrary.jnilib \
	JRiftLibrary.o \
	${OCULUS_SDK}/LibOVR/Lib/Linux/Release/$(ARCH)/libovr.a
endif

