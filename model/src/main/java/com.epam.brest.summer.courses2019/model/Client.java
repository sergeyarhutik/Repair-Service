package com.epam.brest.summer.courses2019.model;

/**
 * POJO Client for model.
 */
public class Client {
    /**
     * Client Id.
     */
    private Integer clientId;

    /**
     * Client Name.
     */
    private String clientName;

    /**
     * Constructor without arguments.
     */
    public Client() {
    }

    /**
     * Constructor with client name.
     *
     * @param clientName client name
     */
    public Client(String clientName) {
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
    public Client setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Client{"
                + "clientId=" + clientId
                + ", clientName='" + clientName + '\''
                + '}';
    }
}