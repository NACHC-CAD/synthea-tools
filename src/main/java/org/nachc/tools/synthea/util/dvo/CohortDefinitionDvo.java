//
// Data Value Object (DVO) for cohort_definition
//

package org.nachc.tools.synthea.util.dvo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

import org.yaorma.dvo.Dvo;

public class CohortDefinitionDvo implements Dvo {

    //
    // tableName
    //
    
    public static final String TABLE_NAME = "cohort_definition";
    
    //
    // schemaName
    //
    
    public static final String SCHEMA_NAME = "synthea_omop";
    
    //
    // columnNames
    //
    
    public static final String[] COLUMN_NAMES = {
        "cohort_definition_description",
        "cohort_definition_id",
        "cohort_definition_name",
        "cohort_definition_syntax",
        "cohort_initiation_date",
        "definition_type_concept_id",
        "subject_concept_id"
    };
    
    //
    // primaryKeyColumnNames
    //
    
    public static final String[] PRIMARY_KEY_COLUMN_NAMES = {
    };
    
    //
    // javaNames
    //
    
    public static final String[] JAVA_NAMES = {
        "cohortDefinitionDescription",
        "cohortDefinitionId",
        "cohortDefinitionName",
        "cohortDefinitionSyntax",
        "cohortInitiationDate",
        "definitionTypeConceptId",
        "subjectConceptId"
    };
    
    //
    // javaNamesProper
    //
    
    public static final String[] JAVA_NAMES_PROPER = {
        "CohortDefinitionDescription",
        "CohortDefinitionId",
        "CohortDefinitionName",
        "CohortDefinitionSyntax",
        "CohortInitiationDate",
        "DefinitionTypeConceptId",
        "SubjectConceptId"
    };
    
    
    //
    // member variables
    //
    
    private HashMap<String, String> descriptions = new HashMap<String, String>();
    
    private String cohortDefinitionDescription;
    
    private Integer cohortDefinitionId;
    
    private String cohortDefinitionName;
    
    private String cohortDefinitionSyntax;
    
    private String cohortInitiationDate;
    
    private Integer definitionTypeConceptId;
    
    private Integer subjectConceptId;
    
    private CohortDvo cohortDefinitionDvo;
    
    private ConceptDvo definitionTypeConceptDvo;
    
    private ConceptDvo subjectConceptDvo;
    
    //
    // trivial getters and setters
    //
    
    // cohortDefinitionDescription
    
    public void setCohortDefinitionDescription(String val) {
        this.cohortDefinitionDescription = val;
    }
    
    public String getCohortDefinitionDescription() {
        return this.cohortDefinitionDescription;
    }
    
    // cohortDefinitionId
    
    public void setCohortDefinitionId(Integer val) {
        this.cohortDefinitionId = val;
    }
    
    public Integer getCohortDefinitionId() {
        return this.cohortDefinitionId;
    }
    
    // cohortDefinitionName
    
    public void setCohortDefinitionName(String val) {
        this.cohortDefinitionName = val;
    }
    
    public String getCohortDefinitionName() {
        return this.cohortDefinitionName;
    }
    
    // cohortDefinitionSyntax
    
    public void setCohortDefinitionSyntax(String val) {
        this.cohortDefinitionSyntax = val;
    }
    
    public String getCohortDefinitionSyntax() {
        return this.cohortDefinitionSyntax;
    }
    
    // cohortInitiationDate
    
    public void setCohortInitiationDate(String val) {
        this.cohortInitiationDate = val;
    }
    
    public String getCohortInitiationDate() {
        return this.cohortInitiationDate;
    }
    
    // definitionTypeConceptId
    
    public void setDefinitionTypeConceptId(Integer val) {
        this.definitionTypeConceptId = val;
    }
    
    public Integer getDefinitionTypeConceptId() {
        return this.definitionTypeConceptId;
    }
    
    // subjectConceptId
    
    public void setSubjectConceptId(Integer val) {
        this.subjectConceptId = val;
    }
    
    public Integer getSubjectConceptId() {
        return this.subjectConceptId;
    }
    
    // cohortDefinitionDvo
    
    public void setCohortDefinitionDvo(CohortDvo dvo) {
        this.cohortDefinitionDvo = dvo;
    }
    
    public CohortDvo getCohortDefinitionDvo() {
        return this.cohortDefinitionDvo;
    }
    
    // definitionTypeConceptDvo
    
    public void setDefinitionTypeConceptDvo(ConceptDvo dvo) {
        this.definitionTypeConceptDvo = dvo;
    }
    
    public ConceptDvo getDefinitionTypeConceptDvo() {
        return this.definitionTypeConceptDvo;
    }
    
    // subjectConceptDvo
    
    public void setSubjectConceptDvo(ConceptDvo dvo) {
        this.subjectConceptDvo = dvo;
    }
    
    public ConceptDvo getSubjectConceptDvo() {
        return this.subjectConceptDvo;
    }
    
    //
    // implementation of Dvo
    //
    
    public String getTableName() {
        return TABLE_NAME;
    };
    
    public String getSchemaName() {
        return SCHEMA_NAME;
    };
    
    public String[] getColumnNames() {
        return COLUMN_NAMES;
    };
    
    public String[] getPrimaryKeyColumnNames() {
        return PRIMARY_KEY_COLUMN_NAMES;
    };
    
    public String[] getJavaNames() {
        return JAVA_NAMES;
    };
    
    public String[] getJavaNamesProper() {
        return JAVA_NAMES_PROPER;
    };
    
    public void setDescriptions(HashMap<String, String> descriptions) {
        this.descriptions = descriptions;
    }
    
    public HashMap<String, String> getDescriptions() {
        return this.descriptions;
    }
    
    public void addDescription(String javaName, String value) {
        this.descriptions.put(javaName, value);
    }
    
    public String getDescription(String javaName) {
        return this.descriptions.get(javaName);
    }
    
    public String[] getPrimaryKeyValues() {
        String[] rtn = new String[] {
        };
        return rtn;
    }
}
