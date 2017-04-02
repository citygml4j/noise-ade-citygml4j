package org.citygml.ade.noise.transform;

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
import org.citygml.ade.noise_de._2.ObjectFactory;
import org.citygml.ade.noise_de._2.TrainPropertyType;
import org.citygml.ade.noise_de._2.TrainType;
import org.citygml4j.builder.jaxb.marshal.citygml.ade.ADEMarshallerHelper;
import org.citygml4j.model.citygml.ade.binding.ADEMarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

import net.opengis.gml.MeasureType;

public class NoiseADEMarshaller implements ADEMarshaller {
	private final ObjectFactory factory = new ObjectFactory();

	@Override
	public JAXBElement<?> marshalJAXBElement(ADEModelObject src, ADEMarshallerHelper helper) {
		JAXBElement<?> dest = null;

		// generic application properties
		if (src instanceof NoiseCityFurnitureSegmentPropertyElement) {
			NoiseCityFurnitureSegmentPropertyType value = marshalNoiseCityFurnitureSegmentProperty(((NoiseCityFurnitureSegmentPropertyElement)src).getValue(), helper);
			dest = factory.createNoiseCityFurnitureSegmentProperty(value);
		} else if (src instanceof NoiseRoadSegmentPropertyElement) {
			NoiseRoadSegmentPropertyType value = marshalNoiseRoadSegmentProperty(((NoiseRoadSegmentPropertyElement)src).getValue(), helper);
			dest = factory.createNoiseRoadSegmentProperty(value);
		} else if (src instanceof NoiseRailwaySegmentPropertyElement) {
			NoiseRailwaySegmentPropertyType value = marshalNoiseRailwaySegmentProperty(((NoiseRailwaySegmentPropertyElement)src).getValue(), helper);
			dest = factory.createNoiseRailwaySegmentProperty(value);
		} else if (src instanceof BuildingReflection) {
			dest = factory.createBuildingReflection(((BuildingReflection)src).getValue());
		} else if (src instanceof BuildingReflectionCorrection) {
			MeasureType value = helper.getGMLMarshaller().marshalMeasure(((BuildingReflectionCorrection)src).getValue());
			dest = factory.createBuildingReflectionCorrection(value);
		} else if (src instanceof BuildingLDenMax) {
			MeasureType value = helper.getGMLMarshaller().marshalMeasure(((BuildingLDenMax)src).getValue());
			dest = factory.createBuildingLDenMax(value);
		} else if (src instanceof BuildingLDenMin) {
			MeasureType value = helper.getGMLMarshaller().marshalMeasure(((BuildingLDenMin)src).getValue());
			dest = factory.createBuildingLDenMin(value);
		} else if (src instanceof BuildingLDenEq) {
			MeasureType value = helper.getGMLMarshaller().marshalMeasure(((BuildingLDenEq)src).getValue());
			dest = factory.createBuildingLDenEq(value);
		} else if (src instanceof BuildingLNightMax) {
			MeasureType value = helper.getGMLMarshaller().marshalMeasure(((BuildingLNightMax)src).getValue());
			dest = factory.createBuildingLNightMax(value);
		} else if (src instanceof BuildingLNightMin) {
			MeasureType value = helper.getGMLMarshaller().marshalMeasure(((BuildingLNightMin)src).getValue());
			dest = factory.createBuildingLNightMin(value);
		} else if (src instanceof BuildingLNightEq) {
			MeasureType value = helper.getGMLMarshaller().marshalMeasure(((BuildingLNightEq)src).getValue());
			dest = factory.createBuildingLNightEq(value);
		} else if (src instanceof BuildingHabitants) {
			dest = factory.createBuildingHabitants(((BuildingHabitants)src).getValue());
		} else if (src instanceof BuildingAppartments) {
			dest = factory.createBuildingAppartments(((BuildingAppartments)src).getValue());
		} else if (src instanceof BuildingImmissionPoints) {
			dest = factory.createBuildingImmissionPoints(((BuildingImmissionPoints)src).getValue());
		} else if (src instanceof Remark) {
			dest = factory.createRemark(((Remark)src).getValue());
		}
		
		// all other types
		else {
			Object type = marshal(src, helper);
			if (type instanceof NoiseCityFurnitureSegmentType)
				dest = factory.createNoiseCityFurnitureSegment((NoiseCityFurnitureSegmentType)type);
			else if (type instanceof NoiseCityFurnitureSegmentPropertyType)
				dest = factory.createNoiseCityFurnitureSegmentProperty((NoiseCityFurnitureSegmentPropertyType)type);
			else if (type instanceof NoiseRoadSegmentType)
				dest = factory.createNoiseRoadSegment((NoiseRoadSegmentType)type);
			else if (type instanceof NoiseRoadSegmentPropertyType)
				dest = factory.createNoiseRoadSegmentProperty((NoiseRoadSegmentPropertyType)type);
			else if (type instanceof NoiseRailwaySegmentType)
				dest = factory.createNoiseRailwaySegment((NoiseRailwaySegmentType)type);
			else if (type instanceof NoiseRailwaySegmentPropertyType)
				dest = factory.createNoiseRailwaySegmentProperty((NoiseRailwaySegmentPropertyType)type);
		}

		return dest;
	}

	@Override
	public Object marshal(ADEModelObject src, ADEMarshallerHelper helper) {
		Object dest = null;

		if (src instanceof NoiseCityFurnitureSegment)
			dest = marshalNoiseCityFurnitureSegment((NoiseCityFurnitureSegment)src, helper);
		else if (src instanceof NoiseCityFurnitureSegmentProperty)
			dest = marshalNoiseCityFurnitureSegmentProperty((NoiseCityFurnitureSegmentProperty)src, helper);
		else if (src instanceof NoiseRoadSegment)
			dest = marshalNoiseRoadSegment((NoiseRoadSegment)src, helper);
		else if (src instanceof NoiseRoadSegmentProperty)
			dest = marshalNoiseRoadSegmentProperty((NoiseRoadSegmentProperty)src, helper);
		else if (src instanceof Train)
			dest = marshalTrain((Train)src, helper);
		else if (src instanceof TrainProperty)
			dest = marshalTrainProperty((TrainProperty)src, helper);
		else if (src instanceof NoiseRailwaySegment)
			dest = marshalNoiseRailwaySegment((NoiseRailwaySegment)src, helper);
		else if (src instanceof NoiseRailwaySegmentProperty)
			dest = marshalNoiseRailwaySegmentProperty((NoiseRailwaySegmentProperty)src, helper);
		
		return dest;
	}

	public NoiseCityFurnitureSegmentType marshalNoiseCityFurnitureSegment(NoiseCityFurnitureSegment src, ADEMarshallerHelper helper) {
		NoiseCityFurnitureSegmentType dest = factory.createNoiseCityFurnitureSegmentType();
		helper.getCore200Marshaller().marshalAbstractCityObject(src, dest);

		if (src.isSetType())
			dest.setType(helper.getGMLMarshaller().marshalCode(src.getType()));

		if (src.isSetReflection())
			dest.setReflection(src.getReflection());

		if (src.isSetReflectionCorrection())
			dest.setReflectionCorrection(helper.getGMLMarshaller().marshalMeasure(src.getReflectionCorrection()));

		if (src.isSetHeight())
			dest.setHeight(helper.getGMLMarshaller().marshalLength(src.getHeight()));

		if (src.isSetDistance())
			dest.setDistance(helper.getGMLMarshaller().marshalLength(src.getDistance()));

		if (src.isSetLod0BaseLine())
			dest.setLod0BaseLine(helper.getGMLMarshaller().marshalCurveProperty(src.getLod0BaseLine()));

		return dest;
	}

	public NoiseCityFurnitureSegmentPropertyType marshalNoiseCityFurnitureSegmentProperty(NoiseCityFurnitureSegmentProperty src, ADEMarshallerHelper helper) {
		NoiseCityFurnitureSegmentPropertyType dest = factory.createNoiseCityFurnitureSegmentPropertyType();

		if (src.isSetNoiseCityFurnitureSegment())
			dest.setNoiseCityFurnitureSegment(marshalNoiseCityFurnitureSegment(src.getNoiseCityFurnitureSegment(), helper));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public NoiseRoadSegmentType marshalNoiseRoadSegment(NoiseRoadSegment src, ADEMarshallerHelper helper) {
		NoiseRoadSegmentType dest = factory.createNoiseRoadSegmentType();
		helper.getTransportation200Marshaller().marshalAbstractTransportationObject(src, dest);
		
		if (src.isSetMDay())
			dest.setMDay(helper.getGMLMarshaller().marshalMeasure(src.getMDay()));
		
		if (src.isSetMEvening())
			dest.setMEvening(helper.getGMLMarshaller().marshalMeasure(src.getMEvening()));
		
		if (src.isSetMNight())
			dest.setMNight(helper.getGMLMarshaller().marshalMeasure(src.getMNight()));
		
		if (src.isSetMDay16())
			dest.setMDay16(helper.getGMLMarshaller().marshalMeasure(src.getMDay16()));
		
		if (src.isSetPDay())
			dest.setPDay(helper.getGMLMarshaller().marshalMeasure(src.getPDay()));
		
		if (src.isSetPEvening())
			dest.setPEvening(helper.getGMLMarshaller().marshalMeasure(src.getPEvening()));
		
		if (src.isSetPNight())
			dest.setPNight(helper.getGMLMarshaller().marshalMeasure(src.getPNight()));
		
		if (src.isSetPDay16())
			dest.setPDay16(helper.getGMLMarshaller().marshalMeasure(src.getPDay16()));
		
		if (src.isSetDtv())
			dest.setDtv(helper.getGMLMarshaller().marshalMeasure(src.getDtv()));
		
		if (src.isSetSpeedDayPkw())
			dest.setSpeedDayPkw(helper.getGMLMarshaller().marshalSpeed(src.getSpeedDayPkw()));
		
		if (src.isSetSpeedEveningPkw())
			dest.setSpeedEveningPkw(helper.getGMLMarshaller().marshalSpeed(src.getSpeedEveningPkw()));
		
		if (src.isSetSpeedNightPkw())
			dest.setSpeedNightPkw(helper.getGMLMarshaller().marshalSpeed(src.getSpeedNightPkw()));
		
		if (src.isSetSpeedDayLkw())
			dest.setSpeedDayLkw(helper.getGMLMarshaller().marshalSpeed(src.getSpeedDayLkw()));
		
		if (src.isSetSpeedEveningLkw())
			dest.setSpeedEveningLkw(helper.getGMLMarshaller().marshalSpeed(src.getSpeedEveningLkw()));
		
		if (src.isSetSpeedNightLkw())
			dest.setSpeedNightLkw(helper.getGMLMarshaller().marshalSpeed(src.getSpeedNightLkw()));
		
		if (src.isSetRoadSurfaceMaterial())
			dest.setRoadSurfaceMaterial(src.getRoadSurfaceMaterial());
		
		if (src.isSetRoadSurfaceCorrection())
			dest.setRoadSurfaceCorrection(helper.getGMLMarshaller().marshalMeasure(src.getRoadSurfaceCorrection()));
		
		if (src.isSetDistanceCarriageway())
			dest.setDistanceCarriageway(helper.getGMLMarshaller().marshalLength(src.getDistanceCarriageway()));
		
		if (src.isSetDistanceD())
			dest.setDistanceD(helper.getGMLMarshaller().marshalLength(src.getDistanceD()));
		
		if (src.isSetBridge())
			dest.setBridge(src.getBridge());
		
		if (src.isSetTunnel())
			dest.setTunnel(src.getTunnel());
		
		if (src.isSetRoadGradientPercent())
			dest.setRoadGradientPercent(helper.getGMLMarshaller().marshalMeasure(src.getRoadGradientPercent()));
		
		if (src.isSetLod0BaseLine())
			dest.setLod0BaseLine(helper.getGMLMarshaller().marshalCurveProperty(src.getLod0BaseLine()));
		
		if (src.isSetLineage())
			dest.setLineage(src.getLineage());
		
		return dest;
	}
	
	public NoiseRoadSegmentPropertyType marshalNoiseRoadSegmentProperty(NoiseRoadSegmentProperty src, ADEMarshallerHelper helper) {
		NoiseRoadSegmentPropertyType dest = factory.createNoiseRoadSegmentPropertyType();

		if (src.isSetNoiseRoadSegment())
			dest.setNoiseRoadSegment(marshalNoiseRoadSegment(src.getNoiseRoadSegment(), helper));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public TrainType marshalTrain(Train src, ADEMarshallerHelper helper) {
		TrainType dest = factory.createTrainType();
		helper.getGMLMarshaller().marshalAbstractFeature(src, dest);
		
		if (src.isSetTrainType())
			dest.setTrainType(src.getTrainType());
		
		if (src.isSetTrainTypeCorrection())
			dest.setTrainTypeCorrection(helper.getGMLMarshaller().marshalMeasure(src.getTrainTypeCorrection()));

		if (src.isSetBrakePortionDay())
			dest.setBrakePortionDay(helper.getGMLMarshaller().marshalMeasure(src.getBrakePortionDay()));

		if (src.isSetBrakePortionEvening())
			dest.setBrakePortionEvening(helper.getGMLMarshaller().marshalMeasure(src.getBrakePortionEvening()));

		if (src.isSetBrakePortionNight())
			dest.setBrakePortionNight(helper.getGMLMarshaller().marshalMeasure(src.getBrakePortionNight()));

		if (src.isSetLengthDay())
			dest.setLengthDay(helper.getGMLMarshaller().marshalLength(src.getLengthDay()));

		if (src.isSetLengthEvening())
			dest.setLengthEvening(helper.getGMLMarshaller().marshalLength(src.getLengthEvening()));

		if (src.isSetLengthNight())
			dest.setLengthNight(helper.getGMLMarshaller().marshalLength(src.getLengthNight()));

		if (src.isSetSpeedDay())
			dest.setSpeedDay(helper.getGMLMarshaller().marshalSpeed(src.getSpeedDay()));

		if (src.isSetSpeedEvening())
			dest.setSpeedEvening(helper.getGMLMarshaller().marshalSpeed(src.getSpeedEvening()));

		if (src.isSetSpeedNight())
			dest.setSpeedNight(helper.getGMLMarshaller().marshalSpeed(src.getSpeedNight()));

		if (src.isSetAdditionalCorrectionTrain())
			dest.setAdditionalCorrectionTrain(helper.getGMLMarshaller().marshalMeasure(src.getAdditionalCorrectionTrain()));
		
		return dest;
	}
	
	public TrainPropertyType marshalTrainProperty(TrainProperty src, ADEMarshallerHelper helper) {
		TrainPropertyType dest = factory.createTrainPropertyType();

		if (src.isSetTrain())
			dest.setTrain(marshalTrain(src.getTrain(), helper));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}
	
	public NoiseRailwaySegmentType marshalNoiseRailwaySegment(NoiseRailwaySegment src, ADEMarshallerHelper helper) {
		NoiseRailwaySegmentType dest = factory.createNoiseRailwaySegmentType();
		helper.getTransportation200Marshaller().marshalAbstractTransportationObject(src, dest);
		
		if (src.isSetRailwaySurfaceMaterial())
			dest.setRailwaySurfaceMaterial(src.getRailwaySurfaceMaterial());
		
		if (src.isSetRailwaySurfaceCorrection())
			dest.setRailwaySurfaceCorrection(helper.getGMLMarshaller().marshalMeasure(src.getRailwaySurfaceCorrection()));

		if (src.isSetBridge())
			dest.setBridge(src.getBridge());
		
		if (src.isSetCrossing())
			dest.setCrossing(src.getCrossing());
		
		if (src.isSetCurveRadius())
			dest.setCurveRadius(helper.getGMLMarshaller().marshalLength(src.getCurveRadius()));

		if (src.isSetAdditionalCorrectionSegment())
			dest.setAdditionalCorrectionSegment(helper.getGMLMarshaller().marshalMeasure(src.getAdditionalCorrectionSegment()));

		if (src.isSetLod0BaseLine())
			dest.setLod0BaseLine(helper.getGMLMarshaller().marshalCurveProperty(src.getLod0BaseLine()));

		if (src.isSetUsedBy()) {
			for (TrainProperty trainProperty : src.getUsedBy())
				dest.getUsedBy().add(marshalTrainProperty(trainProperty, helper));
		}
		
		return dest;
	}
	
	public NoiseRailwaySegmentPropertyType marshalNoiseRailwaySegmentProperty(NoiseRailwaySegmentProperty src, ADEMarshallerHelper helper) {
		NoiseRailwaySegmentPropertyType dest = factory.createNoiseRailwaySegmentPropertyType();

		if (src.isSetNoiseRailwaySegment())
			dest.setNoiseRailwaySegment(marshalNoiseRailwaySegment(src.getNoiseRailwaySegment(), helper));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

}
