
package org.citygml.ade.noise_de._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractFeatureType;
import net.opengis.gml.LengthType;
import net.opengis.gml.MeasureType;
import net.opengis.gml.SpeedType;


/**
 * <p>Java-Klasse für TrainType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TrainType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType">
 *       &lt;sequence>
 *         &lt;element name="trainType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trainTypeCorrection" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="brakePortionDay" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="brakePortionEvening" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="brakePortionNight" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *         &lt;element name="lengthDay" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/>
 *         &lt;element name="lengthEvening" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/>
 *         &lt;element name="lengthNight" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/>
 *         &lt;element name="speedDay" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="speedEvening" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="speedNight" type="{http://www.opengis.net/gml}SpeedType" minOccurs="0"/>
 *         &lt;element name="additionalCorrectionTrain" type="{http://www.opengis.net/gml}MeasureType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrainType", propOrder = {
    "trainType",
    "trainTypeCorrection",
    "brakePortionDay",
    "brakePortionEvening",
    "brakePortionNight",
    "lengthDay",
    "lengthEvening",
    "lengthNight",
    "speedDay",
    "speedEvening",
    "speedNight",
    "additionalCorrectionTrain"
})
public class TrainType
    extends AbstractFeatureType
{

    @XmlElement(required = true)
    protected String trainType;
    protected MeasureType trainTypeCorrection;
    protected MeasureType brakePortionDay;
    protected MeasureType brakePortionEvening;
    protected MeasureType brakePortionNight;
    protected LengthType lengthDay;
    protected LengthType lengthEvening;
    protected LengthType lengthNight;
    protected SpeedType speedDay;
    protected SpeedType speedEvening;
    protected SpeedType speedNight;
    protected MeasureType additionalCorrectionTrain;

    /**
     * Ruft den Wert der trainType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainType() {
        return trainType;
    }

    /**
     * Legt den Wert der trainType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainType(String value) {
        this.trainType = value;
    }

    public boolean isSetTrainType() {
        return (this.trainType!= null);
    }

    /**
     * Ruft den Wert der trainTypeCorrection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getTrainTypeCorrection() {
        return trainTypeCorrection;
    }

    /**
     * Legt den Wert der trainTypeCorrection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setTrainTypeCorrection(MeasureType value) {
        this.trainTypeCorrection = value;
    }

    public boolean isSetTrainTypeCorrection() {
        return (this.trainTypeCorrection!= null);
    }

    /**
     * Ruft den Wert der brakePortionDay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getBrakePortionDay() {
        return brakePortionDay;
    }

    /**
     * Legt den Wert der brakePortionDay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setBrakePortionDay(MeasureType value) {
        this.brakePortionDay = value;
    }

    public boolean isSetBrakePortionDay() {
        return (this.brakePortionDay!= null);
    }

    /**
     * Ruft den Wert der brakePortionEvening-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getBrakePortionEvening() {
        return brakePortionEvening;
    }

    /**
     * Legt den Wert der brakePortionEvening-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setBrakePortionEvening(MeasureType value) {
        this.brakePortionEvening = value;
    }

    public boolean isSetBrakePortionEvening() {
        return (this.brakePortionEvening!= null);
    }

    /**
     * Ruft den Wert der brakePortionNight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getBrakePortionNight() {
        return brakePortionNight;
    }

    /**
     * Legt den Wert der brakePortionNight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setBrakePortionNight(MeasureType value) {
        this.brakePortionNight = value;
    }

    public boolean isSetBrakePortionNight() {
        return (this.brakePortionNight!= null);
    }

    /**
     * Ruft den Wert der lengthDay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getLengthDay() {
        return lengthDay;
    }

    /**
     * Legt den Wert der lengthDay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setLengthDay(LengthType value) {
        this.lengthDay = value;
    }

    public boolean isSetLengthDay() {
        return (this.lengthDay!= null);
    }

    /**
     * Ruft den Wert der lengthEvening-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getLengthEvening() {
        return lengthEvening;
    }

    /**
     * Legt den Wert der lengthEvening-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setLengthEvening(LengthType value) {
        this.lengthEvening = value;
    }

    public boolean isSetLengthEvening() {
        return (this.lengthEvening!= null);
    }

    /**
     * Ruft den Wert der lengthNight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getLengthNight() {
        return lengthNight;
    }

    /**
     * Legt den Wert der lengthNight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setLengthNight(LengthType value) {
        this.lengthNight = value;
    }

    public boolean isSetLengthNight() {
        return (this.lengthNight!= null);
    }

    /**
     * Ruft den Wert der speedDay-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedDay() {
        return speedDay;
    }

    /**
     * Legt den Wert der speedDay-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedDay(SpeedType value) {
        this.speedDay = value;
    }

    public boolean isSetSpeedDay() {
        return (this.speedDay!= null);
    }

    /**
     * Ruft den Wert der speedEvening-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedEvening() {
        return speedEvening;
    }

    /**
     * Legt den Wert der speedEvening-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedEvening(SpeedType value) {
        this.speedEvening = value;
    }

    public boolean isSetSpeedEvening() {
        return (this.speedEvening!= null);
    }

    /**
     * Ruft den Wert der speedNight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpeedType }
     *     
     */
    public SpeedType getSpeedNight() {
        return speedNight;
    }

    /**
     * Legt den Wert der speedNight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedType }
     *     
     */
    public void setSpeedNight(SpeedType value) {
        this.speedNight = value;
    }

    public boolean isSetSpeedNight() {
        return (this.speedNight!= null);
    }

    /**
     * Ruft den Wert der additionalCorrectionTrain-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getAdditionalCorrectionTrain() {
        return additionalCorrectionTrain;
    }

    /**
     * Legt den Wert der additionalCorrectionTrain-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setAdditionalCorrectionTrain(MeasureType value) {
        this.additionalCorrectionTrain = value;
    }

    public boolean isSetAdditionalCorrectionTrain() {
        return (this.additionalCorrectionTrain!= null);
    }

}
