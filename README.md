## test case

```shell
$ curl 'localhost:9002/form' -H "Content-Type: multipart/form-data" -X POST -F "name=john" -F "file=@/c/Users/luobd/Documents/test/material.txt"
```

## Thundra Sidekick

https://sidekick.docs.thundra.io/installation/java

## create Secret

```shell
kubectl create secret docker-registry regcred --docker-server=localhost.org --docker-username=admin --docker-password=admin --docker-email=admin@admin

```
