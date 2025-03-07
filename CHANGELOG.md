# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [0.4.1-PR473-474-475] - 2023-06-14

## [0.4.6] - 2023-06-14

## [0.4.5] - 2023-06-14

## [0.4.4] - 2023-06-13

## [0.4.1] - 2023-05-31

### Added

-   SQL implementation for the EDR Cache
-   E2E test variant using PostgreSQL
-   Documentation

### Changed

-   Moved to Java 17
-   Switched to Eclipse Dataspace Components `0.1.0`

### Removed

-   Lombok

## [0.4.0] - 2023-05-18

### Added

-   Support for the new Dataspace Protocol
-   GitHub Workflow to check for missing license headers

### Changed

-   Switched to Eclipse Dataspace Components `0.0.1-milestone-9`

### Removed

-   Business tests. All tests are covered by other means.
-   Control-Plane-Adapter. Replaced by a DSP-compatible implementation

## [0.3.4] - 2023-05-17

### Fixed

-   Added license headers to several files in the code base
-   Refactoring of Helm charts - multiple charts instead of one dynamically assembled chart

## [0.3.3] - 2023-04-19

### Fixed

-   Config values for the data plane part of the helm chart
-   Contract Validity

### Added

-   A log line whenever a policy evaluation of the BPN number was performed

## [0.3.2] - 2023-03-30

### Fixed

-   Fixed mutually-exclusive config values for Azure KeyVault

## [0.3.1] - 2023-03-27

### Added

### Changed

-   Support unauthenticated access to the ObservabilityAPI (#126)

### Fixed

## [0.3.0] - 2023-02-20

**Important Note**: This version introduces multiple breaking changes. Before updating **always** consolidate the
corresponding [documentation](/docs/migration/Version_0.1.x_0.3.x.md).

### Added

-   Add contract id to data source http call (#732)
-   Support also support releases in ci pipeline
-   Introduce typed object for oauth2 provisioning
-   Add documentation
-   Add test case
-   Add client to omejdn
-   add hydra deployment
-   Configure dynamically HTTP Receiver callback endpoints. (#685)
-   cp-adapter : code review, rollbacke name change (#664)
-   Feature/cp adapter task 355 356 357 (#621)
-   Add Validity Mapping in ContractDefinitionStepDefs class
-   Add feature and create SendAnOfferwithoutConstraints method in class negotiationSteps
-   Add validity attribute in class ContractDefinition
-   Add Validity Mapping in ContractDefinitionStepDefs class
-   Add feature and create SendAnOfferwithoutConstraints method in class negotiationSteps
-   Add validity attribute in class ContractDefinition
-   Local TXDC Setup Documentation (#618)
-   Feature: Sftp Provisioner and Client (#554)

### Changed

-   Support horizontal edc scaling in cp adapter extension (#678)
-   Use upstream jackson version (#741)
-   Replace provision-oauth2 with data-plane-http-oauth2
-   docs: Update sample documentation (#671)
-   chore: Disable build ci pipeline if just docu was updated (#705)
-   Increase trivy timeout
-   Remove not useful anymore custom-jsonld extension (#683)
-   update setup docu (#654)
-   remove trailing slash (#652)
-   update alpine from 3.17.0 to 3.17.1 for controlplane-memory-hashicorp-vault (#665)
-   Feature/set charts deprecated (#628)
-   update setup docu (#627)
-   Feature/update txdc deployment downward capabilities (#625)
-   remove git submodule (#619)
-   Feature/update postman (#624)
-   update control plane docu (#623)
-   update postgresql version in Chart.yaml supporting-infrastructure (#622)
-   update link to edc logo in README.md (#612)
-   update description of supporting infrastructure deployment (#616)

### Fixed

-   bugfix: Fix slow AES encryption (#746)
-   Fix typo in tractusx-connector values.yaml comment
-   Fix not working docu link in README.md
-   Fix typo in control-plane adapter README

### Dependency updates

-   Bump EDC to 20220220 (#767)
-   Bump alpine (#749)
-   Bump alpine (#750)
-   Bump alpine (#752)
-   Bump alpine in /edc-controlplane/edc-runtime-memory/src/main/docker (#753)
-   Bump maven-deploy-plugin from 3.0.0 to 3.1.0 (#735)
-   Bump actions/setup-java from 3.9.0 to 3.10.0 (#730)
-   Bump s3 from 2.19.33 to 2.20.0
-   Bump s3 from 2.19.27 to 2.19.33
-   Bump jaxb-runtime from 4.0.1 to 4.0.2
-   Bump spotless-maven-plugin from 2.31.0 to 2.32.0
-   Bump postgresql from 42.5.1 to 42.5.3
-   Bump nimbus-jose-jwt from 9.30 to 9.30.1
-   Bump lombok from 1.18.24 to 1.18.26
-   Bump flyway-core from 9.12.0 to 9.14.1
-   Bump jackson-bom from 2.14.0-rc2 to 2.14.2
-   Bump cucumber.version from 7.11.0 to 7.11.1
-   Bump azure-sdk-bom from 1.2.8 to 1.2.9
-   Bump mockito-bom from 5.0.0 to 5.1.1
-   Bump edc version to 0.0.1-20230131-SNAPSHOT
-   Bump s3 from 2.19.18 to 2.19.27
-   Bump docker/build-push-action from 3 to 4
-   Bump nimbus-jose-jwt from 9.29 to 9.30
-   Bump spotless-maven-plugin from 2.30.0 to 2.31.0
-   Bump nimbus-jose-jwt from 9.28 to 9.29
-   Bump mockito-bom from 4.11.0 to 5.0.0
-   Bump edc version to 0.0.1-20230125-SNAPSHOT
-   Bump flyway-core from 9.11.0 to 9.12.0
-   Bump s3 from 2.19.15 to 2.19.18 (#684)
-   Bump mikefarah/yq from 4.30.6 to 4.30.8 (#682)
-   Bump spotless-maven-plugin from 2.29.0 to 2.30.0
-   Bump edc version to 0.0.1-20230115-SNAPSHOT
-   Bump cucumber.version from 7.10.1 to 7.11.0 (#672)
-   Bump maven-dependency-plugin from 3.4.0 to 3.5.0 (#669)
-   Bump s3 from 2.19.11 to 2.19.15 (#668)
-   Bump maven-surefire-plugin from 3.0.0-M7 to 3.0.0-M8 (#670)
-   Bump edc version to 0.0.1-20230109-SNAPSHOT (#666)
-   Bump alpine in /edc-controlplane/edc-runtime-memory/src/main/docker (#659)
-   Bump alpine in /edc-dataplane/edc-dataplane-azure-vault/src/main/docker (#660)
-   Bump alpine (#658)
-   Bump alpine (#661)
-   Bump alpine (#662)
-   Bump azure/setup-kubectl from 3.1 to 3.2 (#655)
-   Bump junit-bom from 5.9.1 to 5.9.2 (#657)
-   Bump s3 from 2.19.2 to 2.19.11 (#648)
-   Bump actions/checkout from 3.2.0 to 3.3.0 (#647)
-   Bump flyway-core from 9.10.2 to 9.11.0 (#646)
-   Bump spotless-maven-plugin from 2.28.0 to 2.29.0 (#641)
-   Bump mockito-bom from 4.10.0 to 4.11.0 (#637)
-   Bump flyway-core from 9.10.1 to 9.10.2 (#632)
-   Bump s3 from 2.19.1 to 2.19.2 (#631)
-   Bump s3 from 2.18.41 to 2.19.1 (#626)
-   Bump mikefarah/yq from 4.30.5 to 4.30.6 (#613)
-   Bump cucumber.version from 7.10.0 to 7.10.1 (#614)
-   Bump s3 from 2.18.40 to 2.18.41 (#615)
-   Bump azure/setup-helm from 3.4 to 3.5 (#596)
-   Bump actions/checkout from 3.1.0 to 3.2.0 (#598)
-   Bump mockito-bom from 4.9.0 to 4.10.0 (#607)
-   Bump s3 from 2.18.39 to 2.18.40 (#609)
-   Bump flyway-core from 9.10.0 to 9.10.1 (#610)
-   Bump actions/setup-java from 3.8.0 to 3.9.0 (#605)
-   Bump s3 from 2.18.35 to 2.18.39 (#606)

## [0.1.6] - 2023-02-20

### Fixed

-   SQL leakage issue
-   Catalog pagination

## [0.1.5] - 2023-02-13

### Fixed

-   Use patched EDC version: 0.0.1-20220922.2-SNAPSHOT to fix catalog pagination bug
-   Data Encryption extension: fixed usage of a blocking algorithm

## [0.1.2] - 2022-09-30

### Added

-   Introduced DEPENDENCIES file

### Changed

-   Moved helm charts from `deployment/helm` to `charts`
-   Replaced distroless image with alpine in all docker images
-   Update EDC commit to `740c100ac162bc41b1968c232ad81f7d739aefa9`

## [0.1.1] - 2022-09-04

**Important Note**: Please consolidate the migration documentation before updating your
connector. [documentation](/docs/migration/Version_0.1.0_0.1.1.md).

### Added

-   Control-Plane Extension ([cx-oauth2](/edc-extensions/cx-oauth2/README.md))

### Changed

-   Introduced git submodule to import EDC dependencies (instead of snapshot- or milestone artifact)
-   Helm Charts: TLS secret name is now configurable

### Fixed

-   Connectors with Azure Vault extension are now starting
    again [link](https://github.com/eclipse-edc/Connector/issues/1892)

## [0.1.0] - 2022-08-19

**Important Note**: Version 0.1.0 introduces multiple breaking changes. Before updating **always** consolidate the
corresponding [documentation](/docs/migration/Version_0.0.x_0.1.x.md).

### Added

-   Control-Plane
    extension ([data-plane-selector-client](https://github.com/eclipse-edc/Connector/tree/v0.0.1-milestone-5/extensions/data-plane-selector/selector-client))
    -   run the EDC with multiple data planes at once
-   Control-Plane extension ([dataplane-selector-configuration](edc-extensions/dataplane-selector-configuration))
    -   add data plane instances to the control plane by configuration
-   Data-Plane
    extension ([s3-data-plane](https://github.com/eclipse-edc/Connector/tree/main/extensions/aws/data-plane-s3))
    -   transfer from and to AWS S3 buckets
-   Control-Plane extension ([data-encryption](edc-extensions/data-encryption))
    -   Data-Plane authentication attribute transmitted during data-plane-transfer can be encrypted symmetrically (AES)

### Changed

-   Update setting name (`edc.dataplane.token.validation.endpoint` -> `edc.dataplane.token.validation.endpoint`)
-   EDC has been updated to
    version [0.0.1-20220818-SNAPSHOT](https://oss.sonatype.org/#nexus-search;gav~org.eclipse.dataspaceconnector~~0.0.1-20220818-SNAPSHOT~~) -
    implications to the behavior of the connector have been covered in
    the [corresponding migration guide](docs/migration/Version_0.0.x_0.1.x.md)

### Fixed

-   Contract-Offer-Receiving-Connectors must also pass the ContractPolicy of the ContractDefinition before receiving
    offers([issue](https://github.com/eclipse-edc/Connector/issues/1331))
-   Deletion of Asset becomes impossible when Contract Negotiation
    exists([issue](https://github.com/eclipse-edc/Connector/issues/1403))
-   Deletion of Policy becomes impossible when Contract Definition
    exists([issue](https://github.com/eclipse-edc/Connector/issues/1410))

## [0.0.6] - 2022-07-29

### Fixed

-   Fixes [release 0.0.5](https://github.com/eclipse-tractusx/tractusx-edc/releases/tag/0.0.5), which introduced classpath
    issues due to usage of [net.jodah:failsafe:2.4.3](https://search.maven.org/artifact/net.jodah/failsafe/2.4.3/jar)
    library

## [0.0.5] - 2022-07-28

### Added

-   EDC Health Checks for HashiCorp Vault

### Changed

-   BusinessPartnerNumber constraint supports List structure
-   Helm: Confidential EDC settings can be set using k8s secrets
-   HashiCorp Vault API path configurable

## [0.0.4] - 2022-06-27<https://github.com/mercedes-benz/eclipse-tractusx_tractusx-edc-merge/pull/2/conflict?name=CHANGELOG.md&ancestor_oid=fadbf8cb87c6a61a7eee0ce022f6b2243ab3d847&base_oid=ec171ada7e85b0869201d91fcba9fa386d685982&head_oid=99365d3d150c8cf434bfc21ea36ffe4726b2aa6c>

### Added

-   HashiCorp Vault Extension
-   Control Plane with HashiCorp Vault and PostgreSQL support

### Changed

-   Release Workflow now publishes EDC Extensions as Maven Artifacts

### Fixed

-   [#1515](https://github.com/eclipse-edc/Connector/issues/1515) SQL: Connector sends out 50
    contract offers max.

### Removed

-   CosmosDB Control Plane
-   Control API Extension for all Control Planes

## [0.0.3] - 2022-05-23

## [0.0.2] - 2022-05-20

## [0.0.1] - 2022-05-13

[Unreleased]: https://github.com/mercedes-benz/eclipse-tractusx_tractusx-edc-merge/compare/0.4.1-PR473-474-475...HEAD

[0.4.1-PR473-474-475]: https://github.com/mercedes-benz/eclipse-tractusx_tractusx-edc-merge/compare/0.4.6...0.4.1-PR473-474-475

[0.4.6]: https://github.com/mercedes-benz/eclipse-tractusx_tractusx-edc-merge/compare/0.4.5...0.4.6

[0.4.5]: https://github.com/mercedes-benz/eclipse-tractusx_tractusx-edc-merge/compare/0.4.4...0.4.5

[0.4.4]: https://github.com/mercedes-benz/eclipse-tractusx_tractusx-edc-merge/compare/0.4.1...0.4.4

[0.4.1]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.3.3...0.4.1

[0.3.3]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.3.2...0.3.3

[0.3.2]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.3.1...0.3.2

[0.3.1]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.3.0...0.3.1

[0.3.0]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.2.0...0.3.0

[0.1.6]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.1.5...0.1.6

[0.1.5]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.1.2...0.1.5

[0.1.2]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.1.1...0.1.2

[0.1.1]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.1.0...0.1.1

[0.1.0]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.0.6...0.1.0

[0.0.6]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.0.5...0.0.6

[0.0.5]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.0.4...0.0.5

[0.0.4]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.0.3...0.0.4

[0.0.3]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.0.2...0.0.3

[0.0.2]: https://github.com/eclipse-tractusx/tractusx-edc/compare/0.0.1...0.0.2

[0.0.1]: https://github.com/eclipse-tractusx/tractusx-edc/compare/a02601306fed39a88a3b3b18fae98b80791157b9...0.0.1
