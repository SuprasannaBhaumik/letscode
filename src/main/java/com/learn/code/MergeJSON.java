package com.learn.code;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MergeJSON {

    public static void main(String s[]) {
        String json1 = "[{\"country\":\"IND\", \"_id\": \"60e\", \"fields\": {\"smsOptIn\": true}}]";
        String json2 = "[{\"countryCode\":\"IND\", \"countryDesc\": \"India\", \"geo\":\"APAC\"}]";
        performMerge(json1, json2);
    }

    public static void performMerge(String json1, String json2) {

        JSONArray primaryJSON = new JSONArray(json1);
        JSONArray secondaryJSON = new JSONArray(json2);
        Map<String, JSONObject> countrySMSMap = new HashMap<>();
        for (int i = 0; i < primaryJSON.length(); i++) {
            JSONObject explrObject = primaryJSON.getJSONObject(i);
            countrySMSMap.put((String)explrObject.get("country"), (JSONObject) explrObject.get("fields"));
        }

        for (int i = 0; i < secondaryJSON.length(); i++) {
            JSONObject explrObject = secondaryJSON.getJSONObject(i);
            String countryCode = (String)explrObject.get("countryCode");

            if(countrySMSMap.containsKey(countryCode)) {
                JSONObject smsObject = countrySMSMap.get(countryCode);
                explrObject.append("smsOptIn", smsObject.get("smsOptIn"));
            }
        }

        for (int i = 0; i < secondaryJSON.length(); i++) {
            JSONObject explrObject = secondaryJSON.getJSONObject(i);
            String countryDesc = (String)explrObject.get("countryDesc");
            boolean smsOptIn = (boolean)explrObject.get("smsOptIn");
            System.out.println(countryDesc + " -> " + smsOptIn);
        }



    }



}
