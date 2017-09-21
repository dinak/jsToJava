package com.parser;

import com.model.FlightInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by damatya on 9/19/17.
 */
public class Parser {

    private List<FlightInfo> flightInfoList = new ArrayList<FlightInfo>();
    private FlightInfo info;
    private String data ;
    private String singleRowData ;
    private List<String> matchesStartingWithSlash = new ArrayList<String>();

    public Parser(String data)
    {
        this.data = data;
    }

    public List<FlightInfo> parse()
    {
        batch();
        return flightInfoList;
    }

    public void batch()
    {
        //data = "UNH,sdfjl,sdflj.UNThelloworkd;;;UNHdfs,df,efUNTzzzzUNB,,,dsjsfUNZ";

        String regx = "(UNH\\S+?UNT)|(UNB\\S+?UNZ)";
        Pattern p = Pattern.compile(regx);

        Matcher m = p.matcher(data);

        while (m.find())
        {
            System.out.println("batchmatch::"+m.group());
            singleRowData = m.group();
            info =  new FlightInfo();
            setMatchesStartingWithSlash();
            parseSourceAddress();
            parseDestAddress();
            parseTpr();

            parseSenderCode();
            parseMessageType();
            parseMessageId();
            parseMessageVersion();
            parseATA_IATA();
            parseAgentCode();
            parseSenderCity();
            parseSenderCountry();
            parseTicketNumber();
            parseAirlineInfo();
            parsePnr();
            parseActionCode();
            parseErrorCode();
            parseNoPassengers();
            parseNoOfTvls();
            parseFlights();

            flightInfoList.add(info);
        }

    }

    public String segment(String token)
    {

        String esc = token.replace("+", "\\+");

       // String regx = esc+"[\\w+\\d+\\+\\:]+'";
        String regx = esc+"[//b[^']]+";
       // System.out.println("regx::"+regx);
        Pattern p = Pattern.compile(regx);

        Matcher m = p.matcher(singleRowData);

        String returnString = "";
        while (m.find())
        {
            String val = m.group();
            if(val.contains(token))
            {
                returnString = val;
                break;
            }
        }
      //  System.out.println("segment::"+returnString);
        return returnString;
    }

    public String element(String text, int index)
    {
        //Pattern p = Pattern.compile("[\\w\\d\\W]+\\+");
        Pattern p = Pattern.compile("[//b[^+]]+");

        Matcher m = p.matcher(text);

        String returnString = "";
        int i=0;
        while (m.find())
        {
            if(index==i)
            {
                returnString = m.group();
                break;
            }
            i++;
        }

       // System.out.println("element::"+returnString);
        return returnString;
    }

    public String component(String text, int index)
    {
        Pattern p = Pattern.compile("[//b[^:]]+");

        Matcher m = p.matcher(text);

        String returnString = "";
        int i=0;
        while (m.find())
        {
            if(index==i)
            {
                returnString = m.group();
                break;
            }
            i++;
        }

      //  System.out.println("component::"+returnString);
        return returnString;
    }

    private void setMatchesStartingWithSlash()
    {
        Pattern p = Pattern.compile("/\\w+");

        Matcher m = p.matcher(data);

        while (m.find())
        {
            matchesStartingWithSlash.add(m.group());
        }
    }

    private void parseSourceAddress()
    {
        String tempString = matchesStartingWithSlash.get(0);//.replace("/", "");
        String matchedString = tempString.substring(tempString.indexOf("1")+1,tempString.length());
        System.out.println("src::"+matchedString);
        info.setSourceAddress(matchedString);

    }

    private void parseDestAddress()
    {
        String tempString = matchesStartingWithSlash.get(1);
        String matchedString = tempString.substring(tempString.indexOf("1")+1,tempString.length());
        System.out.println("dest::"+matchedString);
        info.setDestinationAddress(matchedString);
    }

    private void parseTpr()
    {
        String tempString = matchesStartingWithSlash.get(2);
        String matchedString = tempString.substring(tempString.indexOf("/")+1,tempString.length()-7);
        System.out.println("tpr::"+matchedString);
        info.setTpr(matchedString);
    }

    private void parseSenderCode()
    {
        //function(){ return(this.segment('UNH').element(2).component(3).toString()); }
        System.out.println("senderCode::"+getThroughSegmentElementComponent("UNH",2,3));
        info.setSenderCode(getThroughSegmentElementComponent("UNH",2,3));
    }

    private void parseMessageType()
    {
        //function(){ return(this.segment('UNH').element(2).component(0).toString());
        System.out.println("messageType::"+getThroughSegmentElementComponent("UNH",2,0));
        info.setMessageType(getThroughSegmentElementComponent("UNH",2,0));
    }

    private void parseMessageId()
    {
       // return(this.segment('UNB').element(5).toString())
        System.out.println("messageId::"+getThroughSegmentElement("UNB",5));
        info.setMessageId(getThroughSegmentElement("UNB",5));
    }



   private void parseMessageVersion()
   {
       //    EDI.prototype.mbaseversion    = function(){ return(this.segment('UNH').element(2).component(1).toString()); }
       System.out.println("message version::"+getThroughSegmentElementComponent("UNH",2,1));
       info.setMessageVersion(getThroughSegmentElementComponent("UNH",2,1));

   }

   private void parseATA_IATA()
   {
       //EDI.prototype.ata_iata_number = function(){ return(this.segment('ORG').element(2).component(0).toString()); }
       System.out.println("ata::"+getThroughSegmentElementComponent("ORG",2,0));
       info.setAta_iata(getThroughSegmentElementComponent("ORG",2,0));


   }

   private void parseAgentCode()
   {
       //EDI.prototype.agent_code = function(){ return(this.segment('ORG').element(2).component(1).toString()); }
       System.out.println("agent code::"+getThroughSegmentElementComponent("ORG",2,1));
       info.setAgentCode(getThroughSegmentElementComponent("ORG",2,1));

   }

    private void parseSenderCity()
    {
        //sender_city = function(){ return(this.segment('ORG').element(3).component(0).toString()); }
        System.out.println("sender city::"+getThroughSegmentElementComponent("ORG",3,0));
        info.setSenderCity(getThroughSegmentElementComponent("ORG",3,0));

    }

    private void parseSenderCountry()
    {
        //sender_country = function(){ return(this.segment('ORG').element(5).component(0).toString()); }
        System.out.println("sender country::"+getThroughSegmentElementComponent("ORG",5,0));
        info.setSenderCountry(getThroughSegmentElementComponent("ORG",5,0));

    }

    private void parseTicketNumber()
    {
        //EDI.prototype.tkt   = function(){ return(this.segment('TKT').element(1).component(0).toString()) }
        System.out.println("ticket number::"+getThroughSegmentElementComponent("TKT",0,1));
        info.setTicketNumber(getThroughSegmentElementComponent("TKT",0,1));

    }

    private void parseAirlineInfo()
    {
        //EDI.prototype.aireline_info = function(){ return(this.segment('UNB').element(3).component(1).toString()); }
        System.out.println("agent code::"+getThroughSegmentElementComponent("UNB",3,1));
        info.setAirlineInfo(getThroughSegmentElementComponent("UNB",3,1));

    }

    private void parsePnr()
    {
        //EDI.prototype.pnr = function(){ return(this.segment('RCI').element(2).component(1).toString()); }
        System.out.println("pnr::"+getThroughSegmentElementComponent("RCI",2,1));
        info.setPnr(getThroughSegmentElementComponent("RCI",2,1));

    }

    private void parseActionCode()
    {
        //EDI.prototype.action_code = function(){ return(this.segment('MSG').element(1).component(1).toString()); }
        System.out.println("action code::"+getThroughSegmentElementComponent("MSG",1,1));
        info.setActionCode(getThroughSegmentElementComponent("MSG",1,1));

    }

    private void parseErrorCode()
    {
       //EDI.prototype.error_code = function(){ return(this.segment('ERC').element(1).toString()); }
        System.out.println("error code::"+getThroughSegmentElement("ERC",1));
        info.setErrorCode(getThroughSegmentElement("ERC",1));

    }

    private void parseNoPassengers()
    {
        //EDI.prototype.no_of_passengers = function(){ return(this.segment('RPI').element(1).toString()); }
        System.out.println("noOfPassengers ::"+getThroughSegmentElement("RPI",2));
        info.setNoPassengers(getThroughSegmentElement("RPI",2));

    }


    private void parseNoOfTvls()
    {
        String regx = "TVL[//b[^']]+";
        Pattern p = Pattern.compile(regx);

        Matcher m = p.matcher(data);

        int count = 0;
        while (m.find())
        {
            String val = m.group();
            count++;
        }


        System.out.println("no of tvls::"+count);
        info.setNoOfLevels(count+"");

    }

    private void parseFlights()
    {
        List<String> flights = new ArrayList<String>();
        String regx = "TVL[//b[^']]+";
        Pattern p = Pattern.compile(regx);

        Matcher m = p.matcher(data);

        int count = 0;
        while (m.find())
        {
            String val = m.group();
            System.out.println("flight::"+element(val,4)+element(val,5));
            flights.add(element(val,4)+element(val,5));
        }
        info.setFlights(flights);

    }

    private String getThroughSegmentElementComponent(String token, int elementIndex, int componentIndex)
    {
        String segment = segment(token);
        String element = element(segment,elementIndex);
        String component = component(element,componentIndex);
        return component;
    }

    private String getThroughSegmentElement(String token, int elementIndex)
    {
        String segment = segment(token);
        String element = element(segment,elementIndex);
        return element;
    }


}


// output
/*
[ { SOURCE_ADDRESS: 'TKRT',
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
        FLIGHTS: '["TK0759","TK1963","TK0763","TK1985"]' } ]
*/