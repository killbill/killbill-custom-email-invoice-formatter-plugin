package org.killbill.billing.plugin.custominvoiceformatter;

import java.util.Locale;
import java.util.Map;

import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.invoice.api.formatters.InvoiceFormatter;
import org.killbill.billing.plugin.notification.api.InvoiceFormatterFactory;
import org.killbill.billing.util.callcontext.TenantContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInvoiceFormatterFactory implements InvoiceFormatterFactory{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomInvoiceFormatterFactory.class);
	
	public CustomInvoiceFormatterFactory() {
		super();
		logger.info("Creating CustomInvoiceFormatterFactory");
	}


	@Override
	public InvoiceFormatter createInvoiceFormatter(Map<String, String> translator, Invoice invoice, Locale locale,
			TenantContext context) {
		return new CustomInvoiceFormatter(translator, invoice, locale);
	}

}
