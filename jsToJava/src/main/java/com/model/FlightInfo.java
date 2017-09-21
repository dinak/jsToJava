package com.model;

/**
 * Created by damatya on 9/19/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * { SOURCE_ADDRESS: 'TKRT',
 DESTINATION_ADDRESS: 'RTDP',
 TPR: 'P0735',
 SENDER_CODE: 'IA',
 MESSAGE_TYPE: 'PAOREQ',
 MESSAGE_ID: '',
 MESSAGE_VERSION: '99.0',
 ATA_IATA: '91224210',
 AGENT_CODE: 'OHP',
 SENDER_CITY: 'LON',
 SENDER_COUNTRY: 'T',
 TICKET_NUMBER: '',
 AIRLINE_INFO: '',
 PNR: '',
 ACTION_CODE: '46',
 ERROR_CODE: '',
 NO_PASSENGERS: '',
 NO_OF_TVLS: 4,
 FLIGHTS: '["TK0759","TK1963","TK0763","TK1985"]' }
 */
public class FlightInfo {

    private String sourceAddress;
    private String destinationAddress;
    private String tpr;
    private String senderCode;
    private String messageType;
    private String messageId;
    private String messageVersion;
    private String ata_iata;
    private String agentCode;
    private String senderCity;
    private String senderCountry;
    private String ticketNumber;
    private String airlineInfo;
    private String pnr;
    private String actionCode;
    private String errorCode;
    private String noPassengers;
    private String noOfLevels;
    private List<String> flights = new ArrayList<String>();

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getTpr() {
        return tpr;
    }

    public void setTpr(String tpr) {
        this.tpr = tpr;
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public String getAta_iata() {
        return ata_iata;
    }

    public void setAta_iata(String ata_iata) {
        this.ata_iata = ata_iata;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getAirlineInfo() {
        return airlineInfo;
    }

    public void setAirlineInfo(String airlineInfo) {
        this.airlineInfo = airlineInfo;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getNoPassengers() {
        return noPassengers;
    }

    public void setNoPassengers(String noPassengers) {
        this.noPassengers = noPassengers;
    }

    public String getNoOfLevels() {
        return noOfLevels;
    }

    public void setNoOfLevels(String noOfLevels) {
        this.noOfLevels = noOfLevels;
    }

    public List<String> getFlights() {
        return flights;
    }

    public void setFlights(List<String> flights) {
        this.flights = flights;
    }




}
