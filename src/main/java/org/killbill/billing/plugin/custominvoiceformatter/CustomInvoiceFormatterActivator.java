package org.killbill.billing.plugin.custominvoiceformatter;

import org.killbill.billing.osgi.libs.killbill.KillbillActivatorBase;
import org.killbill.billing.plugin.notification.api.InvoiceFormatterFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class CustomInvoiceFormatterActivator extends KillbillActivatorBase {


    // Ideally this string should match the pluginName on the filesystem, but there is no enforcement
    public static final String PLUGIN_NAME = "custom-email-invoice-formatter-plugin";


    private CustomInvoiceFormatterFactory customInvoiceFormatterFactory;
    private ServiceRegistration<InvoiceFormatterFactory> registration = null;

    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);

        // create CustomInvoiceFormatterFactory
        customInvoiceFormatterFactory = new CustomInvoiceFormatterFactory();
        Hashtable<String, Object> properties = new Hashtable<>();
        registration = context.registerService(InvoiceFormatterFactory.class, customInvoiceFormatterFactory,
                properties); // register factory as OSGi service

    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        super.stop(context);
        if (registration != null) {
            registration.unregister();
            registration = null;
        }
        // Do additional work on shutdown (optional)
    }

}
