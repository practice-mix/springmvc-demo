## test case

```shell
$ curl 'localhost:9002/form' -H "Content-Type: multipart/form-data" -X POST -F "name=john" -F "file=@/c/Users/luobd/Documents/test/material.txt"
```

## Thundra Sidekick
```shell
java -javaagent:"D:\PortableSoft\thundra-agent-bootstrap-2.7.22.jar"
```
https://sidekick.docs.thundra.io/installation/java

## create Secret

```shell
kubectl create secret docker-registry regcred --docker-server=localhost.org --docker-username=admin --docker-password=admin --docker-email=admin@admin

```

# issues

## issue: x509: certificate signed by unknown authority

### try2, usefull

install ca to k8s node

login k8s node,

```shell
cd /usr/local/share/ca-certificates/
cat > localhost.org.crt 
...

update-ca-certificates
```

https://stackoverflow.com/questions/42292444/how-do-i-add-a-ca-root-certificate-inside-a-docker-image

### 　try1:　（no use)

install certificate authority to k8s pod:  
https://paraspatidar.medium.com/add-self-signed-or-ca-root-certificate-in-kubernetes-pod-ca-root-certificate-store-cb7863cb3f87

create configmap:

```
kubectl  create configmap ca-pemstore --from-file=D:/temp/nginx-reverse-proxy-temp/nginx-ssl-proxy-self-signed-cert-temp/secrets/self.crt
```

use configmap:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: demo-web
spec:
  selector:
    matchLabels:
      app: demo-web
  replicas: 2
  template:
    metadata:
      labels:
        app: demo-web
    spec:
      containers:
        - name: demo-web
          image: localhost.org/demo/web:3.0
          imagePullPolicy: IfNotPresent
          ports:
            - containerPort: 8080
          volumeMounts:
            - name: ca-pemstore
              mountPath: /etc/ssl/certs/self.crt
              subPath: self.crt
              readOnly: false


```
