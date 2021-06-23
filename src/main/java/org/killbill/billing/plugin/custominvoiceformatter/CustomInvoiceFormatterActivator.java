package org.killbill.billing.plugin.custominvoiceformatter;

import java.util.Hashtable;
import java.util.Properties;

import org.killbill.billing.osgi.api.Healthcheck;
import org.killbill.billing.osgi.api.OSGIPluginProperties;
import org.killbill.billing.osgi.libs.killbill.KillbillActivatorBase;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillEventDispatcher;
import org.killbill.billing.osgi.libs.killbill.OSGIKillbillEventDispatcher.OSGIFrameworkEventHandler;
import org.killbill.billing.payment.plugin.api.PaymentPluginApi;
import org.killbill.billing.plugin.api.notification.PluginConfigurationEventHandler;
import org.killbill.billing.plugin.core.config.PluginEnvironmentConfig;
import org.killbill.billing.plugin.core.resources.jooby.PluginApp;
import org.killbill.billing.plugin.core.resources.jooby.PluginAppBuilder;
import org.killbill.billing.plugin.notification.api.InvoiceFormatterFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class CustomInvoiceFormatterActivator extends KillbillActivatorBase{
	

	//
	// Ideally that string should match the pluginName on the filesystem, but there
	// is no enforcement
	//
	public static final String PLUGIN_NAME = "custom-invoice-formatter-plugin";


	private CustomInvoiceFormatterFactory customInvoiceFormatterFactory;
	private ServiceRegistration<InvoiceFormatterFactory> registration = null;

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);

		// use CustomInvoiceFormatterFactory
		customInvoiceFormatterFactory = new CustomInvoiceFormatterFactory();
		Hashtable<String, Object> properties = new Hashtable<>();
		registration = context.registerService(InvoiceFormatterFactory.class, customInvoiceFormatterFactory,
				properties);

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
