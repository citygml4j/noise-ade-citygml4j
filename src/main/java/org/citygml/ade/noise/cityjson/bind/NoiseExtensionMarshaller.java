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
import org.citygml.ade.noise.model.NoiseCityFurnitureSegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRailwaySegment;
import org.citygml.ade.noise.model.NoiseRailwaySegmentPropertyElement;
import org.citygml.ade.noise.model.NoiseRoadSegment;
import org.citygml.ade.noise.model.NoiseRoadSegmentPropertyElement;
import org.citygml.ade.noise.model.RemarkProperty;
import org.citygml.ade.noise.model.Train;
import org.citygml.ade.noise.model.TrainProperty;
import org.citygml4j.builder.cityjson.extension.ADEPropertyContext;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionMarshaller;
import org.citygml4j.builder.cityjson.extension.ExtensionAttribute;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ADEMarshallerHelper;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.concurrent.locks.ReentrantLock;

public class NoiseExtensionMarshaller implements CityJSONExtensionMarshaller {
    private final ReentrantLock lock = new ReentrantLock();
    private ADEMarshallerHelper helper;
    private BiFunctionTypeMapper<CityJSON, AbstractCityObjectType> cityObjectMapper;
    private BiFunctionTypeMapper<ADEPropertyContext, Extension> propertyMapper;

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

    private BiFunctionTypeMapper<ADEPropertyContext, Extension> getPropertyMapper() {
        if (propertyMapper == null) {
            lock.lock();
            try {
                if (propertyMapper == null) {
                    propertyMapper = BiFunctionTypeMapper.<ADEPropertyContext, Extension>create()
                            .with(NoiseCityFurnitureSegmentPropertyElement.class, this::marshalNoiseCityFurnitureSegmentPropertyElement)
                            .with(NoiseRailwaySegmentPropertyElement.class, this::marshalNoiseRailwaySegmentPropertyElement)
                            .with(NoiseRoadSegmentPropertyElement.class, this::marshalNoiseRoadSegmentPropertyElement)
                            .with(BuildingReflectionProperty.class, this::marshalBuildingReflectionProperty)
                            .with(BuildingReflectionCorrectionProperty.class, this::marshalBuildingReflectionCorrectionProperty)
                            .with(BuildingLDenMaxProperty.class, this::marshalBuildingLDenMaxProperty)
                            .with(BuildingLDenMinProperty.class, this::marshalBuildingLDenMinProperty)
                            .with(BuildingLDenEqProperty.class, this::marshalBuildingLDenEqProperty)
                            .with(BuildingLNightMaxProperty.class, this::marshalBuildingLNightMaxProperty)
                            .with(BuildingLNightMinProperty.class, this::marshalBuildingLNightMinProperty)
                            .with(BuildingLNightEqProperty.class, this::marshalBuildingLNightEqProperty)
                            .with(BuildingHabitantsProperty.class, this::marshalBuildingHabitantsProperty)
                            .with(BuildingAppartmentsProperty.class, this::marshalBuildingAppartmentsProperty)
                            .with(BuildingImmissionPointsProperty.class, this::marshalBuildingImmissionPointsProperty)
                            .with(RemarkProperty.class, this::marshalRemarkProperty);
                }
            } finally {
                lock.unlock();
            }
        }

        return propertyMapper;
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
    public Extension marshalGenericApplicationProperty(ADEModelObject src, ADEPropertyContext context) {
        return getPropertyMapper().apply(src, context);
    }

    private Extension marshalNoiseCityFurnitureSegmentPropertyElement(NoiseCityFurnitureSegmentPropertyElement src, ADEPropertyContext context) {
        return helper.getGMLMarshaller().marshalFeatureProperty(src.getValue(), context.getCityJSON());
    }

    private Extension marshalNoiseRailwaySegmentPropertyElement(NoiseRailwaySegmentPropertyElement src, ADEPropertyContext context) {
        return helper.getGMLMarshaller().marshalFeatureProperty(src.getValue(), context.getCityJSON());
    }

    private Extension marshalNoiseRoadSegmentPropertyElement(NoiseRoadSegmentPropertyElement src, ADEPropertyContext context) {
        return helper.getGMLMarshaller().marshalFeatureProperty(src.getValue(), context.getCityJSON());
    }

    private Extension marshalBuildingReflectionProperty(BuildingReflectionProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingReflection", src.getValue());
    }

    private Extension marshalBuildingReflectionCorrectionProperty(BuildingReflectionCorrectionProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingReflectionCorrection", marshalMeasure(src.getValue()));
    }

    private Extension marshalBuildingLDenMaxProperty(BuildingLDenMaxProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingLDenMax", marshalMeasure(src.getValue()));
    }

    private Extension marshalBuildingLDenMinProperty(BuildingLDenMinProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingLDenMin", marshalMeasure(src.getValue()));
    }

    private Extension marshalBuildingLDenEqProperty(BuildingLDenEqProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingLDenEq", marshalMeasure(src.getValue()));
    }

    private Extension marshalBuildingLNightMaxProperty(BuildingLNightMaxProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingLNightMax", marshalMeasure(src.getValue()));
    }

    private Extension marshalBuildingLNightMinProperty(BuildingLNightMinProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingLNightMin", marshalMeasure(src.getValue()));
    }

    private Extension marshalBuildingLNightEqProperty(BuildingLNightEqProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingLNightEq", marshalMeasure(src.getValue()));
    }

    private Extension marshalBuildingHabitantsProperty(BuildingHabitantsProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingHabitants", src.getValue());
    }

    private Extension marshalBuildingAppartmentsProperty(BuildingAppartmentsProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingAppartments", src.getValue());
    }

    private Extension marshalBuildingImmissionPointsProperty(BuildingImmissionPointsProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-buildingImmissionPoints", src.getValue());
    }

    private Extension marshalRemarkProperty(RemarkProperty src, ADEPropertyContext context) {
        return new ExtensionAttribute("+noise-remark", src.getValue());
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
