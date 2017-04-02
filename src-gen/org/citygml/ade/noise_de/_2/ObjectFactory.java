
package org.citygml.ade.noise_de._2;

import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.opengis.gml.MeasureType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.citygml.ade.noise_de._2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Remark_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "remark");
    private final static QName _BuildingLNightEq_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingLNightEq");
    private final static QName _NoiseRailwaySegment_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "NoiseRailwaySegment");
    private final static QName _NoiseCityFurnitureSegment_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "NoiseCityFurnitureSegment");
    private final static QName _BuildingHabitants_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingHabitants");
    private final static QName _BuildingReflectionCorrection_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingReflectionCorrection");
    private final static QName _NoiseRailwaySegmentProperty_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "noiseRailwaySegmentProperty");
    private final static QName _NoiseCityFurnitureSegmentProperty_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "noiseCityFurnitureSegmentProperty");
    private final static QName _NoiseRoadSegmentProperty_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "noiseRoadSegmentProperty");
    private final static QName _BuildingImmissionPoints_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingImmissionPoints");
    private final static QName _BuildingLDenEq_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingLDenEq");
    private final static QName _BuildingAppartments_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingAppartments");
    private final static QName _NoiseRoadSegment_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "NoiseRoadSegment");
    private final static QName _BuildingReflection_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingReflection");
    private final static QName _BuildingLNightMax_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingLNightMax");
    private final static QName _BuildingLDenMax_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingLDenMax");
    private final static QName _BuildingLNightMin_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingLNightMin");
    private final static QName _BuildingLDenMin_QNAME = new QName("http://www.citygml.org/ade/noise_de/2.0", "buildingLDenMin");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.citygml.ade.noise_de._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NoiseRoadSegmentType }
     * 
     */
    public NoiseRoadSegmentType createNoiseRoadSegmentType() {
        return new NoiseRoadSegmentType();
    }

    /**
     * Create an instance of {@link NoiseRailwaySegmentType }
     * 
     */
    public NoiseRailwaySegmentType createNoiseRailwaySegmentType() {
        return new NoiseRailwaySegmentType();
    }

    /**
     * Create an instance of {@link NoiseCityFurnitureSegmentType }
     * 
     */
    public NoiseCityFurnitureSegmentType createNoiseCityFurnitureSegmentType() {
        return new NoiseCityFurnitureSegmentType();
    }

    /**
     * Create an instance of {@link NoiseRailwaySegmentPropertyType }
     * 
     */
    public NoiseRailwaySegmentPropertyType createNoiseRailwaySegmentPropertyType() {
        return new NoiseRailwaySegmentPropertyType();
    }

    /**
     * Create an instance of {@link NoiseCityFurnitureSegmentPropertyType }
     * 
     */
    public NoiseCityFurnitureSegmentPropertyType createNoiseCityFurnitureSegmentPropertyType() {
        return new NoiseCityFurnitureSegmentPropertyType();
    }

    /**
     * Create an instance of {@link NoiseRoadSegmentPropertyType }
     * 
     */
    public NoiseRoadSegmentPropertyType createNoiseRoadSegmentPropertyType() {
        return new NoiseRoadSegmentPropertyType();
    }

    /**
     * Create an instance of {@link TrainPropertyType }
     * 
     */
    public TrainPropertyType createTrainPropertyType() {
        return new TrainPropertyType();
    }

    /**
     * Create an instance of {@link TrainType }
     * 
     */
    public TrainType createTrainType() {
        return new TrainType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "remark", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<String> createRemark(String value) {
        return new JAXBElement<String>(_Remark_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingLNightEq", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<MeasureType> createBuildingLNightEq(MeasureType value) {
        return new JAXBElement<MeasureType>(_BuildingLNightEq_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoiseRailwaySegmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "NoiseRailwaySegment", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<NoiseRailwaySegmentType> createNoiseRailwaySegment(NoiseRailwaySegmentType value) {
        return new JAXBElement<NoiseRailwaySegmentType>(_NoiseRailwaySegment_QNAME, NoiseRailwaySegmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoiseCityFurnitureSegmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "NoiseCityFurnitureSegment", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<NoiseCityFurnitureSegmentType> createNoiseCityFurnitureSegment(NoiseCityFurnitureSegmentType value) {
        return new JAXBElement<NoiseCityFurnitureSegmentType>(_NoiseCityFurnitureSegment_QNAME, NoiseCityFurnitureSegmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingHabitants", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<BigInteger> createBuildingHabitants(BigInteger value) {
        return new JAXBElement<BigInteger>(_BuildingHabitants_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingReflectionCorrection", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<MeasureType> createBuildingReflectionCorrection(MeasureType value) {
        return new JAXBElement<MeasureType>(_BuildingReflectionCorrection_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoiseRailwaySegmentPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "noiseRailwaySegmentProperty", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/2.0", substitutionHeadName = "_GenericApplicationPropertyOfRailway")
    public JAXBElement<NoiseRailwaySegmentPropertyType> createNoiseRailwaySegmentProperty(NoiseRailwaySegmentPropertyType value) {
        return new JAXBElement<NoiseRailwaySegmentPropertyType>(_NoiseRailwaySegmentProperty_QNAME, NoiseRailwaySegmentPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoiseCityFurnitureSegmentPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "noiseCityFurnitureSegmentProperty", substitutionHeadNamespace = "http://www.opengis.net/citygml/cityfurniture/2.0", substitutionHeadName = "_GenericApplicationPropertyOfCityFurniture")
    public JAXBElement<NoiseCityFurnitureSegmentPropertyType> createNoiseCityFurnitureSegmentProperty(NoiseCityFurnitureSegmentPropertyType value) {
        return new JAXBElement<NoiseCityFurnitureSegmentPropertyType>(_NoiseCityFurnitureSegmentProperty_QNAME, NoiseCityFurnitureSegmentPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoiseRoadSegmentPropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "noiseRoadSegmentProperty", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/2.0", substitutionHeadName = "_GenericApplicationPropertyOfRoad")
    public JAXBElement<NoiseRoadSegmentPropertyType> createNoiseRoadSegmentProperty(NoiseRoadSegmentPropertyType value) {
        return new JAXBElement<NoiseRoadSegmentPropertyType>(_NoiseRoadSegmentProperty_QNAME, NoiseRoadSegmentPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link BigInteger }{@code >}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingImmissionPoints", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<List<BigInteger>> createBuildingImmissionPoints(List<BigInteger> value) {
        return new JAXBElement<List<BigInteger>>(_BuildingImmissionPoints_QNAME, ((Class) List.class), null, ((List<BigInteger> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingLDenEq", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<MeasureType> createBuildingLDenEq(MeasureType value) {
        return new JAXBElement<MeasureType>(_BuildingLDenEq_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingAppartments", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<BigInteger> createBuildingAppartments(BigInteger value) {
        return new JAXBElement<BigInteger>(_BuildingAppartments_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoiseRoadSegmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "NoiseRoadSegment", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<NoiseRoadSegmentType> createNoiseRoadSegment(NoiseRoadSegmentType value) {
        return new JAXBElement<NoiseRoadSegmentType>(_NoiseRoadSegment_QNAME, NoiseRoadSegmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingReflection", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<String> createBuildingReflection(String value) {
        return new JAXBElement<String>(_BuildingReflection_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingLNightMax", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<MeasureType> createBuildingLNightMax(MeasureType value) {
        return new JAXBElement<MeasureType>(_BuildingLNightMax_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingLDenMax", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<MeasureType> createBuildingLDenMax(MeasureType value) {
        return new JAXBElement<MeasureType>(_BuildingLDenMax_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingLNightMin", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<MeasureType> createBuildingLNightMin(MeasureType value) {
        return new JAXBElement<MeasureType>(_BuildingLNightMin_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.citygml.org/ade/noise_de/2.0", name = "buildingLDenMin", substitutionHeadNamespace = "http://www.opengis.net/citygml/building/2.0", substitutionHeadName = "_GenericApplicationPropertyOfAbstractBuilding")
    public JAXBElement<MeasureType> createBuildingLDenMin(MeasureType value) {
        return new JAXBElement<MeasureType>(_BuildingLDenMin_QNAME, MeasureType.class, null, value);
    }

}
