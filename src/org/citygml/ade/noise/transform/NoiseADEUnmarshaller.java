package org.citygml.ade.noise.transform;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml.ade.noise.model.BuildingAppartments;
import org.citygml.ade.noise.model.BuildingHabitants;
import org.citygml.ade.noise.model.BuildingImmissionPoints;
import org.citygml.ade.noise.model.BuildingLDenEq;
import org.citygml.ade.noise.model.BuildingLDenMax;
import org.citygml.ade.noise.model.BuildingLDenMin;
import org.citygml.ade.noise.model.BuildingLNightEq;
import org.citygml.ade.noise.model.BuildingLNightMax;
import org.citygml.ade.noise.model.BuildingLNightMin;
import org.citygml.ade.noise.model.BuildingReflection;
import org.citygml.ade.noise.model.BuildingReflectionCorrection;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegment;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentProperty;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRailwaySegmentProperty;
import org.citygml.ade.noise.model.NoiseRailwaySegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRoadSegment;
import org.citygml.ade.noise.model.NoiseRoadSegmentProperty;
import org.citygml.ade.noise.model.NoiseRoadSegmentPropertyElement;
import org.citygml.ade.noise.model.Remark;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.model.TrainProperty;
import org.citygml.ade.noise_de._2.NoiseCityFurnitureSegmentPropertyType;
import org.citygml.ade.noise_de._2.NoiseCityFurnitureSegmentType;
import org.citygml.ade.noise_de._2.NoiseRailwaySegmentPropertyType;
import org.citygml.ade.noise_de._2.NoiseRailwaySegmentType;
import org.citygml.ade.noise_de._2.NoiseRoadSegmentPropertyType;
import org.citygml.ade.noise_de._2.NoiseRoadSegmentType;
import org.citygml.ade.noise_de._2.TrainPropertyType;
import org.citygml.ade.noise_de._2.TrainType;
import org.citygml4j.builder.jaxb.unmarshal.citygml.ade.ADEUnmarshallerHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.binding.ADEUnmarshaller;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import net.opengis.gml.MeasureType;

public class NoiseADEUnmarshaller implements ADEUnmarshaller {

	@SuppressWarnings("unchecked")
	@Override
	public ADEModelObject unmarshal(JAXBElement<?> src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		ADEModelObject dest = null;

		// generic application properties
		if (src.getValue() instanceof NoiseCityFurnitureSegmentPropertyType 
				&& src.getName().getLocalPart().equals("noiseCityFurnitureSegmentProperty")) {
			NoiseCityFurnitureSegmentProperty value = unmarshalNoiseCityFurnitureSegmentProperty((NoiseCityFurnitureSegmentPropertyType)src.getValue(), helper);
			dest = new NoiseCityFurnitureSegmentPropertyElement(value);
		} else if (src.getValue() instanceof NoiseRoadSegmentPropertyType
				&& src.getName().getLocalPart().equals("noiseRoadSegmentProperty")) {
			NoiseRoadSegmentProperty value = unmarshalNoiseRoadSegmentProperty((NoiseRoadSegmentPropertyType)src.getValue(), helper);
			dest = new NoiseRoadSegmentPropertyElement(value);
		} else if (src.getValue() instanceof NoiseRailwaySegmentPropertyType
				&& src.getName().getLocalPart().equals("noiseRailwaySegmentProperty")) {
			NoiseRailwaySegmentProperty value = unmarshalNoiseRailwaySegmentProperty((NoiseRailwaySegmentPropertyType)src.getValue(), helper);
			dest = new NoiseRailwaySegmentPropertyElement(value);
		} else if (src.getValue() instanceof String) {
			String name = src.getName().getLocalPart();
			if (name.equals("buildingReflection"))
				dest = new BuildingReflection((String)src.getValue());
			else if (name.equals("remark"))
				dest = new Remark((String)src.getValue());
		} else if (src.getValue() instanceof MeasureType) {
			String name = src.getName().getLocalPart();
			Measure value = helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)src.getValue());
			if (name.equals("buildingReflectionCorrection"))
				dest = new BuildingReflectionCorrection(value);
			else if (name.equals("buildingLDenMax"))
				dest = new BuildingLDenMax(value);
			else if (name.equals("buildingLDenMin"))
				dest = new BuildingLDenMin(value);
			else if (name.equals("buildingLDenEq"))
				dest = new BuildingLDenEq(value);
			else if (name.equals("buildingLNightMax"))
				dest = new BuildingLNightMax(value);
			else if (name.equals("buildingLNightMin"))
				dest = new BuildingLNightMin(value);
			else if (name.equals("buildingLNightEq"))
				dest = new BuildingLNightEq(value);
		} else if (src.getValue() instanceof BigInteger) {
			String name = src.getName().getLocalPart();
			if (name.equals("buildingHabitants"))
				dest = new BuildingHabitants((BigInteger)src.getValue());
			else if (name.equals("buildingAppartments"))
				dest = new BuildingAppartments((BigInteger)src.getValue());
		} else if (src.getValue() instanceof List<?> && src.getName().getLocalPart().equals("buildingImmissionPoints")) {
			dest = new BuildingImmissionPoints((List<BigInteger>)src.getValue()); 
		}
		
		// all other types
		else
			dest = unmarshal(src.getValue(), helper);
		
		return dest;
	}

	@Override
	public ADEModelObject unmarshal(Object src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src, helper);

		ADEModelObject dest = null;

		if (src instanceof NoiseCityFurnitureSegmentType)
			dest = unmarshalNoiseCityFurnitureSegment((NoiseCityFurnitureSegmentType)src, helper);
		else if (src instanceof NoiseCityFurnitureSegmentPropertyType)
			dest = unmarshalNoiseCityFurnitureSegmentProperty((NoiseCityFurnitureSegmentPropertyType)src, helper);
		else if (src instanceof NoiseRoadSegmentType)
			dest = unmarshalNoiseRoadSegment((NoiseRoadSegmentType)src, helper);
		else if (src instanceof NoiseRoadSegmentPropertyType)
			dest = unmarshalNoiseRoadSegmentProperty((NoiseRoadSegmentPropertyType)src, helper);
		else if (src instanceof TrainType)
			dest = unmarshalTrain((TrainType)src, helper);
		else if (src instanceof TrainPropertyType)
			dest = unmarshalTrainProperty((TrainPropertyType)src, helper);
		else if (src instanceof NoiseRailwaySegmentType)
			dest = unmarshalNoiseRailwaySegment((NoiseRailwaySegmentType)src, helper);
		else if (src instanceof NoiseRailwaySegmentPropertyType)
			dest = unmarshalNoiseRailwaySegmentProperty((NoiseRailwaySegmentPropertyType)src, helper);
		
		return dest;
	}

	public NoiseCityFurnitureSegment unmarshalNoiseCityFurnitureSegment(NoiseCityFurnitureSegmentType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		NoiseCityFurnitureSegment dest = new NoiseCityFurnitureSegment();
		helper.getCore200Unmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetType())
			dest.setType(helper.getGMLUnmarshaller().unmarshalCode(src.getType()));

		if (src.isSetReflection())
			dest.setReflection(src.getReflection());

		if (src.isSetReflectionCorrection())
			dest.setReflectionCorrection(helper.getGMLUnmarshaller().unmarshalMeasure(src.getReflectionCorrection()));

		if (src.isSetHeight())
			dest.setHeight(helper.getGMLUnmarshaller().unmarshalLength(src.getHeight()));

		if (src.isSetDistance())
			dest.setDistance(helper.getGMLUnmarshaller().unmarshalLength(src.getDistance()));

		if (src.isSetLod0BaseLine())
			dest.setLod0BaseLine(helper.getGMLUnmarshaller().unmarshalCurveProperty(src.getLod0BaseLine()));

		return dest;
	}

	public NoiseCityFurnitureSegmentProperty unmarshalNoiseCityFurnitureSegmentProperty(NoiseCityFurnitureSegmentPropertyType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		NoiseCityFurnitureSegmentProperty dest = new NoiseCityFurnitureSegmentProperty();

		if (src.isSetNoiseCityFurnitureSegment()) {
			ModelObject object = helper.getJAXBUnmarshaller().unmarshal(src.getNoiseCityFurnitureSegment());
			if (object instanceof NoiseCityFurnitureSegment)
				dest.setNoiseCityFurnitureSegment((NoiseCityFurnitureSegment)object);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}
	
	public NoiseRoadSegment unmarshalNoiseRoadSegment(NoiseRoadSegmentType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		NoiseRoadSegment dest = new NoiseRoadSegment();
		helper.getTransportation200Unmarshaller().unmarshalAbstractTransportationObject(src, dest);
		
		if (src.isSetMDay())
			dest.setMDay(helper.getGMLUnmarshaller().unmarshalMeasure(src.getMDay()));
		
		if (src.isSetMEvening())
			dest.setMEvening(helper.getGMLUnmarshaller().unmarshalMeasure(src.getMEvening()));
		
		if (src.isSetMNight())
			dest.setMNight(helper.getGMLUnmarshaller().unmarshalMeasure(src.getMNight()));
		
		if (src.isSetMDay16())
			dest.setMDay16(helper.getGMLUnmarshaller().unmarshalMeasure(src.getMDay16()));
		
		if (src.isSetPDay())
			dest.setPDay(helper.getGMLUnmarshaller().unmarshalMeasure(src.getPDay()));
		
		if (src.isSetPEvening())
			dest.setPEvening(helper.getGMLUnmarshaller().unmarshalMeasure(src.getPEvening()));
		
		if (src.isSetPNight())
			dest.setPNight(helper.getGMLUnmarshaller().unmarshalMeasure(src.getPNight()));
		
		if (src.isSetPDay16())
			dest.setPDay16(helper.getGMLUnmarshaller().unmarshalMeasure(src.getPDay16()));
		
		if (src.isSetDtv())
			dest.setDtv(helper.getGMLUnmarshaller().unmarshalMeasure(src.getDtv()));
		
		if (src.isSetSpeedDayPkw())
			dest.setSpeedDayPkw(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedDayPkw()));
		
		if (src.isSetSpeedEveningPkw())
			dest.setSpeedEveningPkw(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedEveningPkw()));
		
		if (src.isSetSpeedNightPkw())
			dest.setSpeedNightPkw(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedNightPkw()));
		
		if (src.isSetSpeedDayLkw())
			dest.setSpeedDayLkw(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedDayLkw()));
		
		if (src.isSetSpeedEveningLkw())
			dest.setSpeedEveningLkw(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedEveningLkw()));
		
		if (src.isSetSpeedNightLkw())
			dest.setSpeedNightLkw(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedNightLkw()));
		
		if (src.isSetRoadSurfaceMaterial())
			dest.setRoadSurfaceMaterial(src.getRoadSurfaceMaterial());
		
		if (src.isSetRoadSurfaceCorrection())
			dest.setRoadSurfaceCorrection(helper.getGMLUnmarshaller().unmarshalMeasure(src.getRoadSurfaceCorrection()));
		
		if (src.isSetDistanceCarriageway())
			dest.setDistanceCarriageway(helper.getGMLUnmarshaller().unmarshalLength(src.getDistanceCarriageway()));
		
		if (src.isSetDistanceD())
			dest.setDistanceD(helper.getGMLUnmarshaller().unmarshalLength(src.getDistanceD()));
		
		if (src.isSetBridge())
			dest.setBridge(src.isBridge());
		
		if (src.isSetTunnel())
			dest.setTunnel(src.isTunnel());
		
		if (src.isSetRoadGradientPercent())
			dest.setRoadGradientPercent(helper.getGMLUnmarshaller().unmarshalMeasure(src.getRoadGradientPercent()));
		
		if (src.isSetLod0BaseLine())
			dest.setLod0BaseLine(helper.getGMLUnmarshaller().unmarshalCurveProperty(src.getLod0BaseLine()));
		
		if (src.isSetLineage())
			dest.setLineage(src.getLineage());
		
		return dest;
	}
	
	public NoiseRoadSegmentProperty unmarshalNoiseRoadSegmentProperty(NoiseRoadSegmentPropertyType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		NoiseRoadSegmentProperty dest = new NoiseRoadSegmentProperty();

		if (src.isSetNoiseRoadSegment()) {
			ModelObject object = helper.getJAXBUnmarshaller().unmarshal(src.getNoiseRoadSegment());
			if (object instanceof NoiseRoadSegment)
				dest.setNoiseRoadSegment((NoiseRoadSegment)object);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}
	
	public Train unmarshalTrain(TrainType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		Train dest = new Train();
		helper.getGMLUnmarshaller().unmarshalAbstractFeature(src, dest);
		
		if (src.isSetTrainType())
			dest.setTrainType(src.getTrainType());
		
		if (src.isSetTrainTypeCorrection())
			dest.setTrainTypeCorrection(helper.getGMLUnmarshaller().unmarshalMeasure(src.getTrainTypeCorrection()));

		if (src.isSetBrakePortionDay())
			dest.setBrakePortionDay(helper.getGMLUnmarshaller().unmarshalMeasure(src.getBrakePortionDay()));

		if (src.isSetBrakePortionEvening())
			dest.setBrakePortionEvening(helper.getGMLUnmarshaller().unmarshalMeasure(src.getBrakePortionEvening()));

		if (src.isSetBrakePortionNight())
			dest.setBrakePortionNight(helper.getGMLUnmarshaller().unmarshalMeasure(src.getBrakePortionNight()));

		if (src.isSetLengthDay())
			dest.setLengthDay(helper.getGMLUnmarshaller().unmarshalLength(src.getLengthDay()));

		if (src.isSetLengthEvening())
			dest.setLengthEvening(helper.getGMLUnmarshaller().unmarshalLength(src.getLengthEvening()));

		if (src.isSetLengthNight())
			dest.setLengthNight(helper.getGMLUnmarshaller().unmarshalLength(src.getLengthNight()));

		if (src.isSetSpeedDay())
			dest.setSpeedDay(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedDay()));

		if (src.isSetSpeedEvening())
			dest.setSpeedEvening(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedEvening()));

		if (src.isSetSpeedNight())
			dest.setSpeedNight(helper.getGMLUnmarshaller().unmarshalSpeed(src.getSpeedNight()));

		if (src.isSetAdditionalCorrectionTrain())
			dest.setAdditionalCorrectionTrain(helper.getGMLUnmarshaller().unmarshalMeasure(src.getAdditionalCorrectionTrain()));

		return dest;
	}
	
	public TrainProperty unmarshalTrainProperty(TrainPropertyType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		TrainProperty dest = new TrainProperty();

		if (src.isSetTrain()) {
			ModelObject object = helper.getJAXBUnmarshaller().unmarshal(src.getTrain());
			if (object instanceof Train)
				dest.setTrain((Train)object);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}
	
	public NoiseRailwaySegment unmarshalNoiseRailwaySegment(NoiseRailwaySegmentType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		NoiseRailwaySegment dest = new NoiseRailwaySegment();
		helper.getTransportation200Unmarshaller().unmarshalAbstractTransportationObject(src, dest);
		
		if (src.isSetRailwaySurfaceMaterial())
			dest.setRailwaySurfaceMaterial(src.getRailwaySurfaceMaterial());
		
		if (src.isSetRailwaySurfaceCorrection())
			dest.setRailwaySurfaceCorrection(helper.getGMLUnmarshaller().unmarshalMeasure(src.getRailwaySurfaceCorrection()));

		if (src.isSetBridge())
			dest.setBridge(src.isBridge());
		
		if (src.isSetCrossing())
			dest.setCrossing(src.isCrossing());
		
		if (src.isSetCurveRadius())
			dest.setCurveRadius(helper.getGMLUnmarshaller().unmarshalLength(src.getCurveRadius()));

		if (src.isSetAdditionalCorrectionSegment())
			dest.setAdditionalCorrectionSegment(helper.getGMLUnmarshaller().unmarshalMeasure(src.getAdditionalCorrectionSegment()));

		if (src.isSetLod0BaseLine())
			dest.setLod0BaseLine(helper.getGMLUnmarshaller().unmarshalCurveProperty(src.getLod0BaseLine()));

		if (src.isSetUsedBy()) {
			for (TrainPropertyType trainPropertyType : src.getUsedBy())
				dest.addUsedBy(unmarshalTrainProperty(trainPropertyType, helper));
		}
		
		return dest;
	}
	
	public NoiseRailwaySegmentProperty unmarshalNoiseRailwaySegmentProperty(NoiseRailwaySegmentPropertyType src, ADEUnmarshallerHelper helper) throws MissingADESchemaException {
		NoiseRailwaySegmentProperty dest = new NoiseRailwaySegmentProperty();

		if (src.isSetNoiseRailwaySegment()) {
			ModelObject object = helper.getJAXBUnmarshaller().unmarshal(src.getNoiseRailwaySegment());
			if (object instanceof NoiseRailwaySegment)
				dest.setNoiseRailwaySegment((NoiseRailwaySegment)object);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

}
