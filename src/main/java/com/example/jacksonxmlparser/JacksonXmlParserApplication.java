package com.example.jacksonxmlparser;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@SpringBootApplication
public class JacksonXmlParserApplication {

    public static void main(String[] args) {
        try {
//            String xml = Files.readString(Paths.get("/home/dmitry/work/JavaProjects/JacksonXmlParser/data.xml"));

            OdataMetadataXmlParser.OdataMetadata data = OdataMetadataXmlParser.parse(xml);
            System.out.println(data);
            var types = data.toPropertyTypes();
            System.out.println("PropertyTypes:\n" + types);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final static String xml = """
            <?xml version="1.0" encoding="utf-8"?>
            <edmx:Edmx Version="4.0" xmlns:edmx="http://docs.oasis-open.org/odata/ns/edmx">
                <edmx:DataServices>
                    <Schema Namespace="Visary.Audit.Data.Entities" xmlns="http://docs.oasis-open.org/odata/ns/edm">
                        <EntityType Name="EntityAuditEntry" OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="LineNumber"/>
                                <PropertyRef Name="Recorder_Type"/>
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
                            <NavigationProperty Name="ВалютаCr"
                                    Relationship="StandardODATA.AccountingRegister_Хозрасчетный_RecordType_ВалютаCr"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="ПодразделениеDr"
                                    Relationship="StandardODATA.AccountingRegister_Хозрасчетный_RecordType_ПодразделениеDr"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="ПодразделениеCr"
                                    Relationship="StandardODATA.AccountingRegister_Хозрасчетный_RecordType_ПодразделениеCr"
                                    FromRole="Begin"
                                    ToRole="End"/>
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
                        <ComplexType Name="AccumulationRegister_ЗакупленныеТоварыКомитентов_Balance">
                            <Property Name="Организация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Контрагент_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ДоговорКонтрагента_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Номенклатура_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Партия"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="КоличествоBalance"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаBalance"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаНДСBalance"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Партия_Type"
                                    Type="Edm.String"
                                    Nullable="true"/>
                        </ComplexType>
                        <ComplexType Name="AccumulationRegister_ВыработкаМатериалов_RowType">
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="Period"
                                    Type="Edm.DateTime"
                                    Nullable="true"/>
                            <Property Name="LineNumber"
                                    Type="Edm.Int64"
                                    Nullable="false"/>
                            <Property Name="Active"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="Организация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Номенклатура_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Количество"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                        </ComplexType>
                        <Association Name="AccountingRegister_Хозрасчетный_RecordType_AccountDr">
                            <End Role="Begin"
                                    Type="StandardODATA.AccountingRegister_Хозрасчетный_RecordType"
                                    Multiplicity="*"/>
                            <End Role="End"
                                    Type="StandardODATA.ChartOfAccounts_Хозрасчетный"
                                    Multiplicity="0..1"/>
                        </Association>
                        <Association Name="AccountingRegister_Хозрасчетный_RecordType_AccountCr">
                            <End Role="Begin"
                                    Type="StandardODATA.AccountingRegister_Хозрасчетный_RecordType"
                                    Multiplicity="*"/>
                            <End Role="End"
                                    Type="StandardODATA.ChartOfAccounts_Хозрасчетный"
                                    Multiplicity="0..1"/>
                        </Association>
                        <EnumType Name="ЧастиЖурналаУчетаСчетовФактур"
                                UnderlyingType="Edm.Int32">
                            <Member Name="ВыставленныеСчетаФактуры"/>
                            <Member Name="ПолученныеСчетаФактуры"/>
                        </EnumType>
                        <EnumType Name="ХарактерВыплатыЗарплаты"
                                UnderlyingType="Edm.Int32">
                            <Member Name="Аванс"/>
                            <Member Name="Зарплата"/>
                            <Member Name="Межрасчет"/>
                        </EnumType>
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
