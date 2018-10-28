/*
 * module-noise-ade - Noise ADE module for citygml4j
 * https://github.com/citygml4j/module-noise-ade
 *
 * module-noise-ade is part of the citygml4j project
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
package org.citygml.ade.noise.model;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.ObjectCopier;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.gml.measures.Speed;

public class Train extends AbstractFeature implements ADEModelObject {
	private String trainType;
	private Measure trainTypeCorrection;
	private Measure brakePortionDay;
	private Measure brakePortionEvening;
	private Measure brakePortionNight;
	private Length lengthDay;
	private Length lengthEvening;
	private Length lengthNight;
	private Speed speedDay;
	private Speed speedEvening;
	private Speed speedNight;
	private Measure additionalCorrectionTrain;
	
	public String getTrainType() {
		return trainType;
	}
	
	public boolean isSetTrainType() {
		return trainType != null;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public Measure getTrainTypeCorrection() {
		return trainTypeCorrection;
	}
	
	public boolean isSetTrainTypeCorrection() {
		return trainTypeCorrection != null;
	}

	public void setTrainTypeCorrection(Measure trainTypeCorrection) {
		if (trainTypeCorrection != null)
			trainTypeCorrection.setParent(this);
		
		this.trainTypeCorrection = trainTypeCorrection;
	}

	public Measure getBrakePortionDay() {
		return brakePortionDay;
	}
	
	public boolean isSetBrakePortionDay() {
		return brakePortionDay != null;
	}

	public void setBrakePortionDay(Measure brakePortionDay) {
		if (brakePortionDay != null)
			brakePortionDay.setParent(this);
		
		this.brakePortionDay = brakePortionDay;
	}

	public Measure getBrakePortionEvening() {
		return brakePortionEvening;
	}
	
	public boolean isSetBrakePortionEvening() {
		return brakePortionEvening != null;
	}

	public void setBrakePortionEvening(Measure brakePortionEvening) {
		if (brakePortionEvening != null)
			brakePortionEvening.setParent(this);
		
		this.brakePortionEvening = brakePortionEvening;
	}

	public Measure getBrakePortionNight() {
		return brakePortionNight;
	}
	
	public boolean isSetBrakePortionNight() {
		return brakePortionNight != null;
	}

	public void setBrakePortionNight(Measure brakePortionNight) {
		if (brakePortionNight != null)
			brakePortionNight.setParent(this);
		
		this.brakePortionNight = brakePortionNight;
	}

	public Length getLengthDay() {
		return lengthDay;
	}
	
	public boolean isSetLengthDay() {
		return lengthDay != null;
	}

	public void setLengthDay(Length lengthDay) {
		if (lengthDay != null)
			lengthDay.setParent(this);
		
		this.lengthDay = lengthDay;
	}

	public Length getLengthEvening() {
		return lengthEvening;
	}
	
	public boolean isSetLengthEvening() {
		return lengthEvening != null;
	}

	public void setLengthEvening(Length lengthEvening) {
		if (lengthEvening != null)
			lengthEvening.setParent(this);
		
		this.lengthEvening = lengthEvening;
	}

	public Length getLengthNight() {
		return lengthNight;
	}
	
	public boolean isSetLengthNight() {
		return lengthNight != null;
	}

	public void setLengthNight(Length lengthNight) {
		if (lengthNight != null)
			lengthNight.setParent(this);
		
		this.lengthNight = lengthNight;
	}

	public Speed getSpeedDay() {
		return speedDay;
	}
	
	public boolean isSetSpeedDay() {
		return speedDay != null;
	}

	public void setSpeedDay(Speed speedDay) {
		if (speedDay != null)
			speedDay.setParent(this);
		
		this.speedDay = speedDay;
	}

	public Speed getSpeedEvening() {
		return speedEvening;
	}
	
	public boolean isSetSpeedEvening() {
		return speedEvening != null;
	}

	public void setSpeedEvening(Speed speedEvening) {
		if (speedEvening != null)
			speedEvening.setParent(this);
		
		this.speedEvening = speedEvening;
	}

	public Speed getSpeedNight() {
		return speedNight;
	}
	
	public boolean isSetSpeedNight() {
		return speedNight != null;
	}

	public void setSpeedNight(Speed speedNight) {
		if (speedNight != null)
			speedNight.setParent(this);
		
		this.speedNight = speedNight;
	}

	public Measure getAdditionalCorrectionTrain() {
		return additionalCorrectionTrain;
	}
	
	public boolean isSetAdditionalCorrectionTrain() {
		return additionalCorrectionTrain != null;
	}

	public void setAdditionalCorrectionTrain(Measure additionalCorrectionTrain) {
		if (additionalCorrectionTrain != null)
			additionalCorrectionTrain.setParent(this);
		
		this.additionalCorrectionTrain = additionalCorrectionTrain;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Train(), copyBuilder);
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Train copy = (target == null) ? new Train() : (Train)target;
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
