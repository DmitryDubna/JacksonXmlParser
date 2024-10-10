package com.example.jacksonxmlparser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
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
//
//        System.out.println(json);

        XmlMapper xmlMapper = new XmlMapper();
        OdataMetadata odataMetadata = xmlMapper.readValue(xml, OdataMetadata.class);
//        System.out.println(odataMetadata);

//        XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        var json = xmlMapper.writeValueAsString(new OdataMetadata());
//        System.out.println(json);

        return odataMetadata;
    }

//    @XmlRootElement(name = "Edmx", namespace = edmxNamespace)
    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonRootName("Edmx")
    static class OdataMetadata {
        @JacksonXmlProperty(localName = "Version", isAttribute = true)
        private String version/* = "1.0"*/;

        @JacksonXmlElementWrapper(localName = "DataServices")
        @JacksonXmlProperty(localName = "Schema")
        private List<Schema> dataServices/* = List.of(new Schema())*/;

        public Map<String, String> toPropertyTypes()
        {
            return dataServices.stream()
                    .filter(schema -> Objects.nonNull(schema.getEntityTypes()))
                    .flatMap(schema -> schema.getEntityTypes().stream())
                    .filter(entityType -> Objects.nonNull(entityType.getProperties()))
                    .flatMap(entityType -> entityType.getProperties().stream())
                    .distinct()
                    .collect(Collectors.toMap(Property::getName, Property::getType));
        }
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Schema {
        @JacksonXmlProperty(localName = "Namespace", isAttribute = true)
        private String namespace/* = "my-namespace"*/;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "EntityType")
        private List<EntityType> entityTypes/* = List.of(new EntityType())*/;

        @JacksonXmlElementWrapper(localName = "EntityContainer")
        @JacksonXmlProperty(localName = "EntitySet")
        private List<EntitySet> entityContainer/* = List.of(new EntitySet())*/;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class EntityType {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name/* = "my-name"*/;

        @JacksonXmlProperty(localName = "Key")
        private Key key/* = new Key()*/;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Property")
        private List<Property> properties/* = List.of(new Property())*/;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Key {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name/* = "key-name"*/;

        @JacksonXmlProperty(localName = "PropertyRef")
        private PropertyRef propertyRef/* = new PropertyRef()*/;
    }

//    @Getter
//    @ToString
//    @EqualsAndHashCode
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    static class NamedItem {
//        @JacksonXmlProperty(localName = "Name", isAttribute = true)
//        private String name;
//    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class PropertyRef {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name/* = "ID"*/;
    }

    @Getter
    @ToString()
    @EqualsAndHashCode()
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Property {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name/* = "ID"*/;

        @JacksonXmlProperty(localName = "Type", isAttribute = true)
        private String type/* = "Edm.Guid"*/;

        @JacksonXmlProperty(localName = "Nullable", isAttribute = true)
        private boolean isNullable/* = true*/;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class EntitySet {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name/* = "Audit"*/;

        @JacksonXmlProperty(localName = "EntityType", isAttribute = true)
        private String entityType/* = "Visary.Audit.Data.Entities.EntityAuditEntry"*/;
    }
}
