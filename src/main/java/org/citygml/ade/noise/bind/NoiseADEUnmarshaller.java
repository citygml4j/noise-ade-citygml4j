/*
 * noise-ade-citygml4j - Noise ADE module for citygml4j
 * https://github.com/citygml4j/module-noise-ade
 *
 * noise-ade-citygml4j is part of the citygml4j project
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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

import net.opengis.gml.MeasureType;
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
import org.citygml.ade.noise.model.module.NoiseADEModule;
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
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;

import javax.xml.bind.JAXBElement;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NoiseADEUnmarshaller implements ADEUnmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private ADEUnmarshallerHelper helper;
	private CheckedTypeMapper<ADEModelObject> typeMapper;

	private CheckedTypeMapper<ADEModelObject> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<ADEModelObject>create()
							.with(NoiseCityFurnitureSegmentType.class, this::unmarshalNoiseCityFurnitureSegment)
							.with(NoiseCityFurnitureSegmentPropertyType.class, this::unmarshalNoiseCityFurnitureSegmentProperty)
							.with(NoiseRoadSegmentType.class, this::unmarshalNoiseRoadSegment)
							.with(NoiseRoadSegmentPropertyType.class, this::unmarshalNoiseRoadSegmentProperty)
							.with(TrainType.class, this::unmarshalTrain)
							.with(TrainPropertyType.class, this::unmarshalTrainProperty)
							.with(NoiseRailwaySegmentType.class, this::unmarshalNoiseRailwaySegment)
							.with(NoiseRailwaySegmentPropertyType.class, this::unmarshalNoiseRailwaySegmentProperty)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	@Override
	public void setADEUnmarshallerHelper(ADEUnmarshallerHelper helper) {
		this.helper = helper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ADEModelObject unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
		final Object value = src.getValue();

		// generic application properties
		switch (src.getName().getLocalPart()) {
		case "noiseCityFurnitureSegmentProperty":
			return new NoiseCityFurnitureSegmentPropertyElement(unmarshalNoiseCityFurnitureSegmentProperty((NoiseCityFurnitureSegmentPropertyType)value));
		case "noiseRoadSegmentProperty":
			return new NoiseRoadSegmentPropertyElement(unmarshalNoiseRoadSegmentProperty((NoiseRoadSegmentPropertyType)value));
		case "noiseRailwaySegmentProperty":
			return new NoiseRailwaySegmentPropertyElement(unmarshalNoiseRailwaySegmentProperty((NoiseRailwaySegmentPropertyType)value));
		case "buildingReflection":
			return new BuildingReflectionProperty((String)value);
		case "remark":
			return new RemarkProperty((String)value);
		case "buildingReflectionCorrection":
			return new BuildingReflectionCorrectionProperty(helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)value));
		case "buildingLDenMax":
			return new BuildingLDenMaxProperty(helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)value));
		case "buildingLDenMin":
			return new BuildingLDenMinProperty(helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)value));
		case "buildingLDenEq":
			return new BuildingLDenEqProperty(helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)value));
		case "buildingLNightMax":
			return new BuildingLNightMaxProperty(helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)value));
		case "buildingLNightMin":
			return new BuildingLNightMinProperty(helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)value));
		case "buildingLNightEq":
			return new BuildingLNightEqProperty(helper.getGMLUnmarshaller().unmarshalMeasure((MeasureType)value));
		case "buildingHabitants":
			return new BuildingHabitantsProperty((BigInteger)value);
		case "buildingAppartments":
			return new BuildingAppartmentsProperty((BigInteger)value);
		case "buildingImmissionPoints":
			return new BuildingImmissionPointsProperty((List<BigInteger>)value);
		}

		// all other types
		return unmarshal(value);
	}

	@Override
	public ADEModelObject unmarshal(Object src) throws MissingADESchemaException {
		return getTypeMapper().apply(src);
	}

	public NoiseCityFurnitureSegment unmarshalNoiseCityFurnitureSegment(NoiseCityFurnitureSegmentType src) throws MissingADESchemaException {
		NoiseCityFurnitureSegment dest = new NoiseCityFurnitureSegment(NoiseADEModule.v2_0);
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

	public NoiseCityFurnitureSegmentProperty unmarshalNoiseCityFurnitureSegmentProperty(NoiseCityFurnitureSegmentPropertyType src) throws MissingADESchemaException {
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

	public NoiseRoadSegment unmarshalNoiseRoadSegment(NoiseRoadSegmentType src) throws MissingADESchemaException {
		NoiseRoadSegment dest = new NoiseRoadSegment(NoiseADEModule.v2_0);
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

	public NoiseRoadSegmentProperty unmarshalNoiseRoadSegmentProperty(NoiseRoadSegmentPropertyType src) throws MissingADESchemaException {
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

	public Train unmarshalTrain(TrainType src) throws MissingADESchemaException {
		Train dest = new Train(NoiseADEModule.v2_0);
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

	public TrainProperty unmarshalTrainProperty(TrainPropertyType src) throws MissingADESchemaException {
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

	public NoiseRailwaySegment unmarshalNoiseRailwaySegment(NoiseRailwaySegmentType src) throws MissingADESchemaException {
		NoiseRailwaySegment dest = new NoiseRailwaySegment(NoiseADEModule.v2_0);
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
				dest.addUsedBy(unmarshalTrainProperty(trainPropertyType));
		}

		return dest;
	}

	public NoiseRailwaySegmentProperty unmarshalNoiseRailwaySegmentProperty(NoiseRailwaySegmentPropertyType src) throws MissingADESchemaException {
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
