# \<YourProjectName>

\<YourProjectName> is a Minecraft server made with Minestom server library in Kotlin.

## Development setup

1. Import this project as existing project in IntelliJ IDEA, Eclipse, or any IDE that supports Kotlin

Walla! You're now good to code.

## Deployment

1. To build, run the following command in the terminal:
```
~$ cd path/to/<YourProjectName>
~$ ./gradlew clean shadowJar
```

A server JAR will be available for deployment in directory `./build/lib` once the build task is done. 

## License

Licensed under the [Apache License 2.0](LICENSE).