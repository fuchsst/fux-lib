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

package net.stefanfuchs.fux.schemaregistry.client.rest.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RegisterSchemaRequest {

    private String schema;

    public RegisterSchemaRequest() {
    }

    public RegisterSchemaRequest(String schema) {
        this.schema = schema;
    }

    @JsonProperty("schema")
    public String getSchema() {
        return this.schema;
    }

    @JsonProperty("schema")
    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        RegisterSchemaRequest that = (RegisterSchemaRequest) o;

        return schema != null ? schema.equals(that.schema) : that.schema == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (schema != null ? schema.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{schema=" +
                this.schema +
                "}";
    }

    public String toJson() throws IOException {
        return new ObjectMapper().writeValueAsString(this);
    }

}
