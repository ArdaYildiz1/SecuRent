package com.gmr.securent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "landlord")
public class Landlord extends User {
}