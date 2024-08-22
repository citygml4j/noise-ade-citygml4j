/*
 * noise-ade-citygml4j - Noise ADE module for citygml4j
 * https://github.com/citygml4j/noise-ade-citygml4j
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

import org.citygml.ade.noise.cityjson.model.*;
import org.citygml.ade.noise.model.*;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionUnmarshaller;
import org.citygml4j.builder.cityjson.extension.CityObjectContext;
import org.citygml4j.builder.cityjson.extension.ExtensionPropertyContext;
import org.citygml4j.builder.cityjson.extension.SemanticSurfaceContext;
import org.citygml4j.builder.cityjson.unmarshal.citygml.ade.ADEUnmarshallerHelper;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.cityjson.geometry.GeometryTypeName;
import org.citygml4j.cityjson.geometry.MultiLineStringType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.gml.measures.Speed;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class NoiseExtensionUnmarshaller implements CityJSONExtensionUnmarshaller {
    private final ReentrantLock lock = new ReentrantLock();
    private ADEUnmarshallerHelper helper;
    private BiFunctionTypeMapper<CityObjectContext, AbstractFeature> cityObjectMapper;

    private BiFunctionTypeMapper<CityObjectContext, AbstractFeature> getCityObjectMapper() {
        if (cityObjectMapper == null) {
            lock.lock();
            try {
                if (cityObjectMapper == null) {
                    cityObjectMapper = BiFunctionTypeMapper.<CityObjectContext, AbstractFeature>create()
                            .with(NoiseCityFurnitureSegmentType.class, this::unmarshalNoiseCityFurnitureSegment)
                            .with(NoiseRoadSegmentType.class, this::unmarshalNoiseRoadSegment)
                            .with(NoiseRailwaySegmentType.class, this::unmarshalNoiseRailwaySegment);
                }
            } finally {
                lock.unlock();
            }
        }

        return cityObjectMapper;
    }

    @Override
    public void setADEUnmarshallerHelper(ADEUnmarshallerHelper helper) {
        this.helper = helper;
    }

    @Override
    public AbstractFeature unmarshalCityObject(AbstractCityObjectType src, CityObjectContext context) {
        return getCityObjectMapper().apply(src, context);
    }

    @Override
    public AbstractCityObject unmarshalSemanticSurface(SemanticsType src, SemanticSurfaceContext context) {
        return null;
    }

    @Override
    public boolean assignSemanticSurface(AbstractCityObject semanticSurface, SemanticSurfaceContext context) {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void unmarshalExtensionProperty(String name, ExtensionPropertyContext context) {
        if (context.getParent() instanceof AbstractBuilding) {
            ADEComponent property = null;
            Object value = context.getValue();

            switch (name) {
                case "+noise-buildingReflection":
                    property = new BuildingReflectionProperty((String) value);
                    break;
                case "+noise-buildingReflectionCorrection": {
                    Measure measure = unmarshalMeasure((MeasureType) value);
                    if (measure != null)
                        property = new BuildingReflectionCorrectionProperty(measure);
                    break;
                }
                case "+noise-buildingLDenMax": {
                    Measure measure = unmarshalMeasure((MeasureType) value);
                    if (measure != null)
                        property = new BuildingLDenMaxProperty(measure);
                    break;
                }
                case "+noise-buildingLDenMin": {
                    Measure measure = unmarshalMeasure((MeasureType) value);
                    if (measure != null)
                        property = new BuildingLDenMinProperty(measure);
                    break;
                }
                case "+noise-buildingLDenEq": {
                    Measure measure = unmarshalMeasure((MeasureType) value);
                    if (measure != null)
                        property = new BuildingLDenEqProperty(measure);
                    break;
                }
                case "+noise-buildingLNightMax": {
                    Measure measure = unmarshalMeasure((MeasureType) value);
                    if (measure != null)
                        property = new BuildingLNightMaxProperty(measure);
                    break;
                }
                case "+noise-buildingLNightMin": {
                    Measure measure = unmarshalMeasure((MeasureType) value);
                    if (measure != null)
                        property = new BuildingLNightMinProperty(measure);
                    break;
                }
                case "+noise-buildingLNightEq": {
                    Measure measure = unmarshalMeasure((MeasureType) value);
                    if (measure != null)
                        property = new BuildingLNightEqProperty(measure);
                    break;
                }
                case "+noise-buildingHabitants":
                    property = new BuildingHabitantsProperty(BigInteger.valueOf((Integer) value));
                    break;
                case "+noise-buildingAppartments":
                    property = new BuildingAppartmentsProperty(BigInteger.valueOf((Integer) value));
                    break;
                case "+noise-buildingImmissionPoints":
                    property = new BuildingImmissionPointsProperty((List<BigInteger>) value);
                    break;
                case "+noise-remark":
                    property = new RemarkProperty((String) value);
                    break;
            }

            if (property != null)
                ((AbstractBuilding) context.getParent()).addGenericApplicationPropertyOfAbstractBuilding(property);
        }
    }

    private NoiseCityFurnitureSegment unmarshalNoiseCityFurnitureSegment(NoiseCityFurnitureSegmentType src, CityObjectContext context) {
        NoiseCityFurnitureSegment dest = new NoiseCityFurnitureSegment();
        helper.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, context.getCityJSON());

        NoiseCityFurnitureSegmentAttributes attributes = src.getAttributes();
        if (attributes.isSetType())
            dest.setType(new Code(attributes.getType()));

        if (attributes.isSetReflection())
            dest.setReflection(attributes.getReflection());

        if (attributes.isSetReflectionCorrection())
            dest.setReflectionCorrection(unmarshalMeasure(attributes.getReflectionCorrection()));

        if (attributes.isSetHeight())
            dest.setHeight(unmarshalLength(attributes.getHeight()));

        if (attributes.isSetDistance())
            dest.setDistance(unmarshalLength(attributes.getDistance()));

        for (AbstractGeometryType geometryType : src.getGeometry()) {
            if (geometryType.getType() == GeometryTypeName.MULTI_LINE_STRING) {
                MultiLineStringType multiLineString = (MultiLineStringType) geometryType;
                if (multiLineString.isSetLod() && multiLineString.getLod().intValue() != 0)
                    continue;

                AbstractCurve baseLine = helper.getGMLUnmarshaller().unmarshalCurve((MultiLineStringType) geometryType, context.getCityJSON());
                if (baseLine != null)
                    dest.setLod0BaseLine(new CurveProperty(baseLine));
            }
        }

        if (context.getParent() instanceof CityFurniture) {
            NoiseCityFurnitureSegmentProperty property = new NoiseCityFurnitureSegmentProperty(dest);
            ((CityFurniture) context.getParent()).addGenericApplicationPropertyOfCityFurniture(new NoiseCityFurnitureSegmentPropertyElement(property));
        }

        return dest;
    }

    private NoiseRoadSegment unmarshalNoiseRoadSegment(NoiseRoadSegmentType src, CityObjectContext context) {
        NoiseRoadSegment dest = new NoiseRoadSegment();
        helper.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, context.getCityJSON());

        NoiseRoadSegmentAttributes attributes = src.getAttributes();
        if (attributes.isSetMDay())
            dest.setMDay(unmarshalMeasure(attributes.getMDay()));

        if (attributes.isSetMEvening())
            dest.setMEvening(unmarshalMeasure(attributes.getMEvening()));

        if (attributes.isSetMNight())
            dest.setMNight(unmarshalMeasure(attributes.getMNight()));

        if (attributes.isSetMDay16())
            dest.setMDay16(unmarshalMeasure(attributes.getMDay16()));

        if (attributes.isSetPDay())
            dest.setPDay(unmarshalMeasure(attributes.getPDay()));

        if (attributes.isSetPEvening())
            dest.setPEvening(unmarshalMeasure(attributes.getPEvening()));

        if (attributes.isSetPNight())
            dest.setPNight(unmarshalMeasure(attributes.getPNight()));

        if (attributes.isSetPDay16())
            dest.setPDay16(unmarshalMeasure(attributes.getPDay16()));

        if (attributes.isSetDtv())
            dest.setDtv(unmarshalMeasure(attributes.getDtv()));

        if (attributes.isSetSpeedDayPkw())
            dest.setSpeedDayPkw(unmarshalSpeed(attributes.getSpeedDayPkw()));

        if (attributes.isSetSpeedEveningPkw())
            dest.setSpeedEveningPkw(unmarshalSpeed(attributes.getSpeedEveningPkw()));

        if (attributes.isSetSpeedNightPkw())
            dest.setSpeedNightPkw(unmarshalSpeed(attributes.getSpeedNightPkw()));

        if (attributes.isSetSpeedDayLkw())
            dest.setSpeedDayLkw(unmarshalSpeed(attributes.getSpeedDayLkw()));

        if (attributes.isSetSpeedEveningLkw())
            dest.setSpeedEveningLkw(unmarshalSpeed(attributes.getSpeedEveningLkw()));

        if (attributes.isSetSpeedNightLkw())
            dest.setSpeedNightLkw(unmarshalSpeed(attributes.getSpeedNightLkw()));

        if (attributes.isSetRoadSurfaceMaterial())
            dest.setRoadSurfaceMaterial(attributes.getRoadSurfaceMaterial());

        if (attributes.isSetRoadSurfaceCorrection())
            dest.setRoadSurfaceCorrection(unmarshalMeasure(attributes.getRoadSurfaceCorrection()));

        if (attributes.isSetDistanceCarriageway())
            dest.setDistanceCarriageway(unmarshalLength(attributes.getDistanceCarriageway()));

        if (attributes.isSetDistanceD())
            dest.setDistanceD(unmarshalLength(attributes.getDistanceD()));

        if (attributes.isSetBridge())
            dest.setBridge(attributes.getBridge());

        if (attributes.isSetTunnel())
            dest.setTunnel(attributes.getTunnel());

        if (attributes.isSetRoadGradientPercent())
            dest.setRoadGradientPercent(unmarshalMeasure(attributes.getRoadGradientPercent()));

        if (attributes.isSetLineage())
            dest.setLineage(attributes.getLineage());

        for (AbstractGeometryType geometryType : src.getGeometry()) {
            if (geometryType.getType() == GeometryTypeName.MULTI_LINE_STRING) {
                MultiLineStringType multiLineString = (MultiLineStringType) geometryType;
                if (multiLineString.isSetLod() && multiLineString.getLod().intValue() != 0)
                    continue;

                AbstractCurve baseLine = helper.getGMLUnmarshaller().unmarshalCurve((MultiLineStringType) geometryType, context.getCityJSON());
                if (baseLine != null)
                    dest.setLod0BaseLine(new CurveProperty(baseLine));
            }
        }

        if (context.getParent() instanceof Road) {
            NoiseRoadSegmentProperty property = new NoiseRoadSegmentProperty(dest);
            ((Road) context.getParent()).addGenericApplicationPropertyOfRoad(new NoiseRoadSegmentPropertyElement(property));
        }

        return dest;
    }

    private NoiseRailwaySegment unmarshalNoiseRailwaySegment(NoiseRailwaySegmentType src, CityObjectContext context) {
        NoiseRailwaySegment dest = new NoiseRailwaySegment();
        helper.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, context.getCityJSON());

        NoiseRailwaySegmentAttributes attributes = src.getAttributes();
        if (attributes.isSetRailwaySurfaceMaterial())
            dest.setRailwaySurfaceMaterial(attributes.getRailwaySurfaceMaterial());

        if (attributes.isSetRailwaySurfaceCorrection())
            dest.setRailwaySurfaceCorrection(unmarshalMeasure(attributes.getRailwaySurfaceCorrection()));

        if (attributes.isSetBridge())
            dest.setBridge(attributes.getBridge());

        if (attributes.isSetCrossing())
            dest.setCrossing(attributes.getCrossing());

        if (attributes.isSetCurveRadius())
            dest.setCurveRadius(unmarshalLength(attributes.getCurveRadius()));

        if (attributes.isSetAdditionalCorrectionSegment())
            dest.setAdditionalCorrectionSegment(unmarshalMeasure(attributes.getAdditionalCorrectionSegment()));

        if (src.isSetTrains()) {
            for (Map.Entry<String, TrainType> entry : src.getTrains().entrySet()) {
                Train train = unmarshalTrain(entry.getValue());
                train.setId(entry.getKey());
                dest.addUsedBy(new TrainProperty(train));
            }
        }

        for (AbstractGeometryType geometryType : src.getGeometry()) {
            if (geometryType.getType() == GeometryTypeName.MULTI_LINE_STRING) {
                MultiLineStringType multiLineString = (MultiLineStringType) geometryType;
                if (multiLineString.isSetLod() && multiLineString.getLod().intValue() != 0)
                    continue;

                AbstractCurve baseLine = helper.getGMLUnmarshaller().unmarshalCurve((MultiLineStringType) geometryType, context.getCityJSON());
                if (baseLine != null)
                    dest.setLod0BaseLine(new CurveProperty(baseLine));
            }
        }

        if (context.getParent() instanceof Railway) {
            NoiseRailwaySegmentProperty property = new NoiseRailwaySegmentProperty(dest);
            ((Railway) context.getParent()).addGenericApplicationPropertyOfRailway(new NoiseRailwaySegmentPropertyElement(property));
        }

        return dest;
    }

    private Train unmarshalTrain(TrainType src) {
        Train dest = new Train();

        if (src.isSetTrainType())
            dest.setTrainType(src.getTrainType());

        if (src.isSetTrainTypeCorrection())
            dest.setTrainTypeCorrection(unmarshalMeasure(src.getTrainTypeCorrection()));

        if (src.isSetBrakePortionDay())
            dest.setBrakePortionDay(unmarshalMeasure(src.getBrakePortionDay()));

        if (src.isSetBrakePortionEvening())
            dest.setBrakePortionEvening(unmarshalMeasure(src.getBrakePortionEvening()));

        if (src.isSetBrakePortionNight())
            dest.setBrakePortionNight(unmarshalMeasure(src.getBrakePortionNight()));

        if (src.isSetLengthDay())
            dest.setLengthDay(unmarshalLength(src.getLengthDay()));

        if (src.isSetLengthEvening())
            dest.setLengthEvening(unmarshalLength(src.getLengthEvening()));

        if (src.isSetLengthNight())
            dest.setLengthNight(unmarshalLength(src.getLengthNight()));

        if (src.isSetSpeedDay())
            dest.setSpeedDay(unmarshalSpeed(src.getSpeedDay()));

        if (src.isSetSpeedEvening())
            dest.setSpeedEvening(unmarshalSpeed(src.getSpeedEvening()));

        if (src.isSetSpeedNight())
            dest.setSpeedNight(unmarshalSpeed(src.getSpeedNight()));

        if (src.isSetAdditionalCorrectionTrain())
            dest.setAdditionalCorrectionTrain(unmarshalMeasure(src.getAdditionalCorrectionTrain()));

        return dest;
    }

    private void unmarshalMeasure(MeasureType src, Measure dest) {
        dest.setValue(src.getValue());
        dest.setUom(src.getUom());
    }

    private Measure unmarshalMeasure(MeasureType src) {
        Measure dest = null;

        if (src.isSetValue()) {
            dest = new Measure();
            unmarshalMeasure(src, dest);
        }

        return dest;
    }

    private Length unmarshalLength(MeasureType src) {
        Length dest = null;

        if (src.isSetValue()) {
            dest = new Length();
            unmarshalMeasure(src, dest);
        }

        return dest;
    }

    private Speed unmarshalSpeed(MeasureType src) {
        Speed dest = null;

        if (src.isSetValue()) {
            dest = new Speed();
            unmarshalMeasure(src, dest);
        }

        return dest;
    }
}
