package org.killbill.billing.plugin.custominvoiceformatter;

import org.killbill.billing.invoice.api.Invoice;
import org.killbill.billing.plugin.notification.generator.formatters.DefaultInvoiceFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Map;

public class CustomInvoiceFormatter extends DefaultInvoiceFormatter {

    private static final Logger logger = LoggerFactory.getLogger(CustomInvoiceFormatter.class);
    private final String newInvoiceMessage = "Here is your new invoice!!"; //custom field to be added to invoice

    public CustomInvoiceFormatter(Map<String, String> translator, Invoice invoice, Locale locale) {
        super(translator, invoice, locale);
        logger.info("Creating CustomInvoiceFormatter");
    }

    public String getNewInvoiceMessage() {
        return newInvoiceMessage;
    }


}
