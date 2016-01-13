# Compile RMI--IIOP Java 8

## first 
Compile HelloImpl source.
```sh
javac -d . -classpath . HelloImpl.java
```
## second

now use the rmic for make stubs

```sh
rmic -iiop HelloImpl.java
```

## Third
Compile outher sources.
```jsh
javac -d . -classpath . HelloInterface.java HelloServer.java HelloClient.java

```

# For run 

## Up RMI service

```
sh orb.sh
```

## Run RMI Server
```
sh server.sh
```
## Run Cliente server
```
sh cliente.sh
```


