package com.epam.brest.summer.courses2019.model.stub;

public class ClientStub {

        /**
         * Client Id.
         */
        private Integer clientId;

        /**
         * Client Name.
         */
        private String clientName;

        /**
         * Quantity of Clients devices of the Client.
         */
        private Integer quantityOfClientDevices;

        /**
         * Constructor without arguments.
         */
        public ClientStub() {
        }

        /**
         * Constructor with client name.
         *
         * @param clientName client name
         */
        public ClientStub(String clientName) {
            this.clientName = clientName;
        }

        /**
         * Returns <code>Integer</code> representation of this clientId.
         *
         * @return clientId Client Id.
         */
        public Integer getClientId() {
            return clientId;
        }

        /**
         * Sets the client's identifier.
         *
         * @param clientId Client Id.
         */
        public void setClientId(final Integer clientId) {
            this.clientId = clientId;
        }

        /**
         * Returns <code>String</code> representation of this clientName.
         *
         * @return clientName Client Name.
         */
        public String getClientName() {
            return clientName;
        }

        /**
         * Sets the client's name.
         *
         * @param clientName Client Name.
         */
        public void setClientName(final String clientName) {
            this.clientName = clientName;
        }

        /**
         * Returns <code>Integer</code> representation of quantity of
         * Client's devices.
         *
         * @return clientId.
         */
        public Integer getQuantityOfClientDevices() {
            return quantityOfClientDevices;
        }

        /**
         * Sets quantity of client's devices
         *
         * @param quantityOfClientDevices devices quantity.
         */
        public void setQuantityOfClientDevices(final Integer quantityOfClientDevices) {
            this.quantityOfClientDevices = quantityOfClientDevices;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ClientStub{"
                    + "clientId=" + clientId
                    + ", clientName='" + clientName + '\''
                    + ", quantityOfClientDevices=" + quantityOfClientDevices
                    + '}';
        }
}
