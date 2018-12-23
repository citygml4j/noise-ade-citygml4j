/*
 * noise-ade-citygml4j - Noise ADE module for citygml4j
 * https://github.com/citygml4j/module-noise-ade
 *
 * noise-ade-citygml4j is part of the citygml4j project
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml.ade.noise.bind;

import org.citygml.ade.noise.model.BuildingAppartmentsProperty;
import org.citygml.ade.noise.model.BuildingHabitantsProperty;
import org.citygml.ade.noise.model.BuildingImmissionPointsProperty;
import org.citygml.ade.noise.model.BuildingLDenEqProperty;
import org.citygml.ade.noise.model.BuildingLDenMaxProperty;
import org.citygml.ade.noise.model.BuildingLDenMinProperty;
import org.citygml.ade.noise.model.BuildingLNightEqProperty;
import org.citygml.ade.noise.model.BuildingLNightMaxProperty;
import org.citygml.ade.noise.model.BuildingLNightMinProperty;
import org.citygml.ade.noise.model.BuildingReflectionCorrectionProperty;
import org.citygml.ade.noise.model.BuildingReflectionProperty;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegment;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentProperty;
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRailwaySegmentProperty;
import org.citygml.ade.noise.model.NoiseRailwaySegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRoadSegment;
import org.citygml.ade.noise.model.NoiseRoadSegmentProperty;
import org.citygml.ade.noise.model.NoiseRoadSegmentPropertyElement;
import org.citygml.ade.noise.model.RemarkProperty;
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
import org.citygml4j.util.mapper.TypeMapper;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;

import javax.xml.bind.JAXBElement;
import java.util.concurrent.locks.ReentrantLock;

public class NoiseADEMarshaller implements ADEMarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final ObjectFactory factory = new ObjectFactory();
	private ADEMarshallerHelper helper;
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;
	
	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(NoiseCityFurnitureSegmentPropertyElement.class, this::createNoiseCityFurnitureSegmentPropertyElement)
							.with(NoiseRoadSegmentPropertyElement.class, this::createNoiseRoadSegmentPropertyElement)
							.with(NoiseRailwaySegmentPropertyElement.class, this::createNoiseRailwaySegmentPropertyElement)
							.with(BuildingReflectionProperty.class, this::createBuildingReflectionProperty)
							.with(BuildingReflectionCorrectionProperty.class, this::createBuildingReflectionCorrectionProperty)
							.with(BuildingLDenMaxProperty.class, this::createBuildingLDenMaxProperty)
							.with(BuildingLDenMinProperty.class, this::createBuildingLDenMinProperty)
							.with(BuildingLDenEqProperty.class, this::createBuildingLDenEqProperty)
							.with(BuildingLNightMaxProperty.class, this::createBuildingLNightMaxProperty)
							.with(BuildingLNightMinProperty.class, this::createBuildingLNightMinProperty)
							.with(BuildingLNightEqProperty.class, this::createBuildingLNightEqProperty)
							.with(BuildingHabitantsProperty.class, this::createBuildingHabitantsProperty)
							.with(BuildingAppartmentsProperty.class, this::createBuildingAppartmentsProperty)
							.with(BuildingImmissionPointsProperty.class, this::createBuildingImmissionPointsProperty)
							.with(RemarkProperty.class, this::createRemarkProperty)
							.with(NoiseCityFurnitureSegment.class, this::createNoiseCityFurnitureSegment)
							.with(NoiseCityFurnitureSegmentProperty.class, this::createNoiseCityFurnitureSegmentProperty)
							.with(NoiseRoadSegment.class, this::createNoiseRoadSegment)
							.with(NoiseRoadSegmentProperty.class, this::createNoiseRoadSegmentProperty)
							.with(NoiseRailwaySegment.class, this::createNoiseRailwaySegment)
							.with(NoiseRailwaySegmentProperty.class, this::createNoiseRailwaySegmentProperty);
				}
			} finally {
				lock.unlock();
			}
		}

		return elementMapper;
	}
	
	private TypeMapper<Object> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = TypeMapper.create()
							.with(NoiseCityFurnitureSegment.class, this::marshalNoiseCityFurnitureSegment)
							.with(NoiseCityFurnitureSegmentProperty.class, this::marshalNoiseCityFurnitureSegmentProperty)
							.with(NoiseRoadSegment.class, this::marshalNoiseRoadSegment)
							.with(NoiseRoadSegmentProperty.class, this::marshalNoiseRoadSegmentProperty)
							.with(Train.class, this::marshalTrain)
							.with(TrainProperty.class, this::marshalTrainProperty)
							.with(NoiseRailwaySegment.class, this::marshalNoiseRailwaySegment)
							.with(NoiseRailwaySegmentProperty.class, this::marshalNoiseRailwaySegmentProperty);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}
	
	@Override
	public void setADEMarshallerHelper(ADEMarshallerHelper helper) {
		this.helper = helper;
	}

	@Override
	public JAXBElement<?> marshalJAXBElement(ADEModelObject src) {
		return getElementMapper().apply(src);
	}

	@Override
	public Object marshal(ADEModelObject src) {
		return getTypeMapper().apply(src);
	}

	public NoiseCityFurnitureSegmentType marshalNoiseCityFurnitureSegment(NoiseCityFurnitureSegment src) {
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

	public NoiseCityFurnitureSegmentPropertyType marshalNoiseCityFurnitureSegmentProperty(NoiseCityFurnitureSegmentProperty src) {
		NoiseCityFurnitureSegmentPropertyType dest = factory.createNoiseCityFurnitureSegmentPropertyType();

		if (src.isSetNoiseCityFurnitureSegment())
			dest.setNoiseCityFurnitureSegment(marshalNoiseCityFurnitureSegment(src.getNoiseCityFurnitureSegment()));

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
	
	public NoiseRoadSegmentType marshalNoiseRoadSegment(NoiseRoadSegment src) {
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
	
	public NoiseRoadSegmentPropertyType marshalNoiseRoadSegmentProperty(NoiseRoadSegmentProperty src) {
		NoiseRoadSegmentPropertyType dest = factory.createNoiseRoadSegmentPropertyType();

		if (src.isSetNoiseRoadSegment())
			dest.setNoiseRoadSegment(marshalNoiseRoadSegment(src.getNoiseRoadSegment()));

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
	
	public TrainType marshalTrain(Train src) {
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
	
	public TrainPropertyType marshalTrainProperty(TrainProperty src) {
		TrainPropertyType dest = factory.createTrainPropertyType();

		if (src.isSetTrain())
			dest.setTrain(marshalTrain(src.getTrain()));

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
	
	public NoiseRailwaySegmentType marshalNoiseRailwaySegment(NoiseRailwaySegment src) {
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
				dest.getUsedBy().add(marshalTrainProperty(trainProperty));
		}
		
		return dest;
	}
	
	public NoiseRailwaySegmentPropertyType marshalNoiseRailwaySegmentProperty(NoiseRailwaySegmentProperty src) {
		NoiseRailwaySegmentPropertyType dest = factory.createNoiseRailwaySegmentPropertyType();

		if (src.isSetNoiseRailwaySegment())
			dest.setNoiseRailwaySegment(marshalNoiseRailwaySegment(src.getNoiseRailwaySegment()));

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
	
	private JAXBElement<?> createNoiseCityFurnitureSegmentPropertyElement(NoiseCityFurnitureSegmentPropertyElement src) {
		return factory.createNoiseCityFurnitureSegmentProperty(marshalNoiseCityFurnitureSegmentProperty(src.getValue()));
	}
	
	private JAXBElement<?> createNoiseRoadSegmentPropertyElement(NoiseRoadSegmentPropertyElement src) {
		return factory.createNoiseRoadSegmentProperty(marshalNoiseRoadSegmentProperty(src.getValue()));
	}
	
	private JAXBElement<?> createNoiseRailwaySegmentPropertyElement(NoiseRailwaySegmentPropertyElement src) {
		return factory.createNoiseRailwaySegmentProperty(marshalNoiseRailwaySegmentProperty(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingReflectionProperty(BuildingReflectionProperty src) {
		return factory.createBuildingReflection(src.getValue());
	}
	
	private JAXBElement<?> createBuildingReflectionCorrectionProperty(BuildingReflectionCorrectionProperty src) {
		return factory.createBuildingReflectionCorrection(helper.getGMLMarshaller().marshalMeasure(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingLDenMaxProperty(BuildingLDenMaxProperty src) {
		return factory.createBuildingLDenMax(helper.getGMLMarshaller().marshalMeasure(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingLDenMinProperty(BuildingLDenMinProperty src) {
		return factory.createBuildingLDenMin(helper.getGMLMarshaller().marshalMeasure(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingLDenEqProperty(BuildingLDenEqProperty src) {
		return factory.createBuildingLDenEq(helper.getGMLMarshaller().marshalMeasure(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingLNightMaxProperty(BuildingLNightMaxProperty src) {
		return factory.createBuildingLNightMax(helper.getGMLMarshaller().marshalMeasure(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingLNightMinProperty(BuildingLNightMinProperty src) {
		return factory.createBuildingLNightMin(helper.getGMLMarshaller().marshalMeasure(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingLNightEqProperty(BuildingLNightEqProperty src) {
		return factory.createBuildingLNightEq(helper.getGMLMarshaller().marshalMeasure(src.getValue()));
	}
	
	private JAXBElement<?> createBuildingHabitantsProperty(BuildingHabitantsProperty src) {
		return factory.createBuildingHabitants(src.getValue());
	}
	
	private JAXBElement<?> createBuildingAppartmentsProperty(BuildingAppartmentsProperty src) {
		return factory.createBuildingAppartments(src.getValue());
	}
	
	private JAXBElement<?> createBuildingImmissionPointsProperty(BuildingImmissionPointsProperty src) {
		return factory.createBuildingImmissionPoints(src.getValue());
	}
	
	private JAXBElement<?> createRemarkProperty(RemarkProperty src) {
		return factory.createRemark(src.getValue());
	}
	
	private JAXBElement<?> createNoiseCityFurnitureSegment(NoiseCityFurnitureSegment src) {
		return factory.createNoiseCityFurnitureSegment(marshalNoiseCityFurnitureSegment(src));
	}
	
	private JAXBElement<?> createNoiseCityFurnitureSegmentProperty(NoiseCityFurnitureSegmentProperty src) {
		return factory.createNoiseCityFurnitureSegmentProperty(marshalNoiseCityFurnitureSegmentProperty(src));
	}
	
	private JAXBElement<?> createNoiseRoadSegment(NoiseRoadSegment src) {
		return factory.createNoiseRoadSegment(marshalNoiseRoadSegment(src));
	}
	
	private JAXBElement<?> createNoiseRoadSegmentProperty(NoiseRoadSegmentProperty src) {
		return factory.createNoiseRoadSegmentProperty(marshalNoiseRoadSegmentProperty(src));
	}
	
	private JAXBElement<?> createNoiseRailwaySegment(NoiseRailwaySegment src) {
		return factory.createNoiseRailwaySegment(marshalNoiseRailwaySegment(src));
	}
	
	private JAXBElement<?> createNoiseRailwaySegmentProperty(NoiseRailwaySegmentProperty src) {
		return factory.createNoiseRailwaySegmentProperty(marshalNoiseRailwaySegmentProperty(src));
	}

}
