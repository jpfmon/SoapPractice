package com.montojo;

import com.lavasoft.GeoIPService;

public class MainSoap {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("You need to provide one IP Address");
        } else {
            var ipAddress = args[0];
            var geoIPService = new GeoIPService();
            var geoIpServiceSoap = geoIPService.getGeoIPServiceSoap();
            var ipLocation = geoIpServiceSoap.getIpLocation(ipAddress);

            System.out.printf("Location for the IP address provided: \nCountry: %s \nState: %s\n", extractCountry(ipLocation), extractState(ipLocation));
        }
    }

    private static String extractCountry (String location) {
        String result = location.substring(16, location.indexOf("</Country>"));
        return result;
    }

    private static String extractState (String location) {
        String result = location.substring(location.indexOf("<State>") + 7, location.indexOf("</State"));
        return result;
    }
}
