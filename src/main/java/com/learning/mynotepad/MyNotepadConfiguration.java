package com.learning.mynotepad;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class MyNotepadConfiguration extends Configuration {
    private static final String DATABASE = "database";
    private SwaggerBundleConfiguration swagger;

    public SwaggerBundleConfiguration getSwagger() {
        return swagger;
    }

    public void setSwagger(SwaggerBundleConfiguration swagger) {
        this.swagger = swagger;
    }

    @Valid
    @NotNull
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @JsonProperty(DATABASE)
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    @JsonProperty(DATABASE)
    public void setDataSourceFactory(final DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }
}
