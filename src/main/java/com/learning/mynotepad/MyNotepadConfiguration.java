package com.learning.mynotepad;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class MyNotepadConfiguration extends Configuration {
    private static final String DATABASE = "database";

    private SwaggerBundleConfiguration swagger;

    @JsonProperty(DATABASE)
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();


    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    public void setDataSourceFactory(final DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    public SwaggerBundleConfiguration getSwagger() {
        return swagger;
    }

    public void setSwagger(SwaggerBundleConfiguration swagger) {
        this.swagger = swagger;
    }
}
