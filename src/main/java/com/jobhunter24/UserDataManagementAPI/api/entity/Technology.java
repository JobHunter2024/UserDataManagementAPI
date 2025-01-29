package com.jobhunter24.UserDataManagementAPI.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "UserTechnologies",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"userId", "uri"})
        }
)
@SequenceGenerator(
        name = "userTechnology_seq",
        sequenceName = "userTechnology_sequence",
        allocationSize = 1
)
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userTechnology_seq")
    public Long id;

    @Column(nullable = false)
    @NotNull
    public String name;

    @Column(nullable = false)
    @NotNull
    public String uri;

    @Column(nullable = false)
    @NotNull
    public Long userId;
}