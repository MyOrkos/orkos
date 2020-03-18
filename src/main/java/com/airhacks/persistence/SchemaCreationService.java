package com.airhacks.persistence;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Persistence;


public class SchemaCreationService {


        public static void main(String[] args) {
            Persistence.generateSchema("ToDoPU", null);

        }
}
