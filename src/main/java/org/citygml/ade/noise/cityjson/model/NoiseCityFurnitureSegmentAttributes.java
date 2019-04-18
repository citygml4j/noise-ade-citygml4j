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

public class NoiseCityFurnitureSegmentAttributes extends Attributes {
    private String type;
    private String reflection;
    private MeasureType reflectionCorrection;
    private MeasureType height;
    private MeasureType distance;

    public boolean isSetType() {
        return type != null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSetReflection() {
        return reflection != null;
    }

    public String getReflection() {
        return reflection;
    }

    public void setReflection(String reflection) {
        this.reflection = reflection;
    }

    public boolean isSetReflectionCorrection() {
        return reflectionCorrection != null;
    }

    public MeasureType getReflectionCorrection() {
        return reflectionCorrection;
    }

    public void setReflectionCorrection(MeasureType reflectionCorrection) {
        this.reflectionCorrection = reflectionCorrection;
    }

    public boolean isSetHeight() {
        return height != null;
    }

    public MeasureType getHeight() {
        return height;
    }

    public void setHeight(MeasureType height) {
        this.height = height;
    }

    public boolean isSetDistance() {
        return distance != null;
    }

    public MeasureType getDistance() {
        return distance;
    }

    public void setDistance(MeasureType distance) {
        this.distance = distance;
    }
}
