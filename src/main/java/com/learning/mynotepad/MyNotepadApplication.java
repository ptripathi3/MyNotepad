package com.learning.mynotepad;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.learning.mynotepad.manager.MyNoteManager;
import com.learning.mynotepad.resources.MyNotepadResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class MyNotepadApplication extends Application<MyNotepadConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyNotepadApplication().run(args);
    }

    public void run(MyNotepadConfiguration myNotepadConfiguration, Environment environment) throws Exception {
        final DataSource dataSource =
                myNotepadConfiguration.getDataSourceFactory().build(environment.metrics(), "sql");
        DBI dbi = new DBI(dataSource);
        environment.jersey().register(new ApiListingResource());
        environment.jersey().register(SwaggerSerializers.class);
        environment.jersey().register(new MyNotepadResource(dbi.onDemand(MyNoteManager.class)));
    }

    @Override
    public void initialize(Bootstrap<MyNotepadConfiguration> bootstrap) {
        bootstrap.getObjectMapper().registerModule(new Jdk8Module());
        bootstrap.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        bootstrap.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        bootstrap.addBundle(new SwaggerBundle<MyNotepadConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(MyNotepadConfiguration myNotepadConfig) {
                return myNotepadConfig.getSwagger();
            }
        });
    }
}
