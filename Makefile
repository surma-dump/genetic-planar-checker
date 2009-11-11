all:
	javac -cp ./core.jar gpc.java
run:
	java -cp ./core.jar:./ gpc
clean:
	-@rm *.class
