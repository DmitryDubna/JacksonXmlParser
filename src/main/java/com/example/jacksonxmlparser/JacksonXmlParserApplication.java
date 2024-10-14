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
            var types = data.toPropertyTypes("AccountingRegister_Хозрасчетный_RecordType");
            System.out.println("PropertyTypes:\n" + types);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final static String xml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <edmx:Edmx xmlns:edmx="http://schemas.microsoft.com/ado/2007/06/edmx"
                    Version="1.0">
                <edmx:DataServices xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata"
                        m:DataServiceVersion="3.0"
                        m:MaxDataServiceVersion="3.0">
                    <Schema xmlns="http://schemas.microsoft.com/ado/2009/11/edm"
                            Namespace="StandardODATA">
                        <EntityType Name="AccountingRegister_Хозрасчетный"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="RecordSet"
                                    Type="Collection(StandardODATA.AccountingRegister_Хозрасчетный_RowType)"
                                    Nullable="false"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                        </EntityType>
                        <EntityType Name="AccountingRegister_Хозрасчетный_RecordType"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="LineNumber"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
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
                            <Property Name="AccountDr_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="AccountCr_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Организация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ВалютаDr_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ВалютаCr_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ПодразделениеDr_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ПодразделениеCr_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Сумма"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="ВалютнаяСуммаDr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="ВалютнаяСуммаCr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="КоличествоDr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="КоличествоCr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаНУDr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаНУCr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаПРDr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаПРCr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаВРDr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаВРCr"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Содержание"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="НеКорректироватьСтоимостьАвтоматически"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <NavigationProperty Name="AccountDr"
                                    Relationship="StandardODATA.AccountingRegister_Хозрасчетный_RecordType_AccountDr"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="AccountCr"
                                    Relationship="StandardODATA.AccountingRegister_Хозрасчетный_RecordType_AccountCr"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Организация"
                                    Relationship="StandardODATA.AccountingRegister_Хозрасчетный_RecordType_Организация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="ВалютаDr"
                                    Relationship="StandardODATA.AccountingRegister_Хозрасчетный_RecordType_ВалютаDr"
                                    FromRole="Begin"
                                    ToRole="End"/>
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
                        <EntityType Name="AccumulationRegister_СведенияОДоходахСтраховыеВзносы"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="RecordSet"
                                    Type="Collection(StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RowType)"
                                    Nullable="false"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="LineNumber"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
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
                            <Property Name="ГоловнаяОрганизация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ФизическоеЛицо_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Организация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ВидДохода_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ОблагаетсяЕНВД"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="ЯвляетсяДоходомФармацевта"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="ОблагаетсяВзносамиНаДоплатуЛетчикам"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="ОблагаетсяВзносамиНаДоплатуШахтерам"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="ЯвляетсяДоходомЧленаЭкипажаСуднаПодФлагомРФ"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="ОблагаетсяВзносамиЗаЗанятыхНаРаботахСДосрочнойПенсией"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="КлассУсловийТруда"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="ЛьготныйТерриториальныйТариф_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="УдалитьВидДохода_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Сумма"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Скидка"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Сотрудник_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Начисление"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="Подразделение_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ДатаНачала"
                                    Type="Edm.DateTime"
                                    Nullable="true"/>
                            <Property Name="ДатаПолученияДохода"
                                    Type="Edm.DateTime"
                                    Nullable="true"/>
                            <Property Name="ПоАктуПроверки"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="Начисление_Type"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <NavigationProperty Name="ГоловнаяОрганизация"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_ГоловнаяОрганизация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="ФизическоеЛицо"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_ФизическоеЛицо"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Организация"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_Организация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="ВидДохода"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_ВидДохода"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="ЛьготныйТерриториальныйТариф"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_ЛьготныйТерриториальныйТариф"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="УдалитьВидДохода"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_УдалитьВидДохода"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Сотрудник"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_Сотрудник"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Подразделение"
                                    Relationship="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType_Подразделение"
                                    FromRole="Begin"
                                    ToRole="End"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="RecordSet"
                                    Type="Collection(StandardODATA.AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению_RowType)"
                                    Nullable="false"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению_RecordType"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="LineNumber"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
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
                            <Property Name="RecordType"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="Организация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="РегистрацияВНалоговомОргане_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="РеквизитыПлатежногоПоручения"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="ДатаПлатежа"
                                    Type="Edm.DateTime"
                                    Nullable="true"/>
                            <Property Name="Ставка"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="МесяцНалоговогоПериода"
                                    Type="Edm.DateTime"
                                    Nullable="true"/>
                            <Property Name="Сумма"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <NavigationProperty Name="Организация"
                                    Relationship="StandardODATA.AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению_RecordType_Организация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="РегистрацияВНалоговомОргане"
                                    Relationship="StandardODATA.AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению_RecordType_РегистрацияВНалоговомОргане"
                                    FromRole="Begin"
                                    ToRole="End"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="RecordSet"
                                    Type="Collection(StandardODATA.AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС_RowType)"
                                    Nullable="false"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС_RecordType"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="LineNumber"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
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
                            <Property Name="RecordType"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="ОсновноеСредство_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Организация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="СрокИспользования"
                                    Type="Edm.Int64"
                                    Nullable="true"/>
                            <Property Name="ЭтоАмортизация"
                                    Type="Edm.Boolean"
                                    Nullable="true"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <NavigationProperty Name="ОсновноеСредство"
                                    Relationship="StandardODATA.AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС_RecordType_ОсновноеСредство"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Организация"
                                    Relationship="StandardODATA.AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС_RecordType_Организация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_РеализованныеТоварыКомитентов"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="RecordSet"
                                    Type="Collection(StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RowType)"
                                    Nullable="false"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_РеализованныеТоварыКомитентов_RecordType"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="LineNumber"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
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
                            <Property Name="RecordType"
                                    Type="Edm.String"
                                    Nullable="true"/>
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
                            <Property Name="Покупатель_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="ДатаРеализации"
                                    Type="Edm.DateTime"
                                    Nullable="true"/>
                            <Property Name="ДокументРасчетов"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="Количество"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Выручка"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаПоступления"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="СуммаНДС"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="Субкомиссионер_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="СчетФактураСубкомиссионера_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="ДокументРасчетов_Type"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <NavigationProperty Name="Организация"
                                    Relationship="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType_Организация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Контрагент"
                                    Relationship="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType_Контрагент"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="ДоговорКонтрагента"
                                    Relationship="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType_ДоговорКонтрагента"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Номенклатура"
                                    Relationship="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType_Номенклатура"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Покупатель"
                                    Relationship="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType_Покупатель"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Субкомиссионер"
                                    Relationship="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType_Субкомиссионер"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="СчетФактураСубкомиссионера"
                                    Relationship="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType_СчетФактураСубкомиссионера"
                                    FromRole="Begin"
                                    ToRole="End"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="RecordSet"
                                    Type="Collection(StandardODATA.AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете_RowType)"
                                    Nullable="false"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете_RecordType"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="LineNumber"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
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
                            <Property Name="RecordType"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="ГоловнаяОрганизация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Организация_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="СчетУчета_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="Налог_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="КодБК"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="РегистрацияВНалоговомОргане_Key"
                                    Type="Edm.Guid"
                                    Nullable="true"/>
                            <Property Name="КодПоОКТМО"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="СрокУплаты"
                                    Type="Edm.DateTime"
                                    Nullable="true"/>
                            <Property Name="Сумма"
                                    Type="Edm.Double"
                                    Nullable="true"/>
                            <Property Name="ПлатежныйДокумент"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="ПлатежныйДокумент_Type"
                                    Type="Edm.String"
                                    Nullable="true"/>
                            <NavigationProperty Name="ГоловнаяОрганизация"
                                    Relationship="StandardODATA.AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете_RecordType_ГоловнаяОрганизация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Организация"
                                    Relationship="StandardODATA.AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете_RecordType_Организация"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="СчетУчета"
                                    Relationship="StandardODATA.AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете_RecordType_СчетУчета"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="Налог"
                                    Relationship="StandardODATA.AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете_RecordType_Налог"
                                    FromRole="Begin"
                                    ToRole="End"/>
                            <NavigationProperty Name="РегистрацияВНалоговомОргане"
                                    Relationship="StandardODATA.AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете_RecordType_РегистрацияВНалоговомОргане"
                                    FromRole="Begin"
                                    ToRole="End"/>
                        </EntityType>
                        <EntityType Name="AccumulationRegister_РасчетыНалоговыхАгентовСБюджетомПоНДФЛ"
                                OpenType="true">
                            <Key>
                                <PropertyRef Name="Recorder"/>
                                <PropertyRef Name="Recorder_Type"/>
                            </Key>
                            <Property Name="Recorder"
                                    Type="Edm.String"
                                    Nullable="false"/>
                            <Property Name="RecordSet"
                                    Type="Collection(StandardODATA.AccumulationRegister_РасчетыНалоговыхАгентовСБюджетомПоНДФЛ_RowType)"
                                    Nullable="false"/>
                            <Property Name="Recorder_Type"
                                    Type="Edm.String"
                                    Nullable="false"/>
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
                        <EntityContainer Name="EnterpriseV8"
                                m:IsDefaultEntityContainer="true">
                            <EntitySet Name="AccountingRegister_Хозрасчетный"
                                    EntityType="StandardODATA.AccountingRegister_Хозрасчетный"/>
                            <EntitySet Name="AccountingRegister_Хозрасчетный_RecordType"
                                    EntityType="StandardODATA.AccountingRegister_Хозрасчетный_RecordType"/>
                            <EntitySet Name="AccumulationRegister_СведенияОДоходахСтраховыеВзносы"
                                    EntityType="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы"/>
                            <EntitySet Name="AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType"
                                    EntityType="StandardODATA.AccumulationRegister_СведенияОДоходахСтраховыеВзносы_RecordType"/>
                            <EntitySet Name="AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению"
                                    EntityType="StandardODATA.AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению"/>
                            <EntitySet Name="AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению_RecordType"
                                    EntityType="StandardODATA.AccumulationRegister_УплатаНДФЛНалоговымиАгентамиКРаспределению_RecordType"/>
                            <EntitySet Name="AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС"
                                    EntityType="StandardODATA.AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС"/>
                            <EntitySet Name="AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС_RecordType"
                                    EntityType="StandardODATA.AccumulationRegister_СрокиИспользованияГрупповыхОбъектовОС_RecordType"/>
                            <EntitySet Name="AccumulationRegister_РеализованныеТоварыКомитентов"
                                    EntityType="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов"/>
                            <EntitySet Name="AccumulationRegister_РеализованныеТоварыКомитентов_RecordType"
                                    EntityType="StandardODATA.AccumulationRegister_РеализованныеТоварыКомитентов_RecordType"/>
                            <EntitySet Name="AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете"
                                    EntityType="StandardODATA.AccumulationRegister_РасчетыПоНалогамНаЕдиномНалоговомСчете"/>
                            <FunctionImport Name="Post"
                                    IsBindable="true"
                                    IsSideEffecting="true">
                            <Parameter Name="bindingParameter"
                                    Type="StandardODATA.Document_ПерерасчетСтраховыхВзносов"/>
                            <Parameter Name="PostingModeOperational"
                                    Type="Edm.Boolean"/>
                            </FunctionImport>
                            <FunctionImport Name="Unpost"
                                    IsBindable="true"
                                    IsSideEffecting="true">
                                <Parameter Name="bindingParameter"
                                        Type="StandardODATA.Document_ПерерасчетСтраховыхВзносов"/>
                                <Parameter Name="PostingModeOperational"
                                        Type="Edm.Boolean"/>
                            </FunctionImport>
                        </EntityContainer>
                    </Schema>
                </edmx:DataServices>
            </edmx:Edmx>
            """;
}
