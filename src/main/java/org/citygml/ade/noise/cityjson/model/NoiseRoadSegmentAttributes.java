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

package org.citygml.ade.noise.cityjson.model;

import org.citygml4j.cityjson.feature.Attributes;

public class NoiseRoadSegmentAttributes extends Attributes {
    private MeasureType mDay;
    private MeasureType mEvening;
    private MeasureType mNight;
    private MeasureType mDay16;
    private MeasureType pDay;
    private MeasureType pEvening;
    private MeasureType pNight;
    private MeasureType pDay16;
    private MeasureType dtv;
    private MeasureType speedDayPkw;
    private MeasureType speedEveningPkw;
    private MeasureType speedNightPkw;
    private MeasureType speedDayLkw;
    private MeasureType speedEveningLkw;
    private MeasureType speedNightLkw;
    private String roadSurfaceMaterial;
    private MeasureType roadSurfaceCorrection;
    private MeasureType distanceCarriageway;
    private MeasureType distanceD;
    private Boolean bridge;
    private Boolean tunnel;
    private MeasureType roadGradientPercent;
    private String lineage;

    public boolean isSetMDay() {
        return mDay != null;
    }

    public MeasureType getMDay() {
        return mDay;
    }

    public void setMDay(MeasureType mDay) {
        this.mDay = mDay;
    }

    public boolean isSetMEvening() {
        return mEvening != null;
    }

    public MeasureType getMEvening() {
        return mEvening;
    }

    public void setMEvening(MeasureType mEvening) {
        this.mEvening = mEvening;
    }

    public boolean isSetMNight() {
        return mNight != null;
    }

    public MeasureType getMNight() {
        return mNight;
    }

    public void setMNight(MeasureType mNight) {
        this.mNight = mNight;
    }

    public boolean isSetMDay16() {
        return mDay16 != null;
    }

    public MeasureType getMDay16() {
        return mDay16;
    }

    public void setMDay16(MeasureType mDay16) {
        this.mDay16 = mDay16;
    }

    public boolean isSetPDay() {
        return pDay != null;
    }

    public MeasureType getPDay() {
        return pDay;
    }

    public void setPDay(MeasureType pDay) {
        this.pDay = pDay;
    }

    public boolean isSetPEvening() {
        return pEvening != null;
    }

    public MeasureType getPEvening() {
        return pEvening;
    }

    public void setPEvening(MeasureType pEvening) {
        this.pEvening = pEvening;
    }

    public boolean isSetPNight() {
        return pNight != null;
    }

    public MeasureType getPNight() {
        return pNight;
    }

    public void setPNight(MeasureType pNight) {
        this.pNight = pNight;
    }

    public boolean isSetPDay16() {
        return pDay16 != null;
    }

    public MeasureType getPDay16() {
        return pDay16;
    }

    public void setPDay16(MeasureType pDay16) {
        this.pDay16 = pDay16;
    }

    public boolean isSetDtv() {
        return dtv != null;
    }

    public MeasureType getDtv() {
        return dtv;
    }

    public void setDtv(MeasureType dtv) {
        this.dtv = dtv;
    }

    public boolean isSetSpeedDayPkw() {
        return speedDayPkw != null;
    }

    public MeasureType getSpeedDayPkw() {
        return speedDayPkw;
    }

    public void setSpeedDayPkw(MeasureType speedDayPkw) {
        this.speedDayPkw = speedDayPkw;
    }

    public boolean isSetSpeedEveningPkw() {
        return speedEveningPkw != null;
    }

    public MeasureType getSpeedEveningPkw() {
        return speedEveningPkw;
    }

    public void setSpeedEveningPkw(MeasureType speedEveningPkw) {
        this.speedEveningPkw = speedEveningPkw;
    }

    public boolean isSetSpeedNightPkw() {
        return speedNightPkw != null;
    }

    public MeasureType getSpeedNightPkw() {
        return speedNightPkw;
    }

    public void setSpeedNightPkw(MeasureType speedNightPkw) {
        this.speedNightPkw = speedNightPkw;
    }

    public boolean isSetSpeedDayLkw() {
        return speedDayLkw != null;
    }

    public MeasureType getSpeedDayLkw() {
        return speedDayLkw;
    }

    public void setSpeedDayLkw(MeasureType speedDayLkw) {
        this.speedDayLkw = speedDayLkw;
    }

    public boolean isSetSpeedEveningLkw() {
        return speedEveningLkw != null;
    }

    public MeasureType getSpeedEveningLkw() {
        return speedEveningLkw;
    }

    public void setSpeedEveningLkw(MeasureType speedEveningLkw) {
        this.speedEveningLkw = speedEveningLkw;
    }

    public boolean isSetSpeedNightLkw() {
        return speedNightLkw != null;
    }

    public MeasureType getSpeedNightLkw() {
        return speedNightLkw;
    }

    public void setSpeedNightLkw(MeasureType speedNightLkw) {
        this.speedNightLkw = speedNightLkw;
    }

    public boolean isSetRoadSurfaceMaterial() {
        return roadSurfaceMaterial != null;
    }

    public String getRoadSurfaceMaterial() {
        return roadSurfaceMaterial;
    }

    public void setRoadSurfaceMaterial(String roadSurfaceMaterial) {
        this.roadSurfaceMaterial = roadSurfaceMaterial;
    }

    public boolean isSetRoadSurfaceCorrection() {
        return roadSurfaceCorrection != null;
    }

    public MeasureType getRoadSurfaceCorrection() {
        return roadSurfaceCorrection;
    }

    public void setRoadSurfaceCorrection(MeasureType roadSurfaceCorrection) {
        this.roadSurfaceCorrection = roadSurfaceCorrection;
    }

    public boolean isSetDistanceCarriageway() {
        return distanceCarriageway != null;
    }

    public MeasureType getDistanceCarriageway() {
        return distanceCarriageway;
    }

    public void setDistanceCarriageway(MeasureType distanceCarriageway) {
        this.distanceCarriageway = distanceCarriageway;
    }

    public boolean isSetDistanceD() {
        return distanceD != null;
    }

    public MeasureType getDistanceD() {
        return distanceD;
    }

    public void setDistanceD(MeasureType distanceD) {
        this.distanceD = distanceD;
    }

    public boolean isSetBridge() {
        return bridge != null;
    }

    public Boolean getBridge() {
        return bridge;
    }

    public void setBridge(Boolean bridge) {
        this.bridge = bridge;
    }

    public boolean isSetTunnel() {
        return tunnel != null;
    }

    public Boolean getTunnel() {
        return tunnel;
    }

    public void setTunnel(Boolean tunnel) {
        this.tunnel = tunnel;
    }

    public boolean isSetRoadGradientPercent() {
        return roadGradientPercent != null;
    }

    public MeasureType getRoadGradientPercent() {
        return roadGradientPercent;
    }

    public void setRoadGradientPercent(MeasureType roadGradientPercent) {
        this.roadGradientPercent = roadGradientPercent;
    }

    public boolean isSetLineage() {
        return lineage != null;
    }

    public String getLineage() {
        return lineage;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }
}
