# prerequisite

kind config, "D:\kind\kind-config.yml", supporting: port-mapping, ingress-controller support

```yaml
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4
nodes:
  - role: control-plane
    extraMounts:
      - hostPath: D:/kind/ca-certificates/localhost.org.crt
        containerPath: /usr/local/share/ca-certificates/localhost.org.crt
    kubeadmConfigPatches:
      - |
        kind: InitConfiguration
        nodeRegistration:
          kubeletExtraArgs:
            node-labels: "ingress-ready=true"     
    extraPortMappings:
      - containerPort: 80
        hostPort: 800
        protocol: TCP
      - containerPort: 443
        hostPort: 4433
        protocol: TCP
 ```

# test

```shell
curl localhost.demo-web.org:800/hello
```

