package com.learning.mynotepad;

import com.learning.mynotepad.manager.MyNoteManager;
import com.learning.mynotepad.resources.MyNotepadResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
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
        environment.jersey().register(new MyNotepadResource(dbi.open(MyNoteManager.class)));
    }

    @Override
    public void initialize(Bootstrap<MyNotepadConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<MyNotepadConfiguration>() {
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(MyNotepadConfiguration myNotepadConfiguration) {
                return myNotepadConfiguration.getSwagger();
            }
        });
    }
}
