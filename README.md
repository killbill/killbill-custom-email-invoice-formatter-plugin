# killbill-custom-email-invoice-formatter

Example code for a custom invoice formatter.For a detailed tutorial, please refer to our [docs](https://docs.killbill.io/latest/custom-email-invoice-formatter.html).Note that this plugin requires the [email notification plugin](https://github.com/killbill/killbill-email-notifications-plugin) to be installed.

## Build

```
mvn clean install -DskipTests=true 
```

## Installation

Run the following [kpm](https://github.com/killbill/killbill-cloud/blob/master/kpm) command:

```
kpm install_java_plugin 'dev-custom-invoice-formatter' --from-source-file=<jar_file_path> --destination=<path_to_install_plugin>
```

