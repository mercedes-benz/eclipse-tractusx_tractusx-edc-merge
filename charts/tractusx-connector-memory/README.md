# tractusx-connector-memory

![Version: 0.4.1-PR473-474-475](https://img.shields.io/badge/Version-0.4.1--PR473--474--475-informational?style=flat-square) ![Type: application](https://img.shields.io/badge/Type-application-informational?style=flat-square) ![AppVersion: 0.4.1-PR473-474-475](https://img.shields.io/badge/AppVersion-0.4.1--PR473--474--475-informational?style=flat-square)

A Helm chart for Tractus-X Eclipse Data Space Connector based on memory. Please only use this for development or testing purposes, never in production workloads!

**Homepage:** <https://github.com/eclipse-tractusx/tractusx-edc/tree/main/charts/tractusx-connector-memory>

This chart uses an in-memory secrets vault, which is required to contain the following secrets on application start:

- `daps-cert`: contains the x509 certificate of the connector.
- `daps-key`: the private key of the x509 certificate

These must be obtained from a DAPS instance, the process of which is out of the scope of this document. Alternatively,
self-signed certificates can be used for testing:

```shell
openssl req -newkey rsa:2048 -new -nodes -x509 -days 3650 -keyout daps.key -out daps.cert -subj "/CN=test"
export DAPS_KEY="$(cat daps.key)"
export DAPS_CERT="$(cat daps.cert)"
```

## Launching the application

The in-memory vault can be seeded directly with secrets that are passed in `<key>:<value>;<key2>:<value2>;...` format.
This config value can be passed to the runtime using the `vault.secrets` parameter. In addition, the runtime requires a
couple of configuration parameters, all of which can be found in the section below. Please also consider using
[this example configuration](https://github.com/eclipse-tractusx/tractusx-edc/blob/main/charts/tractusx-connector-memory/example.yaml)
to launch the application.

Combined, run this shell command to start the in-memory Tractus-X EDC runtime:

```shell
helm repo add tractusx-edc https://eclipse-tractusx.github.io/charts/dev
helm install my-release tractusx-edc/tractusx-connector-memory --version 0.4.1-PR473-474-475 \
     -f <path-to>/example.yaml \
     --set vault.secrets="daps-cert:$DAPS_CERT;daps-key:$DAPS_KEY" \
```

Note that `DAPS_CERT` contains the x509 certificate, `DAPS_KEY` contains the private key.

## Source Code

* <https://github.com/eclipse-tractusx/tractusx-edc/tree/main/charts/tractusx-connector-memory>

## Requirements

| Repository | Name | Version |
|------------|------|---------|
| file://./subcharts/omejdn | daps(daps) | 0.0.1 |

## Values

| Key | Type | Default | Description |
|-----|------|---------|-------------|
| backendService.httpProxyTokenReceiverUrl | string | `""` |  |
| customLabels | object | `{}` |  |
| daps.clientId | string | `""` |  |
| daps.connectors[0].attributes.referringConnector | string | `"http://sokrates-controlplane/BPNSOKRATES"` |  |
| daps.connectors[0].certificate | string | `""` |  |
| daps.connectors[0].id | string | `"E7:07:2D:74:56:66:31:F0:7B:10:EA:B6:03:06:4C:23:7F:ED:A6:65:keyid:E7:07:2D:74:56:66:31:F0:7B:10:EA:B6:03:06:4C:23:7F:ED:A6:65"` |  |
| daps.connectors[0].name | string | `"sokrates"` |  |
| daps.paths.jwks | string | `"/jwks.json"` |  |
| daps.paths.token | string | `"/token"` |  |
| daps.url | string | `"http://{{ .Release.Name }}-daps:4567"` |  |
| fullnameOverride | string | `""` |  |
| idsdaps.connectors[0].certificate | string | `""` |  |
| imagePullSecrets | list | `[]` | Existing image pull secret to use to [obtain the container image from private registries](https://kubernetes.io/docs/concepts/containers/images/#using-a-private-registry) |
| install.daps | bool | `true` |  |
| nameOverride | string | `""` |  |
| participant.id | string | `""` |  |
| runtime.affinity | object | `{}` |  |
| runtime.autoscaling.enabled | bool | `false` | Enables [horizontal pod autoscaling](https://kubernetes.io/docs/tasks/run-application/horizontal-pod-autoscale/https://kubernetes.io/docs/tasks/run-application/horizontal-pod-autoscale/) |
| runtime.autoscaling.maxReplicas | int | `100` | Maximum replicas if resource consumption exceeds resource threshholds |
| runtime.autoscaling.minReplicas | int | `1` | Minimal replicas if resource consumption falls below resource threshholds |
| runtime.autoscaling.targetCPUUtilizationPercentage | int | `80` | targetAverageUtilization of cpu provided to a pod |
| runtime.autoscaling.targetMemoryUtilizationPercentage | int | `80` | targetAverageUtilization of memory provided to a pod |
| runtime.businessPartnerValidation.log.agreementValidation | bool | `true` |  |
| runtime.debug.enabled | bool | `false` |  |
| runtime.debug.port | int | `1044` |  |
| runtime.debug.suspendOnStart | bool | `false` |  |
| runtime.endpoints | object | `{"control":{"path":"/control","port":8083},"default":{"path":"/api","port":8080},"management":{"authKey":"","path":"/management","port":8081},"observability":{"insecure":true,"path":"/observability","port":8085},"protocol":{"path":"/api/v1/dsp","port":8084},"proxy":{"path":"/proxy","port":8186},"public":{"path":"/api/public","port":8086},"validation":{"path":"/validation","port":8082}}` | endpoints of the control plane |
| runtime.endpoints.control | object | `{"path":"/control","port":8083}` | control api, used for internal control calls. can be added to the internal ingress, but should probably not |
| runtime.endpoints.control.path | string | `"/control"` | path for incoming api calls |
| runtime.endpoints.control.port | int | `8083` | port for incoming api calls |
| runtime.endpoints.default | object | `{"path":"/api","port":8080}` | default api for health checks, should not be added to any ingress |
| runtime.endpoints.default.path | string | `"/api"` | path for incoming api calls |
| runtime.endpoints.default.port | int | `8080` | port for incoming api calls |
| runtime.endpoints.management | object | `{"authKey":"","path":"/management","port":8081}` | data management api, used by internal users, can be added to an ingress and must not be internet facing |
| runtime.endpoints.management.authKey | string | `""` | authentication key, must be attached to each 'X-Api-Key' request header |
| runtime.endpoints.management.path | string | `"/management"` | path for incoming api calls |
| runtime.endpoints.management.port | int | `8081` | port for incoming api calls |
| runtime.endpoints.observability | object | `{"insecure":true,"path":"/observability","port":8085}` | observability api with unsecured access, must not be internet facing |
| runtime.endpoints.observability.insecure | bool | `true` | allow or disallow insecure access, i.e. access without authentication |
| runtime.endpoints.observability.path | string | `"/observability"` | observability api, provides /health /readiness and /liveness endpoints |
| runtime.endpoints.observability.port | int | `8085` | port for incoming API calls |
| runtime.endpoints.protocol | object | `{"path":"/api/v1/dsp","port":8084}` | ids api, used for inter connector communication and must be internet facing |
| runtime.endpoints.protocol.path | string | `"/api/v1/dsp"` | path for incoming api calls |
| runtime.endpoints.protocol.port | int | `8084` | port for incoming api calls |
| runtime.endpoints.validation | object | `{"path":"/validation","port":8082}` | validation api, only used by the data plane and should not be added to any ingress |
| runtime.endpoints.validation.path | string | `"/validation"` | path for incoming api calls |
| runtime.endpoints.validation.port | int | `8082` | port for incoming api calls |
| runtime.env | object | `{}` |  |
| runtime.envConfigMapNames | list | `[]` |  |
| runtime.envSecretNames | list | `[]` |  |
| runtime.envValueFrom | object | `{}` |  |
| runtime.image.pullPolicy | string | `"IfNotPresent"` | [Kubernetes image pull policy](https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy) to use |
| runtime.image.repository | string | `""` |  |
| runtime.image.tag | string | `""` | Overrides the image tag whose default is the chart appVersion |
| runtime.ingresses[0].annotations | object | `{}` | Additional ingress annotations to add |
| runtime.ingresses[0].certManager.clusterIssuer | string | `""` | If preset enables certificate generation via cert-manager cluster-wide issuer |
| runtime.ingresses[0].certManager.issuer | string | `""` | If preset enables certificate generation via cert-manager namespace scoped issuer |
| runtime.ingresses[0].className | string | `""` | Defines the [ingress class](https://kubernetes.io/docs/concepts/services-networking/ingress/#ingress-class)  to use |
| runtime.ingresses[0].enabled | bool | `false` |  |
| runtime.ingresses[0].endpoints | list | `["protocol"]` | EDC endpoints exposed by this ingress resource |
| runtime.ingresses[0].hostname | string | `"edc-control.local"` | The hostname to be used to precisely map incoming traffic onto the underlying network service |
| runtime.ingresses[0].tls | object | `{"enabled":false,"secretName":""}` | TLS [tls class](https://kubernetes.io/docs/concepts/services-networking/ingress/#tls) applied to the ingress resource |
| runtime.ingresses[0].tls.enabled | bool | `false` | Enables TLS on the ingress resource |
| runtime.ingresses[0].tls.secretName | string | `""` | If present overwrites the default secret name |
| runtime.ingresses[1].annotations | object | `{}` | Additional ingress annotations to add |
| runtime.ingresses[1].certManager.clusterIssuer | string | `""` | If preset enables certificate generation via cert-manager cluster-wide issuer |
| runtime.ingresses[1].certManager.issuer | string | `""` | If preset enables certificate generation via cert-manager namespace scoped issuer |
| runtime.ingresses[1].className | string | `""` | Defines the [ingress class](https://kubernetes.io/docs/concepts/services-networking/ingress/#ingress-class)  to use |
| runtime.ingresses[1].enabled | bool | `false` |  |
| runtime.ingresses[1].endpoints | list | `["management","control"]` | EDC endpoints exposed by this ingress resource |
| runtime.ingresses[1].hostname | string | `"edc-control.intranet"` | The hostname to be used to precisely map incoming traffic onto the underlying network service |
| runtime.ingresses[1].tls | object | `{"enabled":false,"secretName":""}` | TLS [tls class](https://kubernetes.io/docs/concepts/services-networking/ingress/#tls) applied to the ingress resource |
| runtime.ingresses[1].tls.enabled | bool | `false` | Enables TLS on the ingress resource |
| runtime.ingresses[1].tls.secretName | string | `""` | If present overwrites the default secret name |
| runtime.initContainers | list | `[]` |  |
| runtime.internationalDataSpaces.catalogId | string | `"TXDC-Catalog"` |  |
| runtime.internationalDataSpaces.curator | string | `""` |  |
| runtime.internationalDataSpaces.description | string | `"Tractus-X Eclipse IDS Data Space Connector"` |  |
| runtime.internationalDataSpaces.id | string | `"TXDC"` |  |
| runtime.internationalDataSpaces.maintainer | string | `""` |  |
| runtime.internationalDataSpaces.title | string | `""` |  |
| runtime.livenessProbe.enabled | bool | `true` | Whether to enable kubernetes [liveness-probe](https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/) |
| runtime.livenessProbe.failureThreshold | int | `6` | when a probe fails kubernetes will try 6 times before giving up |
| runtime.livenessProbe.initialDelaySeconds | int | `30` | seconds to wait before performing the first liveness check |
| runtime.livenessProbe.periodSeconds | int | `10` | this fields specifies that kubernetes should perform a liveness check every 10 seconds |
| runtime.livenessProbe.successThreshold | int | `1` | number of consecutive successes for the probe to be considered successful after having failed |
| runtime.livenessProbe.timeoutSeconds | int | `5` | number of seconds after which the probe times out |
| runtime.logging | string | `".level=INFO\norg.eclipse.edc.level=ALL\nhandlers=java.util.logging.ConsoleHandler\njava.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter\njava.util.logging.ConsoleHandler.level=ALL\njava.util.logging.SimpleFormatter.format=[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS] [%4$-7s] %5$s%6$s%n"` | configuration of the [Java Util Logging Facade](https://docs.oracle.com/javase/7/docs/technotes/guides/logging/overview.html) |
| runtime.nodeSelector | object | `{}` |  |
| runtime.podAnnotations | object | `{}` | additional annotations for the pod |
| runtime.podLabels | object | `{}` | additional labels for the pod |
| runtime.podSecurityContext | object | `{"fsGroup":10001,"runAsGroup":10001,"runAsUser":10001,"seccompProfile":{"type":"RuntimeDefault"}}` | The [pod security context](https://kubernetes.io/docs/tasks/configure-pod-container/security-context/#set-the-security-context-for-a-pod) defines privilege and access control settings for a Pod within the deployment |
| runtime.podSecurityContext.fsGroup | int | `10001` | The owner for volumes and any files created within volumes will belong to this guid |
| runtime.podSecurityContext.runAsGroup | int | `10001` | Processes within a pod will belong to this guid |
| runtime.podSecurityContext.runAsUser | int | `10001` | Runs all processes within a pod with a special uid |
| runtime.podSecurityContext.seccompProfile.type | string | `"RuntimeDefault"` | Restrict a Container's Syscalls with seccomp |
| runtime.readinessProbe.enabled | bool | `true` | Whether to enable kubernetes [readiness-probes](https://kubernetes.io/docs/tasks/configure-pod-container/configure-liveness-readiness-startup-probes/) |
| runtime.readinessProbe.failureThreshold | int | `6` | when a probe fails kubernetes will try 6 times before giving up |
| runtime.readinessProbe.initialDelaySeconds | int | `30` | seconds to wait before performing the first readiness check |
| runtime.readinessProbe.periodSeconds | int | `10` | this fields specifies that kubernetes should perform a readiness check every 10 seconds |
| runtime.readinessProbe.successThreshold | int | `1` | number of consecutive successes for the probe to be considered successful after having failed |
| runtime.readinessProbe.timeoutSeconds | int | `5` | number of seconds after which the probe times out |
| runtime.replicaCount | int | `1` |  |
| runtime.resources | object | `{}` | [resource management](https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/) for the container |
| runtime.securityContext.allowPrivilegeEscalation | bool | `false` | Controls [Privilege Escalation](https://kubernetes.io/docs/concepts/security/pod-security-policy/#privilege-escalation) enabling setuid binaries changing the effective user ID |
| runtime.securityContext.capabilities.add | list | `[]` | Specifies which capabilities to add to issue specialized syscalls |
| runtime.securityContext.capabilities.drop | list | `["ALL"]` | Specifies which capabilities to drop to reduce syscall attack surface |
| runtime.securityContext.readOnlyRootFilesystem | bool | `true` | Whether the root filesystem is mounted in read-only mode |
| runtime.securityContext.runAsNonRoot | bool | `true` | Requires the container to run without root privileges |
| runtime.securityContext.runAsUser | int | `10001` | The container's process will run with the specified uid |
| runtime.service.annotations | object | `{}` |  |
| runtime.service.type | string | `"ClusterIP"` | [Service type](https://kubernetes.io/docs/concepts/services-networking/service/#publishing-services-service-types) to expose the running application on a set of Pods as a network service. |
| runtime.tolerations | list | `[]` |  |
| runtime.url.ids | string | `""` | Explicitly declared url for reaching the ids api (e.g. if ingresses not used) |
| runtime.url.public | string | `""` |  |
| runtime.url.readiness | string | `""` |  |
| runtime.volumeMounts | list | `[]` | declare where to mount [volumes](https://kubernetes.io/docs/concepts/storage/volumes/) into the container |
| runtime.volumes | list | `[]` | [volume](https://kubernetes.io/docs/concepts/storage/volumes/) directories |
| serviceAccount.annotations | object | `{}` |  |
| serviceAccount.create | bool | `true` |  |
| serviceAccount.imagePullSecrets | list | `[]` | Existing image pull secret bound to the service account to use to [obtain the container image from private registries](https://kubernetes.io/docs/concepts/containers/images/#using-a-private-registry) |
| serviceAccount.name | string | `""` |  |
| vault.secretNames.dapsPrivateKey | string | `"daps-private-key"` |  |
| vault.secretNames.dapsPublicKey | string | `"daps-public-key"` |  |
| vault.secretNames.transferProxyTokenEncryptionAesKey | string | `"transfer-proxy-token-encryption-aes-key"` |  |
| vault.secretNames.transferProxyTokenSignerPrivateKey | string | `"transfer-proxy-token-signer-private-key"` |  |
| vault.secretNames.transferProxyTokenSignerPublicKey | string | `"transfer-proxy-token-signer-public-key"` |  |
| vault.secrets | string | `""` |  |
| vault.server.postStart | string | `""` |  |

----------------------------------------------
Autogenerated from chart metadata using [helm-docs v1.10.0](https://github.com/norwoodj/helm-docs/releases/v1.10.0)
