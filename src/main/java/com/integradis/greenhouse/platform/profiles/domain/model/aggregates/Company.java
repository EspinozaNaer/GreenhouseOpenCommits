package com.integradis.greenhouse.platform.profiles.domain.model.aggregates;

import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.CompanyName;
import com.integradis.greenhouse.platform.profiles.domain.model.valueobjects.Tin;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Company extends AbstractAggregateRoot<Company> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private CompanyName companyName;

    @Embedded
    private Tin tin;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public Company() {

    }

    public Company(String name, String number){
        this.companyName = new CompanyName(name);
        this.tin = new Tin(number);
    }

    public String getCompanyName(){
        return this.companyName.name();
    }

    public String getTin() {
        return this.tin.number();
    }
}
