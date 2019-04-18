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

public class TrainType {
    private transient String gmlId;
    private String trainType;
    private MeasureType trainTypeCorrection;
    private MeasureType brakePortionDay;
    private MeasureType brakePortionEvening;
    private MeasureType brakePortionNight;
    private MeasureType lengthDay;
    private MeasureType lengthEvening;
    private MeasureType lengthNight;
    private MeasureType speedDay;
    private MeasureType speedEvening;
    private MeasureType speedNight;
    private MeasureType additionalCorrectionTrain;

    public boolean isSetGmlId() {
        return gmlId != null;
    }

    public String getGmlId() {
        return gmlId;
    }

    public void setGmlId(String gmlId) {
        this.gmlId = gmlId;
    }

    public boolean isSetTrainType() {
        return trainType != null;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public boolean isSetTrainTypeCorrection() {
        return trainTypeCorrection != null;
    }

    public MeasureType getTrainTypeCorrection() {
        return trainTypeCorrection;
    }

    public void setTrainTypeCorrection(MeasureType trainTypeCorrection) {
        this.trainTypeCorrection = trainTypeCorrection;
    }

    public boolean isSetBrakePortionDay() {
        return brakePortionDay != null;
    }

    public MeasureType getBrakePortionDay() {
        return brakePortionDay;
    }

    public void setBrakePortionDay(MeasureType brakePortionDay) {
        this.brakePortionDay = brakePortionDay;
    }

    public boolean isSetBrakePortionEvening() {
        return brakePortionEvening != null;
    }

    public MeasureType getBrakePortionEvening() {
        return brakePortionEvening;
    }

    public void setBrakePortionEvening(MeasureType brakePortionEvening) {
        this.brakePortionEvening = brakePortionEvening;
    }

    public boolean isSetBrakePortionNight() {
        return brakePortionNight != null;
    }

    public MeasureType getBrakePortionNight() {
        return brakePortionNight;
    }

    public void setBrakePortionNight(MeasureType brakePortionNight) {
        this.brakePortionNight = brakePortionNight;
    }

    public boolean isSetLengthDay() {
        return lengthDay != null;
    }

    public MeasureType getLengthDay() {
        return lengthDay;
    }

    public void setLengthDay(MeasureType lengthDay) {
        this.lengthDay = lengthDay;
    }

    public boolean isSetLengthEvening() {
        return lengthEvening != null;
    }

    public MeasureType getLengthEvening() {
        return lengthEvening;
    }

    public void setLengthEvening(MeasureType lengthEvening) {
        this.lengthEvening = lengthEvening;
    }

    public boolean isSetLengthNight() {
        return lengthNight != null;
    }

    public MeasureType getLengthNight() {
        return lengthNight;
    }

    public void setLengthNight(MeasureType lengthNight) {
        this.lengthNight = lengthNight;
    }

    public boolean isSetSpeedDay() {
        return speedDay != null;
    }

    public MeasureType getSpeedDay() {
        return speedDay;
    }

    public void setSpeedDay(MeasureType speedDay) {
        this.speedDay = speedDay;
    }

    public boolean isSetSpeedEvening() {
        return speedEvening != null;
    }

    public MeasureType getSpeedEvening() {
        return speedEvening;
    }

    public void setSpeedEvening(MeasureType speedEvening) {
        this.speedEvening = speedEvening;
    }

    public boolean isSetSpeedNight() {
        return speedNight != null;
    }

    public MeasureType getSpeedNight() {
        return speedNight;
    }

    public void setSpeedNight(MeasureType speedNight) {
        this.speedNight = speedNight;
    }

    public boolean isSetAdditionalCorrectionTrain() {
        return additionalCorrectionTrain != null;
    }

    public MeasureType getAdditionalCorrectionTrain() {
        return additionalCorrectionTrain;
    }

    public void setAdditionalCorrectionTrain(MeasureType additionalCorrectionTrain) {
        this.additionalCorrectionTrain = additionalCorrectionTrain;
    }
}
