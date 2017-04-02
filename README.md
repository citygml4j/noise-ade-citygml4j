# noise-ade
CityGML NoiseADE module for citygml4j.

This is a citygml4j module for the CityGML 2.0 Noise Application Domain Extension (ADE). The module is implemented against the `ADEContext` extension of citygml4j that is currently being developed in the citygml4j [ade-context branch](https://github.com/citygml4j/citygml4j/tree/ade-context). In contrast to the generic ADE support of citygml4j, which maps ADE content onto a Java DOM representation, the `ADEContext` allows for extending the citygml4j object model with new ADE classes. JAXB is used for parsing and writing ADE-enriched CityGML datasets. The required JAXB classes mapping the ADE XML Schema can easily be generated with the [ade-xjc](https://github.com/citygml4j/ade-xjc) compiler shipped with citygml4j. 
