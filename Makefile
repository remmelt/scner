npm := npm

build:
	@$(npm) run-script build
	@mvn clean package

run:
	@java -jar target/scner-jar-with-dependencies.jar

start-dev:
	@$(npm) start
