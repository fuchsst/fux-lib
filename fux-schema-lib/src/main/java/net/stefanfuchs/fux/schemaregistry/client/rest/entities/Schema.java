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

import com.fasterxml.jackson.annotation.JsonProperty;

public class Schema implements Comparable<Schema> {

    private String subject;
    private Integer version;
    private Integer id;
    private String schema;

    public Schema(@JsonProperty("subject") String subject,
                  @JsonProperty("version") Integer version,
                  @JsonProperty("id") Integer id,
                  @JsonProperty("schema") String schema) {
        this.subject = subject;
        this.version = version;
        this.id = id;
        this.schema = schema;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return this.version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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

        Schema that = (Schema) o;

        return this.subject.equals(that.subject) &&
                this.version.equals(that.version) &&
                this.id.equals(that.getId()) &&
                this.schema.equals(that.schema);
    }

    @Override
    public int hashCode() {
        int result = subject.hashCode();
        result = 31 * result + version;
        result = 31 * result + id;
        result = 31 * result + schema.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return ("{subject=" + this.subject + ",") +
                "version=" + this.version + "," +
                "id=" + this.id + "," +
                "schema=" + this.schema + "}";
    }

    @Override
    public int compareTo(Schema that) {
        int result = this.subject.compareTo(that.subject);
        if (result != 0) {
            return result;
        }
        result = this.version - that.version;
        return result;
    }
}
