package com.luv2tech.school.model;

import com.luv2tech.model.base.BaseAudit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Setter
@Getter
@ToString
public class Address extends BaseAudit<String> {
    
}
