package org.killbill.billing.plugin.custominvoiceformatter;

import java.util.Locale;
import java.util.Map;

import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.plugin.notification.generator.formatters.DefaultInvoiceFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInvoiceFormatter extends DefaultInvoiceFormatter{
	
	public CustomInvoiceFormatter(Map<String, String> translator, Invoice invoice, Locale locale) {
		super(translator, invoice, locale);
		logger.info("Creating CustomInvoiceFormatter");
	}	
	
	private static final Logger logger = LoggerFactory.getLogger(CustomInvoiceFormatter.class);
	
	private String newInvoiceMessage="Here is your new invoice!!";
	
	public String getNewInvoiceMessage() {
		return newInvoiceMessage;
	}


}
