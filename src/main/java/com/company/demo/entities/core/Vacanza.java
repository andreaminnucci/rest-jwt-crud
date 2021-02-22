package com.company.demo.entities.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name = "vacanza", schema = "core")
public class Vacanza {

	@Id
	@SequenceGenerator(name = "vacanza_sequence_generator", sequenceName = "vacanza_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacanza_sequence_generator")
	@Column(name = "vac_id")	
    private Long id;
	
	@Version
	@Column(name = "vac_version", nullable = false)
	private Date version;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "vac_data_inizio", nullable = false)
	private Date dataInizio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "vac_data_fine", nullable = false)
	private Date dataFine;

	@Column(name = "vac_descrizione", nullable = false, length = 100)
	private String descrizione;
	
	@Column(name = "vac_latitudine", nullable = false)
	private Double latitudine;
	
	@Column(name = "vac_longitudine", nullable = false)
	private Double longitudine;
	
}
