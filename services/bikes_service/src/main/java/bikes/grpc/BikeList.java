// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bikes.proto
// Protobuf Java Version: 3.25.3
package bikes.grpc;

/**
 * Protobuf type {@code BikeList}
 */
public final class BikeList extends com.google.protobuf.GeneratedMessageV3 implements // @@protoc_insertion_point(message_implements:BikeList)
BikeListOrBuilder {

    private static final long serialVersionUID = 0L;

    // Use BikeList.newBuilder() to construct.
    private BikeList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private BikeList() {
        bikes_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({ "unused" })
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
        return new BikeList();
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return bikes.grpc.BikesOuterClass.internal_static_BikeList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return bikes.grpc.BikesOuterClass.internal_static_BikeList_fieldAccessorTable.ensureFieldAccessorsInitialized(bikes.grpc.BikeList.class, bikes.grpc.BikeList.Builder.class);
    }

    public static final int BIKES_FIELD_NUMBER = 1;

    @SuppressWarnings("serial")
    private java.util.List<bikes.grpc.Bike> bikes_;

    /**
     * <code>repeated .Bike bikes = 1;</code>
     */
    @java.lang.Override
    public java.util.List<bikes.grpc.Bike> getBikesList() {
        return bikes_;
    }

    /**
     * <code>repeated .Bike bikes = 1;</code>
     */
    @java.lang.Override
    public java.util.List<? extends bikes.grpc.BikeOrBuilder> getBikesOrBuilderList() {
        return bikes_;
    }

    /**
     * <code>repeated .Bike bikes = 1;</code>
     */
    @java.lang.Override
    public int getBikesCount() {
        return bikes_.size();
    }

    /**
     * <code>repeated .Bike bikes = 1;</code>
     */
    @java.lang.Override
    public bikes.grpc.Bike getBikes(int index) {
        return bikes_.get(index);
    }

    /**
     * <code>repeated .Bike bikes = 1;</code>
     */
    @java.lang.Override
    public bikes.grpc.BikeOrBuilder getBikesOrBuilder(int index) {
        return bikes_.get(index);
    }

    private byte memoizedIsInitialized = -1;

    @java.lang.Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1)
            return true;
        if (isInitialized == 0)
            return false;
        memoizedIsInitialized = 1;
        return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
        for (int i = 0; i < bikes_.size(); i++) {
            output.writeMessage(1, bikes_.get(i));
        }
        getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1)
            return size;
        size = 0;
        for (int i = 0; i < bikes_.size(); i++) {
            size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, bikes_.get(i));
        }
        size += getUnknownFields().getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bikes.grpc.BikeList)) {
            return super.equals(obj);
        }
        bikes.grpc.BikeList other = (bikes.grpc.BikeList) obj;
        if (!getBikesList().equals(other.getBikesList()))
            return false;
        if (!getUnknownFields().equals(other.getUnknownFields()))
            return false;
        return true;
    }

    @java.lang.Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        if (getBikesCount() > 0) {
            hash = (37 * hash) + BIKES_FIELD_NUMBER;
            hash = (53 * hash) + getBikesList().hashCode();
        }
        hash = (29 * hash) + getUnknownFields().hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static bikes.grpc.BikeList parseFrom(java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static bikes.grpc.BikeList parseFrom(java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static bikes.grpc.BikeList parseFrom(com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static bikes.grpc.BikeList parseFrom(com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static bikes.grpc.BikeList parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static bikes.grpc.BikeList parseFrom(byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static bikes.grpc.BikeList parseFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static bikes.grpc.BikeList parseFrom(java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static bikes.grpc.BikeList parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static bikes.grpc.BikeList parseDelimitedFrom(java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static bikes.grpc.BikeList parseFrom(com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static bikes.grpc.BikeList parseFrom(com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(bikes.grpc.BikeList prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    /**
     * Protobuf type {@code BikeList}
     */
    public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements // @@protoc_insertion_point(builder_implements:BikeList)
    bikes.grpc.BikeListOrBuilder {

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return bikes.grpc.BikesOuterClass.internal_static_BikeList_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return bikes.grpc.BikesOuterClass.internal_static_BikeList_fieldAccessorTable.ensureFieldAccessorsInitialized(bikes.grpc.BikeList.class, bikes.grpc.BikeList.Builder.class);
        }

        // Construct using bikes.grpc.BikeList.newBuilder()
        private Builder() {
        }

        private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            super(parent);
        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            bitField0_ = 0;
            if (bikesBuilder_ == null) {
                bikes_ = java.util.Collections.emptyList();
            } else {
                bikes_ = null;
                bikesBuilder_.clear();
            }
            bitField0_ = (bitField0_ & ~0x00000001);
            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return bikes.grpc.BikesOuterClass.internal_static_BikeList_descriptor;
        }

        @java.lang.Override
        public bikes.grpc.BikeList getDefaultInstanceForType() {
            return bikes.grpc.BikeList.getDefaultInstance();
        }

        @java.lang.Override
        public bikes.grpc.BikeList build() {
            bikes.grpc.BikeList result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public bikes.grpc.BikeList buildPartial() {
            bikes.grpc.BikeList result = new bikes.grpc.BikeList(this);
            buildPartialRepeatedFields(result);
            if (bitField0_ != 0) {
                buildPartial0(result);
            }
            onBuilt();
            return result;
        }

        private void buildPartialRepeatedFields(bikes.grpc.BikeList result) {
            if (bikesBuilder_ == null) {
                if (((bitField0_ & 0x00000001) != 0)) {
                    bikes_ = java.util.Collections.unmodifiableList(bikes_);
                    bitField0_ = (bitField0_ & ~0x00000001);
                }
                result.bikes_ = bikes_;
            } else {
                result.bikes_ = bikesBuilder_.build();
            }
        }

        private void buildPartial0(bikes.grpc.BikeList result) {
            int from_bitField0_ = bitField0_;
        }

        @java.lang.Override
        public Builder clone() {
            return super.clone();
        }

        @java.lang.Override
        public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
            return super.setField(field, value);
        }

        @java.lang.Override
        public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
            return super.clearField(field);
        }

        @java.lang.Override
        public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return super.clearOneof(oneof);
        }

        @java.lang.Override
        public Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
            return super.setRepeatedField(field, index, value);
        }

        @java.lang.Override
        public Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
            return super.addRepeatedField(field, value);
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof bikes.grpc.BikeList) {
                return mergeFrom((bikes.grpc.BikeList) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(bikes.grpc.BikeList other) {
            if (other == bikes.grpc.BikeList.getDefaultInstance())
                return this;
            if (bikesBuilder_ == null) {
                if (!other.bikes_.isEmpty()) {
                    if (bikes_.isEmpty()) {
                        bikes_ = other.bikes_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                    } else {
                        ensureBikesIsMutable();
                        bikes_.addAll(other.bikes_);
                    }
                    onChanged();
                }
            } else {
                if (!other.bikes_.isEmpty()) {
                    if (bikesBuilder_.isEmpty()) {
                        bikesBuilder_.dispose();
                        bikesBuilder_ = null;
                        bikes_ = other.bikes_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                        bikesBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getBikesFieldBuilder() : null;
                    } else {
                        bikesBuilder_.addAllMessages(other.bikes_);
                    }
                }
            }
            this.mergeUnknownFields(other.getUnknownFields());
            onChanged();
            return this;
        }

        @java.lang.Override
        public final boolean isInitialized() {
            return true;
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch(tag) {
                        case 0:
                            done = true;
                            break;
                        case 10:
                            {
                                bikes.grpc.Bike m = input.readMessage(bikes.grpc.Bike.parser(), extensionRegistry);
                                if (bikesBuilder_ == null) {
                                    ensureBikesIsMutable();
                                    bikes_.add(m);
                                } else {
                                    bikesBuilder_.addMessage(m);
                                }
                                break;
                            }
                        // case 10
                        default:
                            {
                                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                                    // was an endgroup tag
                                    done = true;
                                }
                                break;
                            }
                    }
                    // switch (tag)
                }
                // while (!done)
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.unwrapIOException();
            } finally {
                onChanged();
            }
            // finally
            return this;
        }

        private int bitField0_;

        private java.util.List<bikes.grpc.Bike> bikes_ = java.util.Collections.emptyList();

        private void ensureBikesIsMutable() {
            if (!((bitField0_ & 0x00000001) != 0)) {
                bikes_ = new java.util.ArrayList<bikes.grpc.Bike>(bikes_);
                bitField0_ |= 0x00000001;
            }
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<bikes.grpc.Bike, bikes.grpc.Bike.Builder, bikes.grpc.BikeOrBuilder> bikesBuilder_;

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public java.util.List<bikes.grpc.Bike> getBikesList() {
            if (bikesBuilder_ == null) {
                return java.util.Collections.unmodifiableList(bikes_);
            } else {
                return bikesBuilder_.getMessageList();
            }
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public int getBikesCount() {
            if (bikesBuilder_ == null) {
                return bikes_.size();
            } else {
                return bikesBuilder_.getCount();
            }
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public bikes.grpc.Bike getBikes(int index) {
            if (bikesBuilder_ == null) {
                return bikes_.get(index);
            } else {
                return bikesBuilder_.getMessage(index);
            }
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder setBikes(int index, bikes.grpc.Bike value) {
            if (bikesBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureBikesIsMutable();
                bikes_.set(index, value);
                onChanged();
            } else {
                bikesBuilder_.setMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder setBikes(int index, bikes.grpc.Bike.Builder builderForValue) {
            if (bikesBuilder_ == null) {
                ensureBikesIsMutable();
                bikes_.set(index, builderForValue.build());
                onChanged();
            } else {
                bikesBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder addBikes(bikes.grpc.Bike value) {
            if (bikesBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureBikesIsMutable();
                bikes_.add(value);
                onChanged();
            } else {
                bikesBuilder_.addMessage(value);
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder addBikes(int index, bikes.grpc.Bike value) {
            if (bikesBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureBikesIsMutable();
                bikes_.add(index, value);
                onChanged();
            } else {
                bikesBuilder_.addMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder addBikes(bikes.grpc.Bike.Builder builderForValue) {
            if (bikesBuilder_ == null) {
                ensureBikesIsMutable();
                bikes_.add(builderForValue.build());
                onChanged();
            } else {
                bikesBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder addBikes(int index, bikes.grpc.Bike.Builder builderForValue) {
            if (bikesBuilder_ == null) {
                ensureBikesIsMutable();
                bikes_.add(index, builderForValue.build());
                onChanged();
            } else {
                bikesBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder addAllBikes(java.lang.Iterable<? extends bikes.grpc.Bike> values) {
            if (bikesBuilder_ == null) {
                ensureBikesIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, bikes_);
                onChanged();
            } else {
                bikesBuilder_.addAllMessages(values);
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder clearBikes() {
            if (bikesBuilder_ == null) {
                bikes_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
                onChanged();
            } else {
                bikesBuilder_.clear();
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public Builder removeBikes(int index) {
            if (bikesBuilder_ == null) {
                ensureBikesIsMutable();
                bikes_.remove(index);
                onChanged();
            } else {
                bikesBuilder_.remove(index);
            }
            return this;
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public bikes.grpc.Bike.Builder getBikesBuilder(int index) {
            return getBikesFieldBuilder().getBuilder(index);
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public bikes.grpc.BikeOrBuilder getBikesOrBuilder(int index) {
            if (bikesBuilder_ == null) {
                return bikes_.get(index);
            } else {
                return bikesBuilder_.getMessageOrBuilder(index);
            }
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public java.util.List<? extends bikes.grpc.BikeOrBuilder> getBikesOrBuilderList() {
            if (bikesBuilder_ != null) {
                return bikesBuilder_.getMessageOrBuilderList();
            } else {
                return java.util.Collections.unmodifiableList(bikes_);
            }
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public bikes.grpc.Bike.Builder addBikesBuilder() {
            return getBikesFieldBuilder().addBuilder(bikes.grpc.Bike.getDefaultInstance());
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public bikes.grpc.Bike.Builder addBikesBuilder(int index) {
            return getBikesFieldBuilder().addBuilder(index, bikes.grpc.Bike.getDefaultInstance());
        }

        /**
         * <code>repeated .Bike bikes = 1;</code>
         */
        public java.util.List<bikes.grpc.Bike.Builder> getBikesBuilderList() {
            return getBikesFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<bikes.grpc.Bike, bikes.grpc.Bike.Builder, bikes.grpc.BikeOrBuilder> getBikesFieldBuilder() {
            if (bikesBuilder_ == null) {
                bikesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<bikes.grpc.Bike, bikes.grpc.Bike.Builder, bikes.grpc.BikeOrBuilder>(bikes_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
                bikes_ = null;
            }
            return bikesBuilder_;
        }

        @java.lang.Override
        public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFields(unknownFields);
        }

        @java.lang.Override
        public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }
        // @@protoc_insertion_point(builder_scope:BikeList)
    }

    // @@protoc_insertion_point(class_scope:BikeList)
    private static final bikes.grpc.BikeList DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new bikes.grpc.BikeList();
    }

    public static bikes.grpc.BikeList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BikeList> PARSER = new com.google.protobuf.AbstractParser<BikeList>() {

        @java.lang.Override
        public BikeList parsePartialFrom(com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
            Builder builder = newBuilder();
            try {
                builder.mergeFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builder.buildPartial());
            } catch (com.google.protobuf.UninitializedMessageException e) {
                throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(builder.buildPartial());
            }
            return builder.buildPartial();
        }
    };

    public static com.google.protobuf.Parser<BikeList> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BikeList> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public bikes.grpc.BikeList getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
