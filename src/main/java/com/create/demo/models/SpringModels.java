package com.create.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "springmodels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpringModels implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "stt")
    private int stt;

}