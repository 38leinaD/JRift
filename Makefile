all:
	make -C JRiftLibrary/JRiftLibrary
	make -C JRift

clean:
	make -C JRiftLibrary/JRiftLibrary clean
	make -C JRift clean

run:
	make -C JRift run
	