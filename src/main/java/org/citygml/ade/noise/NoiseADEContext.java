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
package org.citygml.ade.noise;

import org.citygml.ade.noise.bind.NoiseADEMarshaller;
import org.citygml.ade.noise.bind.NoiseADEUnmarshaller;
import org.citygml.ade.noise.cityjson.NoiseExtension;
import org.citygml.ade.noise.model.module.NoiseADEModule;
import org.citygml.ade.noise.walker.NoiseADEFeatureFunctionWalker;
import org.citygml.ade.noise.walker.NoiseADEFeatureWalker;
import org.citygml.ade.noise.walker.NoiseADEGMLFunctionWalker;
import org.citygml.ade.noise.walker.NoiseADEGMLWalker;
import org.citygml4j.builder.cityjson.extension.CityJSONExtension;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEMarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEUnmarshaller;
import org.citygml4j.model.citygml.ade.binding.ADEWalker;
import org.citygml4j.model.module.ade.ADEModule;
import org.citygml4j.util.walker.FeatureFunctionWalker;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.util.walker.GMLFunctionWalker;
import org.citygml4j.util.walker.GMLWalker;

import java.util.Collections;
import java.util.List;

public class NoiseADEContext implements ADEContext, CityJSONExtensionContext {
    private final List<ADEModule> modules = Collections.singletonList(NoiseADEModule.v2_0);
    private final CityJSONExtension extension = new NoiseExtension();

    @Override
    public List<ADEModule> getADEModules() {
        return modules;
    }

    @Override
    public List<String> getModelPackageNames() {
        return Collections.singletonList("org.citygml.ade.noise.model");
    }

    @Override
    public ADEMarshaller createADEMarshaller() {
        return new NoiseADEMarshaller();
    }

    @Override
    public ADEUnmarshaller createADEUnmarshaller() {
        return new NoiseADEUnmarshaller();
    }

    @Override
    public ADEWalker<FeatureWalker> createDefaultFeatureWalker() {
        return new NoiseADEFeatureWalker();
    }

    @Override
    public ADEWalker<GMLWalker> createDefaultGMLWalker() {
        return new NoiseADEGMLWalker();
    }

    @Override
    public <T> ADEWalker<FeatureFunctionWalker<T>> createDefaultFeatureFunctionWalker() {
        return new NoiseADEFeatureFunctionWalker<>();
    }

    @Override
    public <T> ADEWalker<GMLFunctionWalker<T>> createDefaultGMLFunctionWalker() {
        return new NoiseADEGMLFunctionWalker<>();
    }

    @Override
    public CityJSONExtension getCityJSONExtension() {
        return extension;
    }
}
