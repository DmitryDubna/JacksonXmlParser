package com.example.jacksonxmlparser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OdataMetadataXmlParser {

    public static OdataMetadata parse(final String xml) throws IOException {
//        XmlMapper xmlMapper = new XmlMapper();
//        JsonNode node = xmlMapper.readTree(xml.getBytes());
//        System.out.println(node.toPrettyString());

//        ObjectMapper jsonMapper = new ObjectMapper();
//        String json = jsonMapper.writeValueAsString(node);
//        System.out.println(json);

        XmlMapper xmlMapper = new XmlMapper();
        OdataMetadata odataMetadata = xmlMapper.readValue(xml, OdataMetadata.class);

//        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        var json = xmlMapper.writeValueAsString(odataMetadata);
//        System.out.println("json:\n" + json);

        return odataMetadata;
    }

//    @XmlRootElement(name = "Edmx", namespace = edmxNamespace)
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonRootName("Edmx")
    static class OdataMetadata {
        @JacksonXmlProperty(localName = "Version", isAttribute = true)
        private String version;

        @JacksonXmlElementWrapper(localName = "DataServices")
        @JacksonXmlProperty(localName = "Schema")
        private List<Schema> dataServices;

        public Map<String, String> toPropertyTypes()
        {
            return dataServices.stream()
                    .filter(schema -> Objects.nonNull(schema.getEntityTypes()))
                    .flatMap(schema -> schema.getEntityTypes().stream())
                    .filter(entityType -> Objects.nonNull(entityType.getProperties()))
                    .flatMap(entityType -> entityType.getProperties().stream())
                    .distinct()
                    .peek(System.out::println)
                    .collect(Collectors.toMap(Property::getName, Property::getType));
        }
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Schema {
        @JacksonXmlProperty(localName = "Namespace", isAttribute = true)
        private String namespace;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "EntityType")
        private List<EntityType> entityTypes;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "ComplexType")
        private List<ComplexType> complexTypes;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Association")
        private List<Association> associations;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "EnumType")
        private List<EnumType> enumTypes;

        @JacksonXmlElementWrapper(localName = "EntityContainer")
        @JacksonXmlProperty(localName = "EntitySet")
        private List<EntitySet> entityContainer;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class EntityType {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "OpenType", isAttribute = true)
        private boolean openType;

        @JacksonXmlProperty(localName = "Key")
        private Key key;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Property")
        private List<Property> properties;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "NavigationProperty")
        private List<NavigationProperty> navigationProperties;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class ComplexType {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Property")
        private List<Property> properties;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Association {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "End")
        private List<End> ends;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class EnumType {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "UnderlyingType", isAttribute = true)
        private String underlyingType;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Member")
        private List<Member> members;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Key {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "PropertyRef")
        private List<PropertyRef> propertyRefs;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class PropertyRef {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;
    }

    @Getter
    @ToString()
    @EqualsAndHashCode()
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Property {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "Type", isAttribute = true)
        private String type;

        @JacksonXmlProperty(localName = "Nullable", isAttribute = true)
        private boolean isNullable;
    }

    @Getter
    @ToString()
    @EqualsAndHashCode()
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class NavigationProperty {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "Relationship", isAttribute = true)
        private String relationship;

        @JacksonXmlProperty(localName = "FromRole", isAttribute = true)
        private String fromRole;

        @JacksonXmlProperty(localName = "ToRole", isAttribute = true)
        private String toRole;
    }

    @Getter
    @ToString()
    @EqualsAndHashCode()
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class End {
        @JacksonXmlProperty(localName = "Role", isAttribute = true)
        private String role;

        @JacksonXmlProperty(localName = "Type", isAttribute = true)
        private String type;

        @JacksonXmlProperty(localName = "Multiplicity", isAttribute = true)
        private String multiplicity;
    }


    @ToString(callSuper = true)
    static class Member extends PropertyRef {
    }

    @Getter
    @ToString
    @EqualsAndHashCode()
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class EntitySet {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "EntityType", isAttribute = true)
        private String entityType;
    }
}
