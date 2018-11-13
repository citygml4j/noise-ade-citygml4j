//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.8.1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Tue Nov 13 13:02:18 CET 2018
//


package org.citygml.ade.noise_de._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AbstractCityObjectType;
import net.opengis.gml.CodeType;
import net.opengis.gml.CurvePropertyType;
import net.opengis.gml.LengthType;
import net.opengis.gml.MeasureType;


/**
 * <p>Java-Klasse für NoiseCityFurnitureSegmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="NoiseCityFurnitureSegmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="type" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="reflection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reflectionCorrection" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/&gt;
 *         &lt;element name="height" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/&gt;
 *         &lt;element name="distance" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/&gt;
 *         &lt;element name="lod0BaseLine" type="{http://www.opengis.net/gml}CurvePropertyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoiseCityFurnitureSegmentType", propOrder = {
    "type",
    "reflection",
    "reflectionCorrection",
    "height",
    "distance",
    "lod0BaseLine"
})
public class NoiseCityFurnitureSegmentType
    extends AbstractCityObjectType
{

    protected CodeType type;
    protected String reflection;
    protected MeasureType reflectionCorrection;
    protected LengthType height;
    protected LengthType distance;
    @XmlElement(required = true)
    protected CurvePropertyType lod0BaseLine;

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setType(CodeType value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Ruft den Wert der reflection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReflection() {
        return reflection;
    }

    /**
     * Legt den Wert der reflection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReflection(String value) {
        this.reflection = value;
    }

    public boolean isSetReflection() {
        return (this.reflection!= null);
    }

    /**
     * Ruft den Wert der reflectionCorrection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getReflectionCorrection() {
        return reflectionCorrection;
    }

    /**
     * Legt den Wert der reflectionCorrection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setReflectionCorrection(MeasureType value) {
        this.reflectionCorrection = value;
    }

    public boolean isSetReflectionCorrection() {
        return (this.reflectionCorrection!= null);
    }

    /**
     * Ruft den Wert der height-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getHeight() {
        return height;
    }

    /**
     * Legt den Wert der height-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setHeight(LengthType value) {
        this.height = value;
    }

    public boolean isSetHeight() {
        return (this.height!= null);
    }

    /**
     * Ruft den Wert der distance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getDistance() {
        return distance;
    }

    /**
     * Legt den Wert der distance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setDistance(LengthType value) {
        this.distance = value;
    }

    public boolean isSetDistance() {
        return (this.distance!= null);
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

}
