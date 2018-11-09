/**
 * Copyright 2014 Confluent Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.stefanfuchs.fux.schemaregistry.client.rest.entities;

import org.codehaus.jackson.annotate.JsonProperty;

public class Config {

    private String compatibilityLevel;

    public Config(@JsonProperty("compatibility") String compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }

    public Config() {
        compatibilityLevel = null;
    }

    @JsonProperty("compatibility")
    public String getCompatibilityLevel() {
        return compatibilityLevel;
    }

    @JsonProperty("compatibility")
    public void setCompatibilityLevel(String compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Config that = (Config) o;

        return this.compatibilityLevel.equals(that.compatibilityLevel);
    }

    @Override
    public int hashCode() {
        return 31 * compatibilityLevel.hashCode();
    }

    @Override
    public String toString() {
        return ("{compatibilityLevel=" + this.compatibilityLevel + "}");
    }
}
