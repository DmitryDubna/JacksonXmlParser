package com.example.jacksonxmlparser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

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

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonRootName("Edmx")
    static class OdataMetadata {
        @JacksonXmlProperty(localName = "Version", isAttribute = true)
        private String version;

        @JacksonXmlElementWrapper(localName = "DataServices")
        @JacksonXmlProperty(localName = "Schema")
        private List<Schema> dataServices;

        public Map<String, String> toPropertyTypes(final String entityName)
        {
            var entityTypeName = dataServices.stream()
                    .filter(schema -> Objects.nonNull(schema.getEntityContainer()))
                    .flatMap(schema -> schema.getEntityContainer().getEntitySets().stream())
                    .filter(entitySet -> entitySet.getName().equalsIgnoreCase(entityName))
                    .map(EntitySet::getEntityType)
                    .findFirst()
                    .orElse(null);

            if (Objects.isNull(entityTypeName))
                return Map.of();

            return dataServices.stream()
                    .filter(schema -> entityTypeName.startsWith(schema.getNamespace()))
                    .flatMap(schema -> schema.getEntityTypes().stream())
                    .filter(entityType -> entityTypeName.endsWith(entityType.getName()))
                    .flatMap(entityType -> entityType.getProperties().stream())
                    .collect(Collectors.toMap(Property::getName, Property::getType));
        }
    }

    @Data
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

        @JacksonXmlProperty(localName = "EntityContainer")
        private EntityContainer entityContainer;
    }

    @Data
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

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class ComplexType {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "Property")
        private List<Property> properties;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Association {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "End")
        private List<End> ends;
    }

    @Data
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

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class EntityContainer {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "IsDefaultEntityContainer", isAttribute = true)
        private boolean isDefaultEntityContainer;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "EntitySet")
        private List<EntitySet> entitySets;

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "FunctionImport")
        private List<FunctionImport> functionImports;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Key {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "PropertyRef")
        private List<PropertyRef> propertyRefs;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class PropertyRef {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Property {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "Type", isAttribute = true)
        private String type;

        @JacksonXmlProperty(localName = "Nullable", isAttribute = true)
        private boolean isNullable;
    }

    @Data
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

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class End {
        @JacksonXmlProperty(localName = "Role", isAttribute = true)
        private String role;

        @JacksonXmlProperty(localName = "Type", isAttribute = true)
        private String type;

        @JacksonXmlProperty(localName = "Multiplicity", isAttribute = true)
        private String multiplicity;
    }


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Member {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class EntitySet {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "EntityType", isAttribute = true)
        private String entityType;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class FunctionImport {
        @JacksonXmlProperty(localName = "Name", isAttribute = true)
        private String name;

        @JacksonXmlProperty(localName = "IsBindable", isAttribute = true)
        private boolean isBindable;

        @JacksonXmlProperty(localName = "IsSideEffecting", isAttribute = true)
        private boolean isSideEffecting;
    }
}
