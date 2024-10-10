package com.example.jacksonxmlparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class JacksonXmlParserApplication {

    public static void main(String[] args) {
        try {
            OdataMetadataXmlParser.OdataMetadata data = OdataMetadataXmlParser.parse(xml);
            Map<String, String> types = data.toPropertyTypes();
            System.out.println(types);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final static String xml = """
            <?xml version="1.0" encoding="utf-8"?>
            <edmx:Edmx Version="4.0" xmlns:edmx="http://docs.oasis-open.org/odata/ns/edmx">
                <edmx:DataServices>
                    <Schema Namespace="Visary.Audit.Data.Entities" xmlns="http://docs.oasis-open.org/odata/ns/edm">
                        <EntityType Name="EntityAuditEntry">
                            <Key>
                                <PropertyRef Name="ID"/>
                            </Key>
                            <Property Name="ID" Type="Edm.Int32" Nullable="false"/>
                            <Property Name="Hidden" Type="Edm.Boolean" Nullable="false"/>
                            <Property Name="EventId" Type="Edm.Guid" Nullable="false"/>
                            <Property Name="EventType" Type="Edm.String"/>
                            <Property Name="EventName" Type="Edm.String"/>
                            <Property Name="EntityId" Type="Edm.Int32" Nullable="false"/>
                            <Property Name="EntityType" Type="Edm.String"/>
                            <Property Name="EntityVersion" Type="Edm.Int64" Nullable="false"/>
                            <Property Name="Info" Type="Edm.String"/>
                            <Property Name="UserId" Type="Edm.Int32"/>
                            <Property Name="Data" Type="Edm.String"/>
                            <Property Name="Date" Type="Edm.DateTimeOffset" Nullable="false"/>
                            <Property Name="Source" Type="Edm.String"/>
                            <Property Name="Ip" Type="Edm.String"/>
                            <Property Name="UserAgent" Type="Edm.String"/>
                        </EntityType>
                        <EntityType Name="IdentityAuditEntry">
                            <Key>
                                <PropertyRef Name="ID"/>
                            </Key>
                            <Property Name="ID" Type="Edm.Int32" Nullable="false"/>
                            <Property Name="Hidden" Type="Edm.Boolean" Nullable="false"/>
                            <Property Name="EventId" Type="Edm.Guid" Nullable="false"/>
                            <Property Name="Date" Type="Edm.DateTimeOffset" Nullable="false"/>
                            <Property Name="UserId" Type="Edm.Int32"/>
                            <Property Name="AccountId" Type="Edm.Int32" Nullable="false"/>
                            <Property Name="EventType" Type="Edm.String"/>
                            <Property Name="EventName" Type="Edm.String"/>
                            <Property Name="Data" Type="Edm.String"/>
                            <Property Name="Ip" Type="Edm.String"/>
                            <Property Name="UserAgent" Type="Edm.String"/>
                        </EntityType>
                    </Schema>
                    <Schema Namespace="Default" xmlns="http://docs.oasis-open.org/odata/ns/edm">
                        <EntityContainer Name="Container">
                            <EntitySet Name="Audit" EntityType="Visary.Audit.Data.Entities.EntityAuditEntry"/>
                            <EntitySet Name="Identity" EntityType="Visary.Audit.Data.Entities.IdentityAuditEntry"/>
                        </EntityContainer>
                    </Schema>
                </edmx:DataServices>
            </edmx:Edmx>
            """;
}
