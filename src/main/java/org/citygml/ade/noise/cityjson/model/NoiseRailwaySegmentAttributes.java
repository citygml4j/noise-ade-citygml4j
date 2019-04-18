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

package org.citygml.ade.noise.cityjson.model;

import org.citygml4j.cityjson.feature.Attributes;

public class NoiseRailwaySegmentAttributes extends Attributes {
    private String railwaySurfaceMaterial;
    private MeasureType railwaySurfaceCorrection;
    private Boolean bridge;
    private Boolean crossing;
    private MeasureType curveRadius;
    private MeasureType additionalCorrectionSegment;

    public boolean isSetRailwaySurfaceMaterial() {
        return railwaySurfaceMaterial != null;
    }

    public String getRailwaySurfaceMaterial() {
        return railwaySurfaceMaterial;
    }

    public void setRailwaySurfaceMaterial(String railwaySurfaceMaterial) {
        this.railwaySurfaceMaterial = railwaySurfaceMaterial;
    }

    public boolean isSetRailwaySurfaceCorrection() {
        return railwaySurfaceCorrection != null;
    }

    public MeasureType getRailwaySurfaceCorrection() {
        return railwaySurfaceCorrection;
    }

    public void setRailwaySurfaceCorrection(MeasureType railwaySurfaceCorrection) {
        this.railwaySurfaceCorrection = railwaySurfaceCorrection;
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

    public boolean isSetCrossing() {
        return crossing != null;
    }

    public Boolean getCrossing() {
        return crossing;
    }

    public void setCrossing(Boolean crossing) {
        this.crossing = crossing;
    }

    public boolean isSetCurveRadius() {
        return curveRadius != null;
    }

    public MeasureType getCurveRadius() {
        return curveRadius;
    }

    public void setCurveRadius(MeasureType curveRadius) {
        this.curveRadius = curveRadius;
    }

    public boolean isSetAdditionalCorrectionSegment() {
        return additionalCorrectionSegment != null;
    }

    public MeasureType getAdditionalCorrectionSegment() {
        return additionalCorrectionSegment;
    }

    public void setAdditionalCorrectionSegment(MeasureType additionalCorrectionSegment) {
        this.additionalCorrectionSegment = additionalCorrectionSegment;
    }
}
