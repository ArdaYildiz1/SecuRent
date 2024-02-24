package com.gmr.securent.model;

import com.gmr.securent.model.enums.Heating;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HouseProperties {
    List<Image> housePhotos = new ArrayList<>();
    private String address;
    private int adID;
    private Date adDate;
    private double areaGross;
    private double areaNet;
    private double areaOpenSpace;
    private int numberOfRooms;
    private int buildingAge;
    private int flatNumber;
    private Heating heating;
    private int numberOfBathrooms;
    private boolean balconyIsPresent;
    private boolean furnitureIsPresent;
    private boolean insideASite;
    private String siteName;
    private double currentAmount;
}
