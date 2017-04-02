//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.5.0+1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Sun Apr 02 23:01:10 CEST 2017
//


package org.citygml.ade.noise_de._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.transportation._2.AbstractTransportationObjectType;
import net.opengis.gml.CurvePropertyType;
import net.opengis.gml.LengthType;
import net.opengis.gml.MeasureType;
import net.opengis.gml.SpeedType;


/**
 * <p>Java-Klasse für NoiseRoadSegmentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="NoiseRoadSegmentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/2.0}AbstractTransportationObjectType">
 *       &lt;sequence>
 *         &lt;element name="mDay" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="mEvening" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="mNight" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="mDay16" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="pDay" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="pEvening" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="pNight" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="pDay16" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="dtv" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="speedDayPkw" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="speedEveningPkw" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="speedNightPkw" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="speedDayLkw" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="speedEveningLkw" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="speedNightLkw" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="roadSurfaceMaterial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roadSurfaceCorrection" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="distanceCarriageway" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/>
 *         &lt;element name="distanceD" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/>
 *         &lt;element name="bridge" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tunnel" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="roadGradientPercent" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="lod0BaseLine" type="{http://www.opengis.net/gml}CurvePropertyType"/>
 *         &lt;element name="lineage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoiseRoadSegmentType", propOrder = {
    "mDay",
    "mEvening",
    "mNight",
    "mDay16",
    "pDay",
    "pEvening",
    "pNight",
    "pDay16",
    "dtv",
    "speedDayPkw",
    "speedEveningPkw",
    "speedNightPkw",
    "speedDayLkw",
    "speedEveningLkw",
    "speedNightLkw",
    "roadSurfaceMaterial",
    "roadSurfaceCorrection",
    "distanceCarriageway",
    "distanceD",
    "bridge",
    "tunnel",
    "roadGradientPercent",
    "lod0BaseLine",
    "lineage"
})
public class NoiseRoadSegmentType
    extends AbstractTransportationObjectType
{

    protected MeasureType mDay;
    protected MeasureType mEvening;
    protected MeasureType mNight;
    protected MeasureType mDay16;
    protected MeasureType pDay;
    protected MeasureType pEvening;
    protected MeasureType pNight;
    protected MeasureType pDay16;
    protected MeasureType dtv;
    protected SpeedType speedDayPkw;
    protected SpeedType speedEveningPkw;
    protected SpeedType speedNightPkw;
    protected SpeedType speedDayLkw;
    protected SpeedType speedEveningLkw;
    protected SpeedType speedNightLkw;
    protected String roadSurfaceMaterial;
    protected MeasureType roadSurfaceCorrection;
    protected LengthType distanceCarriageway;
    protected LengthType distanceD;
    protected Boolean bridge;
    protected Boolean tunnel;
    protected MeasureType roadGradientPercent;
    @XmlElement(required = true)
    protected CurvePropertyType lod0BaseLine;
    protected String lineage;

    /**
     * Ruft den Wert der mDay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMDay() {
        return mDay;
    }

    /**
     * Legt den Wert der mDay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMDay(MeasureType value) {
        this.mDay = value;
    }

    public boolean isSetMDay() {
        return (this.mDay!= null);
    }

    /**
     * Ruft den Wert der mEvening-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMEvening() {
        return mEvening;
    }

    /**
     * Legt den Wert der mEvening-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMEvening(MeasureType value) {
        this.mEvening = value;
    }

    public boolean isSetMEvening() {
        return (this.mEvening!= null);
    }

    /**
     * Ruft den Wert der mNight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMNight() {
        return mNight;
    }

    /**
     * Legt den Wert der mNight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMNight(MeasureType value) {
        this.mNight = value;
    }

    public boolean isSetMNight() {
        return (this.mNight!= null);
    }

    /**
     * Ruft den Wert der mDay16-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getMDay16() {
        return mDay16;
    }

    /**
     * Legt den Wert der mDay16-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setMDay16(MeasureType value) {
        this.mDay16 = value;
    }

    public boolean isSetMDay16() {
        return (this.mDay16 != null);
    }

    /**
     * Ruft den Wert der pDay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getPDay() {
        return pDay;
    }

    /**
     * Legt den Wert der pDay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setPDay(MeasureType value) {
        this.pDay = value;
    }

    public boolean isSetPDay() {
        return (this.pDay!= null);
    }

    /**
     * Ruft den Wert der pEvening-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getPEvening() {
        return pEvening;
    }

    /**
     * Legt den Wert der pEvening-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setPEvening(MeasureType value) {
        this.pEvening = value;
    }

    public boolean isSetPEvening() {
        return (this.pEvening!= null);
    }

    /**
     * Ruft den Wert der pNight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getPNight() {
        return pNight;
    }

    /**
     * Legt den Wert der pNight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setPNight(MeasureType value) {
        this.pNight = value;
    }

    public boolean isSetPNight() {
        return (this.pNight!= null);
    }

    /**
     * Ruft den Wert der pDay16-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getPDay16() {
        return pDay16;
    }

    /**
     * Legt den Wert der pDay16-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setPDay16(MeasureType value) {
        this.pDay16 = value;
    }

    public boolean isSetPDay16() {
        return (this.pDay16 != null);
    }

    /**
     * Ruft den Wert der dtv-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getDtv() {
        return dtv;
    }

    /**
     * Legt den Wert der dtv-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setDtv(MeasureType value) {
        this.dtv = value;
    }

    public boolean isSetDtv() {
        return (this.dtv!= null);
    }

    /**
     * Ruft den Wert der speedDayPkw-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedDayPkw() {
        return speedDayPkw;
    }

    /**
     * Legt den Wert der speedDayPkw-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedDayPkw(SpeedType value) {
        this.speedDayPkw = value;
    }

    public boolean isSetSpeedDayPkw() {
        return (this.speedDayPkw!= null);
    }

    /**
     * Ruft den Wert der speedEveningPkw-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedEveningPkw() {
        return speedEveningPkw;
    }

    /**
     * Legt den Wert der speedEveningPkw-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedEveningPkw(SpeedType value) {
        this.speedEveningPkw = value;
    }

    public boolean isSetSpeedEveningPkw() {
        return (this.speedEveningPkw!= null);
    }

    /**
     * Ruft den Wert der speedNightPkw-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedNightPkw() {
        return speedNightPkw;
    }

    /**
     * Legt den Wert der speedNightPkw-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedNightPkw(SpeedType value) {
        this.speedNightPkw = value;
    }

    public boolean isSetSpeedNightPkw() {
        return (this.speedNightPkw!= null);
    }

    /**
     * Ruft den Wert der speedDayLkw-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedDayLkw() {
        return speedDayLkw;
    }

    /**
     * Legt den Wert der speedDayLkw-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedDayLkw(SpeedType value) {
        this.speedDayLkw = value;
    }

    public boolean isSetSpeedDayLkw() {
        return (this.speedDayLkw!= null);
    }

    /**
     * Ruft den Wert der speedEveningLkw-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedEveningLkw() {
        return speedEveningLkw;
    }

    /**
     * Legt den Wert der speedEveningLkw-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedEveningLkw(SpeedType value) {
        this.speedEveningLkw = value;
    }

    public boolean isSetSpeedEveningLkw() {
        return (this.speedEveningLkw!= null);
    }

    /**
     * Ruft den Wert der speedNightLkw-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedNightLkw() {
        return speedNightLkw;
    }

    /**
     * Legt den Wert der speedNightLkw-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedNightLkw(SpeedType value) {
        this.speedNightLkw = value;
    }

    public boolean isSetSpeedNightLkw() {
        return (this.speedNightLkw!= null);
    }

    /**
     * Ruft den Wert der roadSurfaceMaterial-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoadSurfaceMaterial() {
        return roadSurfaceMaterial;
    }

    /**
     * Legt den Wert der roadSurfaceMaterial-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoadSurfaceMaterial(String value) {
        this.roadSurfaceMaterial = value;
    }

    public boolean isSetRoadSurfaceMaterial() {
        return (this.roadSurfaceMaterial!= null);
    }

    /**
     * Ruft den Wert der roadSurfaceCorrection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getRoadSurfaceCorrection() {
        return roadSurfaceCorrection;
    }

    /**
     * Legt den Wert der roadSurfaceCorrection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setRoadSurfaceCorrection(MeasureType value) {
        this.roadSurfaceCorrection = value;
    }

    public boolean isSetRoadSurfaceCorrection() {
        return (this.roadSurfaceCorrection!= null);
    }

    /**
     * Ruft den Wert der distanceCarriageway-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getDistanceCarriageway() {
        return distanceCarriageway;
    }

    /**
     * Legt den Wert der distanceCarriageway-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setDistanceCarriageway(LengthType value) {
        this.distanceCarriageway = value;
    }

    public boolean isSetDistanceCarriageway() {
        return (this.distanceCarriageway!= null);
    }

    /**
     * Ruft den Wert der distanceD-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getDistanceD() {
        return distanceD;
    }

    /**
     * Legt den Wert der distanceD-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setDistanceD(LengthType value) {
        this.distanceD = value;
    }

    public boolean isSetDistanceD() {
        return (this.distanceD!= null);
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
     * Ruft den Wert der tunnel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTunnel() {
        return tunnel;
    }

    /**
     * Legt den Wert der tunnel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTunnel(Boolean value) {
        this.tunnel = value;
    }

    public boolean isSetTunnel() {
        return (this.tunnel!= null);
    }

    /**
     * Ruft den Wert der roadGradientPercent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getRoadGradientPercent() {
        return roadGradientPercent;
    }

    /**
     * Legt den Wert der roadGradientPercent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setRoadGradientPercent(MeasureType value) {
        this.roadGradientPercent = value;
    }

    public boolean isSetRoadGradientPercent() {
        return (this.roadGradientPercent!= null);
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
     * Ruft den Wert der lineage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineage() {
        return lineage;
    }

    /**
     * Legt den Wert der lineage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineage(String value) {
        this.lineage = value;
    }

    public boolean isSetLineage() {
        return (this.lineage!= null);
    }

}
