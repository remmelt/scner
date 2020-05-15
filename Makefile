npm := docker run -it --entrypoint npm -v $(shell pwd)/fe:/work -w /work node

build:
	@$(npm) run-script build
	@mvn clean package

run:
	@java -jar target/scner-jar-with-dependencies.jar

start-dev:
	@$(npm) start
