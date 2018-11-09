/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.stefanfuchs.fux.avro.dto.user;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
/** Generic DTO for UserEvents */
@org.apache.avro.specific.AvroGenerated
public class UserEventDTO extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2186225462374230796L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserEventDTO\",\"namespace\":\"net.stefanfuchs.fux.avro.dto.user\",\"doc\":\"Generic DTO for UserEvents\",\"fields\":[{\"name\":\"eventTime\",\"type\":\"string\",\"doc\":\"Timestamp of event time as Time-UUID\"},{\"name\":\"userUuid\",\"type\":\"string\",\"doc\":\"Id of user that triggered the event as UUID\"},{\"name\":\"sourceType\",\"type\":[\"null\",\"string\"],\"doc\":\"Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType\",\"default\":null},{\"name\":\"userEventType\",\"type\":\"string\",\"doc\":\"Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType\"},{\"name\":\"payload\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"string\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<UserEventDTO> ENCODER =
      new BinaryMessageEncoder<UserEventDTO>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserEventDTO> DECODER =
      new BinaryMessageDecoder<UserEventDTO>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<UserEventDTO> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<UserEventDTO> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<UserEventDTO>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this UserEventDTO to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a UserEventDTO from a ByteBuffer. */
  public static UserEventDTO fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Timestamp of event time as Time-UUID */
  @Deprecated public java.lang.CharSequence eventTime;
  /** Id of user that triggered the event as UUID */
  @Deprecated public java.lang.CharSequence userUuid;
  /** Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType */
  @Deprecated public java.lang.CharSequence sourceType;
  /** Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType */
  @Deprecated public java.lang.CharSequence userEventType;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> payload;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserEventDTO() {}

  /**
   * All-args constructor.
   * @param eventTime Timestamp of event time as Time-UUID
   * @param userUuid Id of user that triggered the event as UUID
   * @param sourceType Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType
   * @param userEventType Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
   * @param payload The new value for payload
   */
  public UserEventDTO(java.lang.CharSequence eventTime, java.lang.CharSequence userUuid, java.lang.CharSequence sourceType, java.lang.CharSequence userEventType, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> payload) {
    this.eventTime = eventTime;
    this.userUuid = userUuid;
    this.sourceType = sourceType;
    this.userEventType = userEventType;
    this.payload = payload;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return eventTime;
    case 1: return userUuid;
    case 2: return sourceType;
    case 3: return userEventType;
    case 4: return payload;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: eventTime = (java.lang.CharSequence)value$; break;
    case 1: userUuid = (java.lang.CharSequence)value$; break;
    case 2: sourceType = (java.lang.CharSequence)value$; break;
    case 3: userEventType = (java.lang.CharSequence)value$; break;
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
   * Gets the value of the 'userUuid' field.
   * @return Id of user that triggered the event as UUID
   */
  public java.lang.CharSequence getUserUuid() {
    return userUuid;
  }

  /**
   * Sets the value of the 'userUuid' field.
   * Id of user that triggered the event as UUID
   * @param value the value to set.
   */
  public void setUserUuid(java.lang.CharSequence value) {
    this.userUuid = value;
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
   * Gets the value of the 'userEventType' field.
   * @return Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
   */
  public java.lang.CharSequence getUserEventType() {
    return userEventType;
  }

  /**
   * Sets the value of the 'userEventType' field.
   * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
   * @param value the value to set.
   */
  public void setUserEventType(java.lang.CharSequence value) {
    this.userEventType = value;
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
   * Creates a new UserEventDTO RecordBuilder.
   * @return A new UserEventDTO RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder newBuilder() {
    return new net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder();
  }

  /**
   * Creates a new UserEventDTO RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserEventDTO RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder newBuilder(net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder other) {
    return new net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder(other);
  }

  /**
   * Creates a new UserEventDTO RecordBuilder by copying an existing UserEventDTO instance.
   * @param other The existing instance to copy.
   * @return A new UserEventDTO RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder newBuilder(net.stefanfuchs.fux.avro.dto.user.UserEventDTO other) {
    return new net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder(other);
  }

  /**
   * RecordBuilder for UserEventDTO instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserEventDTO>
    implements org.apache.avro.data.RecordBuilder<UserEventDTO> {

    /** Timestamp of event time as Time-UUID */
    private java.lang.CharSequence eventTime;
    /** Id of user that triggered the event as UUID */
    private java.lang.CharSequence userUuid;
    /** Code of source as defined in net.stefanfuchs.fux.avro.enums.common.SourceType */
    private java.lang.CharSequence sourceType;
    /** Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType */
    private java.lang.CharSequence userEventType;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> payload;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.eventTime)) {
        this.eventTime = data().deepCopy(fields()[0].schema(), other.eventTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.userUuid)) {
        this.userUuid = data().deepCopy(fields()[1].schema(), other.userUuid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.sourceType)) {
        this.sourceType = data().deepCopy(fields()[2].schema(), other.sourceType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.userEventType)) {
        this.userEventType = data().deepCopy(fields()[3].schema(), other.userEventType);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.payload)) {
        this.payload = data().deepCopy(fields()[4].schema(), other.payload);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing UserEventDTO instance
     * @param other The existing instance to copy.
     */
    private Builder(net.stefanfuchs.fux.avro.dto.user.UserEventDTO other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.eventTime)) {
        this.eventTime = data().deepCopy(fields()[0].schema(), other.eventTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.userUuid)) {
        this.userUuid = data().deepCopy(fields()[1].schema(), other.userUuid);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.sourceType)) {
        this.sourceType = data().deepCopy(fields()[2].schema(), other.sourceType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.userEventType)) {
        this.userEventType = data().deepCopy(fields()[3].schema(), other.userEventType);
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
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder setEventTime(java.lang.CharSequence value) {
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
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder clearEventTime() {
      eventTime = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'userUuid' field.
      * Id of user that triggered the event as UUID
      * @return The value.
      */
    public java.lang.CharSequence getUserUuid() {
      return userUuid;
    }

    /**
      * Sets the value of the 'userUuid' field.
      * Id of user that triggered the event as UUID
      * @param value The value of 'userUuid'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder setUserUuid(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.userUuid = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'userUuid' field has been set.
      * Id of user that triggered the event as UUID
      * @return True if the 'userUuid' field has been set, false otherwise.
      */
    public boolean hasUserUuid() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'userUuid' field.
      * Id of user that triggered the event as UUID
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder clearUserUuid() {
      userUuid = null;
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
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder setSourceType(java.lang.CharSequence value) {
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
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder clearSourceType() {
      sourceType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'userEventType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @return The value.
      */
    public java.lang.CharSequence getUserEventType() {
      return userEventType;
    }

    /**
      * Sets the value of the 'userEventType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @param value The value of 'userEventType'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder setUserEventType(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.userEventType = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'userEventType' field has been set.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @return True if the 'userEventType' field has been set, false otherwise.
      */
    public boolean hasUserEventType() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'userEventType' field.
      * Code of source as defined in net.stefanfuchs.fux.avro.enums.entity.user.UserEventType
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder clearUserEventType() {
      userEventType = null;
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
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder setPayload(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
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
    public net.stefanfuchs.fux.avro.dto.user.UserEventDTO.Builder clearPayload() {
      payload = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserEventDTO build() {
      try {
        UserEventDTO record = new UserEventDTO();
        record.eventTime = fieldSetFlags()[0] ? this.eventTime : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.userUuid = fieldSetFlags()[1] ? this.userUuid : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.sourceType = fieldSetFlags()[2] ? this.sourceType : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.userEventType = fieldSetFlags()[3] ? this.userEventType : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.payload = fieldSetFlags()[4] ? this.payload : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserEventDTO>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserEventDTO>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserEventDTO>
    READER$ = (org.apache.avro.io.DatumReader<UserEventDTO>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}