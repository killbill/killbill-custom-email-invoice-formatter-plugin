# killbill-custom-invoice-formatter-example

Example code for a custom invoice formatter

## Build

```
mvn clean install -DskipTests=true
```

## Installation

Run the following [kpm](https://github.com/killbill/killbill-cloud/blob/master/kpm) command:

```
kpm install_java_plugin 'dev-custom-invoice-formatter' --from-source-file=<jar_file_path> --destination=<path_to_install_plugin>
```

