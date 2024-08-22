/*
 * noise-ade-citygml4j - Noise ADE module for citygml4j
 * https://github.com/citygml4j/noise-ade-citygml4j
 *
 * noise-ade-citygml4j is part of the citygml4j project
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml.ade.noise.model;

import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.ObjectCopier;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.gml.measures.Speed;
import org.citygml4j.util.bbox.BoundingBoxOptions;

public class NoiseRoadSegment extends AbstractTransportationObject implements ADEModelObject {
    private Measure mDay;
    private Measure mEvening;
    private Measure mNight;
    private Measure mDay16;
    private Measure pDay;
    private Measure pEvening;
    private Measure pNight;
    private Measure pDay16;
    private Measure dtv;
    private Speed speedDayPkw;
    private Speed speedEveningPkw;
    private Speed speedNightPkw;
    private Speed speedDayLkw;
    private Speed speedEveningLkw;
    private Speed speedNightLkw;
    private String roadSurfaceMaterial;
    private Measure roadSurfaceCorrection;
    private Length distanceCarriageway;
    private Length distanceD;
    private Boolean bridge;
    private Boolean tunnel;
    private Measure roadGradientPercent;
    private CurveProperty lod0BaseLine;
    private String lineage;

    public NoiseRoadSegment() {

    }

    public NoiseRoadSegment(NoiseADEModule module) {
        super(module);
    }

    public Measure getMDay() {
        return mDay;
    }

    public boolean isSetMDay() {
        return mDay != null;
    }

    public void setMDay(Measure mDay) {
        if (mDay != null)
            mDay.setParent(this);

        this.mDay = mDay;
    }

    public Measure getMEvening() {
        return mEvening;
    }

    public boolean isSetMEvening() {
        return mEvening != null;
    }

    public void setMEvening(Measure mEvening) {
        if (mEvening != null)
            mEvening.setParent(this);

        this.mEvening = mEvening;
    }

    public Measure getMNight() {
        return mNight;
    }

    public boolean isSetMNight() {
        return mNight != null;
    }

    public void setMNight(Measure mNight) {
        if (mNight != null)
            mNight.setParent(this);

        this.mNight = mNight;
    }

    public Measure getMDay16() {
        return mDay16;
    }

    public boolean isSetMDay16() {
        return mDay16 != null;
    }

    public void setMDay16(Measure mDay16) {
        if (mDay16 != null)
            mDay16.setParent(this);

        this.mDay16 = mDay16;
    }

    public Measure getPDay() {
        return pDay;
    }

    public boolean isSetPDay() {
        return pDay != null;
    }

    public void setPDay(Measure pDay) {
        if (pDay != null)
            pDay.setParent(this);

        this.pDay = pDay;
    }

    public Measure getPEvening() {
        return pEvening;
    }

    public boolean isSetPEvening() {
        return pEvening != null;
    }

    public void setPEvening(Measure pEvening) {
        if (pEvening != null)
            pEvening.setParent(this);

        this.pEvening = pEvening;
    }

    public Measure getPNight() {
        return pNight;
    }

    public boolean isSetPNight() {
        return pNight != null;
    }

    public void setPNight(Measure pNight) {
        if (pNight != null)
            pNight.setParent(this);

        this.pNight = pNight;
    }

    public Measure getPDay16() {
        return pDay16;
    }

    public boolean isSetPDay16() {
        return pDay16 != null;
    }

    public void setPDay16(Measure pDay16) {
        if (pDay16 != null)
            pDay16.setParent(this);

        this.pDay16 = pDay16;
    }

    public Measure getDtv() {
        return dtv;
    }

    public boolean isSetDtv() {
        return dtv != null;
    }

    public void setDtv(Measure dtv) {
        if (dtv != null)
            dtv.setParent(this);

        this.dtv = dtv;
    }

    public Speed getSpeedDayPkw() {
        return speedDayPkw;
    }

    public boolean isSetSpeedDayPkw() {
        return speedDayPkw != null;
    }

    public void setSpeedDayPkw(Speed speedDayPkw) {
        if (speedDayPkw != null)
            speedDayPkw.setParent(this);

        this.speedDayPkw = speedDayPkw;
    }

    public Speed getSpeedEveningPkw() {
        return speedEveningPkw;
    }

    public boolean isSetSpeedEveningPkw() {
        return speedEveningPkw != null;
    }

    public void setSpeedEveningPkw(Speed speedEveningPkw) {
        if (speedEveningPkw != null)
            speedEveningPkw.setParent(this);

        this.speedEveningPkw = speedEveningPkw;
    }

    public Speed getSpeedNightPkw() {
        return speedNightPkw;
    }

    public boolean isSetSpeedNightPkw() {
        return speedNightPkw != null;
    }

    public void setSpeedNightPkw(Speed speedNightPkw) {
        if (speedNightPkw != null)
            speedNightPkw.setParent(this);

        this.speedNightPkw = speedNightPkw;
    }

    public Speed getSpeedDayLkw() {
        return speedDayLkw;
    }

    public boolean isSetSpeedDayLkw() {
        return speedDayLkw != null;
    }

    public void setSpeedDayLkw(Speed speedDayLkw) {
        if (speedDayLkw != null)
            speedDayLkw.setParent(this);

        this.speedDayLkw = speedDayLkw;
    }

    public Speed getSpeedEveningLkw() {
        return speedEveningLkw;
    }

    public boolean isSetSpeedEveningLkw() {
        return speedEveningLkw != null;
    }

    public void setSpeedEveningLkw(Speed speedEveningLkw) {
        if (speedEveningLkw != null)
            speedEveningLkw.setParent(this);

        this.speedEveningLkw = speedEveningLkw;
    }

    public Speed getSpeedNightLkw() {
        return speedNightLkw;
    }

    public boolean isSetSpeedNightLkw() {
        return speedNightLkw != null;
    }

    public void setSpeedNightLkw(Speed speedNightLkw) {
        if (speedNightLkw != null)
            speedNightLkw.setParent(this);

        this.speedNightLkw = speedNightLkw;
    }

    public String getRoadSurfaceMaterial() {
        return roadSurfaceMaterial;
    }

    public boolean isSetRoadSurfaceMaterial() {
        return roadSurfaceMaterial != null;
    }

    public void setRoadSurfaceMaterial(String roadSurfaceMaterial) {
        this.roadSurfaceMaterial = roadSurfaceMaterial;
    }

    public Measure getRoadSurfaceCorrection() {
        return roadSurfaceCorrection;
    }

    public boolean isSetRoadSurfaceCorrection() {
        return roadSurfaceCorrection != null;
    }

    public void setRoadSurfaceCorrection(Measure roadSurfaceCorrection) {
        if (roadSurfaceCorrection != null)
            roadSurfaceCorrection.setParent(this);

        this.roadSurfaceCorrection = roadSurfaceCorrection;
    }

    public Length getDistanceCarriageway() {
        return distanceCarriageway;
    }

    public boolean isSetDistanceCarriageway() {
        return distanceCarriageway != null;
    }

    public void setDistanceCarriageway(Length distanceCarriageway) {
        if (distanceCarriageway != null)
            distanceCarriageway.setParent(this);

        this.distanceCarriageway = distanceCarriageway;
    }

    public Length getDistanceD() {
        return distanceD;
    }

    public boolean isSetDistanceD() {
        return distanceD != null;
    }

    public void setDistanceD(Length distanceD) {
        if (distanceD != null)
            distanceD.setParent(this);

        this.distanceD = distanceD;
    }

    public Boolean getBridge() {
        return bridge;
    }

    public boolean isSetBridge() {
        return bridge != null;
    }

    public void setBridge(Boolean bridge) {
        this.bridge = bridge;
    }

    public Boolean getTunnel() {
        return tunnel;
    }

    public boolean isSetTunnel() {
        return tunnel != null;
    }

    public void setTunnel(Boolean tunnel) {
        this.tunnel = tunnel;
    }

    public Measure getRoadGradientPercent() {
        return roadGradientPercent;
    }

    public boolean isSetRoadGradientPercent() {
        return roadGradientPercent != null;
    }

    public void setRoadGradientPercent(Measure roadGradientPercent) {
        if (roadGradientPercent != null)
            roadGradientPercent.setParent(this);

        this.roadGradientPercent = roadGradientPercent;
    }

    public CurveProperty getLod0BaseLine() {
        return lod0BaseLine;
    }

    public boolean isSetLod0BaseLine() {
        return lod0BaseLine != null;
    }

    public void setLod0BaseLine(CurveProperty lod0BaseLine) {
        if (lod0BaseLine != null)
            lod0BaseLine.setParent(this);

        this.lod0BaseLine = lod0BaseLine;
    }

    public String getLineage() {
        return lineage;
    }

    public boolean isSetLineage() {
        return lineage != null;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    @Override
    public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
        BoundingShape boundedBy = super.calcBoundedBy(options);
        if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
            return boundedBy;

        if (lod0BaseLine != null && lod0BaseLine.isSetCurve())
            boundedBy.updateEnvelope(lod0BaseLine.getCurve().calcBoundingBox());

        if (options.isAssignResultToFeatures())
            setBoundedBy(boundedBy);

        return boundedBy;
    }

    @Override
    public LodRepresentation getLodRepresentation() {
        LodRepresentation lodRepresentation = new LodRepresentation();

        if (lod0BaseLine != null)
            lodRepresentation.addRepresentation(0, lod0BaseLine);

        return lodRepresentation;
    }

    @Override
    public Object copy(CopyBuilder copyBuilder) {
        return copyTo(new NoiseRoadSegment(), copyBuilder);
    }

    @Override
    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        NoiseRoadSegment copy = (target == null) ? new NoiseRoadSegment() : (NoiseRoadSegment) target;
        super.copyTo(copy, copyBuilder);

        return ObjectCopier.copyTo(this, copy, copyBuilder);
    }

    @Override
    public void accept(FeatureVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T accept(FeatureFunctor<T> visitor) {
        return visitor.apply(this);
    }

    @Override
    public void accept(GMLVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T accept(GMLFunctor<T> visitor) {
        return visitor.apply(this);
    }

}
