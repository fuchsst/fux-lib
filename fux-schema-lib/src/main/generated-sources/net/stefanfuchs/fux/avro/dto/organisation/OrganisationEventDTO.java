/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.stefanfuchs.fux.avro.dto.organisation;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
/** Generic DTO for OrganisationEvents */
@org.apache.avro.specific.AvroGenerated
public class OrganisationEventDTO extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2155934635204249616L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrganisationEventDTO\",\"namespace\":\"net.stefanfuchs.fux.avro.dto.organisation\",\"doc\":\"Generic DTO for OrganisationEvents\",\"fields\":[{\"name\":\"eventTime\",\"type\":\"string\",\"doc\":\"Timestamp of event time as Time-UUID\"},{\"name\":\"orgUuid\",\"type\":\"string\",\"doc\":\"UUID of the organisation the event is linked to\"},{\"name\":\"sourceType\",\"type\":[\"null\",\"string\"],\"doc\":\"Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType\",\"default\":null},{\"name\":\"organisationEventType\",\"type\":\"string\",\"doc\":\"Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType\"},{\"name\":\"payload\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"string\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrganisationEventDTO> ENCODER =
      new BinaryMessageEncoder<OrganisationEventDTO>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrganisationEventDTO> DECODER =
      new BinaryMessageDecoder<OrganisationEventDTO>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<OrganisationEventDTO> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<OrganisationEventDTO> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OrganisationEventDTO>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this OrganisationEventDTO to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a OrganisationEventDTO from a ByteBuffer. */
  public static OrganisationEventDTO fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Timestamp of event time as Time-UUID */
  @Deprecated public java.lang.CharSequence eventTime;
  /** UUID of the organisation the event is linked to */
  @Deprecated public java.lang.CharSequence orgUuid;
  /** Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType */
  @Deprecated public java.lang.CharSequence sourceType;
  /** Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType */
  @Deprecated public java.lang.CharSequence organisationEventType;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> payload;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrganisationEventDTO() {}

  /**
   * All-args constructor.
   * @param eventTime Timestamp of event time as Time-UUID
   * @param orgUuid UUID of the organisation the event is linked to
   * @param sourceType Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
   * @param organisationEventType Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
   * @param payload The new value for payload
   */
  public OrganisationEventDTO(java.lang.CharSequence eventTime, java.lang.CharSequence orgUuid, java.lang.CharSequence sourceType, java.lang.CharSequence organisationEventType, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> payload) {
    this.eventTime = eventTime;
    this.orgUuid = orgUuid;
    this.sourceType = sourceType;
    this.organisationEventType = organisationEventType;
    this.payload = payload;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return eventTime;
    case 1: return orgUuid;
    case 2: return sourceType;
    case 3: return organisationEventType;
    case 4: return payload;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: eventTime = (java.lang.CharSequence)value$; break;
    case 1: orgUuid = (java.lang.CharSequence)value$; break;
    case 2: sourceType = (java.lang.CharSequence)value$; break;
    case 3: organisationEventType = (java.lang.CharSequence)value$; break;
    case 4: payload = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'eventTime' field.
   * @return Timestamp of event time as Time-UUID
   */
  public java.lang.CharSequence getEventTime() {
    return eventTime;
  }

  /**
   * Sets the value of the 'eventTime' field.
   * Timestamp of event time as Time-UUID
   * @param value the value to set.
   */
  public void setEventTime(java.lang.CharSequence value) {
    this.eventTime = value;
  }

  /**
   * Gets the value of the 'orgUuid' field.
   * @return UUID of the organisation the event is linked to
   */
  public java.lang.CharSequence getOrgUuid() {
    return orgUuid;
  }

  /**
   * Sets the value of the 'orgUuid' field.
   * UUID of the organisation the event is linked to
   * @param value the value to set.
   */
  public void setOrgUuid(java.lang.CharSequence value) {
    this.orgUuid = value;
  }

  /**
   * Gets the value of the 'sourceType' field.
   * @return Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
   */
  public java.lang.CharSequence getSourceType() {
    return sourceType;
  }

  /**
   * Sets the value of the 'sourceType' field.
   * Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
   * @param value the value to set.
   */
  public void setSourceType(java.lang.CharSequence value) {
    this.sourceType = value;
  }

  /**
   * Gets the value of the 'organisationEventType' field.
   * @return Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
   */
  public java.lang.CharSequence getOrganisationEventType() {
    return organisationEventType;
  }

  /**
   * Sets the value of the 'organisationEventType' field.
   * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
   * @param value the value to set.
   */
  public void setOrganisationEventType(java.lang.CharSequence value) {
    this.organisationEventType = value;
  }

  /**
   * Gets the value of the 'payload' field.
   * @return The value of the 'payload' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getPayload() {
    return payload;
  }

  /**
   * Sets the value of the 'payload' field.
   * @param value the value to set.
   */
  public void setPayload(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.payload = value;
  }

  /**
   * Creates a new OrganisationEventDTO RecordBuilder.
   * @return A new OrganisationEventDTO RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder newBuilder() {
    return new net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder();
  }

  /**
   * Creates a new OrganisationEventDTO RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrganisationEventDTO RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder newBuilder(net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder other) {
    return new net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder(other);
  }

  /**
   * Creates a new OrganisationEventDTO RecordBuilder by copying an existing OrganisationEventDTO instance.
   * @param other The existing instance to copy.
   * @return A new OrganisationEventDTO RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder newBuilder(net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO other) {
    return new net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder(other);
  }

  /**
   * RecordBuilder for OrganisationEventDTO instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrganisationEventDTO>
    implements org.apache.avro.data.RecordBuilder<OrganisationEventDTO> {

    /** Timestamp of event time as Time-UUID */
    private java.lang.CharSequence eventTime;
    /** UUID of the organisation the event is linked to */
    private java.lang.CharSequence orgUuid;
    /** Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType */
    private java.lang.CharSequence sourceType;
    /** Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType */
    private java.lang.CharSequence organisationEventType;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> payload;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.eventTime)) {
        this.eventTime = data().deepCopy(fields()[0].schema(), other.eventTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orgUuid)) {
        this.orgUuid = data().deepCopy(fields()[1].schema(), other.orgUuid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.sourceType)) {
        this.sourceType = data().deepCopy(fields()[2].schema(), other.sourceType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.organisationEventType)) {
        this.organisationEventType = data().deepCopy(fields()[3].schema(), other.organisationEventType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.payload)) {
        this.payload = data().deepCopy(fields()[4].schema(), other.payload);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing OrganisationEventDTO instance
     * @param other The existing instance to copy.
     */
    private Builder(net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.eventTime)) {
        this.eventTime = data().deepCopy(fields()[0].schema(), other.eventTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orgUuid)) {
        this.orgUuid = data().deepCopy(fields()[1].schema(), other.orgUuid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.sourceType)) {
        this.sourceType = data().deepCopy(fields()[2].schema(), other.sourceType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.organisationEventType)) {
        this.organisationEventType = data().deepCopy(fields()[3].schema(), other.organisationEventType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.payload)) {
        this.payload = data().deepCopy(fields()[4].schema(), other.payload);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'eventTime' field.
      * Timestamp of event time as Time-UUID
      * @return The value.
      */
    public java.lang.CharSequence getEventTime() {
      return eventTime;
    }

    /**
      * Sets the value of the 'eventTime' field.
      * Timestamp of event time as Time-UUID
      * @param value The value of 'eventTime'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder setEventTime(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.eventTime = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'eventTime' field has been set.
      * Timestamp of event time as Time-UUID
      * @return True if the 'eventTime' field has been set, false otherwise.
      */
    public boolean hasEventTime() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'eventTime' field.
      * Timestamp of event time as Time-UUID
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder clearEventTime() {
      eventTime = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'orgUuid' field.
      * UUID of the organisation the event is linked to
      * @return The value.
      */
    public java.lang.CharSequence getOrgUuid() {
      return orgUuid;
    }

    /**
      * Sets the value of the 'orgUuid' field.
      * UUID of the organisation the event is linked to
      * @param value The value of 'orgUuid'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder setOrgUuid(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.orgUuid = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'orgUuid' field has been set.
      * UUID of the organisation the event is linked to
      * @return True if the 'orgUuid' field has been set, false otherwise.
      */
    public boolean hasOrgUuid() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'orgUuid' field.
      * UUID of the organisation the event is linked to
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder clearOrgUuid() {
      orgUuid = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'sourceType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
      * @return The value.
      */
    public java.lang.CharSequence getSourceType() {
      return sourceType;
    }

    /**
      * Sets the value of the 'sourceType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
      * @param value The value of 'sourceType'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder setSourceType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.sourceType = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'sourceType' field has been set.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
      * @return True if the 'sourceType' field has been set, false otherwise.
      */
    public boolean hasSourceType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'sourceType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder clearSourceType() {
      sourceType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'organisationEventType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @return The value.
      */
    public java.lang.CharSequence getOrganisationEventType() {
      return organisationEventType;
    }

    /**
      * Sets the value of the 'organisationEventType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @param value The value of 'organisationEventType'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder setOrganisationEventType(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.organisationEventType = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'organisationEventType' field has been set.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @return True if the 'organisationEventType' field has been set, false otherwise.
      */
    public boolean hasOrganisationEventType() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'organisationEventType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder clearOrganisationEventType() {
      organisationEventType = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'payload' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getPayload() {
      return payload;
    }

    /**
      * Sets the value of the 'payload' field.
      * @param value The value of 'payload'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder setPayload(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[4], value);
      this.payload = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'payload' field has been set.
      * @return True if the 'payload' field has been set, false otherwise.
      */
    public boolean hasPayload() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'payload' field.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.organisation.OrganisationEventDTO.Builder clearPayload() {
      payload = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrganisationEventDTO build() {
      try {
        OrganisationEventDTO record = new OrganisationEventDTO();
        record.eventTime = fieldSetFlags()[0] ? this.eventTime : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.orgUuid = fieldSetFlags()[1] ? this.orgUuid : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.sourceType = fieldSetFlags()[2] ? this.sourceType : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.organisationEventType = fieldSetFlags()[3] ? this.organisationEventType : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.payload = fieldSetFlags()[4] ? this.payload : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrganisationEventDTO>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrganisationEventDTO>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrganisationEventDTO>
    READER$ = (org.apache.avro.io.DatumReader<OrganisationEventDTO>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
