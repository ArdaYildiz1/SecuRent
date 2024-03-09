//package com.gmr.securent.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//@EqualsAndHashCode(callSuper = true)
//@Entity
//@Data
//@NoArgsConstructor
//@DiscriminatorValue("PROPERTY_PARTICIPANT")
//public abstract class PropertyParticipant extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer participantID;
//
//    public PropertyParticipant(String firstName,
//                               String lastName,
//                               String password,
//                               String emailAddress,
//                               String phoneNo,
//                               int tck,
//                               int profilePhoto) {
//        super(firstName, lastName, password, emailAddress, phoneNo, tck, profilePhoto);
//    }
//
//    public PropertyParticipant(String firstName,
//                               String lastName,
//                               String password,
//                               String emailAddress,
//                               String phoneNo,
//                               int tck) {
//        super(firstName, lastName, password, emailAddress, phoneNo, tck);
//    }
//}
