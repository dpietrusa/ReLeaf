package com.detroitlabs.releaf.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllDisasters extends ArrayList<DisasterData> {

}
