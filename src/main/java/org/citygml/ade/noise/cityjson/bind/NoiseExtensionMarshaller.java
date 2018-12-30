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

package org.citygml.ade.noise.cityjson.bind;

import org.citygml.ade.noise.cityjson.model.MeasureType;
import org.citygml.ade.noise.cityjson.model.NoiseCityFurnitureSegmentAttributes;
import org.citygml.ade.noise.cityjson.model.NoiseCityFurnitureSegmentType;
import org.citygml.ade.noise.cityjson.model.NoiseRailwaySegmentAttributes;
import org.citygml.ade.noise.cityjson.model.NoiseRailwaySegmentType;
import org.citygml.ade.noise.cityjson.model.NoiseRoadSegmentAttributes;
import org.citygml.ade.noise.cityjson.model.NoiseRoadSegmentType;
import org.citygml.ade.noise.cityjson.model.TrainType;
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
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRoadSegment;
import org.citygml.ade.noise.model.RemarkProperty;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.model.TrainProperty;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.extension.CityJSONExtensionMarshaller;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ADEMarshallerHelper;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ExtensionAttribute;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.concurrent.locks.ReentrantLock;

public class NoiseExtensionMarshaller implements CityJSONExtensionMarshaller {
    private final ReentrantLock lock = new ReentrantLock();
    private ADEMarshallerHelper helper;
    private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> cityObjectMapper;

    private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> getCityObjectMapper() {
        if (cityObjectMapper == null) {
            lock.lock();
            try {
                if (cityObjectMapper == null) {
                    cityObjectMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObjectType>create()
                            .with(NoiseCityFurnitureSegment.class, this::marshalNoiseCityFurnitureSegment)
                            .with(NoiseRoadSegment.class, this::marshalNoiseRoadSegment)
                            .with(NoiseRailwaySegment.class, this::marshalNoiseRailwaySegment);
                }
            } finally {
                lock.unlock();
            }
        }

        return cityObjectMapper;
    }

    @Override
    public void setADEMarshallerHelper(ADEMarshallerHelper helper) {
        this.helper = helper;
    }

    @Override
    public AbstractCityObjectType marshalCityObject(ADEModelObject src, CityJSON cityJSON) {
        return getCityObjectMapper().apply(src, cityJSON);
    }

    @Override
    public SemanticsType marshalSemanticSurface(ADEModelObject src) {
        return null;
    }

    @Override
    public ExtensionAttribute marshalExtensionAttribute(ADEModelObject src) {
        String name = null;
        Object value = null;

        if (src instanceof BuildingReflectionProperty) {
            name = "+noise-buildingReflection";
            value = ((BuildingReflectionProperty) src).getValue();
        } else if (src instanceof BuildingReflectionCorrectionProperty) {
            name = "+noise-buildingReflectionCorrection";
            value = marshalMeasure(((BuildingReflectionCorrectionProperty) src).getValue());
        } else if (src instanceof BuildingLDenMaxProperty) {
            name = "+noise-buildingLDenMax";
            value = marshalMeasure(((BuildingLDenMaxProperty) src).getValue());
        } else if (src instanceof BuildingLDenMinProperty) {
            name = "+noise-buildingLDenMin";
            value = marshalMeasure(((BuildingLDenMinProperty) src).getValue());
        } else if (src instanceof BuildingLDenEqProperty) {
            name = "+noise-buildingLDenEq";
            value = marshalMeasure(((BuildingLDenEqProperty) src).getValue());
        } else if (src instanceof BuildingLNightMaxProperty) {
            name = "+noise-buildingLNightMax";
            value = marshalMeasure(((BuildingLNightMaxProperty) src).getValue());
        } else if (src instanceof BuildingLNightMinProperty) {
            name = "+noise-buildingLNightMin";
            value = marshalMeasure(((BuildingLNightMinProperty) src).getValue());
        } else if (src instanceof BuildingLNightEqProperty) {
            name = "+noise-buildingLNightEq";
            value = marshalMeasure(((BuildingLNightEqProperty) src).getValue());
        } else if (src instanceof BuildingHabitantsProperty) {
            name = "+noise-buildingHabitants";
            value = ((BuildingHabitantsProperty) src).getValue();
        } else if (src instanceof BuildingAppartmentsProperty) {
            name = "+noise-buildingAppartments";
            value = ((BuildingAppartmentsProperty) src).getValue();
        } else if (src instanceof BuildingImmissionPointsProperty) {
            name = "+noise-buildingImmissionPoints";
            value = ((BuildingImmissionPointsProperty) src).getValue();
        } else if (src instanceof RemarkProperty) {
            name = "+noise-remark";
            value = ((RemarkProperty) src).getValue();
        }

        return name != null && value != null ? new ExtensionAttribute(name, value) : null;
    }

    private NoiseCityFurnitureSegmentType marshalNoiseCityFurnitureSegment(NoiseCityFurnitureSegment src, CityJSON cityJSON) {
        NoiseCityFurnitureSegmentType dest = new NoiseCityFurnitureSegmentType();
        helper.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

        NoiseCityFurnitureSegmentAttributes attributes = dest.getAttributes();
        if (src.isSetType() && src.getType().isSetValue())
            attributes.setType(src.getType().getValue());

        if (src.isSetReflection())
            attributes.setReflection(src.getReflection());

        if (src.isSetReflectionCorrection())
            attributes.setReflectionCorrection(marshalMeasure(src.getReflectionCorrection()));

        if (src.isSetHeight())
            attributes.setHeight(marshalMeasure(src.getHeight()));

        if (src.isSetDistance())
            attributes.setDistance(marshalMeasure(src.getDistance()));

        if (src.isSetLod0BaseLine()) {
            AbstractGeometryObjectType geometry = helper.getGMLMarshaller().marshalGeometryProperty(src.getLod0BaseLine());
            if (geometry != null) {
                geometry.setLod(0);
                dest.addGeometry(geometry);
            }
        }

        return dest;
    }

    private NoiseRoadSegmentType marshalNoiseRoadSegment(NoiseRoadSegment src, CityJSON cityJSON) {
        NoiseRoadSegmentType dest = new NoiseRoadSegmentType();
        helper.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

        NoiseRoadSegmentAttributes attributes = dest.getAttributes();
        if (src.isSetMDay())
            attributes.setMDay(marshalMeasure(src.getMDay()));

        if (src.isSetMEvening())
            attributes.setMEvening(marshalMeasure(src.getMEvening()));

        if (src.isSetMNight())
            attributes.setMNight(marshalMeasure(src.getMNight()));

        if (src.isSetMDay16())
            attributes.setMDay16(marshalMeasure(src.getMDay16()));

        if (src.isSetPDay())
            attributes.setPDay(marshalMeasure(src.getPDay()));

        if (src.isSetPEvening())
            attributes.setPEvening(marshalMeasure(src.getPEvening()));

        if (src.isSetPNight())
            attributes.setPNight(marshalMeasure(src.getPNight()));

        if (src.isSetPDay16())
            attributes.setPDay16(marshalMeasure(src.getPDay16()));

        if (src.isSetDtv())
            attributes.setDtv(marshalMeasure(src.getDtv()));

        if (src.isSetSpeedDayPkw())
            attributes.setSpeedDayPkw(marshalMeasure(src.getSpeedDayPkw()));

        if (src.isSetSpeedEveningPkw())
            attributes.setSpeedEveningPkw(marshalMeasure(src.getSpeedEveningPkw()));

        if (src.isSetSpeedNightPkw())
            attributes.setSpeedNightPkw(marshalMeasure(src.getSpeedNightPkw()));

        if (src.isSetSpeedDayLkw())
            attributes.setSpeedDayLkw(marshalMeasure(src.getSpeedDayLkw()));

        if (src.isSetSpeedEveningLkw())
            attributes.setSpeedEveningLkw(marshalMeasure(src.getSpeedEveningLkw()));

        if (src.isSetSpeedNightLkw())
            attributes.setSpeedNightLkw(marshalMeasure(src.getSpeedNightLkw()));

        if (src.isSetRoadSurfaceMaterial())
            attributes.setRoadSurfaceMaterial(src.getRoadSurfaceMaterial());

        if (src.isSetRoadSurfaceCorrection())
            attributes.setRoadSurfaceCorrection(marshalMeasure(src.getRoadSurfaceCorrection()));

        if (src.isSetDistanceCarriageway())
            attributes.setDistanceCarriageway(marshalMeasure(src.getDistanceCarriageway()));

        if (src.isSetDistanceD())
            attributes.setDistanceD(marshalMeasure(src.getDistanceD()));

        if (src.isSetBridge())
            attributes.setBridge(src.getBridge());

        if (src.isSetTunnel())
            attributes.setTunnel(src.getTunnel());

        if (src.isSetRoadGradientPercent())
            attributes.setRoadGradientPercent(marshalMeasure(src.getRoadGradientPercent()));

        if (src.isSetLineage())
            attributes.setLineage(src.getLineage());

        if (src.isSetLod0BaseLine()) {
            AbstractGeometryObjectType geometry = helper.getGMLMarshaller().marshalGeometryProperty(src.getLod0BaseLine());
            if (geometry != null) {
                geometry.setLod(0);
                dest.addGeometry(geometry);
            }
        }

        return dest;
    }

    private NoiseRailwaySegmentType marshalNoiseRailwaySegment(NoiseRailwaySegment src, CityJSON cityJSON) {
        NoiseRailwaySegmentType dest = new NoiseRailwaySegmentType();
        helper.getCoreMarshaller().marshalAbstractCityObject(src, dest, cityJSON);

        NoiseRailwaySegmentAttributes attributes = dest.getAttributes();
        if (src.isSetRailwaySurfaceMaterial())
            attributes.setRailwaySurfaceMaterial(src.getRailwaySurfaceMaterial());

        if (src.isSetRailwaySurfaceCorrection())
            attributes.setRailwaySurfaceCorrection(marshalMeasure(src.getRailwaySurfaceCorrection()));

        if (src.isSetBridge())
            attributes.setBridge(src.getBridge());

        if (src.isSetCrossing())
            attributes.setCrossing(src.getCrossing());

        if (src.isSetCurveRadius())
            attributes.setCurveRadius(marshalMeasure(src.getCurveRadius()));

        if (src.isSetAdditionalCorrectionSegment())
            attributes.setAdditionalCorrectionSegment(marshalMeasure(src.getAdditionalCorrectionSegment()));

        if (src.isSetUsedBy()) {
            for (TrainProperty property : src.getUsedBy()) {
                if (property.isSetTrain())
                    dest.addTrain(marshalTrain(property.getTrain()));
            }
        }

        if (src.isSetLod0BaseLine()) {
            AbstractGeometryObjectType geometry = helper.getGMLMarshaller().marshalGeometryProperty(src.getLod0BaseLine());
            if (geometry != null) {
                geometry.setLod(0);
                dest.addGeometry(geometry);
            }
        }

        return dest;
    }

    private TrainType marshalTrain(Train src) {
        TrainType dest = new TrainType();
        dest.setGmlId(src.isSetId() && !src.getId().isEmpty() ? src.getId() : DefaultGMLIdManager.getInstance().generateUUID());

        if (src.isSetTrainType())
            dest.setTrainType(src.getTrainType());

        if (src.isSetTrainTypeCorrection())
            dest.setTrainTypeCorrection(marshalMeasure(src.getTrainTypeCorrection()));

        if (src.isSetBrakePortionDay())
            dest.setBrakePortionDay(marshalMeasure(src.getBrakePortionDay()));

        if (src.isSetBrakePortionEvening())
            dest.setBrakePortionEvening(marshalMeasure(src.getBrakePortionEvening()));

        if (src.isSetBrakePortionNight())
            dest.setBrakePortionNight(marshalMeasure(src.getBrakePortionNight()));

        if (src.isSetLengthDay())
            dest.setLengthDay(marshalMeasure(src.getLengthDay()));

        if (src.isSetLengthEvening())
            dest.setLengthEvening(marshalMeasure(src.getLengthEvening()));

        if (src.isSetLengthNight())
            dest.setLengthNight(marshalMeasure(src.getLengthNight()));

        if (src.isSetSpeedDay())
            dest.setSpeedDay(marshalMeasure(src.getSpeedDay()));

        if (src.isSetSpeedEvening())
            dest.setSpeedEvening(marshalMeasure(src.getSpeedEvening()));

        if (src.isSetSpeedNight())
            dest.setSpeedNight(marshalMeasure(src.getSpeedNight()));

        if (src.isSetAdditionalCorrectionTrain())
            dest.setAdditionalCorrectionTrain(marshalMeasure(src.getAdditionalCorrectionTrain()));

        return dest;
    }

    private MeasureType marshalMeasure(Measure src) {
        MeasureType dest = null;

        if (src.isSetValue()) {
            dest = new MeasureType();
            dest.setValue(src.getValue());
            dest.setUom(src.getUom());
        }

        return dest;
    }
}
