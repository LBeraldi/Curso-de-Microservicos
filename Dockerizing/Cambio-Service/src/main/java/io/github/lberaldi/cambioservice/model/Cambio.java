package io.github.lberaldi.cambioservice.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "cambio")
public class Cambio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(nullable = false)
    private BigDecimal conversionFactor;

    @Transient
    private BigDecimal convertedValue;

    @Transient
    private String envronment;

    public Cambio(){}

    public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue, String envronment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.envronment = envronment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambio cambio = (Cambio) o;
        return Objects.equals(getId(), cambio.getId()) && Objects.equals(getFrom(), cambio.getFrom()) && Objects.equals(getTo(), cambio.getTo()) && Objects.equals(getConversionFactor(), cambio.getConversionFactor()) && Objects.equals(getConvertedValue(), cambio.getConvertedValue()) && Objects.equals(getEnvronment(), cambio.getEnvronment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getConversionFactor(), getConvertedValue(), getEnvronment());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvronment() {
        return envronment;
    }

    public void setEnvronment(String envronment) {
        this.envronment = envronment;
    }
}
