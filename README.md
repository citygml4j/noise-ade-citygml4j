# NoiseADE module for citygml4j
This is a citygml4j ADE module for the CityGML 2.0 Noise Application Domain Extension (ADE). The module is implemented against the `ADEContext` interface of citygml4j introduced in [citygml4j 2.5.0](https://github.com/citygml4j/citygml4j/releases/tag/v2.5.0). In contrast to the generic ADE support of citygml4j, which maps ADE content onto a Java DOM representation, the ADE module approach allows for extending the citygml4j object model with new ADE classes that seamlessly integrate with the predefined citygml4j object model. JAXB is used for parsing and writing ADE-enriched CityGML datasets. The required JAXB classes mapping the ADE XML Schema can be easily generated with the [ade-xjc](https://github.com/citygml4j/ade-xjc) compiler shipped with citygml4j. 

## How to use the module
Simply register the module with the citygml4j library to build a NoiseADE application and to consume and write NoiseADE datasets. Multiple ADE modules can be loaded and registered with citygml4j at runtime simultaneously.

Registering the NoiseADE module with citygml4j only requires one additional line of code. Be careful to register the `ADEContext` before creating the `CityGMLBuilder`.

```java
CityGMLContext context = CityGMLContext.getInstance();

// register NoiseADE module
context.registerADEContext(new NoiseADEContext());

CityGMLBuilder builder = context.createCityGMLBuilder();
...
```

## License
The NoiseADE module is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0). See the `LICENSE` file for more details.

## More information
The CityGML NoiseADE allows for using CityGML-based 3D city models for Noise Immission Simulations in the context of the Environmental Noise Directive of the European Union. It augments the CityGML base model by additional noise-related attributes and feature types using the CityGML ADE extension mechanism. The CityGML NoiseADE is described in detail in the [CityGML 2.0 specification document](https://portal.opengeospatial.org/files/?artifact_id=47842) (see Annex H). The NoiseADE XML Schema as well as example datasets can be obtained from the official [OGC CityGML schema repository](http://schemas.opengis.net/citygml/examples/2.0/ade/noise-ade/).

[OGC CityGML](http://www.opengeospatial.org/standards/citygml) is an open data model and XML-based format for the storage and exchange of semantic 3D city models. It is an application schema for the [Geography Markup Language version 3.1.1 (GML3)](http://www.opengeospatial.org/standards/gml), the extendible international standard for spatial data exchange issued by the Open Geospatial Consortium (OGC) and the ISO TC211. The aim of the development of CityGML is to reach a common definition of the basic entities, attributes, and relations of a 3D city model.

CityGML is an international OGC standard and can be used free of charge.
