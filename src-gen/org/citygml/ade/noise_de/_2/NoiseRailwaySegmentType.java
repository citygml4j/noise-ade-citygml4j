//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.5.0+1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Sun Apr 02 23:01:10 CEST 2017
//


package org.citygml.ade.noise_de._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.transportation._2.AbstractTransportationObjectType;
import net.opengis.gml.CurvePropertyType;
import net.opengis.gml.LengthType;
import net.opengis.gml.MeasureType;


/**
 * <p>Java-Klasse für NoiseRailwaySegmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="NoiseRailwaySegmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/2.0}AbstractTransportationObjectType">
 *       &lt;sequence>
 *         &lt;element name="railwaySurfaceMaterial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="railwaySurfaceCorrection" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="bridge" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="crossing" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="curveRadius" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/>
 *         &lt;element name="additionalCorrectionSegment" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="lod0BaseLine" type="{http://www.opengis.net/gml}CurvePropertyType"/>
 *         &lt;element name="usedBy" type="{http://www.citygml.org/ade/noise_de/2.0}TrainPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoiseRailwaySegmentType", propOrder = {
    "railwaySurfaceMaterial",
    "railwaySurfaceCorrection",
    "bridge",
    "crossing",
    "curveRadius",
    "additionalCorrectionSegment",
    "lod0BaseLine",
    "usedBy"
})
public class NoiseRailwaySegmentType
    extends AbstractTransportationObjectType
{

    protected String railwaySurfaceMaterial;
    protected MeasureType railwaySurfaceCorrection;
    protected Boolean bridge;
    protected Boolean crossing;
    protected LengthType curveRadius;
    protected MeasureType additionalCorrectionSegment;
    @XmlElement(required = true)
    protected CurvePropertyType lod0BaseLine;
    protected List<TrainPropertyType> usedBy;

    /**
     * Ruft den Wert der railwaySurfaceMaterial-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRailwaySurfaceMaterial() {
        return railwaySurfaceMaterial;
    }

    /**
     * Legt den Wert der railwaySurfaceMaterial-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRailwaySurfaceMaterial(String value) {
        this.railwaySurfaceMaterial = value;
    }

    public boolean isSetRailwaySurfaceMaterial() {
        return (this.railwaySurfaceMaterial!= null);
    }

    /**
     * Ruft den Wert der railwaySurfaceCorrection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getRailwaySurfaceCorrection() {
        return railwaySurfaceCorrection;
    }

    /**
     * Legt den Wert der railwaySurfaceCorrection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setRailwaySurfaceCorrection(MeasureType value) {
        this.railwaySurfaceCorrection = value;
    }

    public boolean isSetRailwaySurfaceCorrection() {
        return (this.railwaySurfaceCorrection!= null);
    }

    /**
     * Ruft den Wert der bridge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBridge() {
        return bridge;
    }

    /**
     * Legt den Wert der bridge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBridge(Boolean value) {
        this.bridge = value;
    }

    public boolean isSetBridge() {
        return (this.bridge!= null);
    }

    /**
     * Ruft den Wert der crossing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrossing() {
        return crossing;
    }

    /**
     * Legt den Wert der crossing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrossing(Boolean value) {
        this.crossing = value;
    }

    public boolean isSetCrossing() {
        return (this.crossing!= null);
    }

    /**
     * Ruft den Wert der curveRadius-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getCurveRadius() {
        return curveRadius;
    }

    /**
     * Legt den Wert der curveRadius-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setCurveRadius(LengthType value) {
        this.curveRadius = value;
    }

    public boolean isSetCurveRadius() {
        return (this.curveRadius!= null);
    }

    /**
     * Ruft den Wert der additionalCorrectionSegment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getAdditionalCorrectionSegment() {
        return additionalCorrectionSegment;
    }

    /**
     * Legt den Wert der additionalCorrectionSegment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setAdditionalCorrectionSegment(MeasureType value) {
        this.additionalCorrectionSegment = value;
    }

    public boolean isSetAdditionalCorrectionSegment() {
        return (this.additionalCorrectionSegment!= null);
    }

    /**
     * Ruft den Wert der lod0BaseLine-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurvePropertyType }
     *     
     */
    public CurvePropertyType getLod0BaseLine() {
        return lod0BaseLine;
    }

    /**
     * Legt den Wert der lod0BaseLine-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurvePropertyType }
     *     
     */
    public void setLod0BaseLine(CurvePropertyType value) {
        this.lod0BaseLine = value;
    }

    public boolean isSetLod0BaseLine() {
        return (this.lod0BaseLine!= null);
    }

    /**
     * Gets the value of the usedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrainPropertyType }
     * 
     * 
     */
    public List<TrainPropertyType> getUsedBy() {
        if (usedBy == null) {
            usedBy = new ArrayList<TrainPropertyType>();
        }
        return this.usedBy;
    }

    public boolean isSetUsedBy() {
        return ((this.usedBy!= null)&&(!this.usedBy.isEmpty()));
    }

    public void unsetUsedBy() {
        this.usedBy = null;
    }

    public void setUsedBy(List<TrainPropertyType> value) {
        this.usedBy = value;
    }

}
