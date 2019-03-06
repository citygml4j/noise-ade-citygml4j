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

package org.citygml.ade.noise.cityjson;

import org.citygml.ade.noise.cityjson.bind.NoiseExtensionMarshaller;
import org.citygml.ade.noise.cityjson.bind.NoiseExtensionUnmarshaller;
import org.citygml.ade.noise.cityjson.model.module.NoiseExtensionModule;
import org.citygml4j.builder.cityjson.extension.CityJSONExtension;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionMarshaller;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionModule;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionUnmarshaller;

import java.util.Collections;
import java.util.List;

public class NoiseExtension implements CityJSONExtension {
    private final List<CityJSONExtensionModule> modules = Collections.singletonList(new NoiseExtensionModule());

    @Override
    public List<CityJSONExtensionModule> getExtensionModules() {
        return modules;
    }

    @Override
    public CityJSONExtensionMarshaller createExtensionMarshaller() {
        return new NoiseExtensionMarshaller();
    }

    @Override
    public CityJSONExtensionUnmarshaller createExtensionUnmarshaller() {
        return new NoiseExtensionUnmarshaller();
    }
}
