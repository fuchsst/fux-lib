/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package net.stefanfuchs.fux.avro.dto.ad;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
/** Address information for an advert */
@org.apache.avro.specific.AvroGenerated
public class Address extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 959565323107005804L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Address\",\"namespace\":\"net.stefanfuchs.fux.avro.dto.ad\",\"doc\":\"Address information for an advert\",\"fields\":[{\"name\":\"addressUuid\",\"type\":[\"null\",\"string\"],\"doc\":\"primary key\",\"default\":null},{\"name\":\"country\",\"type\":[\"null\",\"string\"],\"doc\":\"country code\",\"default\":null},{\"name\":\"province\",\"type\":[\"null\",\"string\"],\"doc\":\"name of the provice (state)\",\"default\":null},{\"name\":\"district\",\"type\":[\"null\",\"string\"],\"doc\":\"The district the address belongs to\",\"default\":null},{\"name\":\"postCode\",\"type\":[\"null\",\"string\"],\"doc\":\"postal (zip) code\",\"default\":null},{\"name\":\"postalName\",\"type\":[\"null\",\"string\"],\"doc\":\"city name\",\"default\":null},{\"name\":\"street\",\"type\":[\"null\",\"string\"],\"doc\":\"street including housnaumer etc.\",\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Address> ENCODER =
      new BinaryMessageEncoder<Address>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Address> DECODER =
      new BinaryMessageDecoder<Address>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Address> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Address> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Address>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Address to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Address from a ByteBuffer. */
  public static Address fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** primary key */
  @Deprecated public java.lang.CharSequence addressUuid;
  /** country code */
  @Deprecated public java.lang.CharSequence country;
  /** name of the provice (state) */
  @Deprecated public java.lang.CharSequence province;
  /** The district the address belongs to */
  @Deprecated public java.lang.CharSequence district;
  /** postal (zip) code */
  @Deprecated public java.lang.CharSequence postCode;
  /** city name */
  @Deprecated public java.lang.CharSequence postalName;
  /** street including housnaumer etc. */
  @Deprecated public java.lang.CharSequence street;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Address() {}

  /**
   * All-args constructor.
   * @param addressUuid primary key
   * @param country country code
   * @param province name of the provice (state)
   * @param district The district the address belongs to
   * @param postCode postal (zip) code
   * @param postalName city name
   * @param street street including housnaumer etc.
   */
  public Address(java.lang.CharSequence addressUuid, java.lang.CharSequence country, java.lang.CharSequence province, java.lang.CharSequence district, java.lang.CharSequence postCode, java.lang.CharSequence postalName, java.lang.CharSequence street) {
    this.addressUuid = addressUuid;
    this.country = country;
    this.province = province;
    this.district = district;
    this.postCode = postCode;
    this.postalName = postalName;
    this.street = street;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return addressUuid;
    case 1: return country;
    case 2: return province;
    case 3: return district;
    case 4: return postCode;
    case 5: return postalName;
    case 6: return street;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: addressUuid = (java.lang.CharSequence)value$; break;
    case 1: country = (java.lang.CharSequence)value$; break;
    case 2: province = (java.lang.CharSequence)value$; break;
    case 3: district = (java.lang.CharSequence)value$; break;
    case 4: postCode = (java.lang.CharSequence)value$; break;
    case 5: postalName = (java.lang.CharSequence)value$; break;
    case 6: street = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'addressUuid' field.
   * @return primary key
   */
  public java.lang.CharSequence getAddressUuid() {
    return addressUuid;
  }

  /**
   * Sets the value of the 'addressUuid' field.
   * primary key
   * @param value the value to set.
   */
  public void setAddressUuid(java.lang.CharSequence value) {
    this.addressUuid = value;
  }

  /**
   * Gets the value of the 'country' field.
   * @return country code
   */
  public java.lang.CharSequence getCountry() {
    return country;
  }

  /**
   * Sets the value of the 'country' field.
   * country code
   * @param value the value to set.
   */
  public void setCountry(java.lang.CharSequence value) {
    this.country = value;
  }

  /**
   * Gets the value of the 'province' field.
   * @return name of the provice (state)
   */
  public java.lang.CharSequence getProvince() {
    return province;
  }

  /**
   * Sets the value of the 'province' field.
   * name of the provice (state)
   * @param value the value to set.
   */
  public void setProvince(java.lang.CharSequence value) {
    this.province = value;
  }

  /**
   * Gets the value of the 'district' field.
   * @return The district the address belongs to
   */
  public java.lang.CharSequence getDistrict() {
    return district;
  }

  /**
   * Sets the value of the 'district' field.
   * The district the address belongs to
   * @param value the value to set.
   */
  public void setDistrict(java.lang.CharSequence value) {
    this.district = value;
  }

  /**
   * Gets the value of the 'postCode' field.
   * @return postal (zip) code
   */
  public java.lang.CharSequence getPostCode() {
    return postCode;
  }

  /**
   * Sets the value of the 'postCode' field.
   * postal (zip) code
   * @param value the value to set.
   */
  public void setPostCode(java.lang.CharSequence value) {
    this.postCode = value;
  }

  /**
   * Gets the value of the 'postalName' field.
   * @return city name
   */
  public java.lang.CharSequence getPostalName() {
    return postalName;
  }

  /**
   * Sets the value of the 'postalName' field.
   * city name
   * @param value the value to set.
   */
  public void setPostalName(java.lang.CharSequence value) {
    this.postalName = value;
  }

  /**
   * Gets the value of the 'street' field.
   * @return street including housnaumer etc.
   */
  public java.lang.CharSequence getStreet() {
    return street;
  }

  /**
   * Sets the value of the 'street' field.
   * street including housnaumer etc.
   * @param value the value to set.
   */
  public void setStreet(java.lang.CharSequence value) {
    this.street = value;
  }

  /**
   * Creates a new Address RecordBuilder.
   * @return A new Address RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.ad.Address.Builder newBuilder() {
    return new net.stefanfuchs.fux.avro.dto.ad.Address.Builder();
  }

  /**
   * Creates a new Address RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Address RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.ad.Address.Builder newBuilder(net.stefanfuchs.fux.avro.dto.ad.Address.Builder other) {
    return new net.stefanfuchs.fux.avro.dto.ad.Address.Builder(other);
  }

  /**
   * Creates a new Address RecordBuilder by copying an existing Address instance.
   * @param other The existing instance to copy.
   * @return A new Address RecordBuilder
   */
  public static net.stefanfuchs.fux.avro.dto.ad.Address.Builder newBuilder(net.stefanfuchs.fux.avro.dto.ad.Address other) {
    return new net.stefanfuchs.fux.avro.dto.ad.Address.Builder(other);
  }

  /**
   * RecordBuilder for Address instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Address>
    implements org.apache.avro.data.RecordBuilder<Address> {

    /** primary key */
    private java.lang.CharSequence addressUuid;
    /** country code */
    private java.lang.CharSequence country;
    /** name of the provice (state) */
    private java.lang.CharSequence province;
    /** The district the address belongs to */
    private java.lang.CharSequence district;
    /** postal (zip) code */
    private java.lang.CharSequence postCode;
    /** city name */
    private java.lang.CharSequence postalName;
    /** street including housnaumer etc. */
    private java.lang.CharSequence street;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(net.stefanfuchs.fux.avro.dto.ad.Address.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.addressUuid)) {
        this.addressUuid = data().deepCopy(fields()[0].schema(), other.addressUuid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.country)) {
        this.country = data().deepCopy(fields()[1].schema(), other.country);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.province)) {
        this.province = data().deepCopy(fields()[2].schema(), other.province);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.district)) {
        this.district = data().deepCopy(fields()[3].schema(), other.district);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.postCode)) {
        this.postCode = data().deepCopy(fields()[4].schema(), other.postCode);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.postalName)) {
        this.postalName = data().deepCopy(fields()[5].schema(), other.postalName);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.street)) {
        this.street = data().deepCopy(fields()[6].schema(), other.street);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Address instance
     * @param other The existing instance to copy.
     */
    private Builder(net.stefanfuchs.fux.avro.dto.ad.Address other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.addressUuid)) {
        this.addressUuid = data().deepCopy(fields()[0].schema(), other.addressUuid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.country)) {
        this.country = data().deepCopy(fields()[1].schema(), other.country);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.province)) {
        this.province = data().deepCopy(fields()[2].schema(), other.province);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.district)) {
        this.district = data().deepCopy(fields()[3].schema(), other.district);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.postCode)) {
        this.postCode = data().deepCopy(fields()[4].schema(), other.postCode);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.postalName)) {
        this.postalName = data().deepCopy(fields()[5].schema(), other.postalName);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.street)) {
        this.street = data().deepCopy(fields()[6].schema(), other.street);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'addressUuid' field.
      * primary key
      * @return The value.
      */
    public java.lang.CharSequence getAddressUuid() {
      return addressUuid;
    }

    /**
      * Sets the value of the 'addressUuid' field.
      * primary key
      * @param value The value of 'addressUuid'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder setAddressUuid(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.addressUuid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'addressUuid' field has been set.
      * primary key
      * @return True if the 'addressUuid' field has been set, false otherwise.
      */
    public boolean hasAddressUuid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'addressUuid' field.
      * primary key
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder clearAddressUuid() {
      addressUuid = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'country' field.
      * country code
      * @return The value.
      */
    public java.lang.CharSequence getCountry() {
      return country;
    }

    /**
      * Sets the value of the 'country' field.
      * country code
      * @param value The value of 'country'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder setCountry(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.country = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'country' field has been set.
      * country code
      * @return True if the 'country' field has been set, false otherwise.
      */
    public boolean hasCountry() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'country' field.
      * country code
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder clearCountry() {
      country = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'province' field.
      * name of the provice (state)
      * @return The value.
      */
    public java.lang.CharSequence getProvince() {
      return province;
    }

    /**
      * Sets the value of the 'province' field.
      * name of the provice (state)
      * @param value The value of 'province'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder setProvince(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.province = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'province' field has been set.
      * name of the provice (state)
      * @return True if the 'province' field has been set, false otherwise.
      */
    public boolean hasProvince() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'province' field.
      * name of the provice (state)
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder clearProvince() {
      province = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'district' field.
      * The district the address belongs to
      * @return The value.
      */
    public java.lang.CharSequence getDistrict() {
      return district;
    }

    /**
      * Sets the value of the 'district' field.
      * The district the address belongs to
      * @param value The value of 'district'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder setDistrict(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.district = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'district' field has been set.
      * The district the address belongs to
      * @return True if the 'district' field has been set, false otherwise.
      */
    public boolean hasDistrict() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'district' field.
      * The district the address belongs to
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder clearDistrict() {
      district = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'postCode' field.
      * postal (zip) code
      * @return The value.
      */
    public java.lang.CharSequence getPostCode() {
      return postCode;
    }

    /**
      * Sets the value of the 'postCode' field.
      * postal (zip) code
      * @param value The value of 'postCode'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder setPostCode(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.postCode = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'postCode' field has been set.
      * postal (zip) code
      * @return True if the 'postCode' field has been set, false otherwise.
      */
    public boolean hasPostCode() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'postCode' field.
      * postal (zip) code
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder clearPostCode() {
      postCode = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'postalName' field.
      * city name
      * @return The value.
      */
    public java.lang.CharSequence getPostalName() {
      return postalName;
    }

    /**
      * Sets the value of the 'postalName' field.
      * city name
      * @param value The value of 'postalName'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder setPostalName(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.postalName = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'postalName' field has been set.
      * city name
      * @return True if the 'postalName' field has been set, false otherwise.
      */
    public boolean hasPostalName() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'postalName' field.
      * city name
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder clearPostalName() {
      postalName = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'street' field.
      * street including housnaumer etc.
      * @return The value.
      */
    public java.lang.CharSequence getStreet() {
      return street;
    }

    /**
      * Sets the value of the 'street' field.
      * street including housnaumer etc.
      * @param value The value of 'street'.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder setStreet(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.street = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'street' field has been set.
      * street including housnaumer etc.
      * @return True if the 'street' field has been set, false otherwise.
      */
    public boolean hasStreet() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'street' field.
      * street including housnaumer etc.
      * @return This builder.
      */
    public net.stefanfuchs.fux.avro.dto.ad.Address.Builder clearStreet() {
      street = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Address build() {
      try {
        Address record = new Address();
        record.addressUuid = fieldSetFlags()[0] ? this.addressUuid : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.country = fieldSetFlags()[1] ? this.country : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.province = fieldSetFlags()[2] ? this.province : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.district = fieldSetFlags()[3] ? this.district : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.postCode = fieldSetFlags()[4] ? this.postCode : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.postalName = fieldSetFlags()[5] ? this.postalName : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.street = fieldSetFlags()[6] ? this.street : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Address>
    WRITER$ = (org.apache.avro.io.DatumWriter<Address>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Address>
    READER$ = (org.apache.avro.io.DatumReader<Address>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}