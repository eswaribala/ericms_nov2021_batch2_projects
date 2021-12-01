package com.eric.invapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Embeddable
@Data
public class ProductDescription {
   @Column(name="Name",nullable = false,length = 100)
   private String name;
   @Column(name="Cost")
   private long cost;
   @Column(name="DOP")
   @DateTimeFormat(iso = ISO.DATE)
   private LocalDate dop;
}
