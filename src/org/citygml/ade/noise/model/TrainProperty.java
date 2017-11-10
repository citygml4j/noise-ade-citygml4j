/*
 * module-noise-ade - Noise ADE module for citygml4j
 * https://github.com/citygml4j/module-noise-ade
 * 
 * module-noise-ade is part of the citygml4j project
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.ade.ADEModule;

public class TrainProperty extends FeatureProperty<Train> implements ADEModelObject {

	public TrainProperty() {
	}
	
	public TrainProperty(Train train) {
		super(train);
	}
	
	public TrainProperty(String href) {
		super(href);
	}
	
	public Train getTrain() {
		return super.getObject();
	}

	public boolean isSetTrain() {
		return super.isSetObject();
	}

	public void setTrain(Train train) {
		super.setObject(train);
	}

	public void unsetTrain() {
		super.unsetObject();
	}

	@Override
	public Class<Train> getAssociableClass() {
		return Train.class;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrainProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrainProperty copy = (target == null) ? new TrainProperty() : (TrainProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	@Override
	public ADEModule getADEModule() {
		return NoiseADEModule.v1_0;
	}

}
