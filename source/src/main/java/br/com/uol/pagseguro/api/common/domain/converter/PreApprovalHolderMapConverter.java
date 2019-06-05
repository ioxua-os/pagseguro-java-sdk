package br.com.uol.pagseguro.api.common.domain.converter;

import br.com.uol.pagseguro.api.common.domain.PreApprovalHolder;
import br.com.uol.pagseguro.api.utils.AbstractMapConverter;
import br.com.uol.pagseguro.api.utils.RequestMap;

public class PreApprovalHolderMapConverter extends AbstractMapConverter<PreApprovalHolder> {

    private final static CreditCardBillingAddressMapConverter ADDRESS_MC = new CreditCardBillingAddressMapConverter();
    private final static AbstractHolderMapConverter

    @Override
    protected void convert(RequestMap requestMap, PreApprovalHolder holder) {
        requestMap.putMap(ADDRESS_MC.convert(holder.getBillingAddress()));
    }

    /**
     * Implementation of {@code AbstractAddressMapConverter}. Used to set key values
     *
     * @see AbstractAddressMapConverter
     */
    private static class CreditCardBillingAddressMapConverter extends AbstractAddressMapConverter {

        @Override
        protected String getCountryKey() {
            return "billingAddress.country";
        }

        @Override
        protected String getStateKey() {
            return "billingAddress.state";
        }

        @Override
        protected String getCityKey() {
            return "billingAddress.city";
        }

        @Override
        protected String getPostalCodeKey() {
            return "billingAddress.postalCode";
        }

        @Override
        protected String getDistrictKey() {
            return "billingAddress.district";
        }

        @Override
        protected String getStreetKey() {
            return "billingAddress.street";
        }

        @Override
        protected String getNumberKey() {
            return "billingAddress.number";
        }

        @Override
        protected String getComplementKey() {
            return "billingAddress.complement";
        }

    }
}
