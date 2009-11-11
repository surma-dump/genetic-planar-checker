all:
	javac -cp ./core.jar *.java
run:
	java -cp ./core.jar:./ gpc
clean:
	-@rm *.class
