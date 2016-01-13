# Compile RMI--IIOP Java 8

## first 
Compile HelloImpl source.
```sh
javac -d . -classpath . ServicoImpl.java
```
## second

now use the rmic for make stubs

```sh
rmic -iiop ServicoImpl
```

## Third
Compile outhers sources.

```sh
javac -d . -classpath . Client.java Server.class Servico.class
```

# For run 

## Up RMI service

```sh
./orb.sh &
```

## Run RMI Server
```sh
./server.sh &
```
## Run Cliente server
```sh
./cliente.sh &
```
## Run requests
```sh
./make-requiests.sh &
```

