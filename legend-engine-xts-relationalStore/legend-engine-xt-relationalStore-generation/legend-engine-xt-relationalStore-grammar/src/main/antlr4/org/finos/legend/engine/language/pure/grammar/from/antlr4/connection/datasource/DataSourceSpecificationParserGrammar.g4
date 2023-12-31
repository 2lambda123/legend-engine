parser grammar DataSourceSpecificationParserGrammar;

import CoreParserGrammar;

options
{
    tokenVocab = DataSourceSpecificationLexerGrammar;
}

identifier:                      VALID_STRING
;

// ----------------------------- RELATIONAL DATABASE CONNECTION DATASOURCE SPEC -----------------------------

localH2DatasourceSpecification:             LOCAL_H2_DSP
                                                BRACE_OPEN
                                                    (
                                                        localH2DSPTestDataSetupCSV |
                                                        localH2DSPTestDataSetupSQLS
                                                    )*
                                                BRACE_CLOSE
;
localH2DSPTestDataSetupCSV:                 LOCAL_H2_DSP_TEST_DATA_SETUP_CSV COLON STRING SEMI_COLON
;
localH2DSPTestDataSetupSQLS:                LOCAL_H2_DSP_TEST_DATA_SETUP_SQLS COLON sqlsArray SEMI_COLON
;
sqlsArray:                                  BRACKET_OPEN ( STRING (COMMA STRING)* )? BRACKET_CLOSE
;
staticDatasourceSpecification:              STATIC_DSP
                                                BRACE_OPEN
                                                    (
                                                        dbName
                                                        | dbHost
                                                        | dbPort
                                                    )*
                                                BRACE_CLOSE
;
embeddedH2DatasourceSpecification:          EMBEDDED_H2_DSP
                                                BRACE_OPEN
                                                    (
                                                        dbName
                                                        | embeddedH2DSPDirectory
                                                        | embeddedH2DSPAutoServerMode
                                                    )*
                                                BRACE_CLOSE
;
embeddedH2DSPDirectory:                     DIRECTORY COLON STRING SEMI_COLON
;
embeddedH2DSPAutoServerMode:                EMBEDDED_H2_DSP_AUTO_SERVER_MODE COLON BOOLEAN SEMI_COLON
;

port:                                       PORT COLON STRING SEMI_COLON
;

region:                                     REGION COLON STRING SEMI_COLON
;

// ----------------------------- SHARED -----------------------------

dbPort:                                     PORT COLON INTEGER SEMI_COLON
;
dbHost:                                     HOST COLON STRING SEMI_COLON
;
dbName:                                     NAME COLON STRING SEMI_COLON
;